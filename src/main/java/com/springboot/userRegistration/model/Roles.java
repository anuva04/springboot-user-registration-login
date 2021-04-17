package com.springboot.userRegistration.model;
import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name = "auth_role")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auth_role_id")
    private int id;

    @Column(name = "role_name")
    private String role;

    @Column(name = "role_desc")
    private String desc;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getRoles(){
        return role;
    }
    public void setRoles(String role){
        this.role = role;
    }
    public String getDesc(){
        return desc;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
    public Set<User> getUsers(){
        return users;
    }
    public void setUsers(Set<User> users){
        this.users = users;
    }
}
