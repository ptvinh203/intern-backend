package com.ptvinh203.internbackend.util.base_model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.ptvinh203.internbackend.util.constant.CommonConstant;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiDataResponse {

    private String status;
    private Object data;
    private Object error;
    private Object meta;

    /**
     * Create successful generic response instance
     *
     * @param data Data object
     * @param meta Meta data include paging information
     * @return ApiDataResponse
     */
    public static ApiDataResponse success(Object data, Object meta) {
        return ApiDataResponse.builder().status(CommonConstant.SUCCESS).data(data).meta(meta).build();
    }

    public static ApiDataResponse successWithoutMeta(Object data) {
        return ApiDataResponse.builder().status(CommonConstant.SUCCESS).data(data).build();
    }

    public static ApiDataResponse successWithoutMetaAndData() {
        return ApiDataResponse.builder().status(CommonConstant.SUCCESS).build();
    }

    /**
     * Create failed generic response instance
     *
     * @param error Error object description
     * @return ResponseDataAPI
     */
    public static ApiDataResponse error(Object error) {
        return ApiDataResponse.builder().status(CommonConstant.FAILURE).error(error).build();
    }
}
