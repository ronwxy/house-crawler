package com.ray.crawler.house.crawler;

import java.util.HashMap;
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

public class ProjectPageProcessor implements PageProcessor {
	
	private static AbstractApplicationContext ctx;

	private Site site = Site
			.me()
			.setRetryTimes(3)
			.setSleepTime(100)
			.addHeader("X-Requested-With", "XMLHttpRequest")
			.addHeader("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");

	public void process(Page page) {
//		System.out.println(page.getRawText());
		page.putField("content", page.getRawText());

	}

	public Site getSite() {
		return site;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext(new String[] {"classpath:applicationContext.xml"});
		Spider spider = Spider.create(new ProjectPageProcessor());
		Request[] requests = new Request[307];
		for (int i = 1; i <= 307; i++) {
			Request request = new Request(
					"http://szjw.changsha.gov.cn/index.php/home/Index/getnewslist/");
			Map nameValuePair = new HashMap();
			NameValuePair[] values = new NameValuePair[2];
			values[0] = new BasicNameValuePair("type", "25");
			values[1] = new BasicNameValuePair("p", "" + i);
			nameValuePair.put("nameValuePair", values);
			request.setExtras(nameValuePair);
			request.setMethod(HttpConstant.Method.POST);
			requests[i-1] = request;
		}
		spider.setScheduler(new QueueScheduler().setDuplicateRemover(new LocalDuplicateRemover()));
		spider.addRequest(requests);
        spider.addPipeline(new PageParsePipeline()).thread(5)
				.run();
	}
	
	public static AbstractApplicationContext getContext(){
		return ctx;
	}
}
