package net.general.aggregation.vo.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 杨强
 * @Date: 2019/10/25 10:16
 * @Version 1.0
 * @Discription 错误的文件上传请求对象
 */
@Data
public class ErrorUploadReq {

    /** 上传的Excel文件 */
    private MultipartFile file;

    /** 上传的name */
    private String name;
}
