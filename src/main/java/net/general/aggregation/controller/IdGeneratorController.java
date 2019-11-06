package net.general.aggregation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dreamer Q
 * @Date: 2019/10/29 21:11
 * @Version 1.0
 * @Discription 分布式id生成
 */
@Controller("/api/v1/id")
public class IdGeneratorController {

    /**
     * 分布式id生成测试
     * @return
     */
    @RequestMapping("/generator")
    public List<String> IdGeneratorTest(){
        List<String> list=new ArrayList<>();
        return list;
    }
}
