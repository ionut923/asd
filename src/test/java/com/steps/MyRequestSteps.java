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
	  public void selectFilterItem(String filter){
		  myRequestPage.selectFilterItem(filter);
	  }
	  
	  /*@Step
	  public void selectVacationTypeList(String filter){
		  myRequestPage.selectVacationTypeList(filter);
	  }
	  
	  @Step
	  public void selectVacationsDaysNumber(String option){
		  myRequestPage.selectVacationDaysNumberList(option);
		  
	  }
	  
	  @Step
	  public void selectVacationStatus(String opt){
		  myRequestPage.selectVacationStatus(opt);
		  
		  
	  }*/
	  
	  
	  @Step
	  public void checkboxFutureVacations(){
		  myRequestPage.futureVacations();
		  
	  }
	  
	  @Step
	  public void applyButtonClick(){
		  myRequestPage.applyClick();
	  }
	
	
}
