package src2;

import java.util.ArrayList;

class testt1 {
	public ArrayList<String> position_matrix() {
		String name = "p";
		Integer x = 6;
		Integer y = 2;
		Integer xx;
		Integer yy;
		System.out.printf("\n x,y = %d,%d\n\n",x,y);
		ArrayList<String> temp = new ArrayList<String>();
		
		switch (name) {
		case "p":
			// i<3 for 3 directions
			yy = y+1;
			for(int i=0;i<3;i++) {
				xx = x+i-1;
				temp.add(xx.toString()+yy.toString());	
			}
			break;
		case "r":
			for(int i=0;i<4;i++) {
				
			}
			break;
		case "n":

			break;
		case "b":

			break;
		case "q":

			break;
		case "k":

			break;
		}
	return temp;
	}
}

public class testt{
	public static void main(String[] args) {
		testt1 t = new testt1();
		ArrayList<String> temp = new ArrayList<String>();
		temp = t.position_matrix();
		for (String name : temp) {
			System.out.println(name);
		}
	}
	
}