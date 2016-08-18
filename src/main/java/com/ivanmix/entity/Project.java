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


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project", cascade = CascadeType.ALL)
    private List<Reply> replies;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != null ? !id.equals(project.id) : project.id != null) return false;
        if (user != null ? !user.equals(project.user) : project.user != null) return false;
        if (title != null ? !title.equals(project.title) : project.title != null) return false;
        if (description != null ? !description.equals(project.description) : project.description != null) return false;
        if (created != null ? !created.equals(project.created) : project.created != null) return false;
        if (update != null ? !update.equals(project.update) : project.update != null) return false;
        if (replies != null ? !replies.equals(project.replies) : project.replies != null) return false;
        return status != null ? status.equals(project.status) : project.status == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (update != null ? update.hashCode() : 0);
        result = 31 * result + (replies != null ? replies.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    /*
    @Override
    public String
    toString() {
        String projectReplyItem = "";
        for (ProjectReply item: projectReplies){
            projectReplyItem += item.toString();
            projectReplyItem += " | ";
        }

        return "Project{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", update=" + update +
                ", projectReplies=" + projectReplyItem +
                ", status='" + status + '\'' +
                '}';
    }*/
/*
    @Override
    public String toString() {
        return String.format("%s[id=%s]", getClass().getSimpleName(),  getId());
    }*/
}
