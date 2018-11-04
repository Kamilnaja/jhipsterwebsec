package com.mycompany.myapp.models;

import javax.persistence.*;
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
    private String secondname;

    @NotNull
    @Column(unique = true)
    private String email;

    public Author() {
    }

    public Author(@NotNull String firstname, @NotNull String secondname, @NotNull String email) {
        this.firstname = firstname;
        this.secondname = secondname;
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

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
