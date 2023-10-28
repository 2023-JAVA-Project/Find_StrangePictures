package global;

import javax.swing.*;
import java.util.Date;

public class Model {
    public JTextField name;
    int score=0;
    Date date;

    public Model(JTextField name,int score){
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
    public int getScore(){
        return score;
    }
    public void setName(JTextField name){
        this.name=name;
    }
    public void setDate(Date date){
        this.date=date;
    }
    public void setScore(int score){
        this.score=score;
    }
}
