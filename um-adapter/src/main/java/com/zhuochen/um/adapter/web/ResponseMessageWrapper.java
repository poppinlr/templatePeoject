package com.zhuochen.um.adapter.web;

import com.zhuochen.um.adapter.config.enums.ResponseCommonCodeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@NoArgsConstructor
public class ResponseMessageWrapper<T> {

    @ApiModelProperty(value = "response data")
    private T data;

    @ApiModelProperty(value = "response status")
    private String status = ResponseCommonCodeEnum.SUCCESS.getValue();

    @ApiModelProperty(value = "response message")
    private String message = ResponseCommonCodeEnum.SUCCESS.getMessage();

    /**
     * SUCCESS 返回，并封装数据
     *
     * @param data
     */
    public ResponseMessageWrapper(T data) {
        this.data = data;
    }

    /**
     * ERROR 返回状态和错误信息
     *
     * @param responseStatusEnum
     * @param errorMessage
     */
    public ResponseMessageWrapper(ResponseCommonCodeEnum responseStatusEnum, String errorMessage) {
        if (StringUtils.isNotBlank(errorMessage)) {
            this.status = responseStatusEnum.getValue();
            this.message = errorMessage;
        } else {
            this.status = responseStatusEnum.getValue();
            this.message = responseStatusEnum.getMessage();
        }
    }
}
