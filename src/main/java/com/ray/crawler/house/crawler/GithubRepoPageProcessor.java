package com.ray.crawler.house.crawler;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class GithubRepoPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).addHeader("X-Requested-With", "XMLHttpRequest").addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");


    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
//        if (page.getResultItems().get("name") == null) {
//            //skip this page
//            page.setSkip(true);
//        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
//        System.out.println(page.getResultItems().get("author"));
//        System.out.println(page.getResultItems().get("name"));
//        System.out.println(page.getResultItems().get("readme"));

    }


    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new GithubRepoPageProcessor()).addUrl("http://szjw.changsha.gov.cn/index.php/home/Index/getnewslist/")
                .addPipeline(new JsonFilePipeline("D:/webmagic_test"))
                .thread(5)
                .run();
    }
}
