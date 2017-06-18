package com.bemach.aep.pisentry.event;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class EmailSenderImpl implements EmailSender {

	private static Logger logger = Logger.getLogger(EmailSenderImpl.class);
	private static Properties props = new Properties();

	public void send(String msg) {
		if (true) {
			return;
		}
		loadProperties();
		/*
		 * In this code, I use ENV variables to get email addr/psw/target email
		 * so that I do not have to expose private information. You can change
		 * to fit your need here.
		 * 
		 */
		final String fromEmail = props.getProperty("ALARM_EMAIL");
		final String password = props.getProperty("ALARM_PSW");
		final String toEmail = props.getProperty("ALARM_TARGET_EMAIL");
		final String smtpHost = props.getProperty("SMTP_HOST");
		final String smtpPort = props.getProperty("SMTP_PORT");

		logger.info("fromEmail: " + fromEmail);

		logger.info("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.socketFactory.port", smtpPort);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", smtpPort);

		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};

		Session session = Session.getDefaultInstance(props, auth);
		logger.info("Session created");
		sendEmail(session, fromEmail, toEmail, "pisentry state", msg);
	}

	/**
	 * Utility method to send simple HTML email
	 * 
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	private void sendEmail(Session session, String fromEmail, String toEmail, String subject, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);

			// set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress(fromEmail, "pisentry"));
			msg.setReplyTo(InternetAddress.parse(fromEmail, true));
			msg.setSubject(subject, "UTF-8");
			msg.setText(body, "UTF-8");
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

			logger.info("Message is ready");
			Transport.send(msg);
			logger.info("EMail Sent Successfully!!");
		} catch (Exception e) {
			logger.error("Error in send mail: " + e);
		}
	}

	private void loadProperties() {
		logger.info("getting properties ... ");
		String resourceName = "pisentry.properties";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			logger.info("Loading ...");
			props.load(resourceStream);
			Iterator it = props.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				logger.info(key + "=" + props.getProperty(key));
			}
		} catch (IOException e) {
			logger.error("Startup Server in error: " + e);
		}
	}

}
