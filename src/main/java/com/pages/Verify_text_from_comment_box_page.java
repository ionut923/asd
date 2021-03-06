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

//@DefaultUrl("http://en.wiktionary.org/wiki/Wiktionary:Main_Page")
//@DefaultUrl("http://192.168.1.68:9090/login")
public class Verify_text_from_comment_box_page extends PageObject {

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
	
/*	@FindBy(css="td[class='dp_previous']")
	private WebElementFacade previous_button;
	
	@FindBy(css="td[class='dp_next']")
	private WebElementFacade next_button;
	*/
	
	
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
	 
	 @FindBy(css="label[for='_evovacation_WAR_EvoVacationportlet_type_CS']")
	 private WebElementFacade special_vacation_label;
	 
	 @FindBy (css="option[value$='OTHER']")
	 private WebElementFacade other_option;
	 
	 @FindBy (css="div[class='requiredComment']")
	 private WebElementFacade comment;
	 
	 @FindBy (css="textarea[name='commentContent']")
	 private WebElementFacade text_zone;
	 
	 @FindBy (css="div[class='comment']")
	 private WebElementFacade commented_text;
	/*@FindBy(css = "a[href*='http://192.168.1.68:9090/vacation?p_p_id=evovacation_WAR_EvoVacationportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_evovacation_WAR_EvoVacationportlet_backURL=%2Fvacation&_evovacation_WAR_EvoVacationportlet_menuItem=my-free-days']")
	private WebElementFacade Myfreedays_button;*/

	/*@FindBy(xpath = "//td[text()='Free days given this year']/following-sibling::td")
	private WebElementFacade FreeDaysGivenThisYear;

	@FindBy(xpath = "//td[text()='Free days left from last year']/following-sibling::td")
	private WebElementFacade FreeDaysLeftFromLastYear;

	@FindBy(xpath = "//td[text()='Vacation days taken this year']/following-sibling::td")
	private WebElementFacade VacationDaysTakenThisYear;

	@FindBy(xpath = "//td[text()='Total available free days']/following-sibling::td")
	private WebElementFacade TotalAvailablefreedays;*/

	public void enter_username(String username) {
		userInput.sendKeys(username);

	}
	public void click_special_vacation(){
		
		special_vacation_label.click();
	}
	
	public void click_submit_button(){
		submit_button.click();
	}
	
	public void click_comment(){
		comment.click();
		
	}
	
	public void check_commented_text(){
		String text= commented_text.getText().toString();
		System.out.println(text);
		Assert.assertTrue(text.contains("lene"));
		//Assert.assert
	}
	
	public void click_text_zone(){
		text_zone.click();
		text_zone.sendKeys("lene");
		
	}
	
	

	/*public void verifyTheTotalnumberdays() {
		int freedaysgivennr = Integer
				.parseInt(FreeDaysGivenThisYear.getText().toString());
		int freedaysleftnr = Integer.parseInt(FreeDaysLeftFromLastYear.getText()
				.toString());
		int vacationdaysnr = Integer.parseInt(VacationDaysTakenThisYear.getText()
				.toString());
		int totaldaysnrshown = Integer.parseInt(TotalAvailablefreedays.getText()
				.toString());
		System.out.print(freedaysgivennr);
		// int
		// totalfreedays=(FreeDaysGivenThisYear+FreeDaysLeftFromLastYear)-VacationDaysTakenThisYear;
		int totaldaysnr = (freedaysgivennr + freedaysleftnr) - vacationdaysnr;

		Assert.assertEquals(totaldaysnr, totaldaysnrshown);*/

	//}

	public void vacation_press() {
		vacation_button.click();
	}
	

	public void newrequest_press() {
		Newrequest_button.click();

	}
	public void click_other_option(){
		other_option.click();
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
	/*
	 * public void getPageRibbon(String param) { //WebElementFacade list =
	 * find(By.cssSelector(".lfr-nav-deletable.lfr-nav-updateable"));
	 * List<WebElement> results = (List<WebElement>)
	 * find(By.cssSelector(".lfr-nav-deletable.lfr-nav-updateable a span"));
	 * for(WebElement l:results){
	 * if(l.getText().toLowerCase().toString().equals(param)) {
	 * System.out.print(l.getText().toString()); l.click(); } } }
	 */

	public void click_EndDate() {
		// TODO Auto-generated method stub
		endDate.click();
	}

	public void click_StartDate() {
		// TODO Auto-generated method stub
		startDate.click();
	}

	/*
	 * public List<String> getDefinitions() { WebElementFacade definitionList =
	 * find(By.css("ol")); List<WebElement> results =
	 * definitionList.findElements(By.tagName("li")); return convert(results,
	 * toStrings()); }
	 * 
	 * private Converter<WebElement, String> toStrings() { return new
	 * Converter<WebElement, String>() { public String convert(WebElement from)
	 * { return from.getText(); }
	 * 
	 * };
	 * 
	 * }
	 */
}