package Controller;

import javafx.animation.AnimationTimer;

import java.util.ArrayList;

/**
 * Handles logic for menu
 */
public class Menu  extends AnimationTimer {

    Controller controller;
    private ArrayList<MenuItem> Menu_item_list = new ArrayList<MenuItem>();
        final double x = 680;
        final double y = 40;
        final double width =600;
        final double height = 250;
        final double vertical_space = 50;

    public Menu(Controller controller){
        this.controller = controller;
        int i =0;

        controller.stage.setScene(controller.MenuScene);

        Menu_item_list.add(new MenuItem_Start(controller,x,y+((i++)* vertical_space),width,height));
        Menu_item_list.add(new MenuItem_exit(controller,x,y+((i++)* (vertical_space+ height)),width,height));


    }

    /**
     * @param type_of_action
     * @param mouse_pose_x
     * @param mouse_pose_y
     */
    void call_menu_on_mouse_event(int type_of_action,double mouse_pose_x,double mouse_pose_y){

        for (MenuItem menuItem : Menu_item_list){
            if (menuItem.containts(mouse_pose_x,mouse_pose_y)) {
                menuItem.execute_on_mouse_interaction(type_of_action, mouse_pose_x, mouse_pose_y);
            }
            else {
                menuItem.setState(0);
            }
        }

    }

    /**
     * Sets up buttons for menu,
     */
    public void RE_SET_UP(){
        Menu_item_list.clear();
        int i =0;
        Menu_item_list.add(new MenuItem_Start(controller,x,y+((i++)* vertical_space),width,height));

        if(!controller.model.isGameOver()){
            Menu_item_list.add(new Menuitem_continue(controller,x,y+((i++)* (vertical_space+ height)),width,height));
        }

        Menu_item_list.add(new MenuItem_exit(controller,x,y+((i++)* (vertical_space+ height)),width,height));
    }


    /**
     * @param now
     */
    @Override
    public void handle(long now) {
        controller.update_for_menu();
    }

    public ArrayList<MenuItem> getMenu_item_list() {
        return Menu_item_list;
    }
}
