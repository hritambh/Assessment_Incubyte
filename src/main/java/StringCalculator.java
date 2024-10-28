package main.java;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] extractedDelimeterAndNumers =  extractDelimeterAndNumers(numbers);
        String delimiter = extractedDelimeterAndNumers[0];
        numbers = extractedDelimeterAndNumers[1];

        return processOperation(numbers,delimiter);
    }

    private int processOperation(String numbers, String delimiter) {

        String[] nums = numbers.split(delimiter);
        handleNegatives(nums,delimiter);
        if(delimiter.contains("*")){
            return performMultiplication(nums);
        } else {
            return performAddition(nums);
        }
    }

    private void handleNegatives(String[] numbers, String delimiter) {
        List<Integer> negatives = new ArrayList<>();

        for (String num : numbers) {
            int number = Integer.parseInt(num);
            if (number < 0) {
                negatives.add(number);
                break;
            }
        }

        if (!negatives.isEmpty()){
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }
    }

    private int performMultiplication(String[] numbers) {
        int prod = 1;
        for (String num : numbers) {
            int number = Integer.parseInt(num);
            prod *= number;
        }
        return prod;
    }

    private int performAddition(String[] numbers) {
        int sum = 0;
        for (String num : numbers) {
            int number = Integer.parseInt(num);
            sum += number;
        }
        return sum;
    }

    private String[] extractDelimeterAndNumers(String numbers) {
        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            if (delimiter.equals("*")){
                delimiter = "\\*";
            }

            numbers = numbers.substring(delimiterIndex + 1);
        }
        return new String[]{delimiter,numbers};
    }
}
