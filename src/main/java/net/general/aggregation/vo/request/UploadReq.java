package net.general.aggregation.vo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: 杨强
 * @Date: 2019/10/25 10:19
 * @Version 1.0
 * @Discription 文件上传请求对象
 */
@Data
public class UploadReq {
    /** 姓名字段 */
    @NotBlank(message = "名称字段非空")
    private String  name;
}
