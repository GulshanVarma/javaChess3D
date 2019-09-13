package src2;

public class test {
	public static void main(String[] args) {
		int start_x, start_y, end_x, end_y;
		String move = "a1b2";
		char[] moves = move.toCharArray();
		start_x = ((int)moves[0])-97;
        start_y = 8-(int)moves[1]+48;
        end_x = ((int)moves[2])-97;
        end_y = 8-((int)moves[3])+48;
        System.out.printf("%d%d%d%d",start_x, start_y, end_x, end_y);
	}
}
