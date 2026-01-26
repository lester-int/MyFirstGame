package github.game.Entities;

public class Player {

    private float x;
    private float y;
    private float height = 70;
    private float width = 40;
    private float speed = 100f;

    public float getX(){return x;}
    public float getY(){return y;}
    public float getSpeed(){return this.speed;}
    public float getWidth(){return this.width;}
    public float getHeight(){return this.height;}

    public void setX(float x){ this.x = x;}
    public void  setY(float y){ this.y = y;}
    public void setSpeed(float s){this.speed = s;}

    public Player(float x ,float y){

        this.x = x;
        this.y = y;

    }
    
}
