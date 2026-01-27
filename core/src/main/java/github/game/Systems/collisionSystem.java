package github.game.Systems;

import github.game.Entities.Player;

public class collisionSystem {

    private final float screenWidth;
    private final float screenHeight;

    public collisionSystem(float h, float w){

        this.screenHeight = h;
        this.screenWidth = w;

    }

    public Boolean canMove(Player p, Vector2 v,float delta){

        float x = p.getX() + v.getX() * p.getSpeed() * delta;
        float y = p.getY() + v.getY() * p.getSpeed() * delta;


        if(x <0) return false;
        if(y <0) return false;
        if(x + p.getWidth() > this.screenWidth) return false;
        if(y + p.getHeight() > this.screenHeight) return false;

        return true;
    }
    
}
