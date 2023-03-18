package challenges;

import java.util.*;

public class CodingChallenges {

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
                break;
            case "LONGESTSEQUENCE":
                System.out.println("Give me numbers separated by space");
                System.out.println(longestIncreasingSubsequence(scanner.nextLine()));
                break;
            case "SHORTESTWORD":
                System.out.println("Give me a sentence to determine the smallest word in it.");
                System.out.println(returnShortestWord(scanner.nextLine()));
                break;
            case "NPRIME":
                System.out.println("Give me a number");
                System.out.println(returnPrimeNumber(scanner.nextInt()));
                break;
            case "VOWELS":
                System.out.println("Give me a word");
                System.out.println("Number of vowels: " + numberOfVowels(scanner.nextLine()));
                break;
            case "HIGHESTPRODUCT":
                System.out.println("Give me numbers");
                String [] parts = scanner.nextLine().split(" ");
                int [] numbers  = new int[parts.length];

                for (int i = 0; i < parts.length; i++) {
                    numbers[i] = Integer.parseInt(parts[i]);
                }
                System.out.println(highestProduct(numbers));
                break;
            default:
                System.out.println("Wrong command. Use menu to display valid commands:");
                break;
        }
    }

    /**
     * Write a program that returns if a word is palindrome or not.
     */
    static boolean checkPalindrome(String input){
        char [] array2 = new char[input.length()];

        for (int i = array2.length-1; i >= 0 ; i--) {
            array2[i] = input.charAt(i);
        }
        return input.equals(String.valueOf(array2));
    }

    /**
     * Write a program that receives an argument which includes of
     * an array of numbers and returns two numbers such that their
     * distance is the smallest among the other numbers.
     */
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

    /**
     * Write a program that receives a string of numbers
     * as arguments separated by white space, and calculates the
     * longest increasing subsequence
     */
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

    /**
     * Write a program that takes a sentence as argument, and returns the smallest
     * word in that sentence.
     */
    static String returnShortestWord(String input){
        String [] parts = input.split(" ");

        String smallestWord = "";
        int smallestCounter = Integer.MAX_VALUE;

        for (String word: parts){
            int counter = 0;
            for (char ignored : word.toCharArray()){
                counter++;
            }
            if (counter < smallestCounter){
                smallestWord = word;
                smallestCounter = counter;
            }
        }
        return smallestWord;
    }

    /**
     * Write a program that prompts the user to enter a string
     * and then prints out the number of vowels (a, e, i, o, u) in the string.
     */
    static int numberOfVowels(String input){
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int counter = 0;
        for (char character: input.toCharArray()){
            if (vowels.contains(character)) counter++;
        }
        return counter;
    }

    /**
     * Write a program that takes in an array of integers and returns
     * the highest product that can be obtained by multiplying any
     * three integers in the array. The input array will contain
     * at least three integers.
     */
    static int highestProduct(int [] numbers){
        //Arrays.sort(numbers);
        int highest = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                //avoiding same element.
                for (int k = j+1; k < numbers.length; k++) {
                    int number = numbers[i] * numbers[j] * numbers[k];
                    if (number >= highest){
                        highest = number;
                    }
                }
            }
        }
        return highest;
    }

    /**
     * Write a program that takes in an integer N and returns the Nth prime number.
     * The first prime number is 2, and the second prime number is 3.
     * For example, if the input is 5, the output should be 11, because 11 is the 5th prime number.
     */
    //FIXME: currently working on this
    static int returnPrimeNumber(int N) {
        int [] numbers = new int[N+1];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 2; j < 500; j++) {

            }
        }

        return numbers[N-1];
    }
}
