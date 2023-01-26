package org.example.model;

public class Password {
    String url;

    String email;

    String password;

    public Password(String url, String email, String password) {
        this.url = url;
        this.email = email;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
