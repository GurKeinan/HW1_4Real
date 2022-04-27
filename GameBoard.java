public class GameBoard
{
    Square[] boardSquares;

    public GameBoard(int n)
    {
        this.boardSquares = new Square[n];
        for(int i = 0; i < n; i++){
            boardSquares[i] = new Square();
        }

    }

    public Square [] getBoard(){
        return this.boardSquares;
    }

}
