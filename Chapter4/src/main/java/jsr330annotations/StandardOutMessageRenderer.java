package jsr330annotations;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/*@Service("messageRenderer")  // Component/Repository/Controller
@Scope("singleton")*/ // Spring annotations

@Named("messageRenderer")
@Singleton
public class StandardOutMessageRenderer implements MessageRenderer {
	
	
	@Inject
	@Named("messageProvider") // JSR way of depedancy injection
	 		
	
	//@Resource(name = "messageProvider")  // java annotation
	
	//@Autowired // Autowired  --- if multiple implementation of MessageProvider will be there then there will be ambiguity problem
	private MessageProvider messageProvider = null;  // No need of setter method to set dependency, it can be done by annotations during declarations.

	@Override
	public void render() {
		if (messageProvider == null) {
			throw new RuntimeException(
					"You must set the property messageProvider of class:" + StandardOutMessageRenderer.class.getName());
		}
		System.out.println(messageProvider.getMessage());
	}

	//@Required  // This spring annotation DI must be fulfilled and is only applicable to setter method not during variable declaration. With variables use like this : @Autowired(required = true)
	//@Override
	public void setMessageProvider(MessageProvider provider) {
		this.messageProvider = provider;
	}  

	@Override
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}
}