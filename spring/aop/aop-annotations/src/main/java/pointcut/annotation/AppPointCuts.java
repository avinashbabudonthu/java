package pointcut.annotation;

import org.aspectj.lang.annotation.Pointcut;

public class AppPointCuts {

	@Pointcut("execution(@pointcut.annotation.TestAnnotation * *(..))")
	public void testAnnotationPointcut() {
	}
}
