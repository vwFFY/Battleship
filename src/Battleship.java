
public class Battleship extends Ship {
	
	public int size = 5;
	public char direction;
	public Tuple[] shipInfo = new Tuple[size];
	
	public Battleship(char orientation, int x, int y){
		this.direction = orientation;
		
		if(orientation == 'S'){
			this.shipInfo = new Tuple[]{new Tuple(0, x, y), new Tuple(0, x, y+1), new Tuple(0, x, y+2), new Tuple(0, x, y+3), new Tuple(0, x, y+4)};
		}
		if(orientation == 'E'){
			this.shipInfo = new Tuple[]{new Tuple(0, x, y), new Tuple(0, x+1, y), new Tuple(0, x+2, y), new Tuple(0, x+3, y), new Tuple(0, x+4, y)};
		}
		if(orientation == 'N'){
			this.shipInfo = new Tuple[]{new Tuple(0, x, y), new Tuple(0, x, y-1), new Tuple(0, x, y-2), new Tuple(0, x, y-3), new Tuple(0, x, y-4)};
		}
		if(orientation == 'W'){
			this.shipInfo = new Tuple[]{new Tuple(0, x, y), new Tuple(0, x-1, y), new Tuple(0, x-2, y), new Tuple(0, x-3, y), new Tuple(0, x-4, y)};
		}
		
	}
	
	@Override
	public Tuple[] getShipInfo(){
		return this.shipInfo;
	}


	@Override
	public boolean isValidPlacement(Board board) {
		int res = 0; //if gets to size, then all fit
		boolean bRes = true;
		Tuple[] ship = this.shipInfo;
		for(Tuple i : ship){
			int xLoc = i.x;
			int yLoc = i.y;
			if(xLoc < 0 || xLoc > 9) bRes = false;
			if(yLoc < 0 || yLoc > 9) bRes = false;
			try{
				if(board.ID[yLoc][xLoc] == 0){ // +1 to res each time it 
					res += 1;
				}
			} catch (IndexOutOfBoundsException e){
			}
			
		}
		return (res == size) && bRes;
	}

	@Override
	public boolean checkHit(int x, int y) {
		boolean res = false;
		for(int i = 0; i < this.shipInfo.length; i++){
			int xLoc = this.shipInfo[i].x;
			int yLoc = this.shipInfo[i].y;
			int hit = this.shipInfo[i].hit;
			if(x == xLoc && y == yLoc && hit == 0){
				res = true;
			}
		}
		return res;
		
	}
	
	@Override
	public void shipHitUpdate(int x, int y){
		for(int i = 0; i < this.shipInfo.length; i++){
			int xLoc = this.shipInfo[i].x;
			//System.out.println(xLoc);
			int yLoc = this.shipInfo[i].y;
			int hit = this.shipInfo[i].hit;
			if(x == xLoc && y == yLoc && hit == 0){
				this.shipInfo[i] = new Tuple(1, x, y);
				System.out.println(this.shipInfo[i].hit);
			}
		}
	}
	
}
