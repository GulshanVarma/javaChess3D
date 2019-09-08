import java.io.*;

class initialization{
    boolean turn = true;
    board b = new board();
    void init_board() throws IOException {
        try {
            String temp;
            boolean t = false;
            BufferedReader br = new BufferedReader(new FileReader("src/positions.txt"));
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++){
                    temp = br.readLine();
                    piece p = new piece(temp);
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
        game_start();
    }
    void game_start() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            if (turn) {
                System.out.println("player white turn..");
                b.draw_board();
                System.out.println("enter your move : ");
                b.movements(br.readLine());

            } else {
                System.out.println("player black turn..");
                b.draw_board();
                System.out.println("enter your move : ");
                b.movements(br.readLine());
            }
            turn = !turn;

        }

    }
}

public class init {
    public static void main(String[] args) throws IOException {
        initialization i = new initialization();
        i.init_board();
    }
}
