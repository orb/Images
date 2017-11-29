package com.nostacktrace;

import java.util.ArrayList;
import java.util.List;

public class MessageManager {
	public List<Message> loadMessages() {
		List<Message> messages = new ArrayList<>();
		messages.add(new Message(50, "This is the first message"));
		messages.add(new Message(51, "Another message."));
		messages.add(new Message(52, "Let's pretend this data is from a database"));
		return messages;
	}
	
	public Message messageById(int id) {
		for (Message message: loadMessages()) {
			if (message.getId() == id) {
				return message;
			}
		}
		return null;
	}
}
