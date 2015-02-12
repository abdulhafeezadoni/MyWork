package com.fosiness.batch.processors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fosiness.batch.dataobject.CampaignSubscriberEmail;
import com.fosiness.batch.processorhelper.EmailSender;

@Component("campaignCustomProcessorr")
public class CampaignCustomProcessor implements ItemProcessor<CampaignSubscriberEmail, CampaignSubscriberEmail> {

	Logger logger = LogManager.getLogger(CampaignCustomProcessor.class);
	
	@Autowired
	private EmailSender emailSender;
	
	public CampaignSubscriberEmail process(CampaignSubscriberEmail campaignSubscriberEmail) throws Exception {
		
		logger.info("processing Email for user :: "+campaignSubscriberEmail);		
						
		emailSender.sendEmail(campaignSubscriberEmail.getSubscriber(), "", "User Registration Verification", campaignSubscriberEmail, campaignSubscriberEmail.getTemplateId());
				
		return campaignSubscriberEmail;
	}

}
