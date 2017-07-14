
public class Board {
	public int[][] ID = new int[10][10]; //0 for unknown, 1 for a ship, 2 for a hit ship, -1 for miss. Just draw using this info
	// coordinate system is in [y][x] since row THEN column...
	public Ship[] shipsContained = new Ship[5];
	
	public void placeShip(Ship s){
		if(s.isValidPlacement(this)){
			for(Tuple i : s.getShipInfo()){
				int xLoc = i.x;
				int yLoc = i.y;
				this.ID[yLoc][xLoc] = 1;
				if(s instanceof Battleship) this.shipsContained[0] = s;
				if(s instanceof AircraftCarrier) this.shipsContained[1] = s;
				if(s instanceof Cruiser) this.shipsContained[2] = s;
				if(s instanceof Destroyer) this.shipsContained[3] = s;
				if(s instanceof Submarine) this.shipsContained[4] = s;
			}
		} else System.out.println("Not valid placement ");
	}
	
	
	public void fire(int x, int y){
		boolean res = false;
		for(Ship ship : shipsContained){
			if(ship.checkHit(x, y)){
				System.out.println("ship hit recognised");
				res = true;
				ship.shipHitUpdate(x, y);
				this.hit(x, y);
				System.out.println("Hit! at " + (x) +" "+ (y));
			}	
		}
		if(!res){
			System.out.println("Miss! at " + (x) + " " + (y) );
			this.miss(x, y);
		}

	}
	
	public void miss(int x, int y){
		ID[y][x] = -1;
	}
	public void hit(int x, int y){
		ID[y][x] = 2;
	}
	
	
	
	public void drawOwn(){
		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		for(int i = 0; i < ID.length; i++){
			System.out.println(intChar(i) +" "+ intDrawOwn(ID[i][0]) + " " + intDrawOwn(ID[i][1]) + " " + intDrawOwn(ID[i][2]) + " " + intDrawOwn(ID[i][3]) + " " + intDrawOwn(ID[i][4]) + " " + intDrawOwn(ID[i][5]) + " " + intDrawOwn(ID[i][6]) + " " + intDrawOwn(ID[i][7]) + " " + intDrawOwn(ID[i][8]) + " " + intDrawOwn(ID[i][9]));
		}
	}
	
	public void drawEnemy(){
		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		for(int i = 0; i < ID.length; i++){
			System.out.println(intChar(i) + " " +intDraw(ID[i][0]) + " " + intDraw(ID[i][1]) + " " + intDraw(ID[i][2]) + " " + intDraw(ID[i][3]) + " " + intDraw(ID[i][4]) + " " + intDraw(ID[i][5]) + " " + intDraw(ID[i][6]) + " " + intDraw(ID[i][7]) + " " + intDraw(ID[i][8]) + " " + intDraw(ID[i][9]));
		}
	}
	
	public String intDrawOwn(int i){
		if(i == 0) return "_";
		if(i == 2) return "X"; //Own ship hit
		if(i == -1) return "O";
		if(i == 1) return "#";
		else return "E";
	}
	
	public String intDraw(int i){
		if(i == 0) return "_";
		if(i == 2) return "X"; //Own ship hit
		if(i == -1) return "O";
		if(i == 1) return "_";
		else return "E";
	}
	public char intChar(int n){
		switch (n){
		case 0 : return 'A';
		case 1 : return 'B';
		case 2 : return 'C';
		case 3 : return 'D';
		case 4 : return 'E';
		case 5 : return 'F';
		case 6 : return 'G';
		case 7 : return 'H';
		case 8 : return 'I';
		case 9 : return 'J';
		default : return 'X';
		}
	}
}
