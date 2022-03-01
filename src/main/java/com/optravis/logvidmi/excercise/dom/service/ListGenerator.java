package com.optravis.logvidmi.excercise.dom.service;

import com.optravis.logvidmi.excercise.config.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generates lists with random numbers
 * from 0 to {@link com.optravis.logvidmi.excercise.config.Config#RANDOM_NUMBER_UPPER_BOUND} - 1.
 */
public class ListGenerator {


    /**
     * Generates list A with random numbers.
     * @param listSize Requested list size
     * @return
     */
    public List<Integer> generateListA(long listSize) {

        return doGenerate(listSize);
    }

    /**
     * Generates list B with random numbers.
     * @param listSize Requested list size
     * @return
     */
    public List<Integer> generateListB(long listSize) {

        return doGenerate(listSize);
    }

    private List<Integer> doGenerate(long listSize) {
        Random rand = new Random();

        List<Integer> generatedList = new ArrayList<>();

        for (long index = 0; index < listSize; index++ ) {
            generatedList.add(rand.nextInt(Config.RANDOM_NUMBER_UPPER_BOUND));
        }

        return generatedList;
    }
}
