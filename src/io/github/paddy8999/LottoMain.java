package io.github.paddy8999;

import java.util.Scanner;

/**
 * Created by padraig on 21/03/15.
 */
public class LottoMain {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int numberOfLottoNumbers = 10;
        int guesses = 5;
        int[] lottoNumbers = new int[numberOfLottoNumbers];
        int[] guessValues = new int[guesses];
        int score = 0;
        int temp = 0;
        boolean redorandom = true;
        boolean correct = false;

        for(int i = 0; i < numberOfLottoNumbers; i++ ){
            while(redorandom == true){
                redorandom = false;
                temp = (((int)(Math.random()*50))+1);
                for(int j = 0; j < numberOfLottoNumbers; j++ ){
                    if (temp == lottoNumbers[j]){
                        redorandom = true;
                    }
                }
            }
            lottoNumbers[i]=temp;
            redorandom = true;
        }

        //printIntArray(lottoNumbers, numberOfLottoNumbers);

        System.out.println("Guess numbers between 1 and 50, if they match any of the computers, you get a point, don't guess the same thing twice");

        for(int i = 0;i<guesses;i++){
            System.out.print("Guess number " + (i + 1) + ":");
            guessValues[i] = input.nextInt();
            correct = false;
            for(int j = 0;j<numberOfLottoNumbers;j++){
                if(guessValues[i] == lottoNumbers[j]) {
                    score++;
                    correct = true;
                }

            }
            if(correct){
                System.out.println("Correct!!");
            }else{
                System.out.println("Incorrect!!");
            }
            System.out.println("Current score: "+ score + "/" + (i+1));
        }
        System.out.println("Total score: "+ score + "/5");
    }

    public static void printIntArray(int[] array, int arraylength){
        for(int i = 0; i < arraylength; i++ ){
            System.out.print(array[i]+ " ");
        }
        System.out.println();
    }

}
