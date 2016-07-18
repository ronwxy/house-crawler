package com.ray.crawler.house.crawler;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;


public class PageDetailParsePipeline implements Pipeline {

	public void process(ResultItems resultItems, Task task) {
		
		String content = resultItems.get("content");
		System.out.println(content);
		
		Document doc = Jsoup.parse(content);
		Elements contentEles = doc.getElementsByAttributeValue("class", "content");
		Element contentEle = contentEles.get(0);
		
		Elements tableEles = contentEle.getElementsByTag("table");
		Element projectNameEle = tableEles.get(0);
		System.out.println(projectNameEle.html());
		Element detailEle = tableEles.get(2);
		System.out.println(detailEle.html());
		Element buildEle = tableEles.get(6);
		System.out.println(buildEle.html());
		
		
		
		
		
//		Element houseTable = doc.attr("style", "border-collapse:collapse;line-height:23px;color:#000000;font-size:12px;");
	
//		String content = resultItems.get("content");
//		Map<String, String> jsonMap = (Map<String, String>) JSON.parse(content);
//		String tableContent = jsonMap.get("content");
//
//		try {
//			Document doc = DocumentHelper.parseText(tableContent);
//			Element root = doc.getRootElement();
//			System.out.println("root: " + root.getName());
//			Iterator rowIter = root.elementIterator("tr");
//			Element rowEle = (Element) rowIter.next();
//			while (rowIter.hasNext()) {
//				ProjectInfo projectInfo = new ProjectInfo();
//				rowEle = (Element) rowIter.next();
//				Iterator colIter = rowEle.elementIterator("td");
//				List<String> dataList = new ArrayList<String>();
//				while (colIter.hasNext()) {
//					Element colEle = (Element) colIter.next();
//
//					Element hrefEle = colEle.element("a");
//					if (hrefEle != null) {
//						dataList.add((String) hrefEle.getData());
//						dataList.add(hrefEle.attribute("href").getValue());
//					} else {
//						dataList.add((String) colEle.getData());
//					}
//
//				}
//				if (dataList.size() == 5) {
//					projectInfo.setProjectName(dataList.get(0));
//					projectInfo.setDetailUrl(dataList.get(1));
//					projectInfo.setAddress(dataList.get(2));
//					projectInfo.setPresellNo(dataList.get(3));
//					projectInfo.setCertificateDate(DateUtils.parseDate(
//							dataList.get(4), "yyyy/MM/dd"));
//					IProjectInfoService projectInfoService = ProjectPageProcessor
//							.getContext().getBean(IProjectInfoService.class);
//					projectInfoService.create(projectInfo);
//				}
//
//			}
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
