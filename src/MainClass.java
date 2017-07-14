import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args){
		Board test = new Board();
		test.placeShip(new Battleship('N', 5, 6));
		test.placeShip(new AircraftCarrier('W', 4, 9));
		test.placeShip(new Cruiser('N', 7, 4));
		test.placeShip(new Destroyer('E', 2, 2));
		test.placeShip(new Submarine('N', 9, 9));
		test.drawOwn();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Beepboobwoop");
		System.out.println("..xxXX-BATTLESHIP-XXxx..");
		System.out.println("Generating enemy placement...");
		do{
			int[] pos = new int[2];
			String position;
			
			System.out.println("Fire where?(A#)");
			position = input.nextLine();
			
			pos[0] = Character.getNumericValue(position.charAt(1));
			pos[1] = charInt(position.charAt(0));
			test.fire(pos[0], pos[1]);
			test.drawEnemy();
		}while (true != false);
	}
	public static int charInt(char c){
		c = Character.toUpperCase(c);
		switch (c){
		case 'A' : return 0;
		case 'B' : return 1;
		case 'C' : return 2;
		case 'D' : return 3;
		case 'E' : return 4;
		case 'F' : return 5;
		case 'G' : return 6;
		case 'H' : return 7;
		case 'I' : return 8;
		case 'J' : return 9;
		default : return -1;
		}
	}
}