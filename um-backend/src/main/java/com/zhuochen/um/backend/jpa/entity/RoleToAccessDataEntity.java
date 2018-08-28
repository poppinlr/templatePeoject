package com.zhuochen.um.backend.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role_to_access_data")
public class RoleToAccessDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_to_access_data_id")
    private Long roleToAccessDataId;

    @Column(name = "user_data_id")
    private Long userDataId;

    @Column(name = "access_data_id")
    private Long accessDataId;
}
