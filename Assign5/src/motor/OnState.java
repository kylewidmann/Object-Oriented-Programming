package motor;

import states.MotorState;
import time.MyTimer;

public class OnState implements MotorState{

    private Motor motor;
    private int msRun;

    OnState(Motor motor){
        this.motor = motor;
        msRun = 0;
    }


    @Override
    public void on() {

    }

    @Override
    public void off() {
        System.out.println("Setting motor off on thread: " + Thread.currentThread());
        motor.setOff();
    }

    @Override
    public void updateTime() {
        msRun += MyTimer.MS_PER_TICK;
        if(msRun >= motor.getRunTime()){
            motor.setOff();
        }
    }

    @Override
    public String toString(){
        return "On";
    }
}
