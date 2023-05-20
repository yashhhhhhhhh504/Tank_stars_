package com.gamesfromscratch;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.util.ArrayList;

// Singleton
public class Application implements InputProcessor {
    private static Application app = null;
    private Stage stage;
    private int i;
    ArrayList<Game> games= new ArrayList<Game>();
    private Application(Stage stage){

        this.stage = stage;
        Group groupselect = new Group();
        Image LoadImg = new Image(new Texture(Gdx.files.internal("Gameop.png")));
        groupselect.addActor(LoadImg);
        stage.addActor(groupselect);

        Gdx.input.setInputProcessor(this);
    }
    public static Application getInstance(Stage stage){
        if(app == null){
            app = new Application(stage);
        }
        return app;
    }

    @Override
    public boolean keyDown(int keycode) {
        Group group = (Group)stage.getActors().first();
        if(keycode == Input.Keys.NUM_1){
            // Create a label style
            group.remove();
            Group groupplay = new Group();

            Label.LabelStyle labelStyle = new Label.LabelStyle();
            labelStyle.font = new BitmapFont(); // Use a BitmapFont object for the font
            labelStyle.fontColor = Color.BLUE; // Set the font color to white

            Label label = new Label("Hello World", labelStyle);

            Table table = new Table();
            table.add(label).pad(10);

            groupplay.addActor(label);
            stage.addActor(groupplay);
            Gdx.input.setInputProcessor(this);
        } else if (keycode == Input.Keys.NUM_2) {
            group.remove();
            Game game = new Game(stage);
        }
        return true;
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
