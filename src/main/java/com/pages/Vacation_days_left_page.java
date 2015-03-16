package com.pages;



import net.thucydides.core.annotations.DefaultUrl;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.protobuf.TextFormat.ParseException;

import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static ch.lambdaj.Lambda.convert;


public class Vacation_days_left_page extends PageObject {

	@FindBy(id = "sign-in")
	private WebElementFacade Sign_in_button;

	@FindBy(id = "_58_login")
	private WebElementFacade userInput;

	@FindBy(id = "_58_password")
	private WebElementFacade passwordInput;

	@FindBy(css = "[type='submit']")
	private WebElementFacade loginButton;

	@FindBy(css = "a[href*='vacation']")
	private WebElementFacade vacation_button;
	
	@FindBy(css="a[href='http://192.168.1.68:9090/vacation?p_p_id=evovacation_WAR_EvoVacationportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_evovacation_WAR_EvoVacationportlet_backURL=%2Fvacation&_evovacation_WAR_EvoVacationportlet_menuItem=new-request']")
	private WebElementFacade Newrequest_button;
	
	@FindBy(xpath = "//td[text()='Total available free days']/following-sibling::td")
	private WebElementFacade TotalAvailablefreedays;
	
	
	@FindBy(css="div#selectedDaysContainer label[id='_evovacation_WAR_EvoVacationportlet_businessDaysOutput']")
	private WebElementFacade selected;
	//vacation left number
	 @FindBy(css="div[id='vacDaysLeft'] b")
	 private WebElementFacade vacationleft;

	@FindBy(css = "div[style*='block'] td.dp_caption")
	 private WebElementFacade calendarTitle;

	 @FindBy(css = "div[style*='block'] td.dp_next")
	 private WebElementFacade nextButton;

	 @FindBy(css = "div[style*='block'] td.dp_previous")
	 private WebElementFacade previousButton;
	 
	 @FindBy(css="input[name='startDate']")
	 private WebElementFacade startDate;
	 
	 @FindBy(css="input[name='endDate']")
	 private WebElementFacade endDate;
	 
	 @FindBy(css="input[type='submit']")
	 private WebElementFacade submit_button;
	 
	 @FindBy(css="#p_p_id_evovacation_WAR_EvoVacationportlet_ > div > div > div > div.aui-layout > div > div.aui-column.aui-w25.aui-column-first > div > div:nth-child(1) > ul > li:nth-child(2) > a")
	 private WebElementFacade new_req_button2;
	
	 @FindBy(css= "a[href$='my-free-days']")
	 private WebElementFacade my_free_days_button;

	static int sel_vechi=0;
	static int vac_vechi=0;
	 
	public void enter_username(String username) {
		userInput.sendKeys(username);

	}
	/*public void click_my_free_days_button(){
		my_free_days_button.click();
		
	}*/
	
	public void click_submit_button(){
		submit_button.click();
	}
	
	//public void get_total_vacation_days(){
	//	int total_days_nr_shown = Integer.parseInt(TotalAvailablefreedays.getText()
			//	.toString());
		
//	}
	
	

		public void difference(){
			
			System.out.println(selected.getText());
			System.out.println(vacationleft.getText());
			 sel_vechi = Integer.parseInt(selected.getText()
					.toString());
			vac_vechi = Integer.parseInt(vacationleft.getText()
					.toString());
		
		
		}
		public void Verify_DaysOfVacation_left(){
			int vac_nou=Integer.parseInt(vacationleft.getText()
					.toString());
			int total_days_nr_shown = Integer.parseInt(TotalAvailablefreedays.getText()
						.toString());
			
		Assert.assertEquals((vac_vechi - sel_vechi), vac_nou);
		//Assert.assertEquals((vac_vechi - sel_vechi), total_days_nr_shown);	
		}

		

	public void vacation_press() {
		vacation_button.click();
	}
	

	public void newrequest_press() {
		Newrequest_button.click();

	}
	public void new_req_press_again(){
		new_req_button2.click();
	}

	public void press_sign_in() {
		Sign_in_button.click();

	}

	public void enter_password(String password) {
		passwordInput.sendKeys(password);
	}

	public void login_click() {
		loginButton.click();
		System.out.println("poi");
	}
	
	
	public void settingDateByGivenParameter(int month, int day, int year)
			   throws ParseException, java.text.ParseException {

			  Calendar calNew = Calendar.getInstance();
			  SimpleDateFormat sdfNew = new SimpleDateFormat("dd/MM/yyyy");
			  calNew.setTime(sdfNew.parse("1/" + String.valueOf(month) + "/"
			    + String.valueOf(year)));

			  Calendar cal = Calendar.getInstance();

			  do {
			   // get calendar title and create calendar value
			   element(calendarTitle).waitUntilVisible();
			   String MandY = calendarTitle.getText();
			   SimpleDateFormat sdf = new SimpleDateFormat("MMM, yyyy dd");
			   cal.setTime(sdf.parse(MandY + " 1"));

			   // go previous or next based on comparison
			   if (cal.compareTo(calNew) == -1) {
			    nextButton.click();
			   }
			   if (cal.compareTo(calNew) == 1) {
			    previousButton.click();
			   }

			  } while (cal.compareTo(calNew) != 0);
			  // until month and year are as expected

			  // select day
			  List<WebElement> days = getDriver().findElements(
			    By.cssSelector("div[style*='block'] td"));
			  for (WebElement currentDay : days) {
			   if (currentDay.getText().contentEquals(String.valueOf(day)))
			    currentDay.click();
			  }
			 }
	

	public void click_EndDate() {
		// TODO Auto-generated method stub
		endDate.click();
	}

	public void click_StartDate() {
		// TODO Auto-generated method stub
		startDate.click();
	}

	
}