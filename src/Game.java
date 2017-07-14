
public class Game {
	
	public Player playerOne = new Player();
	public Player playerTwo = new Player();
	public Board playerOneBoard = new Board();
	public Board playerTwoBoard = new Board();
	
	public Game(Player p1, Player p2){
		this.playerOne = p1;
		this.playerTwo = p2;
		this.playerOneBoard = new Board();
		this.playerTwoBoard = new Board();
	}
	
	public void restart(){
		this.playerOneBoard = new Board();
		this.playerTwoBoard = new Board();
	}
	

}
