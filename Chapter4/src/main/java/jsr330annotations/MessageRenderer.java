package jsr330annotations;

public interface MessageRenderer {
	void render();

	//void setMessageProvider(MessageProvider provider);

	MessageProvider getMessageProvider();
}