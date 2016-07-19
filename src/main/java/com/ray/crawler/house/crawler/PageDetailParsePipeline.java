package com.ray.crawler.house.crawler;

import java.text.ParseException;
import java.util.Iterator;

import org.apache.commons.lang3.time.DateUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import com.google.common.base.Strings;
import com.ray.crawler.house.domain.BuildingInfo;
import com.ray.crawler.house.domain.ProjectDetailInfo;
import com.ray.crawler.house.service.IBuildingInfoService;
import com.ray.crawler.house.service.IProjectDetailInfoService;

public class PageDetailParsePipeline implements Pipeline {

	public void process(ResultItems resultItems, Task task) {

		String content = resultItems.get("content");

		Document doc = Jsoup.parse(content);
		Elements contentEles = doc.getElementsByAttributeValue("class",
				"content");
		Element contentEle = contentEles.get(0);

		Elements tableEles = contentEle.getElementsByTag("table");
		Element projectNameEle = tableEles.get(0);
	
		ProjectDetailInfo detailInfo = new ProjectDetailInfo();
		Elements colEles = projectNameEle.getElementsByTag("td");
		detailInfo.setProjectName(colEles.get(0).text());
		String extra = colEles.get(1).html();
		String[] extras = extra.split("#FF0000\">");
		Integer approveSellNum = Integer.valueOf(extras[1].substring(0,
				extras[1].indexOf("<")));
		Integer availableSellNum = Integer.valueOf(extras[2].substring(0,
				extras[2].indexOf("<")));
		String priceStr = extras[3].substring(0, extras[3].indexOf("<"));
		Double publicMinPrice = Double.valueOf(priceStr.split("-")[0]);
		Double publicMaxPrice = Double.valueOf(priceStr.split("-")[1]);
		detailInfo.setApproveSellNum(approveSellNum);
		detailInfo.setAvailableSellNum(availableSellNum);
		detailInfo.setPublicMinPrice(publicMinPrice);
		detailInfo.setPublicMaxPrice(publicMaxPrice);

		Element detailEle = tableEles.get(2);
		Elements tdEles = detailEle.getElementsByTag("td");
		detailInfo.setArea(tdEles.get(1).text());
		detailInfo.setApproveNo(tdEles.get(3).text());
		detailInfo.setCompany(tdEles.get(5).text());
		if (!Strings.isNullOrEmpty(tdEles.get(7).text())) {
			detailInfo.setBuildingNum(Integer.valueOf(tdEles.get(7).text()));
		}
		detailInfo.setProjectAddress(tdEles.get(9).text());
		if (!Strings.isNullOrEmpty(tdEles.get(11).text())&& !"-".equals(tdEles.get(11).text())) {
			detailInfo.setMinPrice(Double.valueOf(tdEles.get(11).text()));
		}
		detailInfo.setSellAddress(tdEles.get(13).text());
		detailInfo.setSellPhone(tdEles.get(15).text());
		if (!Strings.isNullOrEmpty(tdEles.get(17).text()) && !"-".equals(tdEles.get(17).text())) {
			detailInfo.setHouseNum(Integer.valueOf(tdEles.get(17).text()));
		}
		detailInfo.setBus(tdEles.get(19).text());
		if (!Strings.isNullOrEmpty(tdEles.get(21).text())) {
			detailInfo.setTotalArea(Double.valueOf(tdEles.get(21).text()));
		}
		detailInfo.setDesignCompany(tdEles.get(23).text());
		if (!Strings.isNullOrEmpty(tdEles.get(25).text())) {
			detailInfo.setTotalBuildingArea(Double.valueOf(tdEles.get(25)
					.text()));
		}

		detailInfo.setSellProxy(tdEles.get(27).text());
		if (!Strings.isNullOrEmpty(tdEles.get(29).text())) {
			detailInfo.setSizeRate(Double.valueOf(tdEles.get(29).text()));
		}
		detailInfo.setPropertyCompany(tdEles.get(31).text());
		if (!Strings.isNullOrEmpty(tdEles.get(33).text())) {
			detailInfo.setGreenRate(Double.valueOf(tdEles.get(33).text()));
		}

		detailInfo.setBuildCompany(tdEles.get(35).text());

		if (!Strings.isNullOrEmpty(tdEles.get(37).text())) {
			detailInfo.setPropertyPrice(Double.valueOf(tdEles.get(37).text()));
		}

		try {
			if (!Strings.isNullOrEmpty(tdEles.get(39).text())) {
				detailInfo.setFinishDate(DateUtils.parseDate(tdEles.get(39)
						.text(), "yyyy/MM/dd"));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		detailInfo.setProjectSummary(tdEles.get(41).text());

		IProjectDetailInfoService detailInfoService = ProjectDetailPageProcessor
				.getContext().getBean(IProjectDetailInfoService.class);
		detailInfoService.create(detailInfo);

		Element buildEle = tableEles.get(6);
		Elements buildEles = buildEle.getElementsByTag("tr");
		Iterator<Element> iter = buildEles.iterator();
		
		while(iter.hasNext()){
			iter.next();
			if(iter.hasNext()){
				Element trEle = iter.next();
				Elements buildTdEles = trEle.getElementsByTag("td");
				BuildingInfo buildingInfo = new BuildingInfo();
				buildingInfo.setPresellNo(buildTdEles.get(0).text());
				buildingInfo.setBuildingNo(buildTdEles.get(1).text());
				try {
					if(!Strings.isNullOrEmpty(buildTdEles.get(2).text())){
					buildingInfo.setCertificateDate(DateUtils.parseDate(buildTdEles.get(2).text(), "yyyy/MM/dd"));
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(!Strings.isNullOrEmpty(buildTdEles.get(3).text())){
				buildingInfo.setApproveSellArea(Double.valueOf(buildTdEles.get(3).text()));
				}
				buildingInfo.setLandNo(buildTdEles.get(4).text());
				buildingInfo.setProjectApproveNo(buildTdEles.get(5).text());
				buildingInfo.setLandApproveNo(buildTdEles.get(6).text());
				buildingInfo.setBuildApproveNo(buildTdEles.get(7).text());
				String buildExtra = buildTdEles.get(8).toString();
				String code = buildExtra.substring(buildExtra.indexOf("('")+2, buildExtra.indexOf("')"));
				buildingInfo.setCode(code);
				buildingInfo.setProjectName(detailInfo.getProjectName());
				IBuildingInfoService buildingInfoService = ProjectDetailPageProcessor.getContext().getBean(IBuildingInfoService.class);
				buildingInfoService.create(buildingInfo);
			}
		}
		
		
		
	}
}
