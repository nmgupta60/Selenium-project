package com.Usgbc.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.DynamicUSGBC.BaseClass;
import com.DynamicUSGBC.CommonMethods;
import com.Usgbc.ReusableMethods.ReusableMethodMembership;
import com.Usgbc.ReusableMethods.ReusableSignInMethod;

public class Membershipflow extends BaseClass{
	
	@Test
	public void MembershipRegistration(int rowNum,String signinSheet,String memberSheet,String sheetName) throws IOException, InterruptedException {
		
		CommonMethods.setUrl(MembershipUrl);
		
		ReusableSignInMethod reuseSign = new ReusableSignInMethod();
		ReusableMethodMembership reuse = new ReusableMethodMembership();
		
		
		reuse.clickSignInMembershipPage();
		reuseSign.SignIn(rowNum, signinSheet);
		reuse.membershipContact(memberSheet, rowNum);
		reuse.membershipDetails(sheetName, rowNum);
		reuse.PaymentByCC(rowNum, sheetName);
	}
	
	

}
