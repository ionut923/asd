package com.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyRequestPage extends PageObject {
	
	
	
	

	@FindBy(css = "[href*='menuItem=my-requests']")
	private WebElementFacade myRequest_Button;

	@FindBy(css = "input[id $='VacationsCheckbox']")
	private WebElementFacade futureVacationCheckbox;

	@FindBy(css = "input[id $='applyButton']")
	private WebElementFacade apply;

	@FindBy(css = "a[class*='aui-paginator-link aui-paginator-next-link']")
	private WebElementFacade nextButton;

	@FindBy(css = "span[class*='aui-paginator-current-page-report aui-paginator-total']")
	private WebElementFacade totalPages;

	//private String ;

	public void applyClick() {
		apply.click();

	}

	public void applyButtonClick() {
		nextButton.click();
	}

	public void myRequestPageClick() {
		myRequest_Button.waitUntilVisible();
		myRequest_Button.click();
	}

	public void futureVacations() {
		futureVacationCheckbox.click();
	}

	public void nextPage(String filter, String filterName) {

		String textfild = totalPages.getText().toString();
		String[] newstring = textfild.split(" ");
		String newnewstring = newstring[0];

		System.out.println(newnewstring);

		String last, last1 = "";
		last = newnewstring.substring(1, newnewstring.length());

		String newnewstring1 = newstring[2];
		last1 = newnewstring1.substring(0, newnewstring1.length() - 1);

		System.out.println(last1);
		System.out.println(last);

		int lastt1 = Integer.parseInt(last1);
		int lastt = Integer.parseInt(last);
		
		
		checkFilters(filter, filterName);
		while (lastt1 > lastt) {

			System.out.println("iN WHILE " + last1);
			System.out.println("iN WHILE " + last);

			lastt++;
			
			nextButton.click();
			checkFilters(filter, filterName);
		}
		

	}

	public void checkFilters(String filter, String filterName) {
		// List<WebElement> daysList = getDriver().findElements(
		// By.cssSelector(("tr td[class*='col-3 col-my.request.column.header.day.number']")));

		List<WebElement> vacationTypeList = getDriver().findElements(
				By.cssSelector("tr td[id*='evovacation'][class*='col-4']"));

		if (!filterName.trim().contentEquals("")) {
			if (filter.contentEquals("Vacation Type")) {
				boolean option = false;

				for (WebElement vacationTypeListOption : vacationTypeList) {

					if ((vacationTypeListOption.getText()
							.contentEquals(filterName))) {
						System.out
								.print("!!!!!!!!!!!!!!!!! Vacation type displayed in the table!!! "
										+ vacationTypeListOption.getText());
						System.out.print("Selected option :" + filterName);
						option = true;
					}

				}

				Assert.assertTrue("The option " + filterName
						+ " was not found!", option);

			}
		}
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

	public void FindMyRequest(String firstDate) {

		
		//transforma firstDate si endDate
		
		
		String textfild = totalPages.getText().toString();
		String[] newstring = textfild.split(" ");
		String newnewstring = newstring[0];

		System.out.println(newnewstring);

		String last, last1 = "";
		last = newnewstring.substring(1, newnewstring.length());

		String newnewstring1 = newstring[2];
		last1 = newnewstring1.substring(0, newnewstring1.length() - 1);

		System.out.println(last1);
		System.out.println(last);

		int lastt1 = Integer.parseInt(last1);
		int lastt = Integer.parseInt(last);
		
		
		checkMyRequest(firstDate);
		
		
		
		while (lastt1 > lastt) {

			System.out.println("iN WHILE " + last1);
			System.out.println("iN WHILE " + last);

			lastt++;
			
			nextButton.click();
			
			
			
			checkMyRequest(firstDate);
		}
		

	}

	
	
	public void checkMyRequest(String firstDate){//, String verifyFirstDate) {
		// List<WebElement> daysList = getDriver().findElements(
		// By.cssSelector(("tr td[class*='col-3 col-my.request.column.header.day.number']")));

//		transforma startDate si endDate din formatul 1/1/2015 in formatul 01/01/2015
		
	//	SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	//	@SuppressWarnings("deprecation")
	//	String fDate = f.format(new Date(firstDate));
		
		
	//	SimpleDateFormat e = new SimpleDateFormat("dd/MM/yyyy");
		//String eDate = e.format(new Date(endDate));
		
		
		
		List<WebElement> verifyingFirstDate = getDriver().findElements(
				By.cssSelector("tr td[id*='evovacation'][class*='col-1']"));

	//	if (!verifyFirstDate.trim().contentEquals("")) {
		//	if (firstDate.contentEquals(verifyingFirstDate)) {
				boolean option = false;
				
				System.out.println("Looking for: " + firstDate);

				for (WebElement vacationTypeListOption : verifyingFirstDate) {
					System.out.println("Date found: " + vacationTypeListOption.getText());
					if ((vacationTypeListOption.getText()
							.contentEquals(firstDate))) {
						System.out
								.print("!!!!!!!!!!!!!!!!!  I found my request  !!! "
										+ vacationTypeListOption.getText());
						//System.out.print("Selected option :" + verifyFirstDate);
						option = true;
						break;
					}

				}

				Assert.assertTrue("The option " + firstDate
						+ " was not found!", option);

		//	}
	//	}
	}
	
	



	
	
}








/*
 * public void checkFilters(String daysFilter, String typeFilter,String
 * statusFilter){ List<WebElement> filtersListt = getDriver().findElements(
 * By.cssSelector
 * (("tr td[class*='col-3 col-my.request.column.header.day.number']"))); if
 * ((!daysFilter
 * .trim().contentEquals(""))&&((!typeFilter.trim().contentEquals(""
 * )))&&((!statusFilter.trim().contentEquals("")))) { boolean option = false;
 * 
 * for (WebElement filterType : filtersListt ) {
 * 
 * if ((filterType.getText().equals(daysFilter))&&(filterType.getText().equals(
 * typeFilter))&&(filterType.getText().equals(statusFilter))) {
 * System.out.print(filterType.getText()); option = true; filterType.click();
 * break; } } Assert.assertTrue("The option was not found!", option); } }
 * 
 * }
 */

/*
 * public void selectVacationTypeList(String filter) { List<WebElement>
 * filtersList = getDriver() .findElements( // am o lista (filtersList) care
 * returneaza numai // elemente de tip webElements
 * By.cssSelector((".aui-column-content-first .column-content label"))); boolean
 * foundOption = false; for (WebElement vacatioType : filtersList) { if
 * (vacatioType.getText().equals(filter)) {
 * System.out.print(vacatioType.getText()); foundOption = true;
 * vacatioType.click(); break; } }
 * Assert.assertTrue("The option was not found!", foundOption);
 * 
 * }
 * 
 * public void selectVacationDaysNumberList(String option) {
 * 
 * List<WebElement> filtersDaysNumber = getDriver().findElements(
 * By.cssSelector(".aui-choice-label")); boolean found = false; for (WebElement
 * daysNumber : filtersDaysNumber) { if (daysNumber.getText().equals(option)) {
 * System.out.print(daysNumber.getText()); found = true; daysNumber.click();
 * break;
 * 
 * }
 * 
 * } Assert.assertTrue("The option was not found!", found);
 * 
 * }
 * 
 * public void selectVacationStatus(String opt) { List<WebElement> filterstatus
 * = getDriver().findElements( By.cssSelector(".aui-choice-label")); boolean
 * isThere = false; for (WebElement status : filterstatus) { if
 * (status.getText().equals(opt)) {
 * 
 * isThere = true; status.click(); break; } }
 * 
 * }
 */

