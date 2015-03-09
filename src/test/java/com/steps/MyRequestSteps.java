package com.steps;

import net.thucydides.core.annotations.Step;

import com.pages.MyRequestPage;

public class MyRequestSteps {

	MyRequestPage myRequestPage;
	
	  @Step
	    public void myRequestPageClick(){
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
