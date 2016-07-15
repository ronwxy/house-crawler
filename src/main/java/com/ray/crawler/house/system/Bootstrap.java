package com.ray.crawler.house.system;

import com.ray.crawler.house.domain.ProjectInfo;
import com.ray.crawler.house.service.IProjectInfoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by ray4w on 2016/7/15.
 */
public class Bootstrap {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:applicationContext.xml"});

        IProjectInfoService projectInfoService = context.getBean(IProjectInfoService.class);
        ProjectInfo projectInfo = new ProjectInfo();
        projectInfo.setAddress("xxx");
        projectInfo.setCertificateDate(new Date());
        projectInfo.setPresellNo("123");
        projectInfo.setProjectName("≤‚ ‘œÓƒø.");
        projectInfoService.create(projectInfo);
    }
}
