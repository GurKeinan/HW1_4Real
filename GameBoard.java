public class GameBoard
{
    Square[] Board_Squares;

    public GameBoard(int n)
    {
        Square[] array = new Square[n];

    }

    public Square [] getBoard(){
        return this.Board_Squares;
    }

}
