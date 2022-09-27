/*SELF ASSESSMENT:
C4RandomAIPlayer class (10 marks):10
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality.
Comment:My class extends the ConnectPlayer claas and overrides the abstract method(s).
*/
public class C4RandomAIPlayer extends ConnectPlayer{
    C4RandomAIPlayer(String name, String piece){
        super(name, piece);
    }

    @Override
    public void playerInput(Connect4Grid2DArray grid) {
        boolean valid = false;
        while(!valid) {
            int column = (int) (Math.random() * (Constants.TOTAL_COLUMN - 1));
            if(!grid.isColumnFull(column)){
                setColumn(column);
                valid = true;
            }
        }
    }
}
