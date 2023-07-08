package com.mygdx.game.States;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


public class PlayState extends State {
    private OrthogonalTiledMapRenderer tmr;
    private TiledMap map;
    private OrthographicCamera camera;
    private Texture bg;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        map = new TmxMapLoader().load("map/biggiesmalls.tmx");
        tmr = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1000);
        bg = new Texture("playstate/playbg.jpg");
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
        tmr.setView(camera);
    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        sb.begin();
        sb.draw(bg,0,0,1920,1000);
        sb.end();
        tmr.render();

    }

    @Override
    public void dispose() {
        tmr.dispose();
        map.dispose();
    }

}
