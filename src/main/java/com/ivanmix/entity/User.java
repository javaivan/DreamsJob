package com.ivanmix.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by ivan on 19.07.2016.
 */

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=255, min = 5)
    private String login;

    @NotNull
    @Size(max=255, min = 5)
    private String email;

    @NotNull
    @Size(max=255, min = 5)
    private String password;

    @Size(max=255, min = 5)
    @Column(name = "first_name")
    private String firstName;

    @Size(max=255, min = 5)
    @Column(name = "last_name")
    private String lastName;

    private Date created;

    private String status;


    @Column(name = "big_image", length=250)
    private String bigImage;

    @Column(name = "small_image", length=250)
    private String smallImage;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    //@OneToMany(mappedBy = "user", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private Set<UserRole> userRole;

    //@OneToMany(mappedBy = "user", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reply> projectReplies;

    @OneToMany(mappedBy = "user", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<Project> projects;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "reader", cascade = CascadeType.ALL)
    private List<Reply> projectReaderReplies;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<UserRole> getUserRole() {
        return this.userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }

    public List<Reply> getProjectReplies() {
        return projectReplies;
    }

    public void setProjectReplies(List<Reply> projectReplies) {
        this.projectReplies = projectReplies;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Reply> getProjectReaderReplies() {
        return projectReaderReplies;
    }

    public void setProjectReaderReplies(List<Reply> projectReaderReplies) {
        this.projectReaderReplies = projectReaderReplies;
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (created != null ? !created.equals(user.created) : user.created != null) return false;
        if (status != null ? !status.equals(user.status) : user.status != null) return false;
        if (userRole != null ? !userRole.equals(user.userRole) : user.userRole != null) return false;
        if (projectReplies != null ? !projectReplies.equals(user.projectReplies) : user.projectReplies != null)
            return false;
        if (projects != null ? !projects.equals(user.projects) : user.projects != null) return false;
        return projectReaderReplies != null ? projectReaderReplies.equals(user.projectReaderReplies) : user.projectReaderReplies == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (userRole != null ? userRole.hashCode() : 0);
        result = 31 * result + (projectReplies != null ? projectReplies.hashCode() : 0);
        result = 31 * result + (projects != null ? projects.hashCode() : 0);
        result = 31 * result + (projectReaderReplies != null ? projectReaderReplies.hashCode() : 0);
        return result;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", created=" + created +
                '}';
    }

}
