package com.AgilecrmAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonApplianceSearchModuleTestCase extends BaseClass {
	@Test(groups = { "regression", "sanity" })
	@Parameters({ "browser" })

	public void AmazonApplianceSearch() {
		launchBrowser("browser");
		driver.navigate().to("http://www.amazon.in");
		selectDropDownValByText(driver.findElement(By.id("searchDropdownBox")), "Appliances");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Washing Machine");
		click(By.id("nav-search-submit-button"), "Click on Search button");
		List<WebElement> applianceNames = driver.findElements(By.xpath("//div[@class='sg-row']/descendant::h2/a/span"));
		// waitForElementToBePresent(By.xpath("//div[@class='sg-row']/descendant::span[@class='a-ofscreen']"));
		List<WebElement> appliancePrices = driver
				.findElements(By.xpath("//div[@class='sg-row']/descendant::span[@class='a-price']"));
		for (int i = 0; i < applianceNames.size(); i++) {

			String name = (applianceNames.get(i).getText());
			String price = (appliancePrices.get(i).getText());
			System.out.println(name + " : " + price);
		}
	}
}
