package com.rc.users;

public class Registered extends User {

    private String username;
    private String password;

    public Registered(String firstName, String lastName, String email, String username, String password) {
        super(firstName, lastName, email);
        this.username = username;
        this.password = password;
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

    public boolean login(String username, String password){
        return (username.equals(this.username) && password.equals(this.password));
    }
}
