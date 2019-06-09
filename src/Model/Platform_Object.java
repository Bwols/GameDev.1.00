package Model;

/**
 * Basic platform on which the player can stand and jump from
 */
public class Platform_Object extends Game_Object {

    /**
     * @param id
     * @param x
     * @param y
     * @param width
     * @param height
     */
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

    @Override
    public String getName_State() {
        return getName();
    }
}
