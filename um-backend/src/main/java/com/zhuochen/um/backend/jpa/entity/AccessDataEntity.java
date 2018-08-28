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
@Table(name = "access_data")
@EntityListeners(CreateAndModifyListener.class)
@ToString(exclude = "roleDataEntityArrayList")
public class AccessDataEntity extends BaseDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "access_data_id")
    private Long accessDataId;

    @Column(name = "name", columnDefinition = "权限名")
    private String name;

    @Column(name = "comment", columnDefinition = "权限描述")
    private String comment;

    @Column(name = "url", columnDefinition = "权限地址", unique = true)
    private String url;

    @ManyToMany(mappedBy = "accessDataEntityList")
    private List<RoleDataEntity> roleDataEntityArrayList;
}
