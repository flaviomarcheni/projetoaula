package com.fmarcheni.projetoaula.model;

import android.text.TextUtils;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

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

    public User(String name, String email, String password)  throws Exception{
        this.name = name;
        this.email = email;
        this.password = password;
        if(name==null || name.isEmpty() || name.length() <3){
            throw  new Exception("O nome deve ter no mínimo 3 letras.");
        }
        if(password==null || password.isEmpty() || password.length() <6){
            throw  new Exception("A senha deve ter no mínimo 6 caracters.");
        }
        if(!isValidEmail(email)){
            throw  new Exception("Email inválido");
        }

    }

    public final static boolean isValidEmail(String target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public static User findByUserAndPassword(String user, String password) {
        return new Select()
                .from(User.class)
                .where("email = ?", user)
                .and("password =?",password)
                .executeSingle();
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
