package Model;

public class Hostile_Object extends Game_Object {

    static double bounce_v_x = 600;
    static double bounce_v_y = 13;

    Hostile_Object( double x, double y , double width, double height){
        super(4,x,y,width,height);
    }

    double hit_velocity_x(){
        return bounce_v_x ;
    }
    double hit_velocity_y(){
        return bounce_v_y;
    }
    int get_damage(){
        return 1;
    }

    @Override
    public String getName_State() {
        return getName();
    }

    @Override
    public String getName() {
        return "spike";
    }

    @Override
    public boolean isCollidable() {
        return false;
    }
}
