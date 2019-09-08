class piece {
    char name;
    char color;
    boolean alternate_xy;
    boolean both_xy;
    boolean only_y;

    piece(String p){
        if(p.equals(".")) {
            name = '.';
            return;
        }
        char[] temp = p.toCharArray();
        color = temp[0];
        name = temp[1];
        alternate_xy = false;
        both_xy = false;
        only_y = false;
        get_rule();
    }
    void get_rule(){        // sets rule parameters
        if(name == 'r'){
//            if(verify())
        }
        if(name == 'p') only_y = true;
        if(name == 'b') both_xy = true;
        if(name == 'q' || name == 'k') {
            alternate_xy = true;
            both_xy = true;
        }
    }
}
