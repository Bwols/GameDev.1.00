package View;

import Controller.MenuItem;
import Model.Game_Object;
import Model.Player_Object;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeMap;


/**
 * Contains all code that is responsible for graphic layer of the game
 */
public class Renderer {
    Stage stage;
    Group root;
    Scene GameScene;

    Group root_for_menu;
    Scene MenuScene;

    GraphicsContext graphiccontext;
    GraphicsContext graphicsContext_for_menu;


    Camera camera;
    HUD gui;


    final double height = Screen.getPrimary().getVisualBounds().getHeight();
    final double width = Screen.getPrimary().getVisualBounds().getWidth();

    final String image_directory = "Resources/";

    TreeMap<String,Image> imageTreeMap = new TreeMap<String,Image>();
    Rendered_object rendered_object;

    ArrayList<Rendered_sprite> rendered_spriteArrayList = new ArrayList<Rendered_sprite>();


    /**
     * Prepares and adjusts resources for rendering
     */
    public void Set_UP(){

       // stage.setFullScreen(true);
        stage.setX(0);
        stage.setY(0);
        stage.setHeight(height);
        stage.setWidth(width);
        camera = new Camera(0,0);


        load_images(image_directory);

        Canvas canvas = new Canvas(width,height);//canvas the size of screen
        Canvas canvas_for_menu = new Canvas(width,height);

        root.getChildren().add(canvas);
        root_for_menu.getChildren().add(canvas_for_menu);

        graphiccontext = canvas.getGraphicsContext2D();
        graphicsContext_for_menu = canvas_for_menu.getGraphicsContext2D();


        rendered_object = new Rendered_object(this,graphiccontext,graphicsContext_for_menu,camera,imageTreeMap);
        gui = new HUD(rendered_object);
         load_sprites();


        stage.setTitle("SQIK-TheGame");

        stage.setScene(MenuScene);


    }

    public Renderer(Stage stage) {
        this.stage = stage;
    }

    /**
     * Updates the screen.
     * @param Player
     * @param game_object_list
     */
    public void update(Game_Object Player, ArrayList<Game_Object> game_object_list){
        graphiccontext.clearRect(0,0,width,height);

        camera.update(Player.getX(),- Player.getY());
        for(Rendered_sprite rs : rendered_spriteArrayList){
            rs.update(camera);
            rendered_object.render(rs);
        }

        for(Game_Object go : game_object_list){

            rendered_object.render(go);
        }
        rendered_object.render(Player);

        gui.update((Player_Object) Player);
        gui.draw_lives();
        gui.display_score();


    }

    /**
     * updates the screen while in menu context
     * @param menuItemArrayList
     */
    public void update_for_menu(ArrayList<MenuItem> menuItemArrayList){

        graphicsContext_for_menu.drawImage(imageTreeMap.get("owl.jpg"),0,0,stage.getWidth(),stage.getHeight());

        for (MenuItem menuItem : menuItemArrayList){
         rendered_object.render(menuItem);
        }

    }


    /**
     * @param gameScene
     */
    public void addGameScene(Scene gameScene){
        this.GameScene = gameScene;
    }

    /**
     * @param MenuScene
     */
    public void addMenuScnene(Scene MenuScene){
        this.MenuScene = MenuScene;
    }

    /**
     * @param root
     */
    public void addRoot(Group root){
        this.root = root;
    }

    /**
     * @param root_for_menu
     */
    public void addRoot_for_menu(Group root_for_menu){
        this.root_for_menu = root_for_menu;
    }


    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    /**
     * Loads not recursively all images in said path
     * @param image_directory
     */
    public void load_images(String image_directory){
        File directory = new File("./src/"+image_directory);

        for(String name : directory.list()){

            System.out.println(name +"   "+image_directory+name);
            imageTreeMap.put(name,new Image(image_directory+name));
        }

    }


    public TreeMap<String, Image> getImageTreeMap() {
        return imageTreeMap;
    }

    public void load_sprites(){
        rendered_spriteArrayList.add(new Rendered_sprite_background());
    }

    /**
     * Displays the game over scene
     */
    public void setGameOver(){
        Rendered_sprite gameover = new Rendered_sprite("gameover",800,500);
        gameover.setX(600);
        gameover.setY(200);
        rendered_object.render(gameover);
    }



}
