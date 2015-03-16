package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;

import com.pages.FreeDaysCheckPage;

public class FreeDaysCheckSteps extends ScenarioSteps {
	FreeDaysCheckPage freeDaysCheckPage;

	@Step
	public void myRequest_Button_click() {
		freeDaysCheckPage.myRequest_Button_click();
	}

	@Step
	public void pending_button_checkbox_click() {
		freeDaysCheckPage.pending_button_checkbox_click();
	}

	@Step
	public void myrequest_apply_button_click() {
		freeDaysCheckPage.myrequest_apply_button_click();
	}

	@Step
	public void first_row_in_column1_click() {
		freeDaysCheckPage.first_row_in_column1_click();
	}

	@Step
	public void press_withdrawn_button() {

		freeDaysCheckPage.press_withdrawn_button();
		String withdrawn = freeDaysCheckPage.get_Withdrawn_in_text();
		String numberday = freeDaysCheckPage
				.get_days_number_from_withdrawn_table();
		
		System.out.println(withdrawn+numberday);
		freeDaysCheckPage.free_days_history_button_press();
		freeDaysCheckPage.added_days_checkbox_press();
		freeDaysCheckPage.apply_button_freeday_press();
		String withdrawn1 = freeDaysCheckPage.get_number_of_day_number_column();
		String numberday1 = freeDaysCheckPage.get_added_date();
		System.out.println(numberday1+withdrawn1);
		boolean in= withdrawn.contains(numberday1)&&numberday.contains(withdrawn1);
		Assert.assertTrue(in);
	}
}