package src2;

import java.io.*;
import java.util.ArrayList;

class initialization{
    boolean turn = true;
    board b = new board();
    user_moves u = new user_moves();
    piece p_temp = new piece();
    BufferedReader br;
    
    void init_board() throws IOException {
        try {
            String temp;
            boolean t = false;
            
            try {
            	br = new BufferedReader(new FileReader("positions.txt"));
            System.out.println("file present");
            }catch(Exception e) {
            	System.out.println("no file present");
            	return;
            }
            
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++){
                    temp = br.readLine();
                    piece p = new piece(temp,i,j);
                    b.bb[i][j] = p;
                    b.temp[i][j] = p; 
                    t = !t;
                    b.color[i][j] = t;
                }
            }
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println("game initialized\n..moves eg: a1b2");
        game_start();
    }
    
    void game_start() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            if (turn) {
            	System.out.println("******************************");
                System.out.println("player white turn..");
                b.draw_board();
                System.out.println("enter your move : ");
                movements(br.readLine());
        
            } else {
            	System.out.println("******************************");
            	System.out.println("player black turn..");
                b.draw_board();
                System.out.println("enter your move : ");
                movements(br.readLine());
            }
            turn = !turn;
        }

    }
	
    void movements(String s_move) throws IOException {        //get movements and move
        
    	u.get_moves(s_move);            // use object for values
        if(verify_move(s_move)){
        	if (b.bb[u.start_x][u.start_y].name == '.') {
        		System.out.println("blank cannot be moved, enter move :");
        		movements(br.readLine());
        	}

            // get possible moves
        	ArrayList<Integer> possible_moves = possible_moves(b.bb[u.start_x][u.start_y],
                    b.bb[u.start_x][u.start_y].color,b.position[u.start_x][u.start_y]);
            
        	// play on temporary board

        	
        	
        	
        	
        	
        	
        	//actual board changing moves
        	p_temp.name = b.bb[u.start_x][u.start_y].name;
            p_temp.color = b.bb[u.start_x][u.start_y].color;
            b.bb[u.end_x][u.end_y].name = p_temp.name;
            b.bb[u.end_x][u.end_y].color = p_temp.color;
            b.clear_board(b.bb[u.start_x][u.start_y]);
        }
        else{
        	System.out.println("moves cannot be played, enter move : ");
			while (true) {
				try {
					movements(br.readLine());
					break;
				} catch (IOException e1) {
					System.out.println("moves cannot be played, enter move : ");
				}catch (Exception e1) {
					System.out.println("moves cannot be played, enter move : ");
				}
			}
        }
    }

    boolean verify_move(String s_move) {
        char[] m = s_move.toLowerCase().toCharArray();

        //movements for turn and color should match
        if ((int) (m[0]) % 97 <= 8 && (int) (m[2]) % 97 <= 8) {
            if ((int) m[1] - 47 > 1 && (int) m[1] - 47 <= 9) {
                if((int) m[3] - 47 > 1 && (int) m[3] - 47 <= 9){
                    if(b.bb[u.start_x][u.start_y].color == 'w' && turn)
                    	return true;
                    if(b.bb[u.start_x][u.start_y].color == 'b' && !turn)
                    	return true;
                }
            }
        }
        return false;
    }
    public ArrayList<Integer> possible_moves(piece p,char color,int position) {
        char name = p.name;        //manage piecces here
        ArrayList<Integer> t11 = new ArrayList<Integer>();
        int temp1, n;
        switch (name) {
            case 'p':
                n=position;
                if (color == 'w') {
                    if (n % 10 != 0 && n / 10 != 0)            //up-left
                        t11.add(n - 11);
                    if (n % 10 != 7 && n / 10 != 0)            //up-right
                        t11.add(n - 9);
                    if (n - 10 >= n % 10)            //up
                        t11.add(n - 10);
                } else if(color == 'b'){
                    if (n / 10 != 7 && n % 70 != 0)            //left-down
                        t11.add(n + 11);
                    if (n % 10 != 0 && n / 10 != 7)            //up-left
                        t11.add(n + 9);
                    if (n + 10 <= (n % 10) + 70)        //down
                        t11.add(n + 10);
                }
                break;
            case 'r':
                temp1 = position;
                n = temp1;                // from position matrix
                while (n - 10 >= temp1 % 10) {            //up
                    n = n - 10;
                    t11.add(n);
                }

                n = temp1;
                while (n + 1 <= (temp1 / 10) * 10 + 7) {        //right
                    n = n + 1;
                    t11.add(n);
                }

                n = temp1;
                while (n + 10 <= (temp1 % 10) + 70) {        //down
                    n = n + 10;
                    t11.add(n);
                }

                n = temp1;
                while (n - 1 >= (temp1 / 10) * 10) {            //left
                    n = n - 1;
                    t11.add(n);
                }
                break;
            case 'n':
                n = position;
                if (n - 21 >= 0 && ((n - 21) / 10) * 10 + 7 >= n - 21)           //up ways
                    t11.add(n - 21);
                if (n - 19 >= 0 && ((n - 19) / 10) * 10 + 7 >= n - 19)
                    t11.add(n - 19);
                if (n + 21 <= 77 && ((n + 21) / 10) * 10 + 7 >= n + 21)
                    t11.add(n + 21);
                if (n + 19 <= 77 && ((n + 19) / 10) * 10 + 7 >= n + 19)
                    t11.add(n + 19);

                if (n - 12 >= 0 && ((n - 12) / 10) * 10 + 7 >= n - 12)           // side ways
                    t11.add(n - 12);
                if (n - 8 >= 0 && ((n - 8) / 10) * 10 + 7 >= n - 8)
                    t11.add(n - 8);
                if (n + 12 <= 77 && ((n + 12) / 10) * 10 + 7 >= n + 12)
                    t11.add(n + 12);
                if (n + 8 <= 77 && ((n + 8) / 10) * 10 + 7 >= n + 8)
                    t11.add(n + 8);
                break;
            case 'b':
                temp1 = position;
                n = temp1;                // from position matrix
                while (n % 10 != 0 && n / 10 != 0) {            //up-left
                    n = n - 11;
                    t11.add(n);
                }

                n = temp1;
                while (n % 10 != 7 && n / 10 != 0) {            //up-right
                    n = n - 9;
                    t11.add(n);
                }

                n = temp1;
                while (n / 10 != 7 && n % 70 != 0) {            //left-down
                    n = n + 11;
                    t11.add(n);
                }

                n = temp1;
                while (n % 10 != 0 && n / 10 != 7) {            //up-left
                    n = n + 9;
                    t11.add(n);
                }

                break;
            case 'q':
                temp1 = position;
                n = temp1;                // from position matrix
                while (n - 10 >= temp1 % 10) {            //up
                    n = n - 10;
                    t11.add(n);
                }

                n = temp1;
                while (n + 1 <= (temp1 / 10) * 10 + 7) {        //right
                    n = n + 1;
                    t11.add(n);
                }

                n = temp1;
                while (n + 10 <= (temp1 % 10) + 70) {        //down
                    n = n + 10;
                    t11.add(n);
                }

                n = temp1;
                while (n - 1 >= (temp1 / 10) * 10) {            //left
                    n = n - 1;
                    t11.add(n);
                }
                n = temp1;                // from position matrix
                while (n % 10 != 0 && n / 10 != 0) {            //up-left
                    n = n - 11;
                    t11.add(n);
                }

                n = temp1;
                while (n % 10 != 7 && n / 10 != 0) {            //up-right
                    n = n - 9;
                    t11.add(n);
                }

                n = temp1;
                while (n / 10 != 7 && n % 70 != 0) {            //left-down
                    n = n + 11;
                    t11.add(n);
                }

                n = temp1;
                while (n % 10 != 0 && n / 10 != 7) {            //up-left
                    n = n + 9;
                    t11.add(n);
                }

                break;
            case 'k':
                n = position;        // from position matrix
                if (n - 10 >= n % 10)            //up
                    t11.add(n - 10);

                if (n + 1 <= (n / 10) * 10 + 7)        //right
                    t11.add(n + 1);

                if (n + 10 <= (n % 10) + 70)        //down
                    t11.add(n + 10);

                if (n - 1 >= (n / 10) * 10)            //left
                    t11.add(n - 1);

                if (n % 10 != 0 && n / 10 != 0)            //up-left
                    t11.add(n - 11);

                if (n % 10 != 7 && n / 10 != 0)            //up-right
                    t11.add(n - 9);

                if (n / 10 != 7 && n % 70 != 0)            //left-down
                    t11.add(n + 11);

                if (n % 10 != 0 && n / 10 != 7)            //up-left
                    t11.add(n + 9);

                break;
        }
        return t11;
    }
}


public class init {
    public static void main(String[] args) throws IOException {
        try{
            initialization i = new initialization();
            i.init_board();
        }
        catch (Exception e){
            System.out.println("Error Occurred,"+e.getMessage());
        }

        
    }
}
