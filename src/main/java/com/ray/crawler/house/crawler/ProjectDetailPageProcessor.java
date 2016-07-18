package com.ray.crawler.house.crawler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.QueueScheduler;

import com.ray.crawler.house.service.IProjectInfoService;

public class ProjectDetailPageProcessor implements PageProcessor{
	
	private static AbstractApplicationContext ctx;

	private Site site = Site
			.me()
			.setRetryTimes(3)
			.setSleepTime(100);

	@Override
	public void process(Page page) {
		page.putField("content", page.getRawText());
	}
	
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext(new String[] {"classpath:applicationContext.xml"});
		IProjectInfoService projectInfoService = ctx.getBean(IProjectInfoService.class);
		List<String> detailUrls = projectInfoService.getProjectDetailUrls();
		Spider spider = Spider.create(new ProjectDetailPageProcessor());
		List<Request> requests = new ArrayList<Request>(detailUrls.size());
		for(String detailUrl : detailUrls){
			Request request = new Request(
					"http://szjw.changsha.gov.cn" + detailUrl);
			requests.add(request);
		}
		spider.setScheduler(new QueueScheduler());
		spider.addRequest((Request[]) requests.toArray(new Request[requests.size()]));
        spider.addPipeline(new PageDetailParsePipeline()).thread(5)
				.run();
	}

	@Override
	public Site getSite() {
		return site;
	}
	
	public static AbstractApplicationContext getContext(){
		return ctx;
	}

}
