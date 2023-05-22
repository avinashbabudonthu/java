package around.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class AroundAspect {

	/**
	 * throwing="ex" - ex should be same parameter name "ex"
	 * @param ex
	 * @throws Throwable 
	 */
	@Around("execution(* *(..))")
	public Object aroundAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		final String className = proceedingJoinPoint.getTarget().getClass().getName();
		final String methodName = proceedingJoinPoint.getSignature().getName();
		log.info("around aspect - before method call - {}.{}", className, methodName);
		try {
			Object result = proceedingJoinPoint.proceed();
			log.info("around aspect - after method call - {}.{}", className, methodName);
			return result;
		} catch (Exception e) {
			log.error("exception", e);
			throw e;
		}
	}
}
