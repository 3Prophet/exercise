package com.optravis.logvidmi.excercise.dom.service;

import com.optravis.logvidmi.excercise.command.ComputeIntersectionOfTwoListsCmd;
import com.optravis.logvidmi.excercise.command.ListName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class IntersectionCalculatorTest {


    @DisplayName("Intersection of two empty lists results in empty set")
    @Test
    public void twoEmptyListsYieldEmptySetAsIntersection() {

        IntersectionCalculator intersectionCalculator = new IntersectionCalculator(new ListGenerator());

        final int listSize = 0;

        assertThat(intersectionCalculator.calculateIntersection(
                new ComputeIntersectionOfTwoListsCmd(listSize, listSize, ListName.A)).size(), is(listSize));

    }

    @DisplayName("Intersection is commutative. Result when list A intersects with B is the same as when list B intersects with list A")
    @Test
    public void intersectionIsCommutative() {

        Set<Integer> intersectionResult =  new HashSet<>(Arrays.asList(1, 2));

        ListGenerator listGenerator = Mockito.mock(ListGenerator.class);

        List<Integer> listA = Arrays.asList(1, 2, 3);

        List<Integer> listB = Arrays.asList(1, 2);

        when(listGenerator.generateListA(anyLong())).thenReturn(listA);
        when(listGenerator.generateListB(anyLong())).thenReturn(listB);

        IntersectionCalculator intersectionCalculator = new IntersectionCalculator(listGenerator);

        assertThat(intersectionCalculator.calculateIntersection(new
                ComputeIntersectionOfTwoListsCmd(listA.size(), listB.size(), ListName.A)), is(intersectionResult));

    }

    @DisplayName("Elements from the list A that do not belong to intersection also do not belong to list B and wise versa")
    @Test
    public void elementsFromListAThatDoNotBelongToIntersectionAlsoDoNotBelongToBAndWiseVersa() {

        Set<Integer> intersectionResult =  new HashSet<>(Arrays.asList(1, 2));

        ListGenerator listGenerator = Mockito.mock(ListGenerator.class);

        List<Integer> listA = Arrays.asList(1, 2, 3, 5);

        List<Integer> listB = Arrays.asList(1, 2, 4, 6);

        when(listGenerator.generateListA(anyLong())).thenReturn(listA);
        when(listGenerator.generateListB(anyLong())).thenReturn(listB);

        IntersectionCalculator intersectionCalculator = new IntersectionCalculator(listGenerator);

        assertThat(intersectionCalculator.calculateIntersection(new
                ComputeIntersectionOfTwoListsCmd(listA.size(), listB.size(), ListName.A)), is(intersectionResult));


        List<Integer> elementsFromListAThatAreNotInIntersection = listA.stream()
                .filter(number -> !intersectionResult.contains(number)).collect(Collectors.toList());

        List<Integer> elementsFromListBThatAreNotInIntersection = listB.stream()
                .filter(number -> !intersectionResult.contains(number)).collect(Collectors.toList());

        elementsFromListAThatAreNotInIntersection.forEach(number -> assertThat(listB.indexOf(number), is(-1)));

        elementsFromListBThatAreNotInIntersection.forEach(number -> assertThat(listA.indexOf(number), is(-1)));
    }

    @DisplayName("Intersection of two lists without common element is an empty set")
    @Test
    public void intersectionOfListsThatDoNotHaveCommonElementsIsEmptySet() {

        ListGenerator listGenerator = Mockito.mock(ListGenerator.class);

        List<Integer> listA = Arrays.asList(3, 5);

        List<Integer> listB = Arrays.asList(4, 6);

        when(listGenerator.generateListA(anyLong())).thenReturn(listA);
        when(listGenerator.generateListB(anyLong())).thenReturn(listB);

        IntersectionCalculator intersectionCalculator = new IntersectionCalculator(listGenerator);

        assertThat(intersectionCalculator.calculateIntersection(new
                ComputeIntersectionOfTwoListsCmd(listA.size(), listB.size(), ListName.A)).size(), is(0));
    }

    @DisplayName("Intersection of list with an empty list is empty set")
    @Test
    public void intersectionOfListWithAnEmptyListIsEmptySet() {
        ListGenerator listGenerator = Mockito.mock(ListGenerator.class);

        List<Integer> listA = Arrays.asList(3, 5);

        List<Integer> listB = new ArrayList<>();

        when(listGenerator.generateListA(anyLong())).thenReturn(listA);
        when(listGenerator.generateListB(anyLong())).thenReturn(listB);

        IntersectionCalculator intersectionCalculator = new IntersectionCalculator(listGenerator);

        assertThat(intersectionCalculator.calculateIntersection(new
                ComputeIntersectionOfTwoListsCmd(listA.size(), listB.size(), ListName.A)).size(), is(0));
    }
}
