package autowirewithQualifierAnnotation;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service("mechStudent")
@Lazy(true)
public class MechStudent implements Student {
	@Override
	public String getDeptName() {
		return "MechDept";
	}
}
