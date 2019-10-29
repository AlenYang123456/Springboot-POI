package net.general.aggregation.service.impl;

import net.general.aggregation.domain.User;
import net.general.aggregation.mapper.UserMapper;
import net.general.aggregation.service.IUserService;
import net.general.aggregation.utils.ImportThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 杨强
 * @Date: 2019/10/24 17:23
 * @Version 1.0
 * @Discription
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public void saveBatch(List<User> list) throws Exception {
        //一个线程处理200条数据
        int count = 200;
        //数据集合大小
        int listSize = list.size();
        //开启的线程数
        int runSize = (listSize / count) + 1;
        //存放每个线程的执行数据
        List<User> newlist = null;

        //创建一个线程池，数量和开启线程的数量一样
        //Executors 的写法
        // ExecutorService executor = Executors.newFixedThreadPool(runSize);

        //ThreadPoolExecutor的写法
        ThreadPoolExecutor executor = new ThreadPoolExecutor(runSize, runSize, 1,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        //创建两个个计数器
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(runSize);
        //循环创建线程
        for (int i = 0; i < runSize; i++) {
            //计算每个线程执行的数据
            if ((i + 1) == runSize) {
                int startIndex = (i * count);
                int endIndex = list.size();
                newlist = list.subList(startIndex, endIndex);
            } else {
                int startIndex = (i * count);
                int endIndex = (i + 1) * count;
                newlist = list.subList(startIndex, endIndex);
            }
            //线程类
            ImportThread mythead = new ImportThread(newlist, begin, end,userMapper);
            //这里执行线程的方式是调用线程池里的executor.execute(mythead)方法。
            executor.execute(mythead);
        }
        begin.countDown();
        end.await();
        //执行完关闭线程池
        executor.shutdown();
    }
}
