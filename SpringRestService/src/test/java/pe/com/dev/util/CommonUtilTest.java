package pe.com.dev.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommonUtilTest {
	CommonUtil cu = null;

	@Before
	public void setUp() throws Exception {
		cu = new CommonUtil();
	}

	@Test
	public void testEmailValidator() {
		assertTrue(cu.emailValidator("user@domain.com"));
		assertTrue(cu.emailValidator("user@domain.co.in"));
		assertTrue(cu.emailValidator("user1@domain.com"));
		assertTrue(cu.emailValidator("user.name@domain.com"));
		assertTrue(cu.emailValidator("user#@domain.co.in"));
		
		assertFalse(cu.emailValidator(""));
		assertFalse(cu.emailValidator("user@domaincom"));
		assertFalse(cu.emailValidator("user#domain.com"));
		assertFalse(cu.emailValidator("@yahoo.com"));
		assertFalse(cu.emailValidator(null));
	}

	@Test
	public void testValidateNewPass() {
		//assertEquals(cu.validateNewPass(null, null), "One or both passwords are null");
		
	}

	@Test
	public void testGetNewPassValidation() {
		//fail("Not yet implemented");
	}

}
