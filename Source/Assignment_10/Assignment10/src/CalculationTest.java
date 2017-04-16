import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculationTest {

	Calculation cal = new Calculation();
	double volume = cal.Volume(7);
	double testVolume = 1437.3333333333333;
	
	@Test
	public void testVolume() {
		System.out.println("@Test Volume(): " + volume + " = " + testVolume);
		assertEquals(volume, testVolume,0);
	}

}
