package github.game.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import github.game.Systems.Vector2;


public class Player {

    private float x;
    private float y;
    private float height = 70;
    private float width = 40;
    private float speed = 100f;
    private boolean facingLeft = true;
    
    //Animations attributes 
    private Texture spriteSheet;
    private TextureRegion currentFrame;
    private Animation<TextureRegion> standingAnimation;
    private Animation<TextureRegion> walkingAnimation;
    private Animation<TextureRegion> runningAnimation;
    private Animation<TextureRegion> jumpingAnimation;
    private Animation<TextureRegion> fallingAnimation;
    private Animation<TextureRegion> hittingAnimation;
    private Animation<TextureRegion> dyingAnimation;
    private TextureRegion[][] sheet;
    
    private float stateTime = 0f;

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

        spriteSheet = new Texture("Characters/hero.png");
        sheet = TextureRegion.split(spriteSheet,spriteSheet.getWidth()/10,spriteSheet.getHeight()/7);

        TextureRegion[] standingFrames = new TextureRegion[5];
        for(int i=0; i<5 ; i++){ standingFrames[i]=sheet[0][i];}
        standingAnimation = new Animation<>(0.1f, standingFrames);

        TextureRegion[] walkingFrames = new TextureRegion[8];
        for(int i=0;i<8;i++){walkingFrames[i]=sheet[1][i];}
        walkingAnimation = new Animation<>(0.06f, walkingFrames);

        TextureRegion[] runningFrames = new TextureRegion[8];
        for(int i=0;i<8;i++){runningFrames[i]=sheet[2][i];}
        runningAnimation = new Animation<>(0.375f, runningFrames);

        TextureRegion[] dyingFrames = new TextureRegion[10];
        for(int i=0;i<10;i++){dyingFrames[i]=sheet[6][i];}
        dyingAnimation = new Animation<>(0.3f, dyingFrames);

        currentFrame = standingAnimation.getKeyFrame(0);

    }

    public void update(float delta,Boolean isMoving,Vector2 v){

        stateTime += delta;

        if(v.getX()<0 && !facingLeft){this.facingLeft =true;flipFrames();}
        else if(v.getX()>0 && facingLeft){this.facingLeft = false;flipFrames();}

        if(isMoving){currentFrame = walkingAnimation.getKeyFrame(stateTime,true);

        }else{currentFrame = standingAnimation.getKeyFrame(stateTime,true);}  
    
    }


    public void flipFrames(){

        for(TextureRegion frame :walkingAnimation.getKeyFrames()){frame.flip(true,false);}

        for(TextureRegion frame : standingAnimation.getKeyFrames()){frame.flip(true,false);}

    }

    public void draw(SpriteBatch batch){

        batch.draw(currentFrame,x,y);

    }


    
}
