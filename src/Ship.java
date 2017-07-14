
public abstract class Ship {
	
	public abstract boolean isValidPlacement(Board board);
	public abstract Tuple[] getShipInfo();
	public abstract boolean checkHit(int x, int y);
	public abstract void shipHitUpdate(int x, int y);

	
	
}
