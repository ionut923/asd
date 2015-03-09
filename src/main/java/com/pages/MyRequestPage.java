package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import java.util.List;

public class MyRequestPage extends PageObject{

	@FindBy(css = "[href*='menuItem=my-requests']")
	private WebElementFacade myRequest_Button;

	@FindBy(css = "input[id $='VacationsCheckbox']")
	private WebElementFacade futureVacationCheckbox;
	
	@FindBy(css = "input[id $='applyButton']")
	private WebElementFacade apply;
	
	public void applyClick() {
		apply.click();
		
	}

	public void myRequestPageClick() {
		myRequest_Button.waitUntilVisible();
		myRequest_Button.click();
	}
	
	public void futureVacations() {
		futureVacationCheckbox.click();
	}

}
