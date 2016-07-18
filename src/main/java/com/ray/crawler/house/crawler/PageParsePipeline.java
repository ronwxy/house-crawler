package com.ray.crawler.house.crawler;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.time.DateUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import com.alibaba.fastjson.JSON;
import com.ray.crawler.house.domain.ProjectInfo;
import com.ray.crawler.house.service.IProjectInfoService;

/**
 * @Copyright (c) 2015, hunantv.com All Rights Reserved.
 * @author: wuxinyong@e.hunantv.com
 * @date: 16-7-14
 * @time: 下午11:09
 */
public class PageParsePipeline implements Pipeline {

	public void process(ResultItems resultItems, Task task) {
		String path = UUID.randomUUID().toString();

		// try {
		String content = resultItems.get("content");
		Map<String, String> jsonMap = (Map<String, String>) JSON.parse(content);
		String tableContent = jsonMap.get("content");

		try {
			Document doc = DocumentHelper.parseText(tableContent);
			Element root = doc.getRootElement();
			System.out.println("root: " + root.getName());
			Iterator rowIter = root.elementIterator("tr");
			Element rowEle = (Element) rowIter.next();
			while (rowIter.hasNext()) {
				ProjectInfo projectInfo = new ProjectInfo();
				rowEle = (Element) rowIter.next();
				Iterator colIter = rowEle.elementIterator("td");
				List<String> dataList = new ArrayList<String>();
				while (colIter.hasNext()) {
					Element colEle = (Element) colIter.next();

					Element hrefEle = colEle.element("a");
					if (hrefEle != null) {
						dataList.add((String) hrefEle.getData());
						dataList.add(hrefEle.attribute("href").getValue());
					} else {
						dataList.add((String) colEle.getData());
					}

				}
				if (dataList.size() == 5) {
					projectInfo.setProjectName(dataList.get(0));
					projectInfo.setDetailUrl(dataList.get(1));
					projectInfo.setAddress(dataList.get(2));
					projectInfo.setPresellNo(dataList.get(3));
					projectInfo.setCertificateDate(DateUtils.parseDate(
							dataList.get(4), "yyyy/MM/dd"));
					IProjectInfoService projectInfoService = ProjectPageProcessor
							.getContext().getBean(IProjectInfoService.class);
					projectInfoService.create(projectInfo);
				}

			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
