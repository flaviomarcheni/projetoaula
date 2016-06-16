package com.fmarcheni.projetoaula.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by flavi on 22/04/2016.
 */
@Table(name = "user")
public class User extends Model{


    @Column(index = true, name = "name", length = 100, notNull = false)
    private  String  name;
    @Column(index = true, name = "email",unique = true, notNull = false, length = 50)
    private   String  email;
    @Column( name = "password", notNull = false)
    private  String password;

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
