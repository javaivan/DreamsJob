package com.ivanmix.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "project_reply")
public class ProjectReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="project_id", nullable=false)
    private Project project;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "parent_id",insertable=false,updatable=false)
    private ProjectReply parent;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private List<ProjectReply> subProjectReply;

    @NotNull
    @Size(min = 5)
    private String reply;

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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public ProjectReply getParent() {
        return parent;
    }

    public void setParent(ProjectReply parent) {
        this.parent = parent;
    }

    public List<ProjectReply> getSubProjectReply() {
        return subProjectReply;
    }

    public void setSubProjectReply(List<ProjectReply> subProjectReply) {
        this.subProjectReply = subProjectReply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectReply that = (ProjectReply) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (project != null ? !project.equals(that.project) : that.project != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (parent != null ? !parent.equals(that.parent) : that.parent != null) return false;
        if (subProjectReply != null ? !subProjectReply.equals(that.subProjectReply) : that.subProjectReply != null)
            return false;
        return reply != null ? reply.equals(that.reply) : that.reply == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        result = 31 * result + (subProjectReply != null ? subProjectReply.hashCode() : 0);
        result = 31 * result + (reply != null ? reply.hashCode() : 0);
        return result;
    }
/*
    @Override
    public String toString() {
        String subProjectReplyItem = "";
        for (ProjectReply item: subProjectReply){
            subProjectReplyItem += item.getId();
            subProjectReplyItem += " | ";
        }
        return "ProjectReply{" +
                "id=" + id +
                ", project=" + project.getId() +
                ", user=" + user +
                ", parent=" + parent.getId() +
                ", subProjectReply=" + subProjectReplyItem +
                ", reply='" + reply + '\'' +
                '}';
    }*/
/*
    @Override
    public String toString() {
        return String.format("%s[id=%s]", getClass().getSimpleName(),  getId());
    }*/
}