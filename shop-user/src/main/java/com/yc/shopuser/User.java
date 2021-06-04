package com.yc.shopuser;

import java.io.Serializable;

/**
 * @program: shop-index
 * @description:
 * @author: 作者
 * @create: 2021-05-09 09:26
 */
public class User implements Serializable {


    private static final long serialVersionUID = -4471523227528608825L;

    private String name;
    private String pwd;
    private Integer age;
    private char gender;

    public char getGender() {
        return gender;
    }

    public User(String name, String pwd, Integer age, char gender) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
        this.gender = gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public Integer getAge() {
        return age;
    }

    public User(String name, String pwd, Integer age) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
    }

    public User() {
    }
}
