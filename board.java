package src2;

public class board {
    piece[][] bb = new piece[8][8];
    boolean[][] color = new boolean[8][8];
    piece[][] temp = new piece[8][8];
    int[][] position = new int[8][8];

    void draw_board(){
    	System.out.println("\t>>Black Side<<\n");
    	for(int i=0;i<8;i++){
        	System.out.print((8-i)+"  ");
            for(int j=0;j<8;j++){
                System.out.print(this.bb[i][j].name+"  ");
                position[i][j] = (i*10)+j;
            }
            System.out.println();
        }
        System.out.println("\n   A  B  C  D  E  F  G  H");
        System.out.println("\n\t>>White Side<<");
    }
    void clear_board(piece p){
        int i = p.loc_x ;
        int j = p.loc_y ;
        p.name = '.';
    }
}
  