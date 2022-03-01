package com.optravis.logvidmi.excercise.dom.service;

import com.optravis.logvidmi.excercise.command.ComputeIntersectionOfTwoListsCmd;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Service to calculate intersection of two lists.
 */
public class IntersectionCalculator {

    private final ListGenerator listGenerator;

    /**
     * @param listGenerator List generator to generate lists with random numbers.
     */
    public IntersectionCalculator(ListGenerator listGenerator) {
        this.listGenerator = listGenerator;
    }

    /**
     * Calculates intersection of two lists.
     * @param command Parameters for calculation.
     * @return
     */
    public Set<Integer> calculateIntersection(ComputeIntersectionOfTwoListsCmd command) {

        List<Integer> listA = listGenerator.generateListA(command.getSizeOfListA());

        List<Integer> listB = listGenerator.generateListB(command.getSizeOfListB());

        switch(command.getListToHash()) {
            case A:
                return doCalculateIntersection(listB, new HashSet<>(listA));
            default:
                return doCalculateIntersection(listA, new HashSet<>(listB));
        }
    }

    private Set<Integer> doCalculateIntersection(List<Integer> listToIterateOver, Set<Integer> hashedList) {

        Set<Integer> result = new HashSet<>();

        for (Integer number: listToIterateOver) {
            if (hashedList.contains(number)) {
                result.add(number);
            }
        }
        return result;
    }
}
