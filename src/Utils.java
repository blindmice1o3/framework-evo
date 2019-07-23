import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Utils {

    public static BufferedImage loadImage(String path) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(Utils.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

}