package net.general.aggregation.controller;

import net.general.aggregation.vo.request.TestLocalDateTimeVO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @Author: dreamer Q
 * @Date: 2019/11/26 20:32
 * @Version 1.0
 * @Discription 测试接口 LocalDateTime 类型的入参自动转换
 */
@RestController
@RequestMapping("/v2/api")
public class TestController {
    
    /**
    * @Description: 测试Get请求 接口入参LocalDate格式化
    * @Param: [localDateTime]
    * @return: java.lang.String
    * @Date: 2019-11-26
    */
    @GetMapping("/testget")
    public String testget( LocalDateTime localDateTime){
        System.out.println(localDateTime);
        return "success~get 请求";
    }


    @PostMapping("/testpost")
    public String testpost(@RequestBody TestLocalDateTimeVO localDateTimeVO){
        System.out.println(localDateTimeVO.getLocalDateTime());
        return "success~post 请求";
    }
}
