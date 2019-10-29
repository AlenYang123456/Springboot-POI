package net.general.aggregation.service;

import net.general.aggregation.domain.User;

import java.util.List;

/**
 * @Author: 杨强
 * @Date: 2019/10/24 17:22
 * @Version 1.0
 * @Discription
 */
public interface IUserService  {

     void saveBatch(List<User> list) throws Exception;
}
