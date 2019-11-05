package src2;

import java.util.ArrayList;
import java.util.Arrays;

class testt1 {
	public ArrayList<Integer> position_matrix() {
		String name = "p";        //manage piecces here
		int temp1,n;
		boolean color = true; //t=white
		ArrayList<Integer> t11 = new ArrayList<Integer>();

		switch (name) {
			case "p":
				n=10;
				if(color){
					if (n % 10 != 0 && n /10 != 0) 			//up-left
						t11.add(n-11);
					if (n % 10 != 7 && n /10 != 0) 			//up-right
						t11.add(n-9);
					if (n - 10 >= n%10)			//up
						t11.add(n-10);
				}
				else{
					if (n / 10 !=7 && n%70 != 0) 			//left-down
						t11.add(n+11);
					if (n % 10 != 0 && n /10 != 7) 			//up-left
						t11.add(n+9);
					if (n + 10 <= (n%10)+70)		//down
						t11.add(n+10);
				}
				break;
			case "r":
				temp1 = 73;
				n = temp1;                // from position matrix
				while (n - 10 >= temp1%10) {			//up
					n = n - 10;
					t11.add(n);
				}

				n = temp1;
				while (n + 1 <= (temp1/10)*10+7) {		//right
					n = n + 1;
					t11.add(n);
				}

				n = temp1;
				while (n + 10 <= (temp1%10)+70) {		//down
					n = n + 10;
					t11.add(n);
				}

				n = temp1;
				while (n - 1 >= (temp1/10)*10) {			//left
					n = n - 1;
					t11.add(n);
				}
				break;
			case "n":
				n=31;
				if(n-21 >= 0 && ((n-21)/10)*10+7 >= n-21)           //up ways
					t11.add(n-21);
				if(n-19 >= 0 && ((n-19)/10)*10+7 >= n-19)
					t11.add(n-19);
				if(n+21 <= 77 && ((n+21)/10)*10+7 >= n+21)
					t11.add(n+21);
				if(n+19 <= 77 && ((n+19)/10)*10+7 >= n+19)
					t11.add(n+19);

				if(n-12 >= 0 && ((n-12)/10)*10+7 >= n-12)           // side ways
					t11.add(n-12);
				if(n-8 >= 0 && ((n-8)/10)*10+7 >= n-8)
					t11.add(n-8);
				if(n+12 <= 77 && ((n+12)/10)*10+7 >= n+12)
					t11.add(n+12);
				if(n+8 <= 77 && ((n+8)/10)*10+7 >= n+8)
					t11.add(n+8);
				break;
			case "b":
				temp1 = 33;
				n = temp1;                // from position matrix
				while (n % 10 != 0 && n /10 != 0) {			//up-left
					n = n - 11;
					t11.add(n);
				}

				n = temp1;
				while (n % 10 != 7 && n /10 != 0) {			//up-right
					n = n - 9;
					t11.add(n);
				}

				n = temp1;
				while (n / 10 !=7 && n%70 != 0) {			//left-down
					n = n + 11;
					t11.add(n);
				}

				n = temp1;
				while (n % 10 != 0 && n /10 != 7) {			//up-left
					n = n + 9;
					t11.add(n);
				}

				break;
			case "q":
				temp1 = 73;
				n = temp1;                // from position matrix
				while (n - 10 >= temp1%10) {			//up
					n = n - 10;
					t11.add(n);
				}

				n = temp1;
				while (n + 1 <= (temp1/10)*10+7) {		//right
					n = n + 1;
					t11.add(n);
				}

				n = temp1;
				while (n + 10 <= (temp1%10)+70) {		//down
					n = n + 10;
					t11.add(n);
				}

				n = temp1;
				while (n - 1 >= (temp1/10)*10) {			//left
					n = n - 1;
					t11.add(n);
				}
				n = temp1;                // from position matrix
				while (n % 10 != 0 && n /10 != 0) {			//up-left
					n = n - 11;
					t11.add(n);
				}

				n = temp1;
				while (n % 10 != 7 && n /10 != 0) {			//up-right
					n = n - 9;
					t11.add(n);
				}

				n = temp1;
				while (n / 10 !=7 && n%70 != 0) {			//left-down
					n = n + 11;
					t11.add(n);
				}

				n = temp1;
				while (n % 10 != 0 && n /10 != 7) {			//up-left
					n = n + 9;
					t11.add(n);
				}

				break;
			case "k":
				n = 70;		// from position matrix
				if (n - 10 >= n%10)			//up
					t11.add(n-10);

				if (n + 1 <= (n/10)*10+7)		//right
					t11.add(n+1);

				if (n + 10 <= (n%10)+70)		//down
					t11.add(n+10);

				if (n - 1 >= (n/10)*10) 			//left
					t11.add(n-1);

				if (n % 10 != 0 && n /10 != 0) 			//up-left
					t11.add(n-11);

				if (n % 10 != 7 && n /10 != 0) 			//up-right
					t11.add(n-9);

				if (n / 10 !=7 && n%70 != 0) 			//left-down
					t11.add(n+11);

				if (n % 10 != 0 && n /10 != 7) 			//up-left
					t11.add(n+9);

				break;
		}
		return t11;
	}
}

public class testt{
	public static void main(String[] args) {
		testt1 t = new testt1();
		ArrayList<Integer> temp;
		temp = t.position_matrix();
		for (Integer name : temp) {
			System.out.println(name);
		}
	}

}
