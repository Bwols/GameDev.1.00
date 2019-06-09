package Controller;

import com.sun.org.apache.bcel.internal.classfile.Constant;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import Model.Model;

/**
 * Handles all keyboard input during gameplay
 */
public class Keyboard_input_handler implements EventHandler<KeyEvent> {
    private boolean b;
    private Controller controller;
    private Model model;

    /**
     * Standard constructor for Keyboard_input_handler
     *
     * @param controller
     * @param model
     * @param b
     */
    public Keyboard_input_handler(Controller controller,Model model,boolean b){// add arguments of actual game set up
        this.controller = controller;
        this.b = b;
        this.model = model;
    }

    /**
     * Upon pressing or realising certain buttons Model and Controller appropriate methods are called
     * @param event
     */
    @Override
    public void handle(KeyEvent event) {

        //System.out.println(event.getCode());
        switch (event.getCode().toString()){
            case  "UP":
                model.moveup(b);
                break;
            case  "SPACE":
                model.moveup(b);
                break;
            case  "DOWN":
                model.movedown(b);
                break;
            case  "RIGHT":
                model.moveright(b);
                break;
            case  "LEFT":
                model.moveleft(b);
                break;
            case  "ESCAPE":

                if(b){

                   controller.go_to_menu();
                }
                break;
            case  "SHIFT":
                model.moveshift(b);
                break;

        }

    }
}
