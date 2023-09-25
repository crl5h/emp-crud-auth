package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class UserRoleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private Long id;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "description")
    private String roleDesc;


    @ManyToMany(mappedBy = "userRoleGroups")
    private Set<User> users;

    @ManyToMany
    @JoinTable(
            name = "role_group_mapping",
            joinColumns = @JoinColumn(name = "role_group_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions;
}
