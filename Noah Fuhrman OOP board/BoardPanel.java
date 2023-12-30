import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.image.BufferedImage;



public class BoardPanel extends JPanel {

    private static final long serialVersionUID = 1L;


    static final int cols = 32; // Number of columns in the grid
    static final int rows = 32; // Number of rows in the grid
    static final int padding = 20; // Padding in pixels
    static final int windowWidth = 800; // The width of the window
    static final int windowHeight = 800; // The height of the window
    static final int cellSide = (windowWidth - (2 * padding)) / cols; // Calculate the cell side by dividing the available space (window size - padding on both sides) by the number of cells; length of each side
    public final Color DARK_BROWN = new Color(107,48,16);
    public final Color LIGHT_BROWN = new Color(239,134,0); 
    private BoardState boardState; //declare boardState as member variable of BoardState class. 
    private transient BufferedImage entrance; 
    private transient BufferedImage exit;
    private transient BufferedImage rings; 
    private transient BufferedImage wall; 
    private transient BufferedImage blue_sphere;
    private transient BufferedImage star_sphere;
    private transient BufferedImage yellow_sphere;
    private transient BufferedImage green_sphere; 
    
    // Set the originX and originY to padding to start drawing from that point
    static final int originX = padding;
    static final int originY = padding;

    public BoardPanel () {
        boardState = new BoardState(); 
        boardState.initializeNewGame(); //call when starting new game 
         loadLegendImages(); 
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        drawGrid(g); 
        drawLegend(g); 
    }

     private void loadLegendImages() {
        try {
            entrance = ImageIO.read(new File("sprites/sonic.png"));
            exit = ImageIO.read(new File("sprites/emerald.png"));
            rings = ImageIO.read(new File("sprites/ring.png"));
            blue_sphere = ImageIO.read(new File("sprites/blue_sphere.png"));
            wall = ImageIO.read(new File("sprites/red_sphere.png"));
            green_sphere =  ImageIO.read(new File("sprites/green_sphere.png"));
            star_sphere = ImageIO.read(new File("sprites/star_sphere.png"));
            yellow_sphere = ImageIO.read(new File("sprites/yellow_sphere.png"));


        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., use a default image or log an error)
        }
    }

    private void drawGrid(Graphics g) {
        Cell[][] grid = boardState.getGrid(); // Get the grid from BoardState
    
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Cell cell = grid[row][col];
                int x = originX + col * cellSide;
                int y = originY + row * cellSide;
    
                // Alternate colors
                if ((row + col) % 2 == 0) {
                    g.setColor(DARK_BROWN);
                } else {
                    g.setColor(LIGHT_BROWN); 
                }
                g.fillRect(x, y, cellSide, cellSide);
    
                // Draw the cell contents
                if (cell.isEntrance()) {
                    if (entrance != null) {
                        g.drawImage(entrance, x, y, cellSide, cellSide, null);
                    }
                } else if (cell.isExit()) {
                    if (exit != null) {
                        g.drawImage(exit, x, y, cellSide, cellSide, null);
                    }
                } else if (cell.getObstacle() != null) {
                    cell.getObstacle().draw(g, x, y, cellSide);
                } else if (cell.getReward() != null) {
                    cell.getReward().draw(g, x, y, cellSide);
                }
            }
        }
    }    
    

    private void drawLegend(Graphics g) {
        int legendStartX = originX + cols * cellSide + padding; // Start X position of the legend
        int legendStartY = originY; // Start Y position of the legend
        int boxSize = 20; // Size of the color box in the legend
        int lineHeight = 30; // Line height for each item in the legend

        String[] descriptions = {"entrance", "Exit", "Rings (reward)", "Blue Sphere (reward)", "Green Sphere (reward)", "Red Sphere (Wall)", "Star Sphere (obstacle)", "Yellow Sphere (obstacle)"};
        BufferedImage[] images = {entrance, exit, rings, blue_sphere, green_sphere, wall, star_sphere, yellow_sphere};

        g.setColor(Color.BLACK);
        for (int i = 0; i < descriptions.length; i++) {
            g.drawString(descriptions[i], legendStartX + boxSize + 5, legendStartY + i * lineHeight + 15);
            if (images[i] != null) {
                g.drawImage(images[i], legendStartX, legendStartY + i * lineHeight, boxSize, boxSize, null);
            }
            else {
                g.fillRect(legendStartX, legendStartY + i * lineHeight, boxSize, boxSize);
            }
            g.setColor(Color.BLACK); // Reset the color for text drawing
        }
    }

    //setters and getters for boardstate
    public BoardState getBoardState () {
        return this.boardState; 
    }
    
    public void setBoardState (BoardState state) {
        this.boardState = state; 
        repaint(); //repaint to reflect new state. 
    }
}
