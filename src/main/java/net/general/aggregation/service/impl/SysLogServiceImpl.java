package net.general.aggregation.service.impl;

import net.general.aggregation.domain.SysLog;
import net.general.aggregation.service.SysLogService;
import org.springframework.stereotype.Service;

/**
 * @Author: dreamer Q
 * @Date: 2019/12/3 22:41
 * @Version 1.0
 * @Discription
 */

@Service
public class SysLogServiceImpl implements SysLogService {
    @Override
    public void save(SysLog sysLog) {

        System.out.println("保存日志成功");
    }
}
