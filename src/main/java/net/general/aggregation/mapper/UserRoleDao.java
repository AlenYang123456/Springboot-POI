package net.general.aggregation.mapper;

/**
 * @Author: dreamer Q
 * @Date: 2019/11/18 20:54
 * @Version 1.0
 * @Discription 用户权限mapper
 */
public interface UserRoleDao {
    /** 根据角色Id获取是否有对应权限 */
    boolean selectExistPermission(Integer getRoleId, Integer menuId);
}
