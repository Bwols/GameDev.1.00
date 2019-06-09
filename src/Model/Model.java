package Model;

import java.util.ArrayList;

public class Model {

    private Player_Object Player;
    private boolean MoveTable[];
    boolean GameOver = false;
    private ArrayList<Game_Object> game_object_list;

    public Model(){

        MoveTable = new boolean[5];//movetable[4] = shift
        Player = new Player_Object(0,0);
        game_object_list = new ArrayList<Game_Object>();
        load_level();

    }

    public void update(double delta_time){
        if(Player.getLives()==0){
            GameOver = true;
        }else{
            Player.update(delta_time,MoveTable, game_object_list);
        for(Game_Object go :game_object_list){
            if(go instanceof Enemy_Object){
                go.update(delta_time);
            }
        }


        }



    }
    private void load_level(){
        game_object_list.add(new Platform_Object(1,200,100,120,400));
        game_object_list.add(new Platform_Object(1,-200,200,20,400));
        game_object_list.add(new Platform_Object(1,0,-300,800,200));
        game_object_list.add(new Platform_Object(1,1000,-200,800,200));
        game_object_list.add(new Platform_Object(1,1700,-200,800,200));
        game_object_list.add(new Platform_Object(1,2800,-150,800,200));
        game_object_list.add(new Collectable_Object(600,30));
        game_object_list.add(new Hostile_Object(1000,-40,200,100));
        game_object_list.add(new Collectable_Object(1000,100));
        game_object_list.add(new Collectable_Object(1300,30));
        game_object_list.add( new Enemy_Object(2800,120));
    }
    public void restart_level(){
        game_object_list.clear();
        Player.setY(0);
        Player.setX(0);
        Player.setPoints(0);
        Player.setLives(3);
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

    public void setGameOver(boolean gameOver) {
        GameOver = gameOver;
    }

    public boolean isGameOver() {
        return GameOver;
    }
}
