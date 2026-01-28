package github.game.Systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import github.game.Entities.Player;

public class MovementSystem {

    public Vector2 direction(){

        float x = 0;
        float y = 0;

        if(Gdx.input.isKeyPressed(Input.Keys.A)) x-=1;
        if(Gdx.input.isKeyPressed(Input.Keys.D)) x+=1;

        return new Vector2(x,y);

    }

    public void apply(Player p, Vector2 v, float delta){

        p.setX(p.getX() + v.getX() * p.getSpeed() * delta);

    }
    
}
