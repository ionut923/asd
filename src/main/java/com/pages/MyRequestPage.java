package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import java.util.List;

public class MyRequestPage extends PageObject {

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

	public void selectFilterItem(String filterName) {
		List<WebElement> filtersList = getDriver().findElements(
				By.cssSelector((".aui-choice-label")));
		if (!filterName.trim().contentEquals("")) {
			boolean foundOption = false;
			for (WebElement vacatioType : filtersList) {
				if (vacatioType.getText().equals(filterName)) {
					System.out.print(vacatioType.getText());
					foundOption = true;
					vacatioType.click();
					break;
				}
			}
			Assert.assertTrue("The option was not found!", foundOption);
		}

	}

	/*
	 * public void selectVacationTypeList(String filter) { List<WebElement>
	 * filtersList = getDriver() .findElements( // am o lista (filtersList) care
	 * returneaza numai // elemente de tip webElements
	 * By.cssSelector((".aui-column-content-first .column-content label")));
	 * boolean foundOption = false; for (WebElement vacatioType : filtersList) {
	 * if (vacatioType.getText().equals(filter)) {
	 * System.out.print(vacatioType.getText()); foundOption = true;
	 * vacatioType.click(); break; } }
	 * Assert.assertTrue("The option was not found!", foundOption);
	 * 
	 * }
	 * 
	 * public void selectVacationDaysNumberList(String option) {
	 * 
	 * List<WebElement> filtersDaysNumber = getDriver().findElements(
	 * By.cssSelector(".aui-choice-label")); boolean found = false; for
	 * (WebElement daysNumber : filtersDaysNumber) { if
	 * (daysNumber.getText().equals(option)) {
	 * System.out.print(daysNumber.getText()); found = true; daysNumber.click();
	 * break;
	 * 
	 * }
	 * 
	 * } Assert.assertTrue("The option was not found!", found);
	 * 
	 * }
	 * 
	 * public void selectVacationStatus(String opt) { List<WebElement>
	 * filterstatus = getDriver().findElements(
	 * By.cssSelector(".aui-choice-label")); boolean isThere = false; for
	 * (WebElement status : filterstatus) { if (status.getText().equals(opt)) {
	 * 
	 * isThere = true; status.click(); break; } }
	 * 
	 * }
	 */

}
