package com.example.Project.Management.IPF.auth.user.entity;

import com.example.Project.Management.IPF.auth.role.Role;
import com.example.Project.Management.IPF.common.entity.CommonEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tab_user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends CommonEntity implements Serializable {

    private static final long serialVersionUID = -7781624204093241554L;

    @Id
    @GeneratedValue
    @UuidGenerator
    private Long id;

    @Column(name="full_name",nullable = false,length = 100)
    private String fullName;

    @Column(name="password",length = 100)
    @JsonIgnore
    private String password;

    @Column(name="user_name",nullable = false,length = 50, unique = true)
    private String userName;

    @Column(name="email_address",nullable = false, length = 100)
    private String emailAddress;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role=Role.USER;


}
