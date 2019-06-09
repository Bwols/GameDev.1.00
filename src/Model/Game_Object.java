package Model;

import javafx.geometry.Rectangle2D;

public abstract class Game_Object {

    private int ID;
    private double x;
    private double y;
    double velocityX = 0;
    double velocityY = 0;
    private double height;
    private double width;


    public Game_Object(int id, double x, double y , double width, double height){
        this.ID = id;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    public abstract String getName();
    public abstract String getName_State();
    public abstract boolean isCollidable();
    public  void update(){};
    public void update(double deltatime){};
   // public abstract boolean isPhysicApplied();

    public Rectangle2D getBody() {
        return new Rectangle2D(x-width/2,y-height/2,width,height);
    }

    public boolean intersects(Game_Object other){
        return (other.getBody().intersects(this.getBody())&& other.isCollidable());
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setX(double x){
        this.x = x ;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public int getID(){
        return ID;
    }





}

