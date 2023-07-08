package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.MyGdxGame;
import org.w3c.dom.css.Rect;

import java.awt.*;

public class ExitState extends State{
    private Texture background;
    private Texture yesbtn;
    private Texture nobtn;
    private Rectangle yesbounds;
    private Rectangle nobounds;

    protected ExitState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("mainexit/mainexit.png");
        yesbtn = new Texture("mainexit/yesbtn.png");
        nobtn = new Texture("mainexit/nobtn.png");
        yesbounds = new Rectangle(689 , 334 , 194 , 80);
        nobounds = new Rectangle(1044 , 334 , 194 , 80);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.isTouched()) {
            if (yesbounds.contains(Gdx.input.getX(), 1000 - Gdx.input.getY())) {
                System.exit(0);
            }
            else if (nobounds.contains(Gdx.input.getX(), 1000 - Gdx.input.getY())) {
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
        sb.draw(background , 0, 0, 1920, 1000);
        sb.draw(yesbtn , 689 , 334 , 194 , 80);
        sb.draw(nobtn , 1044 , 334 , 194 , 80);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
    }
}
