package com.steps;



import org.junit.Assert;

import com.pages.InboxPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

@SuppressWarnings("serial")
public class InboxSteps extends ScenarioSteps {

	InboxPage inboxstep;

	@Step
	public void press_inbox_button() {
		inboxstep.InboxButtonPressed();

	}

	

	@SuppressWarnings("deprecation")
	@Step
	public void select_the_value_from_inbox(String filter) {
		
		inboxstep.select_the_value_from_inbox(filter);
		inboxstep.select_total_value();
		Assert.assertEquals(inboxstep.select_the_value_from_inbox(filter), inboxstep.select_total_value());
		
	}

}
