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
@Table(name = "company_data")
@EntityListeners(CreateAndModifyListener.class)
@ToString(exclude = "userDataEntityList")
public class CompanyDataEntity extends BaseDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_data_id")
    private Long companyDataId;

    @Column(name="company_code", columnDefinition = "公司代码", unique = true)
    private String companyCode;

    @Column(name = "company_name", columnDefinition = "公司名称")
    private String companyName;

    @Column(name = "address", columnDefinition = "联系地址")
    private String address;

    @Column(name = "phone", columnDefinition = "联系电话")
    private String phone;

    @OneToMany(mappedBy = "companyDataEntity")
    private List<UserDataEntity> userDataEntityList;
}
