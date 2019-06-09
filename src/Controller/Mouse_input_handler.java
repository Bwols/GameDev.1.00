package Controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Handles Mouse input for menu
 */
public class Mouse_input_handler implements EventHandler<MouseEvent> {
    Menu menu;
    int type_of_action;// 0 hover
                // 1 if pressed
                // 2 if realesed

    public Mouse_input_handler(Menu menu,int type_of_action ){
        this.type_of_action = type_of_action;
        this.menu = menu;
    }

    @Override
    public void handle(MouseEvent event) {
        menu.call_menu_on_mouse_event(type_of_action,event.getX(),event.getY());
    }
}
