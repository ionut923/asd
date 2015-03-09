package com.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.pages.MyRequestPage;

public class MyRequestSteps extends ScenarioSteps{

	MyRequestPage myRequestPage;
	
	  @Step
	    public void myRequestPageClick() {
	    	myRequestPage.myRequestPageClick();	
	    }
	  
	  @Step
	  public void checkboxFutureVacations(){
		  myRequestPage.futureVacations();
		  
	  }
	  
	  @Step
	  public void applyButtonClick(){
		  myRequestPage.applyClick();
	  }
	
	
}
