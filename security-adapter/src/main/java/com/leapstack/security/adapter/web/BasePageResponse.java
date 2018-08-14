package com.leapstack.security.adapter.web;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
public class BasePageResponse<T> {

    @ApiModelProperty(value = "每页元素数量，默认10")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "当前页号，默认0")
    private Integer pageNumber = 0;

    @ApiModelProperty(value = "当前分页元素集合")
    private List<T> content;

    @ApiModelProperty(value = "总页数")
    private Integer totalPages;

    @ApiModelProperty(value = "总元素个数")
    private Long totalElements;

    public BasePageResponse(Page<T> page) {
        this.pageSize = page.getSize();
        this.pageNumber = page.getNumber();
        this.content = page.getContent();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
    }
}
