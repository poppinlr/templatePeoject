package com.leapstack.security.adapter.web;

import com.leapstack.security.adapter.config.constants.enums.ResponseCommonCode;
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
    private String status = ResponseCommonCode.SUCCESS.getValue();

    @ApiModelProperty(value = "response message")
    private String message = ResponseCommonCode.SUCCESS.getMessage();

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
    public ResponseMessageWrapper(ResponseCommonCode responseStatusEnum, String errorMessage) {
        this.status = responseStatusEnum.getValue();
        if (StringUtils.isNotBlank(errorMessage)) {
            this.message = errorMessage;
        } else {
            this.message = responseStatusEnum.getMessage();
        }
    }
}
