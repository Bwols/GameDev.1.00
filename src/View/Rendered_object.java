package View;

import Controller.MenuItem;
import Model.Game_Object;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.TreeMap;

public class Rendered_object {

    GraphicsContext graphicsContext;
    GraphicsContext graphicsContext_for_menu;
    Camera camera;
    TreeMap<String, Image> imageTreeMap;
    Renderer renderer;

    public Rendered_object(Renderer renderer,GraphicsContext graphicsContext,GraphicsContext graphicsContext_for_menu,Camera camera, TreeMap<String, Image> imageTreeMap){
        this.renderer = renderer;
        this.graphicsContext = graphicsContext;
        this.graphicsContext_for_menu = graphicsContext_for_menu;
        this.camera = camera;
        this.imageTreeMap = imageTreeMap;
    }



     void render(Game_Object game_object){
        double x = (renderer.width/2) + game_object.getX() - camera.getX() - (game_object.getWidth()/2);
        double y = (renderer.height/2) - game_object.getY() - camera.getY() - (game_object.getHeight()/2);

        Image image = imageTreeMap.get(game_object.getName_State()+".png");

         if(image == null){
             image = imageTreeMap.get("error.png");
         }
         if(game_object.getName() == "platform"){
             graphicsContext.drawImage(image,x ,y-30,game_object.getWidth(),game_object.getHeight()+30);
         }else
         graphicsContext.drawImage(image,x ,y,game_object.getWidth(),game_object.getHeight());

        //--change .jpg -> .png
        // graphicsContext.drawImage(imageTreeMap.get("platform.jpg"),x ,y,game_object.getWidth(),game_object.getHeight()); //--change .jpg -> .png

         //graphicsContext.drawImage(imageTreeMap.get("platform.jpg"), game_object.getX(),-game_object.getY(),game_object.getWidth(),game_object.getHeight());
            //graphicsContext.drawImage(new Image("platform.jpg"),30,30);
        // graphicsContext.drawImage(new Image("Resources/platform.jpg"),30,30);
        //System.out.println(game_object.getName()+".jpg");
    }
    void render(Rendered_sprite rendered_sprite){
        Image image = imageTreeMap.get(rendered_sprite.getName()+".png");
        if(image == null){
            image = imageTreeMap.get("error.png");
        }
        graphicsContext.drawImage(image,rendered_sprite.getX(),rendered_sprite.getY(),rendered_sprite.getWidth(),rendered_sprite.getHeight());
    }

   void  render(MenuItem menuitem){
        Image image = imageTreeMap.get((menuitem.get_Name_State())+".png");
        if(image == null){
            image =imageTreeMap.get("error.png");
        }
        graphicsContext_for_menu.drawImage(image,menuitem.getX(),menuitem.getY(),menuitem.getWidth(),menuitem.getHeight());
    }
    void render(Rendered_sprite rendered_sprite,int x ,int y){
        Image image = imageTreeMap.get(rendered_sprite.getName()+".png");
        if(image == null){
            image = imageTreeMap.get("error.png");
        }
        graphicsContext.drawImage(image,x,y,rendered_sprite.getWidth(),rendered_sprite.getHeight());
    }

}
