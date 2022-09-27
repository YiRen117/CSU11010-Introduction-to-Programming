/*SELF ASSESSMENT:
Connect4Game class (35 marks):35
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win.
Comment:My class creates references to the Connect 4 Grid and two Connect 4 Players.

Total Marks out of 100:100
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Connect4Game {
    public static void main(String[] args) {
        ConnectPlayer humanPlayer, aiPlayer, humanPlayer1, humanPlayer2, currentPlayer;
        ArrayList<ConnectPlayer> players = new ArrayList<>();
        Connect4Grid2DArray grid = new Connect4Grid2DArray();
        System.out.println("Welcome to connect four game.\nWould you like to play or quit? (Enter 'play' or 'quit')");
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        while(!quit) {
            int currentPlayerIndex = 0;
            if (input.hasNext()) {
                String inputString = input.next();
                if (inputString.equalsIgnoreCase("quit")) {
                    quit = true;
                    System.out.println("Goodbye.");
                }
                else if (inputString.equalsIgnoreCase("play")){
                    grid.emptyGrid();
                    System.out.println("Would you like to play with an AI or another human player? (Enter 'AI' or 'human')");
                    boolean validInput = false;
                    while(!validInput) {
                        if (input.hasNext()) {
                            inputString = input.next();
                            if (inputString.equalsIgnoreCase("AI")) {
                                validInput = true;
                                humanPlayer = new C4HumanPlayer("Human Player", "H");
                                aiPlayer = new C4RandomAIPlayer("AI PLayer", "A");
                                players.add(humanPlayer);
                                players.add(aiPlayer);
                            } else if (inputString.equalsIgnoreCase("human")) {
                                validInput = true;
                                humanPlayer1 = new C4HumanPlayer("Human Player1", "1");
                                humanPlayer2 = new C4HumanPlayer("Human Player2", "2");
                                players.add(humanPlayer1);
                                players.add(humanPlayer2);
                            } else {
                                System.out.println("Invalid input. Please enter either 'AI' or 'human'.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a valid string.");
                        }
                    }
                    System.out.println(grid.toString());
                    boolean end = false;
                    while(!end) {
                        System.out.println("Current player : " + players.get(currentPlayerIndex).playerName);
                        currentPlayer = players.get(currentPlayerIndex);
                        currentPlayer.playerInput(grid);
                        grid.dropPiece(currentPlayer, currentPlayer.column);
                        System.out.println(grid.toString());
                        if(grid.didLastPieceConnect4()){
                            System.out.println(currentPlayer.playerName + " wins.");
                            end = true;
                        }
                        else if(grid.isGridFull()){
                            System.out.println("Game over.");
                            end = true;
                        }
                        currentPlayerIndex = (currentPlayerIndex == 0) ? 1 : 0;
                    }
                    System.out.println("Would you like to continue playing or quit? (Enter 'play' or 'quit')");
                    players.clear();
                }
                else{
                    System.out.println("Invalid input. Please enter either 'play' or 'quit'.");
                }
            } else {
                System.out.println("Invalid input. Please enter a string.");
            }
        }
    }
}
