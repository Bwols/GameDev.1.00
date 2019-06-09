
import Controller.Controller;
import Model.Model;
import View.Renderer;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class
 * @author Bartłomiej Wolski
 * @version 2.1
 *
 */

public class Main extends Application {
    /**
     * Creates controller and assigns Model and Renderer / View
     * @param primaryStage
     * @throws Exception
     *
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        Controller controller= new Controller(primaryStage,new Model(),new Renderer(primaryStage));
    }

    /**
     * @param args
     */
    public static void main(String []args){
        launch(args);
    }
}
