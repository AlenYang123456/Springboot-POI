//package net.general.aggregation.base.permission;
//
//import net.general.aggregation.domain.User;
//import net.general.aggregation.enums.ResultEnum;
//import net.general.aggregation.exception.BusinessException;
//import net.general.aggregation.mapper.UserRoleDao;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//
//import java.lang.reflect.Method;
//
//
///**
// * @Author: dreamer Q
// * @Date: 2019/11/18 20:15
// * @Version 1.0
// * @Discription 权限校验切面类
// */
//@Aspect("permissionCheckAspect")
//public class PermissionCheckAspect {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionCheckAspect.class);
//
//    @Value("${super.administrator.name}")
//    private String  superAdministrator;
//
//    @Autowired
//    private UserRoleDao userRoleDao;
//
//
//    /**
//     * 配置织入点
//     */
//    @Pointcut("@annotation(net.general.aggregation.base.permission.PermissionCheck)")
//    public void permissionCheckPointCut(){
//
//    }
//
//    /**
//     * 前置通知 用于拦截操作,在方法返回后执行
//     * @param joinPoint
//     * @throws Exception
//     */
//    @Before("permissionCheckPointCut()")
//    public void doBefore(JoinPoint joinPoint) throws Exception{
//        handle(joinPoint,null);
//    }
//
//    private void handle(JoinPoint joinPoint, Exception e)throws Exception {
//        try {
//            //获得注解
//            PermissionCheck permissionCheck=getAnnotationLog(joinPoint);
//            if (permissionCheck==null){
//                return;
//            }
//
//            Object controller = joinPoint.getTarget();
//            Method getCurrentUser = controller.getClass().getMethod("getCurrentUser");
//            if (getCurrentUser==null) {
//                Object user = getCurrentUser.invoke(controller);
//                if (user==null) {
//                    //抛出没有权限异常
//                    throw  new BusinessException(ResultEnum.FAIL);
//                }
//                if (((User)user).getLoginName().equals(superAdministrator)) {
//                    //超级管理员
//                    return;
//                }
////                if (((User)user).getLoginName().equals(permissionCheck.value())) {
////                   throw BusinessException.NO_PERMISSION_EXCEPTION;
////                }
//                Integer menuId=PermissionManager.getPermissionsMap().get(permissionCheck.value());
//                if (menuId==null) {
//                    //抛出没有权限异常
//                    throw new BusinessException(ResultEnum.FAIL);
//                }
//                boolean hasPermission=this.userRoleDao.selectExistPermission(((User)user).getRoleId,menuId);
//                if (!hasPermission) {
//                    throw new BusinessException(ResultEnum.FAIL);
//                }
//            }
//        } catch (BusinessException e1) {
//
//            throw e1;
//        }catch (Exception e1){
//            //记录本地异常日志
//            LOGGER.error("检查用户权限出错:[{}]", e1.getMessage());
//            e1.printStackTrace();
//        }
//    }
//
//    /**
//     * 是否存在注解,如果存在就获取
//     * @param joinPoint
//     * @return
//     */
//    private PermissionCheck getAnnotationLog(JoinPoint joinPoint) {
//        Signature signature = joinPoint.getSignature();
//        MethodSignature methodSignature = (MethodSignature) signature;
//        Method method = methodSignature.getMethod();
//        if (method!=null) {
//            return method.getAnnotation(PermissionCheck.class);
//        }
//        return null;
//    }
//}
