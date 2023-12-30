import java.io.*; 

public class BoardUtils {

    public static void saveBoardState(BoardState state, File file) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(state);
            System.out.println("Board state saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BoardState loadBoardState(File file) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (BoardState) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
