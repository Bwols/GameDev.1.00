package Model;

public class Collectable_Object extends Game_Object {


    /**
     *  object ready to be collected adds points
     * @param x
     * @param y
     */
  public Collectable_Object( double x, double y){

       super(3,x,y,70,70);
   }


    @Override
    public String getName() {
        return "coin";
    }

    @Override
    public String getName_State() {
        return getName(); // uzpelinc
    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    int get_points(){
      return 10;
    }

}
