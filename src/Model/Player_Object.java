package Model;

import java.util.ArrayList;

/**
 * Most important object in the game, responsible for handling all situations concerning player and surrounding world
 */
public class Player_Object extends Game_Object {

    double accelerationX = 1700;
    final double max_velocityX = 700; // pixels per second
    int intMoveTable[]= new int[5];

    double jumppower = 1700;
    double dash_velocity = 2200;
    boolean on_ground = false;
    int state = 0;
    int lives = 3;
    int points = 0;
    int vulnerable = 0;
    int dash_points = 0;
    public Player_Object(double x,double y){
        super(0,x,y,100,80);

    }


    /**
     * Updates player.First moves it accordingly to user input and then checks for collisions.Eventually updating status variables
     *
     * @param delta_time
     * @param MoveTable
     * @param game_object_list
     */
    public void update(double delta_time, boolean MoveTable[], ArrayList<Game_Object>game_object_list) {//cant be called by game object
        for(int i=0;i<5;++i){
           intMoveTable[i] = MoveTable[i] ? 1 : 0;//to get information on movement
        }
        if(intMoveTable[2]==1){
            state = 0;
        }
        if(intMoveTable[3]==1){
            state = 1;
        }
        if(getY()<-1200){
            lives = 0;
        }

        moveX(delta_time,intMoveTable[2], intMoveTable[3],MoveTable[4]);
        moveY(delta_time,intMoveTable[0]);
        setOn_ground(false);
        --vulnerable;


        for(Game_Object go: game_object_list){

            if(this.getBody().intersects(go.getBody())){
                //System.out.println(this.getX() +" other:" + go.getX());

                if(go instanceof Platform_Object) {
                    if (this.getX() - this.getWidth() / 2.7 < (go.getX() + go.getWidth() / 2) && this.getX() + this.getWidth() / 2.7 > (go.getX() - go.getWidth() / 2)) {


                        setY(Physics.post_collision_positionY(this, go));
                        setVelocityY(Physics.post_collision_velocityY(this, go));
                        if (this.getY() > go.getY()) {
                            setOn_ground(true);
                        }

                    }


                    if (this.getY() < (go.getY() + go.getHeight() / 2 + this.getHeight() / 2) && this.getY() > (go.getY() - go.getHeight() / 2 - this.getHeight() / 2)) {

                        setX(Physics.post_collision_positionX(this, go));
                        setVelocityX(Physics.post_collision_velocityX(this, go));

                    }
                }
                else if(go instanceof Collectable_Object){

                    this.setPoints(((Collectable_Object) go).get_points() +this.getPoints());
                    //game_object_list.removeIf(gno ->gno instanceof Collectable_Object);
                    game_object_list.remove(go);

                }
                else if((go instanceof Hostile_Object && this.vulnerable <= 0)){
                    ((Hostile_Object) go).response_to_player(this);
                    if(this.vulnerable <= 0){
                        game_object_list.remove(go);
                    }

                }



                    //System.out.println("BREACH" + (int)getX() + "other" + (int)go.getX());
               //
               //

            }
        }

    }

    /**
     * Implementation of movement in x axis
     * @param delta_time
     * @param is_going_right
     * @param is_going_left
     * @param is_goingfast
     */
    public void moveX(double delta_time,int is_going_right,int is_going_left,boolean is_goingfast){
            --dash_points;
        if(is_goingfast && dash_points <= 0){
            dash_points = 200;
            velocityX = dash_velocity *Math.signum(velocityX);
        }else if(  dash_points <200 && dash_points > 188){}

        else {

            if (is_going_right - is_going_left == 0) {
                if (Math.abs(velocityX) < max_velocityX / 200) {
                    velocityX = 0;
                } else {
                    velocityX -= (Math.signum(velocityX) * (accelerationX * delta_time / 1000));
                }

            } else {

                velocityX += ((accelerationX * delta_time / 1000) * (is_going_right - is_going_left));

                if (Math.abs(velocityX) > (max_velocityX)) {
                    setVelocityX(max_velocityX * Math.signum(velocityX));//if is faster than possoble set speed to max_speed
                }

            }

        }
        setX(getX() + (velocityX * delta_time / 1000));
    }

    /**
     * Implementation of movement in y axis
     * @param delta_time
     * @param is_jumping
     */
    public void moveY(double delta_time,int is_jumping){
        velocityY += (is_jumping *(on_ground ? 1:0) * jumppower/100) -(Physics.Gforce(delta_time/1000));
        setY(getY() + velocityY);


    }



    @Override
    public String getName() {
        return "player";
    }

    @Override
    public String getName_State() {
        return getName()+"_"+ state;
    }

    @Override
    public boolean isCollidable() {
        return true;
    }

    public double getMax_velocityX() {
        return max_velocityX;
    }

    public boolean is_on_ground() {
        return on_ground;
    }

    public void setOn_ground(boolean on_ground) {
        this.on_ground = on_ground;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getVulnerable() {
        return vulnerable;
    }

    public void setVulnerable(int vulnerable) {
        this.vulnerable = vulnerable;
    }

}
