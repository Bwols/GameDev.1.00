package View;

import Model.Game_Object;
import Model.Player_Object;

public class Camera {
    double x = 0;
    double y = 0;
    Game_Object game_object;

    public Camera(double x ,double y){
        this.x = x;
        this.y = y;
    }
    public Camera(Game_Object game_object){
        this.game_object = game_object;
        this.x = game_object.getX();
        this.y = game_object.getY();
    }
    public void update(){
        this.x = game_object.getX();
        this.y = game_object.getY();
    }

    public void update(double x ,double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
