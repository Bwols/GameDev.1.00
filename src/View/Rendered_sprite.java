package View;


import javafx.scene.canvas.GraphicsContext;

public   class Rendered_sprite {
    double x = 0;
    double y = 0;
    double width ;
    double height;
    private String name;
    public Rendered_sprite(String name,double width,double height){
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update(Camera camera){};

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
