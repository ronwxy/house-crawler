package com.ray.crawler.house;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @Copyright (c) 2015, hunantv.com All Rights Reserved.
 * @author: wuxinyong@e.hunantv.com
 * @date: 16-7-5
 * @time: 下午11:21
 */
public class HousePageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).addHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8").addHeader("X-Requested-With","XMLHttpRequest");

    @Override
    public void process(Page page) {

    }

    @Override
    public Site getSite() {
        return site;
    }
}
