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
        boolean isMultiplilcation=false;
        if (delimiter.contains("*"))
            isMultiplilcation = true;


        String[] nums = numbers.split(delimiter);
        int result = isMultiplilcation ? 1 : 0;
        List<Integer> negatives = new ArrayList<>();
        for (String num : nums) {
            int number = Integer.parseInt(num);
            if (number < 0) {
                negatives.add(number);
                break;
            }
            if (isMultiplilcation)
                result *= number;
            else
                result += number;
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }

        return result;
    }

    private String[] extractDelimeterAndNumers(String numbers) {
        String delimiter = ",|\n";
        boolean isMultiplilcation = false;
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            if (delimiter.equals("*")){
                isMultiplilcation = true;
                delimiter = "\\*";
            }

            numbers = numbers.substring(delimiterIndex + 1);
        }
        return new String[]{delimiter,numbers};
    }
}
