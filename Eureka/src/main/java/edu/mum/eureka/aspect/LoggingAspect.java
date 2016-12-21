package edu.mum.eureka.aspect;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect{
			
		private static final String OUTPUT_FILE = "./src/main/resources/output.txt";	
		//Uncomment to see the different versions of the PointCut 
	
	
		//@Pointcut("execution(* edu.mum.eureka.service..*(..))")
		//@Pointcut("execution(* edu.mum.eureka.service..*(Long))")
		//@Pointcut("execution(* edu.mum.eureka.service..*())")
		@Pointcut("within(edu.mum.eureka.service.impl.*)")	
		public void applicaitonMethod(){}
		
		@Pointcut("args(Long)")
		public void arguments(){}
		
		
		//Advice method that Prints out JointPoint/Method name.
		
		 @Before("execution(* edu.mum.eureka.service..*(..))")
		//@Before("applicaitonMethod()")	 
		 //@Before("applicaitonMethod() and arguments()")	 
		public  void printOutMethodName(JoinPoint joinPoint) throws IOException{	
			 
			 /*
			 	//Output File
				File fout = new File(OUTPUT_FILE);
				
				if (!fout.exists()) {
					fout.createNewFile();
				}
				
				FileWriter fw = new FileWriter(fout.getAbsoluteFile(),false);
				BufferedWriter bw = new BufferedWriter(fw);
				String fileRecordContent = "JointPoint Name : "  + joinPoint.getSignature().getName();
				bw.write(fileRecordContent);			
				bw.newLine();	
				bw.close();*/
			 
			 	Logger log = Logger.getLogger("");
			    log.info("   **********     AOP - TARGET JOINPOINT : " + joinPoint.getSignature().getName() + "    **********");
			 	System.out.println();
			    System.out.println( "   **********   AOP -  TARGET JOINPOINT : " + 
			    		joinPoint.getSignature().getDeclaringTypeName() + "." +
			    		joinPoint.getSignature().getName() + 
 				    			"    **********");
				
				//System.out.println("JointPoint Name : "  + joinPoint.getSignature().getName());
		}
}
