package com.mygdx.virus;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class CharacterManager {
    public static Character createActor(Stage stage, String pathToTexture, float x, float y) {
        return createActor(stage, pathToTexture, x, y, true);
    }

    public static Character createActor(Stage stage, String pathToTexture, float x, float y, boolean visible) {

        Character actor = new Character();
        actor.setTexture(new Texture(
                Gdx.files.internal(pathToTexture)
        ));
        actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);
        actor.setPosition(x - actor.getOriginX(),y - actor.getOriginY());
        actor.setVisible(visible);
        stage.addActor(actor);

        return actor;

    }

//    public static AnimatedActor createAnimetedActor(Stage stage, Animation animation, float x, float y) {
//
//        AnimatedActor actor = new AnimatedActor();
//        actor.setAnimimation(animation);
//        actor.setPosition(x,y);
//        actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);
//        stage.addActor(actor);
//
//        return actor;
//
//    }
}
