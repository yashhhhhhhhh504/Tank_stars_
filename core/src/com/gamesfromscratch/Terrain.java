package com.gamesfromscratch;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

// Design pattern : Singleton Class
public class Terrain {
    private static Terrain land = null;
    private Image TerrainImg = new Image(new Texture(Gdx.files.internal("Terrain.png")));
    private Terrain(){

    }

    public Image getTerrainImg() {
        return TerrainImg;
    }

    public static Terrain getInstance(){
        if(land == null){
            land = new Terrain();
        }
        return land;
    }
}
