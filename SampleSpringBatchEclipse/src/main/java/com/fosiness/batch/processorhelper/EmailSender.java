package com.fosiness.batch.processorhelper;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;











import com.fosiness.batch.dataobject.MailingMarker;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * 
 * @author RCREDDY
 *
 */
@Component("emailSender")
public class EmailSender {

	private Logger log=Logger.getLogger(EmailSender.class);
	
	
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private VelocityEngine velocityEngine;
	
	

	public void sendEmail(final String toEmailAddresses,
			final String fromEmailAddress, final String subject,MailingMarker user,String templateLocation) {
		sendEmail(toEmailAddresses, fromEmailAddress, subject, null, null,user,templateLocation);
	}

	public void sendEmailWithAttachment(final String toEmailAddresses,
			final String fromEmailAddress, final String subject,
			final String attachmentPath, final String attachmentName,MailingMarker mailingMarker,String templateLocation) {
		sendEmail(toEmailAddresses, fromEmailAddress, subject, attachmentPath,
				attachmentName,mailingMarker,templateLocation);
	}

	private void sendEmail(final String toEmailAddresses,
			final String fromEmailAddress, final String subject,
			final String attachmentPath, final String attachmentName,final MailingMarker user,final String templateLocation) {
		
		log.info("Entering the method.");
		
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage,
						true);
				message.setTo(toEmailAddresses);
				/*message.setFrom(new InternetAddress(fromEmailAddress));*/
				message.setSubject(subject);
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("newMessage", user);
				String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,templateLocation, "UTF-8", model);
				message.setText(body, true);
				if (!StringUtils.isBlank(attachmentPath)) {
					FileSystemResource file = new FileSystemResource(
							attachmentPath);
					message.addAttachment(attachmentName, file);
				}
			}
		};
		
		this.mailSender.send(preparator);
		
		/*try{
			this.mailSender.send(preparator);
		}catch(Exception e){
			e.printStackTrace();
		}*/
		log.info("Exiting the method.");
	}
}
