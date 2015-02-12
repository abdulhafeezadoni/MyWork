package com.fosiness.batch.dataobject;

public class CampaignSubscriberEmail extends MailingMarker {
	
	private String campaignId;
	private String templateId;
	private String subscriber;
	private CampaignSubscriberData data;
	private boolean emailDelIndicator;	
	
	public String getCampaignId() {
		return campaignId;
	}
	public String getTemplateId() {
		return templateId;
	}
	public String getSubscriber() {
		return subscriber;
	}
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}	
	public boolean isEmailDelIndicator() {
		return emailDelIndicator;
	}
	public void setEmailDelIndicator(boolean emailDelIndicator) {
		this.emailDelIndicator = emailDelIndicator;
	}	
	
	public CampaignSubscriberData getData() {
		return data;
	}
	public void setData(CampaignSubscriberData data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "CampaignSubscriberEmail [campaignId=" + campaignId
				+ ", templateId=" + templateId + ", subscriber=" + subscriber
				+ ", data=" + data + ", emailDelIndicator=" + emailDelIndicator
				+ "]";
	}
	
	
	
	
}
