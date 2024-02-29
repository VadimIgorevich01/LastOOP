package org.example.GBrains.View;

public class ToConsole implements Viewable{

    @Override
    public void showInConsole (String msg) throws Exception {
        System.out.println(msg);
    }
}
