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

//@DefaultUrl("http://en.wiktionary.org/wiki/Wiktionary:Main_Page")
//@DefaultUrl("http://192.168.1.68:9090/login")
public class DictionaryPage extends PageObject {

	
	@FindBy(id="sign-in")
	 private WebElementFacade Sign_in_button;
	
	
    @FindBy(id="_58_login")
    private WebElementFacade userInput;
    
    @FindBy(id="_58_password")
    private WebElementFacade passwordInput;

    @FindBy(css="[type='submit']")
    private WebElementFacade loginButton;

    public void enter_username(String username) {
    	userInput.sendKeys(username);
    }
     
    public void press_sign_in()
    {
    	Sign_in_button.click();
    	
    	
    }
    public void enter_password(String password) {
        passwordInput.sendKeys(password);
    }
    
    public void login_click() {
        loginButton.click();
        System.out.println("poi");
    }

  /*
   * public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        List<WebElement> results = definitionList.findElements(By.tagName("li"));
        return convert(results, toStrings());
    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
            
        };
        
    }
   * 
   * 
   * 
   * */
}