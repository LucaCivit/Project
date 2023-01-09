package com.project.clicker;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;

public class Check extends Thread{
    public Label label;
    boolean exit = false;

    public Check(Label l){

        this.label = l;

    }

    public void run(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(!exit){
        int score = Integer.parseInt(String.valueOf(label.getText()));
        if( score < 0){
            throw new RuntimeException();
        }
        else{
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }

    }
    }
    public void terminate(){
        exit = true;
    }

}
