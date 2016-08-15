package com.ivanmix.form;


import com.ivanmix.entity.Project;
import com.ivanmix.entity.User;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProjectReplyForm {

    @NotNull
    private Long project;

    @NotNull
    @Size(min = 5)
    private String reply;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectReplyForm that = (ProjectReplyForm) o;

        if (project != null ? !project.equals(that.project) : that.project != null) return false;
        return reply != null ? reply.equals(that.reply) : that.reply == null;

    }

    @Override
    public int hashCode() {
        int result = project != null ? project.hashCode() : 0;
        result = 31 * result + (reply != null ? reply.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProjectReplyForm{" +
                "project=" + project +
                ", reply='" + reply + '\'' +
                '}';
    }
}
