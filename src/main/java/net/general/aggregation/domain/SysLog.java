package net.general.aggregation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: dreamer Q
 * @Date: 2019/12/3 22:26
 * @Version 1.0
 * @Discription
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysLog implements Serializable {
    private Long id;

    private String username; //用户名

    private String operation; //操作

    private String method; //方法名

    private String params; //参数

    private String ip; //ip地址

    private Date createDate; //操作时间
    //创建getter和setter方法
}
