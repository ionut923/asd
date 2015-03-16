package com;



import java.io.IOException;
import java.text.ParseException;

import javax.mail.MessagingException;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

//import Utile.EmailPage;



import com.pages.EmailPage;
import com.steps.Email_Steps;
//import com.LoginTest;
import com.steps.LoginSteps;
//import com.steps.NewVacationTestSteps;
import com.steps.Newrequest_Steps;


@RunWith(ThucydidesRunner.class)
public class MailTest {
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	//public Pages pages;
	
	@Steps 
	public Newrequest_Steps newrequestTestSteps;
	
	
	@Steps
	public LoginSteps loginSteps;
	
	//@Steps
	//public LoginTest loginTest;
	 
	@Steps
	public Email_Steps emailPageSteps;
	
	@Test
	public void checkingIfMailWasReceived() throws ParseException, MessagingException, IOException{
		newrequestTestSteps.is_the_home_page();
		newrequestTestSteps.sign_in();
		newrequestTestSteps.enter_username("ionutciorba");
		newrequestTestSteps.enter_password("Solomon.923");
		newrequestTestSteps.login_click();
		newrequestTestSteps.vacation_button_pressed();
		newrequestTestSteps.click_Newrequest_button();
		//newrequestTestSteps.click_submit_button();
		
		//loginTest.login_action();
		//newrequestTestSteps.new_vacation_open();
		newrequestTestSteps.setStartDate(10, 6, 2015);
		newrequestTestSteps.setEndDate(10, 7, 2015);
		newrequestTestSteps.click_submit_button();
		//newrequestTestSteps.createANewVacation();
		
		String startDate="06/10/2015";
		String endDate="07/10/2015";
		
		
		String body ="Your holiday interval is: <strong>" + startDate + " - " + endDate + "</strong>.";
	//	String body ="Please";
		
		
		emailPageSteps.checkLastEmailSubjectAndBody("You have submitted a new Vacation Request", body);
		
		
		
		}

}