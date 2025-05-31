package com.example.Project.Management.IPF.project.entity;

import com.example.Project.Management.IPF.auth.user.entity.User;
import com.example.Project.Management.IPF.common.entity.CommonEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "tab_projects")
public class Project extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projects_id_generator")
    @SequenceGenerator(name = "projects_id_generator", sequenceName = "seq_projects", initialValue = 1, allocationSize = 1)
    @Column(name = "id", nullable = false, precision = 11)
    private Long id;

    @GeneratedValue
    @UuidGenerator
    @Column(name="projects_uid",nullable = false)
    private UUID projectsUid;

    @PrePersist
    protected void onCreate() {
        setProjectsUid(java.util.UUID.randomUUID());
    }

    @Column(name = "project_name", nullable = false  ,length = 20)
    private String projectName;

    @Column(name = "project_description", length = 50, nullable = false)
    private String  projectDescription;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="user_id" , nullable=false)
    private User user;
}
