package afterreturn.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class AfterReturningAspect {

	/**
	 * returning = "studentName" should be same as entering(..) method parameter name
	 * @param studentName
	 */
	@AfterReturning(pointcut = "execution(* *(..))", returning = "studentName")
	public void entering(String studentName) {
		log.info("student-name={}", studentName);
	}
}
