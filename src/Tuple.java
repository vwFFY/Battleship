
public class Tuple {
	public int hit; //0 not hit, 1 hit
	public int x;
	public int y;
	
	
	public Tuple(){ //shouldnt be called
		this.hit = -1;
		this.x = -1;
		this.y = -1;
	}
	public Tuple(int hit, int x, int y){
		this.hit = hit;
		this.x = x;
		this.y = y;
	}

}
