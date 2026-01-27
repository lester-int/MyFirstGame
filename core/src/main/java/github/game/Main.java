package github.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import github.game.Entities.Player;
import github.game.Systems.MovementSystem;
import github.game.Systems.Vector2;
import github.game.Systems.collisionSystem;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    private  float screenHeight;
    private  float screenWidth;
    private Player player;
    private collisionSystem collisionSystem;
    private MovementSystem movementSystem;
    private SpriteBatch batch;
    private Texture TexturePlayer;

    @Override
    public void create() {

        this.screenHeight = Gdx.graphics.getHeight();
        this.screenWidth = Gdx.graphics.getWidth();
        batch = new SpriteBatch();
        this.player = new Player(100,300);
        this.collisionSystem = new collisionSystem(this.screenHeight,this.screenWidth);
        this.movementSystem = new MovementSystem();

    }

    @Override
    public void render() {

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        float delta = Gdx.graphics.getDeltaTime();

        Vector2 v = movementSystem.direction();

        if(collisionSystem.canMove(this.player,v,delta)){movementSystem.apply(this.player,v,delta);}
        
        boolean isMoving = v.getX() !=0 || v.getY() !=0;

        player.update(delta,isMoving,v);

        batch.begin();
        player.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
