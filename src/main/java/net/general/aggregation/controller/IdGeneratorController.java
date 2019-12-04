package net.general.aggregation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<CharSequence> list=new ArrayList<>();
        List<CharSequence> character=new ArrayList<>();
        List<CharSequence> collect = list.parallelStream().filter(x -> character.contains(x)).collect(Collectors.toList());
        return null;
    }
}
