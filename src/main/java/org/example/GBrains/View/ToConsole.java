package org.example.GBrains.View;

import org.example.GBrains.Controller.Controller;

public class ToConsole implements Viewable{

    @Override
    public void showInConsole (String msg) throws Exception {
        System.out.println(msg);
    }
}
