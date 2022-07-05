package after.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class AfterAspectAfterJoinPoint {

	//	@After("execution(Student3 findStudent())") // before findStudent() method with Student return type 
	@After("execution(* *(..))") // after all methods with any return type, any number of parameters of any type
	public void entering(JoinPoint joinPoint) {
		final String className = joinPoint.getTarget().getClass().getName();
		final String methodName = joinPoint.getSignature().getName();
		log.info("executing class={}, method={}", className, methodName);
	}
}
