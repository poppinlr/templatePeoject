package com.zhuochen.um.adapter.web.login;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    @NotBlank
    @ApiModelProperty(value = "风险结果")
    private String username;

    @NotBlank
    @ApiModelProperty(value = "风险结果")
    private String password;
}
