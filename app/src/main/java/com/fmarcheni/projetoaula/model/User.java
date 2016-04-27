package com.fmarcheni.projetoaula.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by flavi on 22/04/2016.
 */
@Table(name = "user")
public class User extends Model{


    @Column(index = true, name = "name")
    private  String  name;
    @Column(index = true, name = "email")
    private   String  email;
    @Column( name = "password")
    private  String password;

    public User() {

    }

    public User( String name, String email, String password) {
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
