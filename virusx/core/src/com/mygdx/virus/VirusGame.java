package com.mygdx.virus;

import com.badlogic.gdx.Game;

public class VirusGame extends Game {
    @Override
    public void create() {
        GameController z =new GameController(this);
        setScreen(z);
    }
}
