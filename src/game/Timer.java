package game;

import javax.swing.*;
import java.awt.*;

public class Timer extends JLabel implements Runnable {
    int width=650;
    Color color=new Color(255,0,0);

    int second;

    private boolean timerFinished = false;

    public boolean isTimerFinished() {
        return timerFinished;
    }

    public Timer(int second){
        setBackground(color);
        setOpaque(true);
        setBounds(300,610,650,30);
        this.second=second;
    }
    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(50);
            }catch (Exception e) {
                e.printStackTrace();
            }
            if (getWidth() > 0) {
                width -= 1;	// 너비가 1씩 줄어듦
                setBounds(300,610,width,30);
            } else {
                timerFinished = true;
                break;
            }
        }
    }
}
