package com.ray.crawler.house.system;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AppContext implements ApplicationContextAware{

    private static AppContext _appContext ;
    
    private static ApplicationContext _applicationContext;

    private AppContext() {
        _appContext = this;
    }

    public ApplicationContext getApplicationContext() {
        return _applicationContext;
    }

    public static AppContext instance() {
        if( _applicationContext == null){
            throw new RuntimeException("AppContext initialize is incomplete!");
        }
        return _appContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        _applicationContext= applicationContext;
    }

}
