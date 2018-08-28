package com.zhuochen.um.backend.jpa.entity;

import com.zhuochen.um.backend.config.listener.CreateAndModifyListener;
import com.zhuochen.um.backend.jpa.entity.base.BaseDataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "role_data")
@EntityListeners(CreateAndModifyListener.class)
@ToString(exclude = {"userDataEntityList", "accessDataEntityList"})
public class RoleDataEntity extends BaseDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_data_id")
    private Long roleDataId;

    @Column(name = "name", columnDefinition = "角色名", unique = true)
    private String name;

    @Column(name = "comment", columnDefinition = "角色描述")
    private String comment;

    @OneToMany(mappedBy = "roleDataEntity")
    private List<UserDataEntity> userDataEntityList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "role_to_access_data",
            joinColumns = {@JoinColumn(name = "role_data_id")},
            inverseJoinColumns = {@JoinColumn(name = "access_data_id")})
    private List<AccessDataEntity> accessDataEntityList;
}
