package net.general.aggregation.mapper;


import net.general.aggregation.domain.User;

import java.util.List;

/**
 *
 * @author hubin
 * @since 2018-08-11
 */
public interface UserMapper  {

    void saveBatch(List<User> list);
}
