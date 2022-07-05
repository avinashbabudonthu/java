package before.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

	// @Before("execution(Student findStudent())") // before findStudent() method with Student return type
	@Before("execution(* *(..))") // before all methods with any return type, any number of parameters of any type
	public void entering() {
		log.info("executing method");
	}
}
