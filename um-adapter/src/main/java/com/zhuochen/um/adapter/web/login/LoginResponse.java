package com.zhuochen.um.adapter.web.login;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginResponse {

    @ApiModelProperty(value = "风险结果")
    private String token;

    @ApiModelProperty(value = "风险结果")
    private String username;

    @ApiModelProperty(value = "风险结果")
    private String name;
}
