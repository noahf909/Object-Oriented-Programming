import java.io.Serializable;
import java.awt.Color;
import obstacles.Obstacle;
import rewards.Reward;

public class Cell implements Serializable  {
    private boolean topWall;
    private boolean bottomWall;
    private boolean leftWall;
    private boolean rightWall;
    private boolean isEntrance = false;
    private boolean isExit = false;
    private Color color; // Add a color attribute
    private boolean occupied = false;
    private Obstacle obstacle; 
    private Reward reward; 

    
    // Constructor
    public Cell() {
        topWall = false;
        bottomWall = false;
        leftWall = false;
        rightWall = false;
    }

    // Getters and setters 
    // topWall: wall, 
    public boolean hasTopWall() {
        return topWall;
    }

    public boolean hasBottomWall() {
        return bottomWall; 
    }

    public void setTopWall(boolean topWall) {
        this.topWall = topWall;
    }

    public void setBottomWall(boolean bottomWall) {
        this.bottomWall = bottomWall; 
    }

    public boolean hasLeftWall() {
        return leftWall; 
    }

     public void setLeftWall(boolean leftWall) {
        this.leftWall = leftWall; 
    }

    
    public boolean hasRightWall() {
        return rightWall; 
    }

     public void setRightWall(boolean rightWall) {
        this.rightWall = rightWall; 
    }


     // Methods for entrance and exit
     public boolean isEntrance() {
        return isEntrance;
    }

    public void setEntrance(boolean isEntrance) {
        this.isEntrance = isEntrance;
    }

    public boolean isExit() {
        return isExit;
    }

    public void setExit(boolean isExit) {
        this.isExit = isExit;
    }

    // Getter and setter for the color
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    // Method to mark the cell as occupied
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    // Method to check if the cell is occupied
    public boolean isOccupied() {
        return occupied;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle; 
    }
    
    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setReward(Reward reward) {
        this.reward = reward; 
    }
    
    public Reward getReward() {
        return reward; 
    }
}
