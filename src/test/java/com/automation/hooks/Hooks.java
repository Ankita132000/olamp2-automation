package com.automation.hooks;

import com.automation.driver.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	 @Before
	    public void setup() {
	        DriverManager.init();
	    }

	    @After
	    public void tearDown() {
	        DriverManager.quit();
	    }

}
