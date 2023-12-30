package obstacles;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Obstacle implements Serializable{
    public abstract void draw(Graphics g, int x, int y, int cellSide); 
    public abstract void loadImage();
}
