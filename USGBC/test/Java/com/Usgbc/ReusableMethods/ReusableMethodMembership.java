package com.Usgbc.ReusableMethods;

import java.io.IOException;

import com.DynamicUSGBC.BaseClass;
import com.DynamicUSGBC.CommonMethods;




public class ReusableMethodMembership extends BaseClass{

	
	public void clickSignInMembershipPage() throws IOException {
		CommonMethods.click("MemberShipClickSignIn");
	}
	
	public void membershipContact(String sheetName, int rowNum) throws IOException, InterruptedException {
		
		String attentionTo= data.getCellData(sheetName, "AttentionTo", rowNum);
		String company    = data.getCellData(sheetName, "Company", rowNum);
		String country    = data.getCellData(sheetName, "Country", rowNum);
		String street1    = data.getCellData(sheetName, "Street1", rowNum);
		String street2    = data.getCellData(sheetName, "Street2", rowNum);
		String city 	  = data.getCellData(sheetName, "City", rowNum);
		String state      = data.getCellData(sheetName, "State", rowNum);
		String zip        = data.getCellData(sheetName, "Zip", rowNum);
		
		
		CommonMethods.sendKeys("MemberShipAttentionTo", attentionTo);
		CommonMethods.sendKeys("MemberShipCompany", company);
		CommonMethods.selectdropdown("communityCountry", country);
		CommonMethods.moveToElement("CommunityAdd1");
		Thread.sleep(2000);
		CommonMethods.sendKeys("CommunityAdd1", street1);
		CommonMethods.moveToElement("CommunityAdd2");
		Thread.sleep(2000);
		CommonMethods.sendKeys("CommunityAdd2", street2);
		CommonMethods.sendKeys("CommunityCity", city);
		CommonMethods.selectdropdown("CommunityState", state);
		CommonMethods.moveToElement("CommunityZip");
		CommonMethods.sendKeys("CommunityZip", zip);
		CommonMethods.click("tickAgree");
		CommonMethods.click("CommunityContinue");
		//CommonMethods.assertEqualsmessage("MemberShipVerifyContact", "Organization details", "Contact Page Detail is Incomplete");
	}
	public void membershipDetails(String sheetName, int rowNum) throws IOException, InterruptedException {
		
		String term       = data.getCellData(sheetName, "Term", rowNum); 
		String company    = data.getCellData(sheetName, "Company", rowNum);
		String country    = data.getCellData(sheetName, "Country", rowNum);
		
		String website    = data.getCellData(sheetName, "Website", rowNum);
		String email      = data.getCellData(sheetName, "Email", rowNum);
		String indCategory = data.getCellData(sheetName, "IndustryCategory", rowNum);
		String subCategory = data.getCellData(sheetName, "SubCategory", rowNum);
		String revenue     = data.getCellData(sheetName, "Revenue", rowNum);
		
		CommonMethods.selectdropdown("MemberShipTerm",term );
//		String selectedLevel = CommonMethods.clickRandomWebElement("MembershipSelectLevel");
//	    data.setCellData(sheetName, "MembershipLevel", rowNum, selectedLevel);
//	    String random = CommonMethods.randomNumber();
//	    CommonMethods.sendKeys("MemberShipOrganizationName", "Test Organization " + random);
//		data.setCellData(sheetName, "OrganizationName", rowNum, "Test Organization " + random);
		CommonMethods.selectdropdown("MemberShipCountryIncorporate",country );
		
		CommonMethods.sendKeys("MemberShipWebsite", website);
		CommonMethods.sendKeys("MemberShipEmailId", email);
		CommonMethods.selectdropdown("MemberShipIndustryCategory", indCategory);
		CommonMethods.selectdropdown("MemberShipIndustrySubCategory", subCategory);
		CommonMethods.selectdropdown("MemberShipRevenueRange", revenue);
		String[] splits = CommonMethods.getText("MembershipFee").split(" ");
		String Amount = splits[1];
		data.setCellData(sheetName, "TotalAmount", rowNum, Amount);
		CommonMethods.click("CommunityContinue");
		//CommonMethod.assertcontainsmessage("VerifyTextOnPayment", "Confirmation", "Didn't Redirected to paymnet page");
			
	}
	public void PaymentByCC(int rowNum, String sheetName) throws IOException, InterruptedException {

		String NameOnCard = data.getCellData(sheetName, "Name", rowNum);
		String CardNumber = data.getCellData(sheetName, "CardNumber", rowNum);
		String ExpirationMonth = data.getCellData(sheetName, "ExpMonth", rowNum);
		String ExpirationYear = data.getCellData(sheetName, "ExpYear", rowNum);
		String SecurityCode = data.getCellData(sheetName, "SecurityCode", rowNum);
		String BillCountry = data.getCellData(sheetName, "Country", rowNum);
		String BillStreetAdd1 = data.getCellData(sheetName, "Street1", rowNum);
		String BillStreetAdd2 = data.getCellData(sheetName, "Street2", rowNum);
		String BillCity = data.getCellData(sheetName, "City", rowNum);
		String BillState = data.getCellData(sheetName, "State", rowNum);
		String BillZipCode = data.getCellData(sheetName, "Zip", rowNum);

		CommonMethods.sendKeys("NameOnCard", NameOnCard);
		CommonMethods.sendKeys("CardNumber", CardNumber);
		CommonMethods.selectdropdown("ExpirationMonth", ExpirationMonth);
		CommonMethods.selectdropdown("ExpirationYear", ExpirationYear);
		CommonMethods.sendKeys("SecurityCode", SecurityCode);
		CommonMethods.selectdropdown("BillCountry", BillCountry);
		CommonMethods.sendKeys("BillStreetAdd1", BillStreetAdd1);
		CommonMethods.sendKeys("BillStreetAdd2", BillStreetAdd2);
		CommonMethods.sendKeys("BillCity", BillCity);
		CommonMethods.selectdropdown("BillState", BillState);
		CommonMethods.sendKeys("BillZipCode", BillZipCode);
		CommonMethods.click("PaymentSubmitButton");
		Thread.sleep(3000);

	}
}
