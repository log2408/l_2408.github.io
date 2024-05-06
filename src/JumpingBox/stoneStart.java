package JumpingBox;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameFrame.Obj_game;

public class stoneStart extends Obj_game{
	private BufferedImage img;
	private Rectangle rect;
	public stoneStart(int x, int y, int w, int h) throws IOException {
		super(x, y, w, h);
		rect = new Rectangle(x, y, w, h);
		img = ImageIO.read(new File("\\Users\\User\\Desktop\\Javapro\\Bai_Tap_Lon_CongNgheJava\\src\\images\\stStart.png"));
	}
	public void update() {
        setX(getX() - 2);
        rect.setLocation((int)this.getX(), (int)this.getY());
    }
	public void reset() {
		setX(100);
        setY(300);
        setW(516); 
        setH(62);
        rect.setLocation((int)this.getX(), (int)this.getY());
	}
	public void draw(Graphics2D g) {
		g.drawImage(img, getX(), getY(), 516, 62, null);
	}
	public Rectangle getRect() {
		return rect;
	}
	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
}
