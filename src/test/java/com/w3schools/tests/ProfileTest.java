package com.w3schools.tests;

import com.w3schools.utils.Reports;
import com.w3schools.utils.SeWrappers;
import com.w3schools.utils.W3Wrappers;

public class ProfileTest  extends SeWrappers{
	
	W3Wrappers w3 = new W3Wrappers(); 
	Reports report= new Reports();
	LoginTest lt = new LoginTest();
	public void profilevalidation() {
		
	
		report.setTCDesc("Validating Profile page");
		w3.profilepageValidation();
	}
	

}
