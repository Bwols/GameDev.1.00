package Controller;

import javafx.geometry.Rectangle2D;

/**
 * Super class for menu items
 */
public abstract class MenuItem  {

    private String name;
    private int state = 0;// loose 1 hover //2 pressed

    double x;
    double y;
    double width;
    double height;
    Controller controller;

    MenuItem(Controller controller,double x ,double y,double width, double height, String name){
        this.controller = controller;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.name = name;

    }
    public Rectangle2D getBody() {
        return new Rectangle2D(x,y,width,height);
    }

    public boolean containts(double x,double y){
       return this.getBody().contains(x,y);
    }

    abstract public void execute_on_mouse_interaction(int type_of_action,double mouse_pose_x,double mouse_pose_y);

    public String getname(){
        return this.name;
    }

    public String get_Name_State(){
        return name + "_"+ state;
    }

   public int getState(){
       return state;
   }

    public void setState(int state) {
        this.state = state;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
