package com.aviatrade.entity;

import com.aviatrade.entity.Aircraft;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usr_id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;

//    @OneToMany()
//    private List<Aircraft> list = new ArrayList<>();

    public User() {
    }

    public User(String name, String surname, String username, String password, String email) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

//    public List<Aircraft> getList() {
//        return list;
//    }
//
//    public void setList(List<Aircraft> list) {
//        this.list = list;
//    }

    public long getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(long usr_id) {
        this.usr_id = usr_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + usr_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
