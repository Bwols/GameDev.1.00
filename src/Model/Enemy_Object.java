package Model;

public class Enemy_Object extends Hostile_Object {

    static double width = 120;
    static double height = 200;
    private double velocityX = 300;
    private double patrol_range =200;
    static double spawn_x ;
    static double spawn_y ;
    int ticks = 0;

    public Enemy_Object(double spawn_x, double spawn_y ){
        super(spawn_x,spawn_y,width,height);
        this.spawn_x = spawn_x;
        this.spawn_y = spawn_y;

    }

    @Override
    public void update(double deltatime) {
        move(deltatime);
        --ticks;
        if(getX()>spawn_x + patrol_range|| getX() < spawn_x - patrol_range){
            if(ticks <= 0){
                velocityX *= -1;
                ticks = 80;
            }


        }
//        if(getX()> spawn_x + patrol_range){
//            //velocityX = Math.abs(velocityX);
//            //velocityX *= -1;
//            setVelocityY(Math.abs(velocityX) *-1);
//        velocityX -= 1;
//        }
//        if (getX() < spawn_x - patrol_range){
//          setVelocityX(velocityX *-1 );
//
//           // velocityX -= 1;
//        }

    }

    @Override
    public String getName() {
        return "enemy";
    }

    private void move(double deltatime){
        setX(getX() + velocityX*deltatime/1000);
    }

    @Override
    public void response_to_player(Player_Object player_object) {
        if(Math.abs( player_object.getVelocityX())> 800){

        }
        else{
            super.response_to_player(player_object);
        }

    }
}
