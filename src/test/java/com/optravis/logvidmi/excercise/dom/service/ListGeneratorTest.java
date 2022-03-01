package com.optravis.logvidmi.excercise.dom.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class ListGeneratorTest {

    @DisplayName("List generator generates list of provided size.")
    @ParameterizedTest(name = "[{index}] Generating list with random values of size: {0}")
    @MethodSource("sourceOfListSizes")
    public void listGeneratorGenerateListOfProvidedSize(Long listSize) {
        ListGenerator listGenerator = new ListGenerator();

        List<Integer> generatedListA = listGenerator.generateListA(listSize);
        List<Integer> generatedListB = listGenerator.generateListB(listSize);

        assertThat(generatedListA.size(), is(listSize.intValue()));
        assertThat(generatedListB.size(), is(listSize.intValue()));
    }

    public static Stream<Arguments> sourceOfListSizes() {
        return Stream.of(Arguments.arguments(0L), Arguments.arguments(20L));
    }
}
