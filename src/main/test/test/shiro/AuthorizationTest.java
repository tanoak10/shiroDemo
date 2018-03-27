package test.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import test.BaseTest;

public class AuthorizationTest extends BaseTest {


    @Test
    public void test(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(
                "classpath:shiro-permission.ini") ;
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","123456") ;
        //执行认证
        subject.login(token);
        System.out.println("认证状态: "+subject.isAuthenticated());

        //是否拥有权限
        boolean hasRole = subject.hasRole("role1");
        System.out.println(hasRole);

        boolean permitted = subject.isPermitted("user:update");
        System.out.println(permitted);
    }
}
