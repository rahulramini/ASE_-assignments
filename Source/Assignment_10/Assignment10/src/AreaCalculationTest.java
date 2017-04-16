import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AreaCalculationTest {

	AreaCalculation cal = new AreaCalculation();
	double area = cal.Area(7);
	double testArea = 154.0;
	
	@Test
	public void testVolume() {
		System.out.println("@Test Area(): " + area + " = " + testArea);
		assertEquals(area, testArea,0);
	}

}