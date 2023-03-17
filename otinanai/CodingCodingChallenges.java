package otinanai;

import java.util.*;

public class CodingCodingChallenges {

    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Welcome to my coding challenges! Type menu to display the list of available tests" +
                " for my challenges");
        scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String input = scanner.nextLine();
            handleInput(input.toUpperCase());
        }
        scanner.close();
    }

    static void handleInput(String input){
        switch (input){
            case "PALINDROME":
                System.out.println("Give me a word:");
                System.out.println(checkPalindrome(scanner.nextLine()));
                break;
            case "ABSOLUTEDIFFERENCE":
                System.out.println("Give me numbers separated by space:");
                System.out.println(findSmallestDifference(scanner.nextLine()));
                break;
            case "COUNTCHARACTERS":
                System.out.println("Give me a word to count the characters");
                System.out.println(eachCharacterAppearance(scanner.nextLine()));
            case "LONGESTSEQUENCE":
                System.out.println("Give me numbers separated by space");
                System.out.println(longestIncreasingSubsequence(scanner.nextLine()));
                break;
            case "SHORTESTWORD":
                System.out.println("Give me a sentence to determine the smallest word in it.");
                System.out.println(returnShortestWord(scanner.nextLine()));
            default:
                System.out.println("Wrong command. Use menu to display valid commands:");
        }
    }

    static boolean checkPalindrome(String input){
        char [] array2 = new char[input.length()];

        for (int i = array2.length-1; i >= 0 ; i--) {
            array2[i] = input.charAt(i);
        }
        return input.equals(String.valueOf(array2));
    }

    static String findSmallestDifference(String input){
        String [] parts = input.split(" ");
        int [] numbers = new int[parts.length];

        for (int i = 0; i < parts.length-1; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }

        Arrays.sort(numbers);

        int tempNumber1 = 0;
        int tempNumber2 = 0;
        int smallestDifference = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length-1; i++) {
            int checkNumbersDifference = Math.abs(numbers[i] - numbers[i + 1]);
            if (checkNumbersDifference <= smallestDifference){
                smallestDifference = Math.abs(checkNumbersDifference);
                tempNumber1 = numbers[i];
                tempNumber2 = numbers[i + 1];
            }
        }
        return "The pair with the smallest difference is " + tempNumber1 + " " + tempNumber2;
    }

    /**
     * Write a program that takes a string as input and returns the number of times each character
     * appears in the string. The program should ignore whitespace and punctuation, and the output
     * should be sorted alphabetically.
     */
    static String eachCharacterAppearance(String input){
        //tree map automatically sorts the map.
        TreeMap<Character, Integer> countTimes = new TreeMap<>();
        char [] array = input.toCharArray();
        StringBuilder returnedValue = new StringBuilder();

        for (char character: array){
            if (!Character.isLetterOrDigit(character)) continue; //ignoring white-spaces & punctuation as stated.
            if (countTimes.containsKey(character)){
                countTimes.replace(character, countTimes.get(character)+1);
            } else {
                countTimes.put(character,1);
            }
        }

        for (var val : countTimes.keySet()){
            returnedValue.append(val).append("=").append(countTimes.get(val)).append(" ");
        }

        return returnedValue.toString();
    }

    static String longestIncreasingSubsequence(String input){
        String [] parts = input.split(" ");
        int [] numbers = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }

        TreeSet<Integer> set = new TreeSet<>();

        for (int number: numbers){
            set.add(number);
        }

        return set.toString();
    }

    static String returnShortestWord(String input){
        String [] parts = input.split(" ");

        String smallestWord = "";
        int smallestCounter = Integer.MAX_VALUE;

        for (String word: parts){
            int counter = 0;
            for (char character : word.toCharArray()){
                counter++;
            }
            if (counter < smallestCounter){
                smallestWord = word;
                smallestCounter = counter;
            }
        }
        return smallestWord;
    }
}
