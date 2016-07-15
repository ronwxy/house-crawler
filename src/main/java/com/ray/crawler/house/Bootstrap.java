package com.ray.crawler.house;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;

/**
 * @Copyright (c) 2015, hunantv.com All Rights Reserved.
 * @author: wuxinyong@e.hunantv.com
 * @date: 16-7-5
 * @time: 下午11:20
 */
public class Bootstrap {

    public static void main(String[] args) {
        Spider.create(new HousePageProcessor()).addUrl("https://github.com/code4craft")
                .addPipeline(new JsonFilePipeline("/Users/wuxinyong/myworkspace/webmagic_test"))
                .thread(5)
                .run();
    }
}
