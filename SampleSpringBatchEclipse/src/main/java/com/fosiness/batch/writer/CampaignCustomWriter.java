package com.fosiness.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.fosiness.batch.dataobject.CampaignSubscriberEmail;

@Component("campaignCustomWriter")
public class CampaignCustomWriter implements ItemWriter<CampaignSubscriberEmail> {

	public void write(List<? extends CampaignSubscriberEmail> list) throws Exception {
		System.out.println("in custom writer.......................");
		
		for(CampaignSubscriberEmail camp:list){
			System.out.println(" in loop == "+camp);
		}
		
	}

}
