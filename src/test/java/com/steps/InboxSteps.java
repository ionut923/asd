package com.steps;

import com.pages.InboxPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class InboxSteps extends ScenarioSteps {

	InboxPage inboxstep;

	@Step
	public void press_inbox_button() {
		inboxstep.InboxButtonPressed();

	}
	@Step
	public void  selectLinkFromRibbon(String filter){
		inboxstep.selectLinkFromRibbon(filter);
		
	}
	public void total(){
		System.out.println();
	}

}
