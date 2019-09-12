import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class user_moves {
	// converts user input to index of arrays
	int start_x, start_y, end_x, end_y;
	user_moves(){}
	public void get_moves(String move){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	try {
	        char[] moves = move.toCharArray();
	        start_y = ((int)moves[0])-97;
	        start_x = 8-(int)moves[1]+48;
	        end_y = ((int)moves[2])-97;
	        end_x = 8-((int)moves[3])+48;
    	}
    	catch(Exception e){
    		System.out.println("Invalid move, try again");
    		try{get_moves(br.readLine());}
			catch (IOException e1){get_moves(move);}
    	}
    }
}