import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        //Open file chooser dialogue
        JFileChooser fileChooser = new JFileChooser();
        //TO-DO implement file type checking via a FileFilter

        String folderPath = "";
        int y = fileChooser.showOpenDialog(null);
        if (y == JFileChooser.APPROVE_OPTION) {
            folderPath = fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            System.exit(1);
        }

        //Load the image
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(folderPath));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        //Create the ImageIcon
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(imageIcon);

        //Setup and display the JFrame
        JFrame frame = new JFrame("Java Image Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(imageLabel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

