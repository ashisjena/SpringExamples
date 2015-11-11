package sample;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

@Service("simpleMessageListener")
public class SimpleMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println("Message received: " + textMessage.getText());
		} catch (JMSException ex) {
			System.err.println("JMS error" + ex);
		}
	}
}