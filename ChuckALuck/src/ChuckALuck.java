/* SELF ASSESSMENT

1. ResolveBet

I have correctly defined resolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7].
Comment:I have correctly defined resolveBet which takes the bet type (String betType) and the Wallet object(wallet), and a void return type
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
Comment:My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment:My program ensures the bet amount is not greater than the cash in the wallet
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15]..
Comment:My program creates three Dice objects, rolls them and creates a total variable(sum) with a summation of the roll values returned
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
Comment:My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: 10].
Comment:My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15]
Comment:I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5]
Comment:My program loops continuously until the user either enters quit or the cash in the wallet is 0
I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
Comment:I ask the user to enter any of the four bet types or quit
My program calls resolveBet for each bet type entered [Mark out of 5: 5].
Comment:My program calls resolveBet for each bet type entered
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5]
Comment:At the end of the game my program presents a summary message regarding winnings and losses

 Total Mark out of 100 (Add all the previous marks):100
*/
import java.util.Scanner;

public class ChuckALuck {
    public static void main(String[] args) {
        boolean quit = false;
        String type;
        System.out.println("How much do you have in your wallet/purse?");
        Scanner input = new Scanner(System.in);
        Wallet theWallet = new Wallet();
        double initialCash = input.nextDouble();
        theWallet.put(initialCash);
        while(!quit){
            if(theWallet.check() > 0){
                System.out.println("Enter your bet type(Triple, Field, High, Low) or quit: ");
                if(input.hasNext()){
                    String inputString = input.next();
                    if(inputString.equalsIgnoreCase("triple") || inputString.equalsIgnoreCase("field") ||
                        inputString.equalsIgnoreCase("high") || inputString.equalsIgnoreCase("low")){
                        type = inputString;
                        resolveBet(type, theWallet);
                        System.out.println(theWallet.toString());
                    }
                    else if(inputString.equalsIgnoreCase("quit")){
                        quit = true;
                        input.close();
                    }
                    else{
                        System.out.println("Please enter a valid string(Triple/Field/High/Low/Quit).");
                    }
                }
                else{
                    System.out.println("Please enter a valid string.");
                    input.next();
                }
            }
            else{
                quit = true;
                System.out.println("You have run out of money!");
            }
        }
        System.out.printf("[Summary]: %nInitial value of cash in your wallet: %.1f%nFinal value of cash in your wallet: %.1f%n",
                initialCash, (initialCash > 0) ? theWallet.check() : initialCash);
        System.out.printf("%sGoodbye!", (initialCash > 0 && initialCash > theWallet.check() ? "You lose.\n" : initialCash > 0
                && initialCash < theWallet.check() ? "You win.\n" : ""));
    }

    public static void resolveBet(String betType, Wallet wallet) {
        boolean win;
        boolean triple;
        System.out.println("How much would you like to bet? ");
        Scanner input = new Scanner(System.in);
        double bet = input.nextDouble();
        if(wallet.get(bet)){
            wallet.put(bet);
            Dice dice1 = new Dice();
            int result1 = dice1.roll();
            System.out.println(dice1.toString());
            Dice dice2 = new Dice();
            int result2 = dice2.roll();
            System.out.println(dice2.toString());
            Dice dice3 = new Dice();
            int result3 = dice3.roll();
            System.out.println(dice3.toString());
            int sum = result1 + result2 + result3;
            triple = (result1 == result2 && result2 == result3 && result1 != 1 && result1 != 6);
            if (betType.equalsIgnoreCase("triple")){
                win = triple;
            }
            else if (betType.equalsIgnoreCase("field")){
                win = (sum < 8 || sum > 12) && !triple;
            }
            else if (betType.equalsIgnoreCase("high")){
                win = (sum > 10) && !triple;
            }
            else{
                win = (sum < 11) && !triple;
            }
            if(win){
                wallet.put((triple) ? (bet * 30) : bet);
            }
            else{
                boolean notBroke = wallet.get((betType.equalsIgnoreCase("triple")) ? (bet * 30) : bet);
                if (!notBroke){
                    wallet.get(wallet.check());
                }
            }
            System.out.println(win ? "You win!" : "You lose!");
        }
        else{
            if(bet < 0){
                System.out.println("Please enter a positive number!");
            }
            else System.out.println("You have not got enough money!");
        }
    }
}
