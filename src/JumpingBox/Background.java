package JumpingBox;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
	private BufferedImage background_sky;
	private BufferedImage background_mountain;
	private BufferedImage background_clounds;
	private int x1, x2, y;
	public Background() throws IOException {
		background_sky = ImageIO.read(new File("\\Users\\User\\Desktop\\Javapro\\Bai_Tap_Lon_CongNgheJava\\src\\images\\sky_parallax_background.png"));
		background_clounds = ImageIO.read(new File("\\Users\\User\\Desktop\\Javapro\\Bai_Tap_Lon_CongNgheJava\\src\\images\\clouds_parallax_background.png"));
		background_mountain = ImageIO.read(new File("\\Users\\User\\Desktop\\Javapro\\Bai_Tap_Lon_CongNgheJava\\src\\images\\mountain_parallax_background.png"));
		x1 = 0;
        y = 0;
        x2 = x1 + 600;
	}
	public void Paint(Graphics2D g) {
		g.drawImage(background_sky, x1, y, 600, 400, null);
		g.drawImage(background_mountain, x1, y, 600, 400, null);
		g.drawImage(background_clounds, x1, y, 600, 400, null);
		g.drawImage(background_sky, x2, y, 600, 400, null);
		g.drawImage(background_mountain, x2, y, 600, 400, null);
		g.drawImage(background_clounds, x2, y, 600, 400, null);
    }
	public void Update() {
        x1 -= 2;
        x2 -= 2;
        if(x2 < 0) x1 = x2 + 600;
        if(x1 < 0) x2 = x1 + 600;
    }
}
