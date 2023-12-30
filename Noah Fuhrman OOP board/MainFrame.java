import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.io.File;

public class MainFrame extends JFrame {
    private BoardPanel boardPanel; // Reference to BoardPanel

    public MainFrame() {
        setLayout(new BorderLayout()); 

        // Initialize and add the BoardPanel
        boardPanel = new BoardPanel(); 
        add(boardPanel, BorderLayout.CENTER); // Add BoardPanel to the frame

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Vertical layout

        setTitle("Get the Blue Spheres");
        setSize(800, 800);

        // Buttons for serialization  
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");
        buttonPanel.add(saveButton); 
        buttonPanel.add(loadButton); 

        saveButton.addActionListener(e -> saveBoard());
        loadButton.addActionListener(e -> loadBoard());

        // Add the buttonPanel to the right side (EAST) of the frame
        add(buttonPanel, BorderLayout.EAST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void saveBoard() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save"); 

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            BoardUtils.saveBoardState(boardPanel.getBoardState(), fileToSave);
        }
    }

    
    private void loadBoard() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a file to load");
    
        int userSelection = fileChooser.showOpenDialog(this);
    
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToLoad = fileChooser.getSelectedFile();
            BoardState loadedState = BoardUtils.loadBoardState(fileToLoad);
            if (loadedState != null) {
                boardPanel.setBoardState(loadedState); // Set the loaded state
                boardPanel.repaint(); // Repaint the panel to update the display
            }
        }
    }
    
}
