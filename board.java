public class board {
    piece[][] bb = new piece[8][8];
    boolean[][] color = new boolean[8][8];
    piece[][] temp = new piece[8][8];

    void draw_board(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(this.bb[i][j].name+"\t");
            }
            System.out.println();
        }
    }

    void movements(String move){
        user_moves m = new user_moves(move);
        
    }
}
