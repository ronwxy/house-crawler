package com.ray.crawler.house.crawler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.utils.HttpConstant;

import com.ray.crawler.house.domain.BuildingInfo;
import com.ray.crawler.house.service.IBuildingInfoService;

public class HousePageProcessor implements PageProcessor{

	private static AbstractApplicationContext ctx;

	private Site site = Site
			.me()
			.setRetryTimes(3)
			.setSleepTime(100)
			.addHeader("X-Requested-With", "XMLHttpRequest")
			.addHeader("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");

	@Override
	public void process(Page page) {
		page.putField("content", page.getRawText());
		NameValuePair[] values = (NameValuePair[]) page.getRequest().getExtra("nameValuePair");
		page.putField("code", values[0].getValue());
	}
	
	public static void main(String[] args){
		ctx = new ClassPathXmlApplicationContext(new String[] {"classpath:applicationContext.xml"});
		IBuildingInfoService buildingInfoService = ctx.getBean(IBuildingInfoService.class);
		List<BuildingInfo> buildingInfos = buildingInfoService.getAll();
		
		Spider spider = Spider.create(new HousePageProcessor());
		Request[] requests = new Request[buildingInfos.size()];
		for (int i=0;i<buildingInfos.size();i++) {
			Request request = new Request(
					"http://szjw.changsha.gov.cn/index.php/home/Index/geths/");
			BuildingInfo buildingInfo = buildingInfos.get(i);
			Map nameValuePair = new HashMap();
			NameValuePair[] values = new NameValuePair[1];
			values[0] = new BasicNameValuePair("ywzh", buildingInfo.getCode());
			nameValuePair.put("nameValuePair", values);
			request.setExtras(nameValuePair);
			request.setMethod(HttpConstant.Method.POST);
			requests[i] = request;
		}
		spider.setScheduler(new QueueScheduler().setDuplicateRemover(new LocalDuplicateRemover()));
		spider.addRequest(requests);
        spider.addPipeline(new HouseParsePipeline()).thread(5)
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
