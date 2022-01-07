package com.mygdx.virus.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
//import com.ballonbuster.game.BalloonGame;
import com.mygdx.virus.VirusGame;

public class VirusLauncher {
    public static void main(String[] args) {
        VirusGame myProgram = new VirusGame();
        LwjglApplication launcher = new LwjglApplication(
                myProgram );

    }
}
