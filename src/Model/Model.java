package Model;

import java.util.ArrayList;

public class Model {

    private Player_Object Player;
    private boolean MoveTable[];

    private ArrayList<Game_Object> game_object_list;

    public Model(){

        MoveTable = new boolean[5];
        Player = new Player_Object(0,0);
        game_object_list = new ArrayList<Game_Object>();
        load_level();

    }

    public void update(double delta_time){

        Player.update(delta_time,MoveTable, game_object_list);
//        obj1.setX(( obj1.getMax_velocityX()*delta_time/1000)*(intMoveTable[2]-intMoveTable[3])); // propably failed take adjustment to time
//        //System.out.println(obj1.getX()+"   delta ti    " + delta_time);

    }
    private void load_level(){
        game_object_list.add(new Platform_Object(1,200,100,120,400));
        game_object_list.add(new Platform_Object(1,-200,200,20,400));
        game_object_list.add(new Platform_Object(1,0,-300,800,200));
        game_object_list.add(new Platform_Object(1,1000,-200,800,200));
        game_object_list.add(new Platform_Object(1,1800,-200,800,200));
    }
    public void restart_level(){
        game_object_list.clear();
        Player.setY(0);
        Player.setX(0);
        load_level();
    }

    public Game_Object getPlayer_Object(){
        return Player;
    }

    public ArrayList<Game_Object> getGame_object_list(){
        return game_object_list;
    }


    public void moveup(boolean b){

       MoveTable[0] = b;
        //System.out.println("upptabe"+MoveTable[0]);
    };
    public void movedown(boolean b){

        MoveTable[1] = b;
    };
    public void moveright(boolean b)
    {
        MoveTable[2] = b;
        //System.out.println("right"+MoveTable[2]);
    };
    public void moveleft(boolean b){

        MoveTable[3] = b;
    };
    public void ESC_action(boolean b){
        if(b==true) {
            System.out.println("ESC");//end it
        }
    };
    public void moveshift(boolean b){
        MoveTable[4] = b;
        System.out.println("shift"+b);
    };
}
