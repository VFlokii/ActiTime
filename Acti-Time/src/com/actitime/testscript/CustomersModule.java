package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;
import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomersModule extends BaseClass
{
	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		Reporter.log("Create Customer", true);
		HomePage h = new HomePage(driver);
		h.setTaskTab();
		TaskListPage tl = new TaskListPage(driver);
		FileLib f = new FileLib();
		String cn = f.getExcelData("CreateCustomer", 1, 3);
		String dc = f.getExcelData("CreateCustomer", 1, 4);
		tl.setCreateCustomer(cn, dc);
	}

}
