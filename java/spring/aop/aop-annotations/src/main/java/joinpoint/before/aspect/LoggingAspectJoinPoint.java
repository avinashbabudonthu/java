package joinpoint.before.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggingAspectJoinPoint {

	//	@Before("execution(Student2 findStudent())") // before findStudent() method with Student return type 
	@Before("execution(* *(..))") // before all methods with any return type, any number of parameters of any type
	public void entering(JoinPoint joinPoint) {
		final String className = joinPoint.getTarget().getClass().getName();
		final String methodName = joinPoint.getSignature().getName();
		log.info("executing class={}, method={}", className, methodName);
	}
}
