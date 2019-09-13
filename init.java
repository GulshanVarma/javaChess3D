package src2;

import java.io.*;
import java.util.ArrayList;

import com.ibm.jvm.dtfjview.ExitCodes;

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
            
        	verification v = new verification();
        	ArrayList<String> possible_moves = v.position_matrix(b.bb[u.start_x][u.start_y]);
            
        	// get possible moves
        	
        	
        	
        	
        	
        	
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
