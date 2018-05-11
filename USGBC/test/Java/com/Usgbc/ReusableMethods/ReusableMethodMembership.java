package com.Usgbc.ReusableMethods;

import java.io.IOException;

import com.DynamicUSGBC.BaseClass;
import com.DynamicUSGBC.CommonMethods;




public class ReusableMethodMembership extends BaseClass{

	
	public void clickSignInMembershipPage() throws IOException {
		CommonMethods.click("SignIn");
	}
	
	public void membershipContact(String sheetName, int rowNum) throws IOException, InterruptedException {
		
		String attentionTo= data.getCellData(sheetName, "Attention", rowNum);
		String company    = data.getCellData(sheetName, "Company name", rowNum);
		//String country    = data.getCellData(sheetName, "Country", rowNum);
		String street1    = data.getCellData(sheetName, "Address1", rowNum);
		String street2    = data.getCellData(sheetName, "Address2", rowNum);
		String city 	  = data.getCellData(sheetName, "city", rowNum);
		String state      = data.getCellData(sheetName, "state", rowNum);
		String zip        = data.getCellData(sheetName, "Zip", rowNum);
		
		
		CommonMethods.sendKeys("Attention", attentionTo);
		CommonMethods.sendKeys("Company", company);
		//CommonMethods.selectdropdown("communityCountry", country);
		CommonMethods.moveToElement("ContactAddress1");
		Thread.sleep(2000);
		CommonMethods.sendKeys("ContactAddress1", street1);
		CommonMethods.moveToElement("ContactAddress2");
		Thread.sleep(2000);
		CommonMethods.sendKeys("ContactAddress2", street2);
		CommonMethods.sendKeys("ContactCity", city);
		CommonMethods.selectdropdown("ContactState", state);
		CommonMethods.moveToElement("ContactZipcode");
		CommonMethods.sendKeys("ContactZipcode", zip);
		CommonMethods.click("PoliciesCheckBox");
		CommonMethods.click("Continue");
		//CommonMethods.assertEqualsmessage("MemberShipVerifyContact", "Organization details", "Contact Page Detail is Incomplete");
	}
	public void membershipDetails(String sheetName, int rowNum) throws IOException, InterruptedException {
		
		String term       = data.getCellData(sheetName, "Term", rowNum); 
		String company    = data.getCellData(sheetName, "organization", rowNum);
		//String country    = data.getCellData(sheetName, "Country", rowNum);
		
		String website    = data.getCellData(sheetName, "Website", rowNum);
		String email      = data.getCellData(sheetName, "Email", rowNum);
		String indCategory = data.getCellData(sheetName, "IndustryCategory", rowNum);
		String subCategory = data.getCellData(sheetName, "SubCategory", rowNum);
		String revenue     = data.getCellData(sheetName, "Revenue", rowNum);
		
		CommonMethods.selectdropdown("MemberShipTerm",term );
//		String selectedLevel = CommonMethods.clickRandomWebElement("MembershipSelectLevel");
//	    data.setCellData(sheetName, "MembershipLevel", rowNum, selectedLevel);
//	    String random = CommonMethods.randomNumber();
	    
//		data.setCellData(sheetName, "OrganizationName", rowNum, "Test Organization " + random);
		//CommonMethods.selectdropdown("MemberShipCountryIncorporate",country );
		CommonMethods.click("MembershiplevelOrganizational");
		CommonMethods.sendKeys("OrganizationName", company);
		CommonMethods.sendKeys("Website", website);
		CommonMethods.sendKeys("Email", email);
		CommonMethods.selectdropdown("Category", indCategory);
		CommonMethods.selectdropdown("SubCategory", subCategory);
		CommonMethods.selectdropdown("Revenue", revenue);
//		String[] splits = CommonMethods.getText("MembershipFee").split(" ");
//		String Amount = splits[1];
//		data.setCellData(sheetName, "TotalAmount", rowNum, Amount);
		CommonMethods.click("Continue");
		//CommonMethod.assertcontainsmessage("VerifyTextOnPayment", "Confirmation", "Didn't Redirected to paymnet page");
			
	}
	public void PaymentByCC(int rowNum, String sheetName) throws IOException, InterruptedException {

		String NameOnCard = data.getCellData(sheetName, "card holder name", rowNum);
		String CardNumber = data.getCellData(sheetName, "card number", rowNum);
		String ExpirationMonth = data.getCellData(sheetName, "ExpMonth", rowNum);
		String ExpirationYear = data.getCellData(sheetName, "ExpYear", rowNum);
		String SecurityCode = data.getCellData(sheetName, "cvv", rowNum);
//		String BillCountry = data.getCellData(sheetName, "Country", rowNum);
		String BillStreetAdd1 = data.getCellData(sheetName, "Address1", rowNum);
		String BillStreetAdd2 = data.getCellData(sheetName, "Address2", rowNum);
		String BillCity = data.getCellData(sheetName, "city", rowNum);
		String BillState = data.getCellData(sheetName, "state", rowNum);
		String BillZipCode = data.getCellData(sheetName, "Zip", rowNum);

		CommonMethods.sendKeys("NameOnCard", NameOnCard);
		CommonMethods.sendKeys("CardNumber", CardNumber);
		CommonMethods.selectdropdown("ExpiryMonth", ExpirationMonth);
		CommonMethods.selectdropdown("ExpiryYear", ExpirationYear);
		CommonMethods.sendKeys("SecurityCode", SecurityCode);
//		CommonMethods.selectdropdown("BillCountry", BillCountry);
		CommonMethods.sendKeys("BillingAddress1", BillStreetAdd1);
		CommonMethods.sendKeys("BillingAddress2", BillStreetAdd2);
		CommonMethods.sendKeys("BillingCity", BillCity);
		CommonMethods.selectdropdown("BillingState", BillState);
		CommonMethods.sendKeys("BillingZipCode", BillZipCode);
		CommonMethods.click("PaymentSubmit");
		Thread.sleep(3000);

	}
}
