package com.example.Project.Management.IPF.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDto implements Serializable {
    private Long id;
    private String projectName;
    private String  projectDescription;
    private Date startDate;
    private Date endDate;
    private long userId;


}
