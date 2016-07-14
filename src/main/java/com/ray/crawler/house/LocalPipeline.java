package com.ray.crawler.house;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.digest.DigestUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * @Copyright (c) 2015, hunantv.com All Rights Reserved.
 * @author: wuxinyong@e.hunantv.com
 * @date: 16-7-14
 * @time: 下午11:09
 */
public class LocalPipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        String path = UUID.randomUUID().toString();

        try {
            PrintWriter e = new PrintWriter(new FileWriter(new File( "/Users/wuxinyong/" + path +".json")));
            e.write(JSON.toJSONString(resultItems.getAll()));
            e.close();
        } catch (IOException var5) {

        }
        System.out.println(JSON.toJSONString(resultItems.getAll()));
    }
}
