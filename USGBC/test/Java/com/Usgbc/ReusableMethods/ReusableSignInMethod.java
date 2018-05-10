package com.Usgbc.ReusableMethods;

import java.io.IOException;
import com.DynamicUSGBC.CommonMethods;
import com.DynamicUSGBC.BaseClass;



public class ReusableSignInMethod extends BaseClass{
	
	public void SignIn(int rowNum, String sheetName) throws IOException, InterruptedException {

		String email = data.getCellData(sheetName, "Email", rowNum);
		String password = data.getCellData(sheetName, "Password", rowNum);

		CommonMethods.sendKeys("SignInEmailId", email);
		
		CommonMethods.sendKeys("SignInpassword", password);
		
		CommonMethods.click("CommunityContinue");
		
		/*CommonMethod.assertcontainsmessage("VerifyTextOnPayment", "Confirmation",
				"Didn't Rediredted to the payment page");*/
	
	}
	

}
