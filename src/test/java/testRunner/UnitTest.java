package testRunner;

import org.junit.Test;

import base.Base;

public class UnitTest {
	
	@Test
	public void testRun() throws InterruptedException {
		Base baseObj = new Base();
		Base.setUp();
		Thread.sleep(5000);
		Base.tearDown();
	}

}
