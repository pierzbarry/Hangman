package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        Random r = new Random();

        String[] words = {"tree", "rain", "bear", "encourage",
                "promise", "soup", "chess", "insurance", "pancakes", "stream", "smooth", "bitch", "whore"};

        boolean repeat = true;
        int guesses = 0;

        String hangmanWord = words[r.nextInt(words.length)];
        char[] check = hangmanWord.toCharArray();
        char[] guess = new char[hangmanWord.length()];

        for (int i = 0; i < check.length; i++) {
            guess[i] = '_';
        }

        System.out.println("Let's play hangman!");
        System.out.print("Here is the word I am thinking of: ");

        for(char c : guess){
            System.out.print(c + " ");
        }

        System.out.println();

        do {
            System.out.println();
            System.out.print("Enter your guess: ");
            String attempt = key.next();

            boolean correct = false;
            boolean complete = false;

            if (attempt.length() == 1) {
                for (int i = 0; i < check.length; i++) {
                    if (check[i] == attempt.charAt(0)) {
                        guess[i] = attempt.charAt(0);
                        correct = true;
                    }
                }
                if (!correct) {
                    guesses++;
                }
                for (int i = 0; i < check.length; i++) {
                    if (guess[i] == check[i]) {
                        complete = true;
                    } else {
                        complete = false;
                        break;
                    }
                }
            } else {
                if (attempt.length() == check.length) {
                    for (int i = 0; i < check.length; i++) {
                        if (attempt.charAt(i) == check[i]) {
                            complete = true;
                        } else {
                            complete = false;
                            guesses++;
                            break;
                        }
                    }
                }
            }

            if (!complete) {
                System.out.println("Your guess so far: ");
                for (char c : guess) {
                    System.out.print(c + " ");
                }
                System.out.println();
                if (guesses > 0) {
                    System.out.println("You have guessed incorrectly " + guesses + "/" + 6 + " times.");
                }
                if (guesses == 6) {
                    System.out.println("Sorry, you have no more guesses left. The word was " + hangmanWord);
                    System.out.println();
                    System.out.println("Thank you for playing!");
                    System.out.println("lol ur a dumb bitch cant even guess " + hangmanWord);
                    repeat = false;
                }
            }
            else {
                System.out.println("Congrats you won! The word was " + hangmanWord + ".");
                repeat = false;
            }
        } while (repeat) ;
    }

    public static int random(int bound) {
        Random r = new Random();
        return(r.nextInt(bound));
    }

}
