package View;

import Model.Player_Object;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GUI {
    int lives = 0 ;
    int points = 0;
    final int space = 30;
    final int A = 110;

    Rendered_sprite live;
    Rendered_object rendered_object;

    public  GUI( Rendered_object rendered_object){
       this.rendered_object = rendered_object;
        live = new Rendered_sprite("live",A,A);

        rendered_object.graphicsContext.setFont(new Font(60));
        rendered_object.graphicsContext.setFill(Color.ORANGERED);
        rendered_object.graphicsContext.setStroke(Color.WHITE);
    }

    void update(Player_Object player_object){
        lives = player_object.getLives();
        points = player_object.getPoints();
    }

    void draw_lives(){
        for(int i = 0;i< lives ;++i ){
            rendered_object.render(live,space +(space+A) *i,40);

        }
    }
    void display_score(){
        rendered_object.graphicsContext.fillText("SCORE: "+points,1570,70);
        rendered_object.graphicsContext.strokeText("SCORE: "+points,1570,70);


    };
}
