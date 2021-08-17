package com.example.playmate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class petSignUpHelper {
    String name, age, bio, fixed, size, energy, temp;
    List description;

    public petSignUpHelper() {
    }

    public petSignUpHelper(String name, String age, String bio, String fixed) {
        this.name = name;
        this.age = age;
        this.bio = bio;
        this.fixed = fixed;
    }

    public petSignUpHelper(String size, String energy, String temp) {
        this.size = size;
        this.energy = energy;
        this.temp = temp;
    }

    public petSignUpHelper(String name, String age, String bio, String fixed, String size, String energy, String temp) {
        this.name = name;
        this.age = age;
        this.bio = bio;
        this.fixed = fixed;
        this.size = size;
        this.energy = energy;
        this.temp = temp;
    }

    public petSignUpHelper(String name, String age, String bio, String fixed, String size, String energy, String temp, List description) {
        this.name = name;
        this.age = age;
        this.bio = bio;
        this.fixed = fixed;
        this.size = size;
        this.energy = energy;
        this.temp = temp;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFixed() {
        return fixed;
    }

    public void setFixed(String fixed) {
        this.fixed = fixed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public List getDescription() {
        return description;
    }
}
