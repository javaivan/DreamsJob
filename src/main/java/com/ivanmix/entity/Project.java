package com.ivanmix.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author_id")
    private long authorId;

    @NotNull
    @Size(max=255, min = 5)
    private String title;

    @NotNull
    @Size(min = 5)
    private String description;

    @Column(insertable=false)
    private Timestamp created;

    @Column(insertable=false)
    private Date update;

    //@OneToMany(mappedBy = "project", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project", cascade = CascadeType.ALL)
    private List<ProjectReply> projectReplies;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @PreUpdate
    protected void onUpdate() {
        this.update = new Date();
    }

    public List<ProjectReply> getProjectReplies() {
        return projectReplies;
    }

    public void setProjectReplies(List<ProjectReply> projectReplies) {
        this.projectReplies = projectReplies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != project.id) return false;
        if (authorId != project.authorId) return false;
        if (title != null ? !title.equals(project.title) : project.title != null) return false;
        if (description != null ? !description.equals(project.description) : project.description != null) return false;
        if (created != null ? !created.equals(project.created) : project.created != null) return false;
        return status != null ? status.equals(project.status) : project.status == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (int) (authorId ^ (authorId >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", status='" + status + '\'' +
                '}';
    }
}
