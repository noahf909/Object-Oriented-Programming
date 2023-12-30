package rewards;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Coin extends Reward {
    private transient BufferedImage image;
    private static final long serialVersionUID = 1L;

    public Coin() {
        loadImage();
    }

    public void loadImage() {
        try {
            image = ImageIO.read(new File("sprites/ring.png"));
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., use a default image or log an error)
        }
    }

    @Override
    public void draw(Graphics g, int x, int y, int cellSide) {
        if (image != null) {
            g.drawImage(image, x, y, cellSide, cellSide, null);
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        loadImage();
    }
}
