package com.mygdx.virus;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Align;

public class MainMenu extends BaseScreen {

    private Character bg;
    private Character title;

    private Label text;

    public MainMenu(Game game) {
        super(game);
    }

    @Override
    public void create() {

        bg = CharacterManager.createActor(mainStage, "bg.jpg", viewWidth / 2, viewHeight / 2);
        title = CharacterManager.createActor(mainStage, "title.png", viewWidth / 2, viewHeight / 2);

        BitmapFont font = new BitmapFont();
        LabelStyle style = new LabelStyle(font, Color.NAVY);

        text = new Label("Tekan untuk mulai", style);
        text.setPosition(viewWidth / 2 - text.getWidth() /2, 100);
        text.setFontScale(2);
        text.setAlignment(Align.center);

        uiStage.addActor(text);


    }

    @Override
    public void update(float delta) {

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        game.setScreen(new GameController(game));

        return false;
    }
}
