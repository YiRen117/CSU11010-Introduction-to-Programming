/*SELF ASSESSMENT:
C4HumanPlayer class (10 marks):10
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides the Human player functionality.
Comment:My class extends the ConnectPlayer claas and overrides the abstract method(s).
*/
import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer{

    C4HumanPlayer(String userName, String piece) {
        super(userName, piece);
    }

    @Override
    public void playerInput(Connect4Grid2DArray grid) {
        System.out.println("Which column would you like to drop the piece in? (Enter an integer from 1 to 7)");
        Scanner humanInput = new Scanner(System.in);
        boolean valid = false;
        while(!valid) {
            if (humanInput.hasNextInt()) {
                int inputInt = humanInput.nextInt()-1;
                if (grid.isValidColumn(inputInt)) {
                    if (!grid.isColumnFull(inputInt)) {
                        setColumn(inputInt);
                        valid = true;
                    } else {
                        System.out.println("The column you have selected is full.");
                    }
                } else {
                    System.out.println("Please select a valid column (from 1 to 7).");
                }
            } else {
                System.out.println("Please enter a valid integer.");
                humanInput.next();
            }
        }
    }
}
