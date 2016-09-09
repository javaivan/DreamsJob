package com.ivanmix.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "project_reply")
public class Reply {

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
    @JoinColumn(name="reader_id", nullable=false)
    private User reader;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private List<Reply> children;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id", insertable=true)
    private Reply parent;

    @NotNull
    @Size(min = 5)
    private String reply;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private ReplyStatus replyStatus;

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

    public List<Reply> getChildren() {
        return children;
    }

    public void setChildren(List<Reply> children) {
        this.children = children;
    }

    public Reply getParent() {
        return parent;
    }

    public void setParent(Reply parent) {
        this.parent = parent;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public User getReader() {
        return reader;
    }

    public void setReader(User reader) {
        this.reader = reader;
    }

    public ReplyStatus getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(ReplyStatus replyStatus) {
        this.replyStatus = replyStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reply reply1 = (Reply) o;

        if (id != null ? !id.equals(reply1.id) : reply1.id != null) return false;
        if (project != null ? !project.equals(reply1.project) : reply1.project != null) return false;
        if (user != null ? !user.equals(reply1.user) : reply1.user != null) return false;
        if (reader != null ? !reader.equals(reply1.reader) : reply1.reader != null) return false;
        if (children != null ? !children.equals(reply1.children) : reply1.children != null) return false;
        if (parent != null ? !parent.equals(reply1.parent) : reply1.parent != null) return false;
        if (reply != null ? !reply.equals(reply1.reply) : reply1.reply != null) return false;
        return replyStatus == reply1.replyStatus;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (reader != null ? reader.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        result = 31 * result + (reply != null ? reply.hashCode() : 0);
        result = 31 * result + (replyStatus != null ? replyStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%s]", getClass().getSimpleName(),  getId());
    }
}