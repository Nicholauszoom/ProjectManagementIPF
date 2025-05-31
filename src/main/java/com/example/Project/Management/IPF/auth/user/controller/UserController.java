package com.example.Project.Management.IPF.auth.user.controller;

import com.example.Project.Management.IPF.auth.role.Role;
import com.example.Project.Management.IPF.auth.user.dto.UserDto;
import com.example.Project.Management.IPF.auth.user.entity.User;
import com.example.Project.Management.IPF.auth.user.service.UserService;
import com.example.Project.Management.IPF.util.Constants;
import com.example.Project.Management.IPF.util.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@RequestMapping(value="/api/user")
public class UserController {

    @Autowired
            private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MessageSource messageSource;

    String message = null;
    String status = null;
    Boolean isError = false;
    Locale currentLocale = LocaleContextHolder.getLocale();


    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto, HttpServletRequest request){

        UserDto createdUser = null;
        try {

            byte[] credDecoded = Base64.decodeBase64(userDto.getPassword());
            String plainPassword = new String(credDecoded, StandardCharsets.UTF_8);

            String encryptedPassword = passwordEncoder.encode(plainPassword);
            List<User> oldUsersByName = userService.getByUserName(userDto.getEmailAddress().trim().toUpperCase());

                if(oldUsersByName == null) {

                    User user = new User();
                    user.setCreatedBy(Constants.DEFAULT_SYS_USERID);
                    user.setCreatedDate(new Date());
                    user.setRole(Role.valueOf(userDto.getRole()));
                    user.setEmailAddress(userDto.getEmailAddress());
                    user.setUserName(userDto.getEmailAddress());
                    user.setPassword(encryptedPassword);
                    User newUser = userService.saveUser(user);

                    createdUser.setUserName(newUser.getUserName());
                    createdUser.setFullName(newUser.getFullName());
                    createdUser.setRole(newUser.getRole().name());

                    if(newUser != null) {
                        message = messageSource.getMessage("general.create.success", new Object[]{"User "}, currentLocale);
                        status = messageSource.getMessage("code.1001",null, currentLocale);
                        isError  = false;

                    } else {
                        message = messageSource.getMessage("general.create.failure", new Object[]{"User "}, currentLocale);
                        status = messageSource.getMessage("code.1002",null, currentLocale);
                        isError  = true;
                    }
                } else {
                    message = messageSource.getMessage("general.current.exists",new Object[]{"User "}, currentLocale);
                    status = messageSource.getMessage("code.1008",null, currentLocale);
                    isError  = true;
                }

        } catch(Exception ex) {
            ex.printStackTrace();
            message = messageSource.getMessage("general.create.failure", new Object[]{"User "}, currentLocale);
            status = messageSource.getMessage("code.1004",null, currentLocale);
            isError = true;
        }

        Response response = new Response(String.valueOf(Calendar.getInstance().getTime()),status,isError,message,createdUser,request.getRequestURI());
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
