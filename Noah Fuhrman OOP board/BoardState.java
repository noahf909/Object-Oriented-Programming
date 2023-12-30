import java.util.Random;
import java.io.Serializable;
import obstacles.Wall; 
import obstacles.Branch; 
import obstacles.Thorn; 
import rewards.Coin; 
import rewards.IceCream; 
import rewards.Broccoli; 

public class BoardState implements Serializable {
    private static final long serialVersionUID = 1L; 
    private int rows = 32;
    private int cols = 32;
    private int totalWalls = 256;
    private int totalBranches = 16; 
    private int totalThornes = 16; 
    private int coins = 16; 
    private int broccoli = 16; 
    private int iceCream = 16; 
    private Cell[][] grid; 

    public BoardState() {
        grid = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public void initializeNewGame() {
        setupBoard(); 
    }

    public void setupBoard() {
        Random rand = new Random();
        // Set entrance and exit on the border
        grid[0][rand.nextInt(cols)].setEntrance(true); // Entrance (randomized)
        grid[rows - 1][rand.nextInt(cols)].setExit(true); // Exit (randomized)

        // Randomly place walls on the grid
        placeRandomWalls(rand);

        // randomly place branches on the grid
        placeRandomBranches(rand); 

        //randomly place thorns on the grid
        placeRandomThorns(rand); 

        // Randomly place rewards, 16 of each color
        placeCoins(rand);
        placeBroccoli(rand);
        placeIceCream(rand);
    }

    private void placeRandomWalls(Random rand) {
        int wallsPlaced = 0;
        while (wallsPlaced < totalWalls) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
    
            Cell cell = grid[r][c];
            if (!cell.isOccupied() && !cell.isEntrance() && !cell.isExit()) {
                cell.setObstacle(new Wall());
                cell.setOccupied(true);
                wallsPlaced++;
            }
        }
    }

    private void placeRandomBranches(Random rand) {
        int branchesPlaced = 0;
        while (branchesPlaced < totalBranches) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols - 1); //avoid border
    
            Cell cell = grid[r][c];
            if (!cell.isOccupied() && !cell.isEntrance() && !cell.isExit()) {
                cell.setObstacle(new Branch());
                cell.setOccupied(true);
                branchesPlaced++;
            }
        }
    }
    

    private void placeRandomThorns(Random rand) {
        int thornsPlaced = 0;
        while (thornsPlaced < totalThornes) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols - 1) + 1; // Avoid the leftmost column
    
            Cell cell = grid[r][c];
            if (!cell.isEntrance() && !cell.isExit() && !cell.hasLeftWall() && !cell.isOccupied()) {
                cell.setObstacle(new Thorn());
                cell.setOccupied(true); 
                thornsPlaced++;
            }
        }
    }
    
    private void placeCoins(Random rand) {
        int coinsPlaced = 0;
        while (coinsPlaced < coins) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
    
            Cell cell = grid[r][c];
            if (!cell.isEntrance() && !cell.isExit() && !cell.isOccupied()) {
                cell.setReward(new Coin());
                cell.setOccupied(true);
                coinsPlaced++;
            }
        }
    }
    

    private void placeBroccoli(Random rand) {
        int broccoliPlaced = 0;
        while (broccoliPlaced < broccoli) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
    
            Cell cell = grid[r][c];
            if (!cell.isEntrance() && !cell.isExit() && !cell.isOccupied()) {
                cell.setReward(new Broccoli());
                cell.setOccupied(true);
                broccoliPlaced++;
            }
        }
    }


    private void placeIceCream(Random rand) {
        int iceCreamPlaced = 0;
        while (iceCreamPlaced < iceCream) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
    
            Cell cell = grid[r][c];
            if (!cell.isEntrance() && !cell.isExit() && !cell.isOccupied()) {
                cell.setReward(new IceCream());
                cell.setOccupied(true);
                iceCreamPlaced++;
            }
        }
    }

    public Cell[][] getGrid() {
        return grid;
    }
}
