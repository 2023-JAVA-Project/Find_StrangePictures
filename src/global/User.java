package global;

import javax.swing.*;
import java.util.Date;

public class User {
    public JTextField name;
    static int score=0;
    Date date;

    public User(JTextField name, int score){
           this.name=name;
//        this.date=date;
        this.score=score;
    }
    public JTextField getName(){
        return name;
    }
    public Date getDate(){
        return date;
    }
    public static int getScore(){
        return score;
    }
    public void setName(JTextField name){
        this.name=name;
    }
    public void setDate(Date date){
        this.date=date;
    }
    public static void setScore(int scores){
        score=scores;
    }
}
