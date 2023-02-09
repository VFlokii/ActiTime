package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(id="logoutLink")
	private WebElement lgoBtn;
	
	@FindBy(id="container_tasks")
	private WebElement taskBtn;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setLogout()
	{
		lgoBtn.click();
	}
	
	public void setTaskTab()
	{
		taskBtn.click();
	}
}
