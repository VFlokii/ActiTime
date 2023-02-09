package com.actitime.pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.actitime.generic.FileLib;

public class TaskListPage {

	@FindBy(xpath="//div[text()='Add New']")
	private WebElement addNewBtn;
	
	@FindBy(xpath="//div[text()='+ New Customer']")
	private WebElement newCustomerOpt;
	
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement customerName;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement descArea;
	
	@FindBy(xpath="(//div[@class='dropdownButton'])[15]")
	private WebElement dropdownBtn;
	
	@FindBy(xpath="(//div[@class='itemRow cpItemRow '])[4]")
	private WebElement selectBtn;
	
	@FindBy(xpath="//div[text()='Create Customer']")
	private WebElement createCustomeBtn;
	
	@FindBy(xpath="(//div[text()='HDFC_001'])[2]")
	private WebElement verifyCustomer;
	
	public TaskListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setCreateCustomer(String cn, String dc) throws InterruptedException, EncryptedDocumentException, IOException
	{
		addNewBtn.click();
		newCustomerOpt.click();
		Thread.sleep(2000);
		customerName.sendKeys(cn);
		Thread.sleep(2000);
		descArea.sendKeys(dc);
		dropdownBtn.click();
		selectBtn.click();
		createCustomeBtn.click();
		String name = verifyCustomer.getText();
		if(name.equals(cn))
		{
			Reporter.log("Customer is succefully created", true);
			FileLib f = new FileLib();
			f.setExcelData("CreateCustomer", 1, 5, "PASS");
		}
		else
		{
			Reporter.log("Customer is not created", true);
			FileLib f = new FileLib();
			f.setExcelData("CreateCustomer", 1, 5, "FAIL");
		}
	}
	
	
}
