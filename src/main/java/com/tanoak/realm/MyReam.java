package com.tanoak.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyReam  extends AuthorizingRealm{
    @Override
    public void setName(String name) {
        super.setName("My Realm");
    }

    /**
    * 认证
    **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //Token是用户输入
        //1取出身份信息
        String userCode = (String) token.getPrincipal();

        if(!userCode.equals("zhangsan")){
            return null ;
        }
        //2 根据用户输入的Token取出身份信息
        String password = "111111" ;

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userCode ,password ,this.getName()) ;

        return simpleAuthenticationInfo;
    }

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
    }

}
