package com.suny.association.configurations;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Comments:   解决shiro过滤器时还没有装配bean组件的错误，装配到applicationContext
 * Author:   孙建荣
 * Create Date: 2017/03/11 19:59
 */
//@Configuration
public class ShiroConfig implements ApplicationContextAware{
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
   Realm myShiroRealm= (Realm) applicationContext.getBean("myShiroRealm");
     DefaultSecurityManager defaultSecurityManager;
        defaultSecurityManager = (DefaultSecurityManager) applicationContext.getBean("securityManager");
        defaultSecurityManager.setRealm(myShiroRealm);

    }
}
