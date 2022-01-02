package edu.jsut.nursing.model;

public class Admin {
    private String adminRname;

    private String password;

    public String getAdminRname() {
        return adminRname;
    }

    public void setAdminRname(String adminRname) {
        this.adminRname = adminRname == null ? null : adminRname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}