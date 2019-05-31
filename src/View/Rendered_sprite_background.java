package View;

public class Rendered_sprite_background extends Rendered_sprite{

    public Rendered_sprite_background(){
       super("background",5000,1300);
    }

    @Override
    public void update(Camera camera) {
        setX(-camera.getX()/5-1000);
        setY(-camera.getY()/6-200);
    }
}
