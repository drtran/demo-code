package com.bemach.aep.pisentry;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AlarmReceiver {
	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocket = new DatagramSocket(9999);
		byte[] buffer = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		String previousAlarmMsg = "";
		
		for (;;) {
			System.out.print("Receiving .... ");
			datagramSocket.receive(packet);
			String alarmMsg = new String (packet.getData());
			if (alarmMsg.equals(previousAlarmMsg)) {
				System.out.println("");
				continue;
			}
			System.out.println(alarmMsg);
			System.out.println("notifying ...");
			email(alarmMsg);
			previousAlarmMsg = alarmMsg;
		}

	}

	
	private static void email(String msg) {
		/*
		 * In this code, I use ENV variables to get email addr/psw/target email
		 * so that I do not have to expose private information.
		 * You can change to fit your need here.
		 * 
		 */
		final String fromEmail = System.getenv("ALARM_EMAIL");
		final String password = System.getenv("ALARM_PSW");
		final String toEmail = System.getenv("ALARM_TARGET_EMAIL");
		System.out.println("fromemail: "+fromEmail);

		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "mail.bemach.com"); // SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); // SSL Port
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // SSL
																						// Factory
																						// Class
		props.put("mail.smtp.auth", "true"); // Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); // SMTP Port

		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};

		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
		sendEmail(session, toEmail, "Alarm notification", msg);
	}

	/**
	 * Utility method to send simple HTML email
	 * 
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	private static void sendEmail(Session session, String toEmail, String subject, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);
			// set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("no_reply@journaldev.com", "NoReply-JD"));

			msg.setReplyTo(InternetAddress.parse("no_reply@journaldev.com", false));

			msg.setSubject(subject, "UTF-8");

			msg.setText(body, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			Transport.send(msg);

			System.out.println("EMail Sent Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
