package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.mygdx.game.MyGdxGame;

import java.awt.*;

public class LoadState extends State{
    private Texture background,backbtn,savgbtn1,savgbtn2,savgbtn3;
    private Rectangle backbounds,savgbounds1,savgbounds2,savgbounds3;

    protected LoadState(GameStateManager gsm) {
        super(gsm);
        background=new Texture("savedgame/savedgame.png");
        backbtn=new Texture("savedgame/backbtn.png");
        savgbtn1=new Texture("savedgame/saved game screen 1.png");
        savgbtn2=new Texture("savedgame/saved game screen 2.png");
        savgbtn3=new Texture("savedgame/saved game screen 3.png");
        backbounds=new Rectangle(46,909,153,58);
        savgbounds1=new Rectangle(160,69,416,779);
        savgbounds2=new Rectangle(753,69,416,779);
        savgbounds3=new Rectangle(1346,69,416,779);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.isTouched()) {
            if (backbounds.contains(Gdx.input.getX(), 1000 - Gdx.input.getY())) {
                gsm.set(new MenuState(gsm));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0,MyGdxGame.WIDTH,MyGdxGame.HEIGHT);
        sb.draw(backbtn,46,909,153,58);
        sb.draw(savgbtn1,160,69,416,779);
        sb.draw(savgbtn2,753,69,416,779);
        sb.draw(savgbtn3,1346,69,416,779);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
    }
}
