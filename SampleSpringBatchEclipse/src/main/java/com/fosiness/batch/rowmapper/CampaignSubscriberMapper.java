package com.fosiness.batch.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.fosiness.batch.dataobject.CampaignSubscriberData;
import com.fosiness.batch.dataobject.CampaignSubscriberEmail;
import com.google.gson.Gson;


public class CampaignSubscriberMapper implements RowMapper<CampaignSubscriberEmail> {

	Logger logger = LogManager.getLogger(CampaignSubscriberMapper.class);
	
	public CampaignSubscriberEmail mapRow(ResultSet rs, int rowNum) throws SQLException {
		Gson jsonData = new Gson();
		CampaignSubscriberEmail campaignSubEmail = new CampaignSubscriberEmail();
		campaignSubEmail.setCampaignId(rs.getString("cs.id"));
		campaignSubEmail.setSubscriber(rs.getString("cs.subscriber"));
		campaignSubEmail.setTemplateId(rs.getString("c.templateid"));
		campaignSubEmail.setData(jsonData.fromJson(rs.getString("cs.data"), CampaignSubscriberData.class));
		
		logger.info("Mapped the campaignsubscriber object.");
		return campaignSubEmail;
	}

}
