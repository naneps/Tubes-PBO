package com.mygdx.virus;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.io.InputStream;
import java.nio.ByteBuffer;

import javax.swing.JToggleButton;

import jdk.internal.net.http.RequestPublishers;

public abstract class BaseScreen implements Screen, InputProcessor {

    protected Game game ;
    protected Stage mainStage;
    protected Stage uiStage;

    public final int viewWidth = 640;
    public final int viewHeight = 480;

    private boolean paused;

    public BaseScreen(Game g ) {
        game = g;
        mainStage = new Stage( new FitViewport(viewWidth,
                viewHeight) );
        uiStage = new Stage( new FitViewport(viewWidth,
                viewHeight) );
        paused = false;
        InputMultiplexer im = new InputMultiplexer(this,uiStage,mainStage);
        Gdx.input.setInputProcessor( im );
        create();
    }

    public abstract void create();
    public abstract void update(float dt);

    @Override
    public void render(float dt) {
        uiStage.act(dt);
        if ( !isPaused()){
            mainStage.act(dt);
            update(dt);
        }
        // render
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mainStage.draw();
        uiStage.draw();
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }
    public void togglePaused(){
        paused = !paused;
    }

    @Override
    public void resize(int width, int height) {
        mainStage.getViewport().update(width, height,true);
        uiStage.getViewport().update(width, height,true);
    }

    @Override
    public void show() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
