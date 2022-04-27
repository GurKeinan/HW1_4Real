public class Square
{
    Snake snake;
    Ladder ladder;

    public Square(Snake snake , Ladder ladder)
    {
        this.snake= snake;
        this.ladder = ladder;
    }

    public Square()
    {
        this.snake = new Snake(0 );
        this.ladder = new Ladder(0);
    }

    public int getLadderLength(){
        return this.ladder.getLength();
    }

    public int getSnakeLength(){
        return this.snake.getLength();
    }

    public void setLadderLength(int length){
        this.ladder.setLength(length);
    }

    public void setSnakeLength(int length){
        this.snake.setLength(length);
    }




}
