package com.gamesfromscratch;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

// inheritance
public class Tank {
    private String img;
    private Image TankImg;
    public Tank(String img){
        this.TankImg = new Image(new Texture(Gdx.files.internal(img)));
    }

    public Image getTankImg() {
        return TankImg;
    }
}
