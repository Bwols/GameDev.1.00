package Controller;

import Model.*;
import View.*;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controller {
    Stage stage;
    Scene MenuScene;//propably also game scene to add listener to
    Scene GameScene;

    Group root;
    Group root_for_menu;

    Model model;
    Renderer renderer;

    Game_Loop game_loop;
    Menu menu;

    public Controller(Stage stage,Model model,Renderer renderer){

        this.stage = stage;
        this.model = model;
        this.renderer = renderer;

        root = new Group();// or stack pane
        root_for_menu = new Group(); // root nodes for both scenes

        GameScene = new Scene(root,renderer.getWidth(),renderer.getHeight());
        MenuScene = new Scene(root_for_menu,500,500);

        Keyboard_input_handler k1 = new Keyboard_input_handler(this,model,false);
        Keyboard_input_handler k2 = new Keyboard_input_handler(this,model,true);

        menu = new Menu(this);

        MenuScene.setOnMouseMoved( new Mouse_input_handler(menu,0));
        MenuScene.setOnMousePressed( new Mouse_input_handler(menu,1));
        MenuScene.setOnMouseReleased(new Mouse_input_handler(menu,2));


        GameScene.setOnKeyPressed(k2);
        GameScene.setOnKeyReleased(k1);

        renderer.addGameScene(GameScene);//adding nodes that coudlnt have beed added in constructor
        renderer.addRoot(root);

        renderer.addMenuScnene(MenuScene);
        renderer.addRoot_for_menu(root_for_menu);

        renderer.Set_UP();


        game_loop = new Game_Loop(this);
        menu.start();
        //game_loop.start();

        //stage.setScene(GameScene);





        stage.show();

    }
    protected void update(double delta_time){
        model.update(delta_time);
        renderer.update(model.getPlayer_Object(),model.getGame_object_list());                   //pass somehow those objects  tlo -  platforms - enemies /obstacles -player
    }
    protected void update_for_menu(){
        renderer.update_for_menu(menu.getMenu_item_list());
    }

    public Group getRoot(){
        return root;
    }
    public Scene getGameScene(){
        return GameScene;
    }



}
