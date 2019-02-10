package app.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class StudentAOP {

private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//What kind of method calls I would intercept
	//execution(* PACKAGE.*.*(..))
	//Weaving & Weaver
	@Before("execution(* app.repository.*.*(..))")
	public void before(JoinPoint joinPoint){
		//Advice
		logger.info(" \n \n====== @Before===== \t  app.repository");
		logger.info(" Allowed execution for {}", joinPoint);
		logger.info(" ====== @Before=====  \n \n");
	}
	
	
	@AfterReturning(value = "execution(* app.controller.*.*(..))", 
			returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("\n \n ====== @AfterReturning ===== \t : app.controller ");
		logger.info("{} returned with value {}", joinPoint, result);
		logger.info(" ====== @AfterReturning =====  \n \n");
	}
	
	@After(value = "execution(* app.security.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("\n \n ====== @After =====  \t : app.security");
		logger.info("after execution of {}", joinPoint);
		logger.info(" ====== @After =====  \n \n");
	}
	
	
	
	
	
	
	
	
}
