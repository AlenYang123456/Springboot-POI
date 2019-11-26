package net.general.aggregation.mapper;

import net.general.aggregation.domain.Menu;

import java.util.List;

/**
 * @Author: dreamer Q
 * @Date: 2019/11/18 21:00
 * @Version 1.0
 * @Discription 菜单mapper
 */
public interface MenuDao {
    /** 查询所有权限 */
    List<Menu> selectAll();
}
