class user_moves {
    int start_x,start_y,end_x,end_y;
    user_moves(String move) {
        char[] moves = move.toCharArray();
        start_x = ((int)moves[0])-97;
        start_y = 8-(int)moves[1]+48;
        end_x = ((int)moves[3])-97;
        end_y = 8-((int)moves[4])+48;
    }
}