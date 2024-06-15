package Test;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pages.Pim;
import TestBase.testbase;

public class PimTest extends testbase {
	Pim Plp;
	public PimTest() {
		super();
	}
	@BeforeSuite
	public void setup() throws IOException {
		initialize();
		Plp=new Pim(driver);
	}
	@Test(priority=1)
	public void Login_TestCase_Without_Enteringdata() {
		Plp.Click_login_button();
		driver.switchTo().alert().accept();
	}
	@Test(priority=2)
	public void Login_TestCase_valid_username_valid_password() {
		Plp.Enterdata_usernametextbox(prop.getProperty("user1"));
		Plp.Enterdata_passwordtextbox(prop.getProperty("pass1"));
		Plp.Click_login_button();
	}
	@Test(priority=3)
	public void Perform_Pim() 
	{
		Plp.Pim_dropdwon();
		Plp.Employee_List_link();

	}
	@Test(priority=4)
	public void Switch_to_iframe_Acess_selectdrop_id() 
	{


		Plp.Switch_to_iframe();
		Plp.Acess_Select_drop_ID();
	}	

	@Test(priority=5)
	public void enterId_search_text_box() 
	{
		Plp.click_in_the_search_bar(prop.getProperty("Searchfor"));
		Plp.search_box_onclick();
		Plp.search_button_click();
		Plp.Chechk_Box();
		Plp.Delete_perform();
		Plp.Add_to_Page_perform();
	}	



	@AfterSuite
	public void teardown() {
	closure();
	}

}
