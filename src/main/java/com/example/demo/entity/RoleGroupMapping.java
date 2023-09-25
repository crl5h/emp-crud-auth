package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "role_group_mapping")
@Getter
@Setter
public class RoleGroupMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_group_id")
    private UserRoleGroup role;

    @ManyToOne
    @JoinColumn(name = "permission_id")
    private Permission pid;
}
