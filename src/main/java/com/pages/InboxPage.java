package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.WebElementFacade;
import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import java.util.List;

import junit.framework.Assert;

public class InboxPage extends PageObject {

	@FindBy(css = "div[class='carousel-slider span3'] a[ href *='inbox']")
	private WebElementFacade inboxButton;

	@FindBy(css = "div[class='carousel-slider span3'] a[ href *='inbox']")
	private WebElementFacade vacationTab;

	@FindBy(css = "div[class='page-links'] span[class='aui-paginator-current-page-report aui-paginator-total']")
	private WebElementFacade totalSelect;

	@SuppressWarnings("deprecation")
	public void selectLinkFromRibbon(String filter) {
		List<WebElement> filtersList = getDriver().findElements(
				By.cssSelector((filter)));
		boolean foundOption = false;
		String now = new String();
		for (WebElement option : filtersList) {

			now = option.getText().toString();

		}
		StringBuilder asf = new StringBuilder();

		char[] split1 = now.toCharArray();
		char split2;
		for (int i = 1; i < split1.length; i++) {

			if (i != split1.length - 1) {
				asf.append(split1[i]);
			}
		}
		System.out.println(asf.toString());// aici o sa am asf valoarea 6 de la inbox
			int x=Integer.valueOf(asf.toString());
			
			
		String totall;
		totall = totalSelect.getText().toString();
		
		// /////////////////
		String word = new String();
		String doi = new String();
		StringBuilder asf1 = new StringBuilder();

		String[] split11 = totall.toString().split(" ");
		

		for (int i = 4; i < split11.length; i++) {

			asf1.append(split11[i]);

		}
		

		doi = asf1.toString();
		System.out.println(doi);
		String[] split21 = doi.split("\\)");
		word = split21[0].toString();
		System.out.println(word);
		int y=Integer.valueOf(word);

		Assert.assertEquals(x, y);
	}

	public void InboxButtonPressed() {
		inboxButton.waitUntilVisible();
		inboxButton.click();
	}

}
