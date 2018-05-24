package org.anyway;

import org.junit.Test;
import org.springframework.util.StringUtils;

public class BasicTest {
	@Test
	public void replace() {
		
		String aString = "TrainingMemberdto";
		String bString = "TrainingMemberDtO";
		String cString = "TrainingMembertod";
		String result = null;
		
		if (aString.toLowerCase().contains("dto")) {
			System.out.println(aString);
			result =aString.replaceFirst("(?i)dto", "");
			
			
		}
		System.out.println(result);
		
		if (bString.toLowerCase().contains("dto")) {
			System.out.println(bString);
			result =bString.replaceFirst("(?i)dto", "");
			
		}
		System.out.println(result);
		if (cString.toLowerCase().contains("dto")) {
			System.out.println(cString);
			result =cString.replaceFirst("(?i)dto", "");
			
		}
		System.out.println(result);
		
		
	}

}
