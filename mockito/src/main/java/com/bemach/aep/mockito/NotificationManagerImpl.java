package com.bemach.aep.mockito;

public class NotificationManagerImpl implements NotificationManager {

	private EmailSender email;

	public void setEmailSender(EmailSender email) {
		this.email = email;
	}

	public void notify(Event event) {
		email.send(event.getData());
	}
}
