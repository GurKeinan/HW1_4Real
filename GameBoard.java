public class GameBoard
{
    Square[] Board_Squares;

    public GameBoard(Square[] board_Squares)
    {
        Board_Squares = board_Squares;
    }

    public Square [] getBoard(){
        return this.Board_Squares;
    }

}
