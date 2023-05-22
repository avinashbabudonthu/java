package method.level.annotation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class MethodLevelAnnotationAspect {

	/**
	 * 1. any package
	 * 2. any class
	 * 3. any method name
	 * 4. any number of parameters of any return type
	 * 5. method annotated with {@link TestAnnotation}
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(@method.level.annotation.aspect.TestAnnotation * *(..))")
	public Object entering(ProceedingJoinPoint joinPoint) throws Throwable {
		final String className = joinPoint.getTarget().getClass().getName();
		final String methodName = joinPoint.getSignature().getName();
		log.info("executing class={}, method={}", className, methodName);
		Object result = joinPoint.proceed();
		log.info("executed class={}, method={}", className, methodName);
		return result;
	}
}
