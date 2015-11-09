package autowirewithQualifierAnnotation;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service("compStudent")
@Lazy(false)
public class CompStudent implements Student {

	@Override
	public String getDeptName() {
		return "Computer Science Dept";
	}

}
