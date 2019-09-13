package src2;

import java.util.ArrayList;

public class verification {
	piece p;
	public ArrayList<String> position_matrix(piece p) {
		Integer x = p.loc_x;
		Integer y = p.loc_y;
		ArrayList<String> temp = new ArrayList<String>();
		
		switch (p.name.toString().toLowerCase()) {
		case "p":
			// i<3 for 3 directions
			y++;
			for(int i=0;i<3;i++) {
				x = x+i;
				temp.add(x.toString()+y.toString());	
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
