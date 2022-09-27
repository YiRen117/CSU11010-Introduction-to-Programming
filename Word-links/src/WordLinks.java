/*      1. readDictionary
        - I have the correct method definition [Mark out of 5:5]
        - Comment:I have the correct method definition
        - My method reads the words from the "words.txt" file. [Mark out of 5:5]
        - Comment:My method reads the words from the "words.txt" file.
        - It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
        - Comment:It returns the contents from "words.txt" in an ArrayList.

        2. readWordList
        - I have the correct method definition [Mark out of 5:5]
        - Comment:I have the correct method definition
        - My method reads the words provided (which are separated by commas), saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
        - Comment:My method reads the words provided, saves them to an ArrayList of String references and returns it.

        3. isUniqueList
        - I have the correct method definition [Mark out of 5:5]
        - Comment:I have the correct method definition
        - My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
        - Comment:My method compares each word in the array with the rest of the words in the list.
        - Exits the loop when a non-unique word is found. [Mark out of 5:5]
        - Comment:Exits the loop when a non-unique word is found.
        - Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
        - Comment:Returns true if all the words are unique and false otherwise.

        4. isEnglishWord
        - I have the correct method definition [Mark out of 5:5]
        - Comment:I have the correct method definition
        - My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
        - Comment:My method uses the binarySearch method in Arrays library class.
        - Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
        - Comment:Returns true if the binarySearch method return a value >= 0, otherwise false is returned.

        5. isDifferentByOne
        - I have the correct method definition [Mark out of 5:5]
        - Comment:I have the correct method definition
        - My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
        - Comment:My method loops through the length of a words comparing characters at the same position in both words searching for one difference.

        6. isWordChain
        - I have the correct method definition [Mark out of 5:5]
        - Comment:I have the correct method definition
        - My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
        - Comment:My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message

        7. main
        - Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10:10]
        - Comment:Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures
        - Asks the user for input and calls isWordChain [Mark out of 5:5]
        - Comment:Asks the user for input and calls isWordChain

        Total Mark out of 100 (Add all the previous marks):100
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Arrays.binarySearch;

public class WordLinks {
    public static void main(String[] args) {
        System.out.println("Enter a comma separated list of words (or an empty list to quit):");
        boolean quit = false;
        Scanner input = new Scanner(System.in);
        while(!quit){
            String words = input.nextLine();
            if(words.length() == 0){
                System.out.println("Goodbye.");
                quit = true;
                input.close();
            }
            else{
                ArrayList<String> theWords = readWordList(words);
                System.out.println((isWordChain(theWords) ? "V" : "Not a v") + "alid chain of words from Lewis Carroll's word-links game.");
                System.out.println("Enter a comma separated list of words (or an empty list to quit):");
            }
        }
    }

    public static ArrayList<String> readDictionary(){
        ArrayList<String> dictionary = new ArrayList<>();
        try
        {
            FileReader fileReader = new FileReader("words.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean endOfFile = false;

            while(!endOfFile)
            {
                String wordLine = bufferedReader.readLine();
                if (wordLine != null)
                {
                    dictionary.add(wordLine);
                }
                else
                {
                    endOfFile = true;
                }
            }
            bufferedReader.close();
            fileReader.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return dictionary;
    }


    public static ArrayList<String> readWordList(String words){
        ArrayList<String> wordList = new ArrayList<>();
        String[] wordData = words.split(",");
        for (String word : wordData) {
            wordList.add(word.trim());
        }
        return wordList;
    }

    public static boolean isUniqueList(ArrayList<String> theArray){
        boolean isUnique = true;
        for(int i = 0; i < theArray.size() && isUnique; i++){
            String elemA = theArray.get(i);
            for(int j = i + 1; j < theArray.size() && isUnique; j++){
                String elemB = theArray.get(j);
                isUnique = !elemA.equals(elemB);
            }
        }
        return isUnique;
    }

    public static boolean isEnglishWord(String element){
        int index = binarySearch(readDictionary().toArray(), element);
        return index >= 0;
    }

    public static boolean isDifferentByOne(String elemA, String elemB){
        if(elemA.length() == elemB.length()){
            int count = 0;
            for(int i = 0; i < elemA.length(); i++){
                if(elemA.charAt(i) != elemB.charAt(i)){
                    count++;
                }
            }
            return count == 1;
        }
        return false;
    }

    public static boolean isWordChain(ArrayList<String> theArray) {
        if(!isUniqueList(theArray)) {
            return false;
        }
        for(String elem : theArray) {
            if (!isEnglishWord(elem)) {
                return false;
            }
        }
        for(int i = 0; i < theArray.size() - 1; i++){
            if(!isDifferentByOne(theArray.get(i), theArray.get(i+1))){
                return false;
            }
        }
        return true;
    }
}
