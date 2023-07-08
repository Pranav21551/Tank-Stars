package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.MyGdxGame;

public class MenuState extends State {
    private Texture background;
    private Texture exitbtn;
    private Texture multibtn;
    private Texture singlbtn;
    private Texture loadbtn;
    private Rectangle multibounds;
    private Rectangle singlbounds;
    private Rectangle loadbounds;
    private Rectangle exitbounds;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("mainmenu/mainmenu.png");
        singlbtn = new Texture("mainmenu/singlbtn.png");
        multibtn = new Texture("mainmenu/multibtn.png");
        loadbtn = new Texture("mainmenu/loadbtn.png");
        exitbtn = new Texture("mainmenu/exitbtn.png");
        singlbounds = new Rectangle(64, 614, 521, 96);
        multibounds = new Rectangle(64, 458, 521, 96);
        loadbounds = new Rectangle(64, 302, 521, 96);
        exitbounds = new Rectangle(64, 146, 521, 96);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isTouched()) {
            if (multibounds.contains(Gdx.input.getX(), 1000 - Gdx.input.getY())) {
                gsm.set(new ChooseState(gsm, 1,true));
            } else if (loadbounds.contains(Gdx.input.getX(), 1000 - Gdx.input.getY())) {
                gsm.set(new LoadState(gsm));
            } else if (exitbounds.contains(Gdx.input.getX(), 1000 - Gdx.input.getY())) {
                gsm.set(new ExitState(gsm));
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
        sb.draw(background, 0, 0, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        sb.draw(singlbtn, 64, 614, 521, 96);
        sb.draw(multibtn, 64, 458, 521, 96);
        sb.draw(loadbtn, 64, 302, 521, 96);
        sb.draw(exitbtn, 64, 146, 521, 96);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
    }
}
