package ServiceTest;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.fiivirtualcatalog.modules.checkin.services.CheckInServiceImpl;

public class ServiceTest {
	private CheckInServiceImpl service;
	
	@Before
	public void setUp() {
		service = new CheckInServiceImpl();
	}

	@Test
	public void testValidText_1() {
	}
	
	@Test
	public void testValidText_2() {
	}

}
