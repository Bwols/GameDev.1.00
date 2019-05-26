package Model;

public class Platform_Object extends Game_Object {

    public Platform_Object(int id,double x,double y,double width,double height){
        super(id,x,y,width,height);
    }

    @Override
    public boolean isCollidable() {
        return true;
    }

    @Override
    public String getName() {
        return "platform";
    }
}
