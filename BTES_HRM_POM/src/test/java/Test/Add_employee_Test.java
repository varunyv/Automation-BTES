package Test;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pages.Add_employee;
import TestBase.testbase;

public class Add_employee_Test extends testbase {
	Add_employee Ad;
	public Add_employee_Test() {
		super();
	}
	@BeforeSuite
	public void setup() throws IOException {
		initialize();
		Ad= new Add_employee(driver);
	}
	@Test(priority=1)
	public void Login_TestCase_Without_Enteringdata() {
		Ad.Click_login_button();
		driver.switchTo().alert().accept();
	}
	@Test(priority=2)
	public void Login_TestCase_valid_username_valid_password() {
		Ad.Enterdata_usernametextbox(prop.getProperty("user1"));
		Ad.Enterdata_passwordtextbox(prop.getProperty("pass1"));
		Ad.Click_login_button();
	}
	
	@Test(priority=3)
	public void Perform_Pim() 
	{
		Ad.Pim_dropdwon();
		Ad.Click_Add_Employee();

	}
	
	@Test(priority=4)
	public void Add_Emp() 
	{
		Ad.Switch_to_iframe();
		Ad.Code_box("0153");
		Ad.Code_box(prop.getProperty("TextId"));
		Ad.Enter_Last_Name(prop.getProperty("LastName"));
		Ad.Enter_First_Name(prop.getProperty("FirstName"));
		Ad.Enter_Middle_Name(prop.getProperty("MiddleName"));
		Ad.Enter_EmpNick_Name(prop.getProperty("NickName"));
		Ad.photo_file(prop.getProperty("photofile"));
	}
	
	@Test (priority=5)
	public void SaveButton() {
		Ad.click_save_btn();
		Ad.click_reset_btn();
		
	}
//	@Test (priority=6)
//	public void Contactdetails() {
//		Ad.add_Contact_details();
//		}
	@Test (priority=6)
	public void Editbutton(){
		Ad.click_btnEdit();
		Ad.Enter_Middle_Name(prop.getProperty("MiddleName"));
		Ad.SSN_NO_Add(prop.getProperty("vvv"));
		Ad.Nationality();
	}

		
	
	@AfterSuite
	public void teardown() {
	closure();
	}

}
