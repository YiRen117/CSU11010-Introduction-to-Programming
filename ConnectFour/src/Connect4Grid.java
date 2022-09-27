/*SELF ASSESSMENT:
Connect4Grid interface (10 marks):10
I define all 7 methods within this interface.
Comment:I define all 7 methods within this interface.
*/
public interface Connect4Grid {
    void emptyGrid();
    String toString();
    boolean isValidColumn(int column);
    boolean isColumnFull(int column);
    void dropPiece(ConnectPlayer player, int column);
    boolean didLastPieceConnect4();
    boolean isGridFull();
}
