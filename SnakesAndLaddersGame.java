public class SnakesAndLaddersGame
{

    private Die die;
    private int playersNum;
    private Player[] players;
    private GameBoard board;
    final int BOARD_SIZE = 100;
    final int MAX_INPUT_LENGTH = 4;

    /**
     * constructor of new game
     * @param min- the min value of the die
     * @param max- the max value of the die
     */
    public SnakesAndLaddersGame(int min, int max){
        board = new GameBoard(BOARD_SIZE);
        this.die = new Die(max, min);
    }

    /**
     * default constructor- the die gets 1 as min and 6 as max
     */
    public SnakesAndLaddersGame(){
        this.die = new Die();
        board = new GameBoard(BOARD_SIZE);

    }


    /**
     * sorts the players' array by their name- maxSort
     * @param p - array of players before sorting
     */
    public void sortByName(Player [] p) {
        Player tmp;

        for(int i = 0; i < playersNum; i++) {
            int max = i;
            for(int j = i + 1; j < playersNum; j++) {
                if(p[i].getName().compareToIgnoreCase(p[j].getName()) >= 0){
                    max = j;
                }
                tmp = p[0];
                p[0] = p[max];
                p[max] = tmp;
            }
        }
    }


    /**
     * initialize the game by the given input and instruction about valid and invalid input
     * keep going until receiving "end" as input
     * splitting each line to 4- the max length of given sentence
     * continuing the process according to the second word - the type of the object we need to add
     * with each input we update the players' array ot the game board
     */
    public void initializeGame() {
        int squareNum;
        int length;
        this.players = new Player[5];
        this.playersNum = 0;
        boolean sameName = false;
        boolean sameColor = false;
        System.out.println("Initializing the game...");
        String[] input = new String[MAX_INPUT_LENGTH];
        while (true) {
            input = Main.scanner.nextLine().split(" ");
            if (input[0].equals("end"))
            {
                if(playersNum >= 2)
                {
                    break;
                }
                System.out.println("Cannot start the game, there are less than two players!");
                continue;
            }
            if(input[1].equals("player")){
                if(playersNum >= 5) {
                    System.out.println("The maximal number of players is five!");
                    continue;
                }
                for(int i = 0; i < playersNum; i++){
                    if(input[2].equals(players[i].getName())){
                        sameName = true;
                    }
                    if(input[3].equals(players[i].getColor().name())){
                        sameColor = true;
                    }
                }
                if((sameName)&&(sameColor))
                {
                    System.out.println("The name and the color are already taken!");
                }
                else if (sameName)
                {
                    System.out.println("The name is already taken!");
                }
                else if(sameColor){
                    System.out.println("The color is already taken!");
                }
                else{
                    players[playersNum] = new Player(input[2], Colors.valueOf(input[3]));
                    this.playersNum++;
                }
            }
            else if(input[1].equals("ladder")){
                squareNum = Integer.parseInt(input[3]);
                length = Integer.parseInt(input[2]);
                if((squareNum >= 101) || (squareNum <= 0)){
                    System.out.println("The square is not within the board's boundaries!");
                }
                else if(squareNum + length >= 101)
                {
                    System.out.println("The ladder is too long!");
                }
                else if(board.getBoard()[squareNum-1].getLadderLength() != 0){
                    System.out.println("This square already contains a bottom of a ladder!");
                }
                else if(board.getBoard()[squareNum-1].getSnakeLength() != 0){
                    System.out.println("This square contains a head of a snake!");
                }
                else {
                    board.getBoard()[squareNum-1].setLadderLength(length);
                }
            }
            else if(input[1].equals("snake")){
                squareNum = Integer.parseInt(input[3]);
                length = Integer.parseInt(input[2]);
                if((squareNum >= 101) || (squareNum <= 0)){
                    System.out.println("The square is not within the board's boundaries!");
                }
                else if(squareNum == 100)
                {
                    System.out.println("You cannot add a snake in the last square!");
                }
                else if(squareNum - length <= 0)
                {
                    System.out.println("The snake is too long!");
                }
                else if(board.getBoard()[squareNum-1].getLadderLength() != 0){
                    System.out.println("This square contains a bottom of a ladder!");
                }
                else if(board.getBoard()[squareNum-1].getSnakeLength() != 0){
                    System.out.println("This square already contains a head of a snake!");
                }
                else {
                    board.getBoard()[squareNum-1].setSnakeLength(length);
                }
            }

        }
        sortByName(players);
    }

    /**
     * new game starts
     * @return the name of the winner
     */
    public String start(){
        Square curSquare;
        int round = 1;
        int winner = -1;
        while(winner == -1){//runs until player gets to the 100th square
            System.out.println("------------------------- Round number " + round++ + " -------------------------");
            for(int i = 0; i < playersNum && winner == -1; i++){//for each player until there is a winner
                int roll = die.roll();
                System.out.print(players[i].getName() + " rolled " + roll + ". The path to the next square: "
                        + players[i].getCurrSquare() + " -> ");
                players[i].moveSquare(roll);
                System.out.print(players[i].getCurrSquare());
                curSquare = board.getBoard()[players[i].getCurrSquare() - 1];
                while (curSquare.getLadderLength() + curSquare.getSnakeLength() != 0) {
                    //runs until there are no changes in the player square - he landed on a square which has 0 as the
                    //length of both the ladder and the snake
                    players[i].moveSquare(curSquare.getLadderLength() - curSquare.getSnakeLength());
                    curSquare = board.getBoard()[players[i].getCurrSquare() - 1];
                    System.out.print(" -> " + players[i].getCurrSquare());
                }
                System.out.println();


                if(players[i].getCurrSquare() == 100)//checks for winner
                {
                    winner = i;
                }
            }
            System.out.println();
            System.out.println("Players positions on the board:");
            for(int i = 0; i < playersNum; i++) players[i].printPosition();//prints each player position
        }
        return (players[winner].getName());//returns the name of the winner
    }

}
