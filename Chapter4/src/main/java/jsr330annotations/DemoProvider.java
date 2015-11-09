package jsr330annotations;

import javax.inject.Named;

//@Named("demoProvider")
public class DemoProvider implements MessageProvider {
	
	@Override
	public String getMessage() {
		return DemoProvider.class.getName();
	}

}
