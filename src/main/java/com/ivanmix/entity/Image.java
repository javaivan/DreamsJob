package com.ivanmix.entity;


import com.ivanmix.entity.status.ImageStatus;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "project_image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="project_id", nullable=false)
    private Project project;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @Column(name = "big", length=250)
    private String big;

    @Column(name = "small", length=250)
    private String small;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private ImageStatus status;

    @Column(insertable=false)
    private Timestamp created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public ImageStatus getStatus() {
        return status;
    }

    public void setStatus(ImageStatus status) {
        this.status = status;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (id != null ? !id.equals(image.id) : image.id != null) return false;
        if (project != null ? !project.equals(image.project) : image.project != null) return false;
        if (big != null ? !big.equals(image.big) : image.big != null) return false;
        if (small != null ? !small.equals(image.small) : image.small != null) return false;
        if (status != image.status) return false;
        return created != null ? created.equals(image.created) : image.created == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + (big != null ? big.hashCode() : 0);
        result = 31 * result + (small != null ? small.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", project=" + project.getId() +
                ", big='" + big + '\'' +
                ", small='" + small + '\'' +
                ", status=" + status +
                ", created=" + created +
                '}';
    }
}
