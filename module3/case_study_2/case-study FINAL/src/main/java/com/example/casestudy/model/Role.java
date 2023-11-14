package com.example.casestudy.model;

public class Role {
    private int idRole;
    private String roles;

    public Role() {
    }

    public Role(int idRole, String roles) {
        this.idRole = idRole;
        this.roles = roles;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", roles='" + roles + '\'' +
                '}';
    }


}
