package com.pages;

import net.thucydides.core.annotations.DefaultUrl;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

//@DefaultUrl("http://en.wiktionary.org/wiki/Wiktionary:Main_Page")
//@DefaultUrl("http://192.168.1.68:9090/login")
public class MyFreeDaysPage extends PageObject {

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

	@FindBy(css= "a[href$='my-free-days']")
	private WebElementFacade Myfreedays_button;

	@FindBy(xpath = "//td[text()='Free days given this year']/following-sibling::td")
	private WebElementFacade FreeDaysGivenThisYear;

	@FindBy(xpath = "//td[text()='Free days left from last year']/following-sibling::td")
	private WebElementFacade FreeDaysLeftFromLastYear;

	@FindBy(xpath = "//td[text()='Vacation days taken this year']/following-sibling::td")
	private WebElementFacade VacationDaysTakenThisYear;

	@FindBy(xpath = "//td[text()='Total available free days']/following-sibling::td")
	private WebElementFacade TotalAvailablefreedays;
	
	//@FindBy(css= "a[href$='my-free-days']")
	//private WebElementFacade TotalAvailablefreedays;

	public void enter_username(String username) {
		userInput.sendKeys(username);

	}

	public void verifyTheTotalnumberdays() {
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

		Assert.assertEquals(totaldaysnr, totaldaysnrshown);

	}

	public void vacation_press() {
		vacation_button.click();
	}

	public void myfreedays_press() {
		Myfreedays_button.click();

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
	
	public void getPageRibbon(String param) { //WebElementFacade list =
		find(By.cssSelector(".lfr-nav-deletable.lfr-nav-updateable"));
		List<WebElement> results = (List<WebElement>)
				find(By.cssSelector(".lfr-nav-deletable.lfr-nav-updateable a span"));
		for(WebElement l:results){
			if(l.getText().toLowerCase().toString().equals(param)) {
				System.out.print(l.getText().toString()); l.click(); } } }


	
//	public List<String> getDefinitions() { 
//		WebElementFacade definitionList = find(By.cssSelector("ol")); 
//		List<WebElement> results = definitionList.findElements(By.tagName("li")); 
//		return convert(results, toStrings()); 
//	}
	  
//	private Converter<WebElement, String> toStrings() { return new
//			Converter<WebElement, String>() { public String convert(WebElement from)
//			{ return from.getText(); }
//
//	};
	  
	 
}