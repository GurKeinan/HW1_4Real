public class Square
{
    int NumOfSquare;
    Snake snake;
    Ladder ladder;

    public Square(int NumOfSquare, Snake snake , Ladder ladder)
    {
        this.NumOfSquare = NumOfSquare;
        this.snake= snake;
        this.ladder = ladder;
    }

    public Square(int NumOfSquare)
    {
        this.NumOfSquare = NumOfSquare;
        this.snake = new Snake(0 , NumOfSquare);
        this.ladder = new Ladder(0 , NumOfSquare);

    }




}
