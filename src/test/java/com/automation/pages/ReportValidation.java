package com.automation.pages;

import org.openqa.selenium.By;

public class ReportValidation {
	By DashboardZone= By.xpath("//select[@id='zone_id']");
	By DashboardCircle= By.xpath("//select[@id='circle_id']");
	By DashboardDivision= By.xpath("//select[@id='division_id']");
	By DashboardSubDiv= By.xpath("//select[@id='subdivision_id']");
	By DashboardSection= By.xpath("//select[@id='jurisdiction_id']");
	
	By Report= By.xpath("//a[normalize-space()='Report']");
	
	

}
