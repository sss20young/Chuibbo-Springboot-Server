package com.sriracha.ChuibboServer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_post_id")
    private Long id;

    private Long openApiJobPostId;

    private String logoUrl;

    private String companyName;

    private String subject;

    private String descriptionUrl;

    @Column(name = "startdate")
    private LocalDateTime startDate;

    @Column(name = "enddate")
    private LocalDateTime endDate;

    @ManyToMany
    @JoinTable(name = "job_post_has_area",
            joinColumns = @JoinColumn(name="job_post_id"),
            inverseJoinColumns = @JoinColumn(name = "area_id"))
    private List<Area> areas = new ArrayList<Area>();

    @ManyToMany
    @JoinTable(name = "job_post_has_job",
            joinColumns = @JoinColumn(name="job_post_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id"))
    private List<Job> jobs = new ArrayList<Job>();

    @ManyToMany
    @JoinTable(name = "job_post_has_career_type",
            joinColumns = @JoinColumn(name="job_post_id"),
            inverseJoinColumns = @JoinColumn(name = "career_type_id"))
    private List<CareerType> careerTypes = new ArrayList<CareerType>();

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    @UpdateTimestamp
    private Date modificationDate;
}