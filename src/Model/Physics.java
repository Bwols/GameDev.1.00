package Model;

/**
 * Provides static methods for some of in game interactions and behaviour concerning phisical aspects
 */
public class Physics {
    static final double G =30;//pixels per second acceleration

    /**
     *
     * @param deltatime
     * @return increased speed by gravity
     */
    static double Gforce(double deltatime){
        return G * deltatime;//speed after
    }

    /**
     * @param movable
     * @param wall
     * @return x positon after collision
     */
    static double post_collision_positionX(Game_Object movable , Game_Object wall){

        if(movable.getVelocityX() > 0 && movable.getX() < wall.getX()) return wall.getX() - wall.getWidth()/2 - movable.getWidth()/2;

        else if(movable.getVelocityX() < 0 && movable.getX() > wall.getX()) return wall.getX() + wall.getWidth()/2 + movable.getWidth()/2;

        else return movable.getX();
    }

    /**
     * @param movable
     * @param wall
     * @return post_collision_velocityY
     */
    static double post_collision_velocityX(Game_Object movable , Game_Object wall) {
        return movable.getVelocityX();
    }


    /**
     * @param movable
     * @param wall
     * @return y positon after collision
     */
    static double post_collision_positionY(Game_Object movable , Game_Object wall){

        if(movable.getVelocityY() > 0 && movable.getY() < wall.getY()) return wall.getY() - wall.getHeight()/2 - movable.getHeight()/2;

        else if(movable.getVelocityY() < 0 && movable.getY() > wall.getY()) return wall.getY() + wall.getHeight()/2 + movable.getHeight()/2;

        else return movable.getY();

    }

    /**
     * @param movable
     * @param wall
     * @return post_collision_velocityY
     */
    static double post_collision_velocityY(Game_Object movable , Game_Object wall){
        return 0;
    }


}
