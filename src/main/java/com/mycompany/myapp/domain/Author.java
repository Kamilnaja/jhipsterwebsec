package com.mycompany.myapp.domain;

import org.checkerframework.common.aliasing.qual.Unique;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity(name="Author")
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @Email
    @NotNull
    @Unique
    @Column(unique = true)
    private String email;

    public Author() {
    }

    public Author(@NotNull String firstname, @NotNull String lastname, @NotNull String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Author(String firstname) {
        this.firstname = firstname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
