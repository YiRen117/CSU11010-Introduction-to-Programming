/* SELF ASSESSMENT
   1.    createSequence:
         Did I use the correct method definition?
         Mark out of 5:5
         Comment:I used the correct method definition.
         Did I create an array of size n (passed as the parameter) and initialise it?
         Mark out of 5:5
         Comment:I created an array of size n (passed as the parameter) and initialise it.
         Did I return the correct item?
         Mark out of 5:5
         Comment:I returned the correct item as an integer array.
   2.    crossOutMultiples
         Did I use the correct method definition?
         Mark out of 5:5
         Comment:I used the correct method definition.
         Did I ensure the parameters are not null and one of them is a valid index into the array?
         Mark out of 2:2
         Comment:I ensured the parameters are not null and ensured one of them was a valid index into the array by checking if it is over 0.
         Did I loop through the array using the correct multiple?
         Mark out of 5:5
         Comment:I looped through the array using the correct multiple.
         Did I cross out correct items in the array that were not already crossed out?
         Mark out of 3:3
         Comment:I crossed out correct items in the array that were not already crossed out by turning their values into zero.
   3.    sieve
         Did I have the correct function definition?
         Mark out of 5:5
         Comment:I had the correct function definition.
         Did I make calls to other methods?
         Mark out of 5:5
         Comment:I made calls to methods createSequence and crossOutMultiples.
         Did I return an array with all non-prime numbers are crossed out?
         Mark out of 2:2
         Comment:I returned an array with all non-prime numbers are crossed out.
   4.    sequenceTostring
         Did I have the correct function definition?
         Mark out of 5:5
         Comment:I had the correct function definition.
         Did I ensure the parameter to be used is not null?
         Mark out of 3:3
         Comment:I ensured the parameter to be used is not null.
         Did I loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets?
         Mark out of 10:10
         Comment:I looped through the array updating the String variable with the non-crossed out numbers and the crossed numbers (which were turned into 0) in brackets.
   5.    nonCrossedOutSubseqToString
         Did I have the correct function definition
         Mark out of 5:5
         Comment:I had the correct function definition.
         Did I ensure the parameter to be used is not null?
         Mark out of 3:3
         Comment:I ensured the parameter to be used is not null.
         Did I loop through the array updating the String variable with just the non-crossed out numbers?
         Mark out of 5:5
         Comment:I looped through the array updating the String variable with just the non-crossed out numbers.
   6.    main
         Did I ask  the user for input n and handle input errors?
         Mark out of 5:5
         Comments:I asked the user for input n and handled input errors such as integers under 2 or meaningless strings.
         Did I make calls to other methods (at least one)?
         Mark out of 5:5
         Comment:I made calls to methods createSequence, crossOutMultiples, sequenceTostring and nonCrossedOutSubseqToString.
         Did I print the output as shown in the question?
         Mark out of 5:5
         Comment:I printed the output as shown in the question.
   7.    Overall
         Is my code indented correctly?
         Mark out of 4:4
         Comments:My code indented correctly.
         Do my variable names make sense?
         Mark out of 4:4
         Comments:My variable names make sense.
         Do my variable names, method names and class name follow the Java coding standard
         Mark out of 4:4
         Comments:My variable names, method names and class name follow the Java coding standard.
         Total Mark out of 100 (Add all the previous marks):100
        */

import java.util.Scanner;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.print("Enter int >= 2 : ");
            if(input.hasNextInt()) {
                int max = input.nextInt();
                if(max >= 2) {
                    int[] sequence = createSequence(max);
                    System.out.println(nonCrossedOutSubseqToString(sequence));
                    for(int index = 0; sequence[index] <= Math.sqrt(max);index++) {
                        if(sequence[index] != 0) {
                            crossOutHigherMultiples(sequence, sequence[index]);
                            System.out.println(sequenceToString(sequence));
                        }
                    }
                    System.out.println(nonCrossedOutSubseqToString(sieve(max)));
                }
                else{
                    System.out.println("Please enter an integer which is at least 2!");
                }
            }
            else if(input.hasNext("quit")){
                System.out.println("Goodbye.");
                quit = true;
                input.close();
            }
            else{
                System.out.println("Please enter an integer which is at least 2!");
                input.next();
            }
        }
    }

    public static int[] createSequence(int max){
        int[] sequence = new int[max - 2 + 1];
        for(int index = 2; index <= max; index++){
            sequence[index - 2] = index;
        }
        return sequence;
    }

    public static void crossOutHigherMultiples(int[] oriSequence, int value){
        if (oriSequence != null){
            for(int index = 0; value > 0 && index <= oriSequence.length - 1; index++){
                if (oriSequence[index] % value == 0 && oriSequence[index] != value){
                    oriSequence[index] = 0;
                }
            }
        }
    }

    public static int[] sieve(int max){
        int[] original = createSequence(max);
        for(int index = 0; original[index] <= Math.sqrt(max); index++) {
            crossOutHigherMultiples(original, original[index]);
        }
        return original;
    }

    public static String sequenceToString(int[] sequence){
        if(sequence != null){
            StringBuilder crossed = new StringBuilder("2");
            for(int index = 1; index <= sequence.length - 1; index++){
                int number = sequence[index];
                crossed.append(",").append(number != 0 ? sequence[index] : ("[" + (index + 2) + "]"));
            }
            return crossed.toString();
        }
        else{
            return "";
        }
    }

    public static String nonCrossedOutSubseqToString(int[] sequence){
        if(sequence != null){
            StringBuilder nonCrossed = new StringBuilder("2");
            for(int index = 1; index <= sequence.length - 1; index++){
                int number = sequence[index];
                nonCrossed.append(number != 0 ? "," + sequence[index] : "");
            }
            return nonCrossed.toString();
        }
        else{
            return "";
        }
    }
}
