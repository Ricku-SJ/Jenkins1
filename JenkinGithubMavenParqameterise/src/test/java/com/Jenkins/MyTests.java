package com.Jenkins;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Git.MyAnnotions;

public class MyTests extends MyAnnotions {
	@Test
	public void createActi()
	{
		Reporter.log("Create Acti",true);
	}

	@Test
		public void mopdifyActi()
		{
			Reporter.log("Modify Acti",true);
		}
}
