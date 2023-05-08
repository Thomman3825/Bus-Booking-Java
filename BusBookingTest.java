import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BusBookingTest {
Traveller b1 = new Traveller();

	@Test
	void test() {
//		fail("Not yet implemented");
		b1.busName.add("B1");
		b1.busName.add("B2");
		b1.busName.add("B3");
		assertEquals("Adding 4 student to list", 3, b1.busName.size());
	}

}
