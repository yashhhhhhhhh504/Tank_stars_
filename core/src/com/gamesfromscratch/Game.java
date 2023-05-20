package com.gamesfromscratch;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Game implements GamePlay, InputProcessor {
    private Terrain Terr;
    private Tank player1;
    private Tank player2;
    private Image player1Img;
    private Image player2Img;
    private int i;
    private Stage stage;


    @Override
    public void pauseGame() {

    }

    @Override
    public void exitGame() {

    }

    public Game(Stage stage) {
        this.stage = stage;
        Group groupselect = new Group();
        Terr = Terrain.getInstance();
        this.i =0;

        player1Img = new Image(new Texture(Gdx.files.internal("player1.png")));
        player1Img.setName("Player1");
        groupselect.addActor(player1Img);
        stage.addActor(groupselect);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode) {
        Group group = (Group)stage.getActors().first();
        if(i == 0){
            if(keycode == Input.Keys.NUM_1){
                this.player1 = SelectTank.Select(1);
            } else if (keycode == Input.Keys.NUM_2) {
                this.player1 = SelectTank.Select(2);
            }else if (keycode == Input.Keys.NUM_3) {
                this.player1 = SelectTank.Select(3);
            }

            group.remove();

            Group groupselect = new Group();
            player2Img = new Image(new Texture(Gdx.files.internal("player2.png")));
            player2Img.setName("Player2");
            groupselect.addActor(player2Img);
            stage.addActor(groupselect);
            Gdx.input.setInputProcessor(this);
            i++;
        } else if (i==1) {
            if(keycode == Input.Keys.NUM_1){
                this.player2 = SelectTank.Select(1);
            } else if (keycode == Input.Keys.NUM_2) {
                this.player2 = SelectTank.Select(2);
            }else if (keycode == Input.Keys.NUM_3) {
                this.player2 = SelectTank.Select(3);
            }

            group.remove();

            Group groupplay = new Group();

            Image TerrainImg = Terr.getTerrainImg();
            Image Tank1Img = player1.getTankImg();
            Image Tank2Img = player2.getTankImg();
            Image Resume = new Image(new Texture(Gdx.files.internal("resume.png")));
            Image pause = new Image(new Texture(Gdx.files.internal("pause.png")));
            Image exit = new Image(new Texture(Gdx.files.internal("exit.png")));
            Image vs = new Image(new Texture(Gdx.files.internal("vs.png")));

            TerrainImg.setName("terrain");
            Tank1Img.setName("tank1");
            Tank2Img.setName("tank2");



            groupplay.addActor(TerrainImg);
            groupplay.addActor(Tank1Img);
            groupplay.addActor(Tank2Img);
            groupplay.addActor(Resume);
            groupplay.addActor(pause);
            groupplay.addActor(exit);
            groupplay.addActor(vs);

            stage.addActor(groupplay);
            this.player2.getTankImg().setPosition(1400,0);
            Resume.setPosition(0,600);
            pause.setPosition(0,500);
            vs.setPosition(700,600);
            exit.setPosition(1300,600);
            i++;
        } else if (i==2) {
            Group group1 = (Group)stage.getActors().first();
            Image Tank1 = (Image)group1.findActor("tank1");
            Image Tank2 = (Image)group1.findActor("tank2");

            if(keycode == Input.Keys.RIGHT){
                Tank1.setPosition(Tank1.getX()+3f, Tank1.getY());
            }
            if(keycode == Input.Keys.LEFT){
                Tank1.setPosition(Tank1.getX()-3f, Tank1.getY());
            }
            if(keycode == Input.Keys.UP){
                Tank2.setPosition(Tank2.getX()-3f, Tank2.getY());
            }
            if(keycode == Input.Keys.DOWN){
                Tank2.setPosition(Tank2.getX()+3f, Tank2.getY());
            }
            else if(keycode == Input.Keys.ENTER){
                group.remove();

                Group groupplay = new Group();
                Image congrats = new Image(new Texture(Gdx.files.internal("congrats.png")));
                groupplay.addActor(congrats);
                stage.addActor(groupplay);

            }
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
