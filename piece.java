class piece {
    char name;
    char color;
    int loc_x,loc_y;    // index locations of piece
    piece(){}	// temp_piece
    piece(String p,int i, int j){
        if(p.equals(".")) {
            name = '.';
            color= 'n';
            return;
        }
        loc_x = i;
        loc_y = j;
        char[] temp = p.toCharArray();
        name = temp[1];
        color= temp[0];
        get_rule();
    }
    void get_rule(){        // sets rule parameters

    }
}
