public class GameBoard
{
    Square[] boardSquares;

    /**
     * constructor for a new game board - contains array of squares
     * @param n- number of squares in the board
     */
    public GameBoard(int n)
    {
        this.boardSquares = new Square[n];
        for(int i = 0; i < n; i++){
            boardSquares[i] = new Square();
        }

    }

    /**
     * @return the squares' array - will be useful for checking single square in it.
     */
    public Square [] getBoard(){
        return this.boardSquares;
    }

}
