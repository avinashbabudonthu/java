package after.throwing;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class AfterThrowingAspectJoinPoint {

	/**
	 * throwing="ex" - ex should be same as parameter name "ex"
	 * @param ex
	 */
	@AfterThrowing(pointcut = "execution(* *(..))", throwing = "ex")
	public void runtTimeException(RuntimeException ex) {
		log.info("exception", ex);
	}
}
