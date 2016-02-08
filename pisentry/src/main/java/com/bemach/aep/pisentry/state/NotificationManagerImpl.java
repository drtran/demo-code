package com.bemach.aep.pisentry.state;

import com.bemach.aep.pisentry.event.EmailSender;
import com.bemach.aep.pisentry.vos.Event;

public class NotificationManagerImpl implements NotificationManager {

	private EmailSender email;

	public void setEmailSender(EmailSender email) {
		this.email = email;
	}

	public void notify(Event event) {
		email.send(event.getData());
	}
}
