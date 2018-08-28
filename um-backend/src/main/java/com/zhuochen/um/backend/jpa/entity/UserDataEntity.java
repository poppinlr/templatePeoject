package com.zhuochen.um.backend.jpa.entity;

import com.zhuochen.um.adapter.config.enums.GenderEnum;
import com.zhuochen.um.backend.config.constants.CommonConstant;
import com.zhuochen.um.backend.config.listener.CreateAndModifyListener;
import com.zhuochen.um.backend.jpa.entity.base.BaseDataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_data")
@EntityListeners(CreateAndModifyListener.class)
@ToString(exclude = {"companyDataEntity", "roleDataEntity"})
public class UserDataEntity extends BaseDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_data_id")
    private Long userDataId;

    @Column(name = "username", columnDefinition = "系统登录账号", unique = true)
    private String username;

    @Column(name = "password", columnDefinition = "系统登录密码")
    @ColumnTransformer(
            read = "AES_DECRYPT(password, '" + CommonConstant.ENCRYPTION_KEY + "')",
            write = "AES_ENCRYPT(?, '" + CommonConstant.ENCRYPTION_KEY + "')")
    private String password;

    @Column(name = "name", columnDefinition = "系统显示名")
    private String name;

    @Column(name = "phone", columnDefinition = "联系电话")
    private String phone;

    @Column(name = "gender", columnDefinition = "性别")
    @Enumerated
    private GenderEnum gender;

    @Column(name = "company_data_id")
    private Long companyDataId;

    @Column(name = "role_data_id")
    private Long roleDataId;

    @ManyToOne
    @JoinColumn(name = "company_data_id", referencedColumnName = "company_data_id", insertable = false, updatable = false)
    private CompanyDataEntity companyDataEntity;

    @ManyToOne
    @JoinColumn(name = "role_data_id", referencedColumnName = "role_data_id", insertable = false, updatable = false)
    private RoleDataEntity roleDataEntity;
}
