package com.leapstack.security.adapter.web;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.PageRequest;

@Data
public class BasePageRequest {

    @ApiModelProperty(value = "每页元素数量")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "当前页号")
    private Integer pageNumber = 0;

    public PageRequest getPageRequest() {
        return PageRequest.of(this.pageNumber, this.pageSize);
    }
}
