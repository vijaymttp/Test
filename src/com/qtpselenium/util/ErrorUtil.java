package com.qtpselenium.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ErrorUtil {
	private static Map<ITestResult,List> verificationFailuresMap = new HashMap<ITestResult,List>();
	private static Map<ITestResult,List> skipMap = new HashMap<ITestResult,List>();

	
	     public static void addVerificationFailure(Throwable e) 
	     {
				List verificationFailures = getVerificationFailures();
				verificationFailuresMap.put(Reporter.getCurrentTestResult(), verificationFailures);
				verificationFailures.add(e);
				System.out.println("error list is ::"+verificationFailures);
				if(verificationFailures.size()>1){
					System.out.println("error are greater than 1 in this testy case:::");
					return;
					
				}
				
			}
		  
		  public static List getVerificationFailures()
		  {
				List verificationFailures = verificationFailuresMap.get(Reporter.getCurrentTestResult());
				return verificationFailures == null ? new ArrayList() : verificationFailures;
			}
		 
		  
}
