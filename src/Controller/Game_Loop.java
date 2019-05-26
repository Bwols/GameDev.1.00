package Controller;


import javafx.animation.AnimationTimer;

public class Game_Loop extends AnimationTimer {
    private Controller controller;

    double delta_time = 0;//time variables
    final double constant = 1000_000;//time is counted in nanoseconds we have miliseconds
    double last_time = 0;

    double FrameRateTime = 0;//to count fps
    int FPS = 0;

    public Game_Loop(Controller controller){
        this.controller = controller;
    }

    @Override
    public void handle(long now) {

        if (last_time == 0){  // first iteration
            last_time = now;
            FrameRateTime = now;
            return;
        }

        delta_time = (now - last_time)/constant;
        controller.update(delta_time);

        last_time = now;


        //fps optional mangement
        ++FPS;
        if((now -FrameRateTime)/constant >=1000){ ///////!!!!!!!!!!!!!!!hardcoeded 1000 ms
            System.out.println(String.format("FPS : %d",FPS));
            // -- add function call --
            FrameRateTime =now;
            FPS=0;
        }

    }

    @Override
    public void start() {
        super.start();
    }
    public void stop(){
        last_time =0;
        super.stop();
    }

}
