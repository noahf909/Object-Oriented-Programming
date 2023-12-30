package rewards;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Reward implements Serializable {
    public abstract void draw(Graphics g, int x, int y, int cellSide); 
    
    public abstract void loadImage(); 

}