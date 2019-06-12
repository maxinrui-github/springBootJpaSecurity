package com.master.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Maxinrui
 * \* Date: 2019/6/12
 * \* Time: 10:40
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Entity
@Table(name = "sys_role")
public class SysRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<SysUser> users = new HashSet<>();;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_role_meun",joinColumns = @JoinColumn(name="role_id"),inverseJoinColumns = @JoinColumn(name="meun_id"))
    private Set<SysMeun> meuns = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SysUser> getUsers() {
        return users;
    }

    public void setUsers(Set<SysUser> users) {
        this.users = users;
    }

    public Set<SysMeun> getMeun() {
        return meuns;
    }

    public void setMeun(Set<SysMeun> meuns) {
        this.meuns = meuns;
    }
}