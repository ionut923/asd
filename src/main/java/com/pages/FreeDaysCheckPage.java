package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class FreeDaysCheckPage extends PageObject {

	@FindBy(css = "li a[href*='menuItem=my-requests']")
	private WebElementFacade myRequest_Button;

	@FindBy(css = "input[id*='PENDINGCheckbox']")
	private WebElementFacade pending_button_checkbox;

	@FindBy(css = "input[id*='_evovacation_WAR_EvoVacationportlet_applyButton']")
	private WebElementFacade myrequest_apply_button;

	@FindBy(css = "td[id*='header.start.date_row-1'] a")
	private WebElementFacade first_row_in_column1;

	@FindBy(css = "#mainVacationContent > div > div.view-vacation > div.aui-column.aui-w70.vacation-info-column.aui-column-first > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > div > b")
	private WebElementFacade Withdrawn_in_text;

	@FindBy(css = "#mainVacationContent > div > div.view-vacation > div.aui-column.aui-w70.vacation-info-column.aui-column-first > div > div:nth-child(5) > b:nth-child(3)")
	private WebElementFacade days_number;
	
	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_withdrawnVacationRequest")
	private WebElementFacade withdrawn_button;
	
	@FindBy(xpath="//*[contains(text(),'Free Days History')] ")
	private WebElementFacade free_days_history_button;
	
	
	@FindBy(css = "#_evovacation_WAR_EvoVacationportlet_ADDED_DAYSCheckbox")
	private WebElementFacade added_days_checkbox;
	
	@FindBy(css = "input[id*='_evovacation_WAR_EvoVacationportlet_applyButton']")
	private WebElementFacade apply_button_freeday;
	
	@FindBy(css = "td[id*='header.number_row-1']")
	private WebElementFacade number_of_day_number_column;
	
	@FindBy(css = "td[id*='header.added.date_row-1']")
	private WebElementFacade date_last;
	
	

	public void myRequest_Button_click() {
		myRequest_Button.click();
	}

	public void pending_button_checkbox_click() {
		pending_button_checkbox.click();
	}

	public void myrequest_apply_button_click() {
		myrequest_apply_button.click();
	}

	public void first_row_in_column1_click() {
		first_row_in_column1.click();
	}

	public String get_Withdrawn_in_text() {
		String Withdrawn_in_text_from_table;
		Withdrawn_in_text_from_table = Withdrawn_in_text.getText();
		return Withdrawn_in_text_from_table;
	}

	public String get_days_number_from_withdrawn_table() {
		String day_number_from_withdrawn_table;
		day_number_from_withdrawn_table = days_number.getText();
		return day_number_from_withdrawn_table;
	}
	 public void press_withdrawn_button(){
		 withdrawn_button.click();
		 
	 }
	 public void free_days_history_button_press(){
		 free_days_history_button.click();
	 }
	 public void added_days_checkbox_press(){
		 added_days_checkbox.click();
	 }
	 public void apply_button_freeday_press(){
		 apply_button_freeday.click();
	 }
	 public String get_number_of_day_number_column(){
		 String number=number_of_day_number_column.getText();
		 return number;
	 }
	 
	 public String get_added_date(){
		 String date=date_last.getText();
		 return date;
	 }

}
