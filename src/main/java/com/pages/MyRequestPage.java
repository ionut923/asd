package com.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.thucydides.core.pages.WebElementFacade;

import net.thucydides.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

public class MyRequestPage {

	@FindBy(css = "li[class='active-menu'] > a")
	private WebElementFacade myRequest_Button;

	@FindBy(css = "input[id $='VacationsCheckbox']")
	private WebElementFacade futureVacationCheckbox;
	
	@FindBy(css = "input[id $='applyButton']")
	private WebElementFacade apply;
	
	public void applyClick() {
		apply.click();
		
	}

	public void myRequestPageClick() {
		myRequest_Button.click();
	}
	
	public void futureVacations() {
		futureVacationCheckbox.click();
	}

}
