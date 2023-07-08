package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class ChooseState extends State {

    private Texture background;
    private Texture forward_arrow;
    private Rectangle forward_arrow_bounds;
    private Texture backward_arrow;
    private Rectangle backward_arrow_bounds;
    private Texture selectbtn;
    private Rectangle selectbounds;
    private Texture backbtn;

    private Rectangle backbounds;
    private Texture playermrk;

    public int flag;
    public boolean pflag;


    protected ChooseState(GameStateManager gsm, int flag,boolean pflag) {
        super(gsm);
        this.flag = flag;
        this.pflag = pflag;
        forward_arrow = new Texture("choosetank/rightarrow.png");
        backward_arrow = new Texture("choosetank/leftarrow.png");
        backbtn = new Texture("choosetank/backbtn.png");
        selectbtn = new Texture("choosetank/selectbtn.png");
        if (this.pflag) playermrk = new Texture("choosetank/p1.png");
        if (!this.pflag) playermrk = new Texture("choosetank/p2.png");
        forward_arrow_bounds = new Rectangle(1802, 416, 65, 138);
        backward_arrow_bounds = new Rectangle(56, 416, 65, 138);
        selectbounds = new Rectangle(848, 40, 280, 80);
        backbounds = new Rectangle(72, 864, 153, 58);
        if (this.flag == 1) background = new Texture("choosetank/tank1.png");
        if (this.flag == 2) background = new Texture("choosetank/tank2.png");
        if (this.flag == 3) background = new Texture("choosetank/tank3.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            if (Gdx.input.isTouched()) {
                if (forward_arrow_bounds.contains(Gdx.input.getX(), 1000 - Gdx.input.getY())) {
                    if (this.flag != 3) gsm.set(new ChooseState(gsm, this.flag + 1,this.pflag));
                } else if (backward_arrow_bounds.contains(Gdx.input.getX(), 1000 - Gdx.input.getY())) {
                    if (this.flag != 1) gsm.set(new ChooseState(gsm, this.flag - 1,this.pflag));
                } else if (backbounds.contains(Gdx.input.getX(), 1000 - Gdx.input.getY())) {
                    if (!pflag) {
                        pflag = true;
                        gsm.set(new ChooseState(gsm, this.flag,true));
                        //remove p1 tank choice
                    } else {
                        gsm.set(new MenuState(gsm));
                    }
                } else if (selectbounds.contains(Gdx.input.getX(), 1000 - Gdx.input.getY())) {
                    if (pflag) {
                        pflag = false;
                        gsm.set(new ChooseState(gsm, this.flag,false));
                        //save p1 tank choice
                    } else if (!pflag) {
                        gsm.set(new PlayState(gsm));

                        //save p2 tank choice
                        //go to play state
                    }
                }
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
        sb.draw(background, 0, 0, 1920, 1000);
        sb.draw(backbtn, 72, 864, 153, 58);
        sb.draw(forward_arrow, 1802, 416, 65, 138);
        sb.draw(backward_arrow, 56, 416, 65, 138);
        sb.draw(playermrk, 887, 695, 212, 160);
        sb.draw(selectbtn, 848, 40, 280, 80);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
    }
}

