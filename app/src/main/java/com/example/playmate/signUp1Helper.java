package com.example.playmate;

public class signUp1Helper {
    String first, last, email, username, password;

    public signUp1Helper() {    }

    public signUp1Helper(String first, String last, String email, String username, String password) {
        this.first = first;
        this.last = last;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
