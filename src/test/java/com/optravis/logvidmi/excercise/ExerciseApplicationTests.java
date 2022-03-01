package com.optravis.logvidmi.excercise;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
class ExerciseApplicationTests {

	@Test
	void contextLoads() {
		assertThat(true, is(true));
	}


}
