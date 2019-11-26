//package net.general.aggregation.base.permission;
//
//import net.general.aggregation.domain.Menu;
//import net.general.aggregation.mapper.MenuDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Author: dreamer Q
// * @Date: 2019/11/18 20:57
// * @Version 1.0
// * @Discription 权限管理类
// */
//@Component
//public class PermissionManager {
//    @Value("classpath:permission.json")
//    private Resource permissionRes;
//
//    private static final Map<String,Integer> PERMISSIONS_MAP=new HashMap<>(32);
//
//    @Autowired
//    private MenuDao menuDao;
//
//    @PostConstruct
//    public void init(){
//        List<Menu> menus=menuDao.selectAll();
//        for (Menu menu : menus) {
//            PERMISSIONS_MAP.put(menu.getResource(), menu.getId());
//        }
//    }
//
//    public static Map<String,Integer> getPermissionsMap(){
//        return PERMISSIONS_MAP;
//    }
//}
