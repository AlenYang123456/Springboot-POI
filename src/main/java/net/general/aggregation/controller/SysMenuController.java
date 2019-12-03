package net.general.aggregation.controller;

import com.baomidou.mybatisplus.extension.api.R;
import net.general.aggregation.config.MyLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dreamer Q
 * @Date: 2019/12/3 22:36
 * @Version 1.0
 * @Discription
 */
@RestController
@RequestMapping("/sys")
public class SysMenuController{


    @MyLog(value = "删除菜单记录")  //这里添加了AOP的自定义注解
    @GetMapping("/list")
    public R deleteBatch() {
        System.out.println("success");
        return R.ok("删除成功");
    }
}