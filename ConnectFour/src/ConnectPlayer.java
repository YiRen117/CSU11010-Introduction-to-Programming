/*SELF ASSESSMENT:
ConnectPlayer abstract class (10 marks):10
My class provides at lest one non-abstract method and at least one abstract method.
Comment:My class provides at lest one non-abstract method and at least one abstract method.
*/
public abstract class ConnectPlayer {
    String playerName;
    String piece;
    int column;
    ConnectPlayer(String userName, String piece){
        this.playerName = userName;
        this.piece = piece;
        Connect4Grid2DArray a = new Connect4Grid2DArray();
        System.out.println(piece + ": " + userName);
    }
    public abstract void playerInput(Connect4Grid2DArray grid);
    public void setColumn(int col){
        this.column = col;
    }
}
