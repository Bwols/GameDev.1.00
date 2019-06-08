package Controller;

public class MenuItem_Start extends MenuItem {

    public  MenuItem_Start(Controller controller ,double x ,double y,double width, double height){
        super(controller,x,y,width,height,"start");
    }

    @Override
    public void execute_on_mouse_interaction(int type_of_action, double mouse_pose_x, double mouse_pose_y) {


        switch (type_of_action){
            case 0: setState(1);
                break;
            case 1: setState(2);
                break;
            case 2: if(getState()==2){
                controller.model.setGameOver(false);
                controller.stage.setScene(controller.GameScene);
                controller.game_loop.start();
                controller.menu.stop();
                controller.model.restart_level();
                break;
            }


        }

    }

}
