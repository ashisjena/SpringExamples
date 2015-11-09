package autowirewithQualifierAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service(value = "dependant")
@Lazy(false)
public class Dependant {
	@Autowired(required = true) // To avoid ambiguity over two implementations
								// of Student @Qualifier is needed.
	//@Qualifier("mechStudent") // or can be declared as below along with declaration
	private @Qualifier("mechStudent") Student student = null;
	
	// @Autowired + @Qualifier == @Resource(JSR250)
	
	public Student getStudent() {
		return this.student;
	}

	@Autowired(required = true)
	public void setAllStudents(@Qualifier("mechStudent") Student student1, 
							   @Qualifier("compStudent") Student student2,
							   @Value("Rama") String name) {
		System.out.println("Got both Students : ");
		System.out.println(student1);
		System.out.println(student2);
		System.out.println("and " + name);
		System.out.println();
	}
}
