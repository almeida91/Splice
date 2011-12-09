package ga.stopConditions;

import static org.junit.Assert.*;
import ga.GenerationData;

import org.junit.Before;
import org.junit.Test;

public class GenerationsTest {
	Generations condition;
	GenerationData data;
	final int GENERATIONS = 1000;
	final int MAX = 100;

	@Before
	public void setUp() throws Exception {
		condition = new Generations(GENERATIONS);
		data = new GenerationData();
	}

	@Test
	public void testStop() {
		for (int i = 0; i < GENERATIONS + MAX; i++) {
			data.setGeneration(i);
			if (i < GENERATIONS)
				assertFalse(condition.stop(data));
			else
				assertTrue(condition.stop(data));
		}
	}

}
