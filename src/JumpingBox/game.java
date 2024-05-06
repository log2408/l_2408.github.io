package JumpingBox;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.Timer;
import javax.imageio.ImageIO;

import gameFrame.AFrameOnImage;
import gameFrame.Animation;
import gameFrame.gameScreen;
public class game extends gameScreen{
	private Box box;
	private BufferedImage cha_run;
	private BufferedImage cha_double_jump;
	private Animation box_anim;
	private Animation double_jump;
	private BufferedImage jump;
	private BufferedImage fall;
	private Timer gameTimer;
	private Background bg;
	private StoneGroup st;
	private stoneStart stStart;
	
	private int BEGIN_SCREEN = 0;
    private int GAMEPLAY_SCREEN = 1;
    private int GAMEOVER_SCREEN = 2;
    private int CurrentScreen = BEGIN_SCREEN;
    private BufferedImage start;
    private BufferedImage over;
    
    private int point;
    
	public game() throws IOException {
		super(600, 425);
		cha_run = ImageIO.read(new File("\\Users\\User\\Desktop\\Javapro\\Bai_Tap_Lon_CongNgheJava\\src\\images\\Run (32x32).png"));
		
		box_anim = new Animation(20);
		box_anim.addFrame(new AFrameOnImage(6, 0, 25, 32));
		box_anim.addFrame(new AFrameOnImage(38, 0, 25, 32));
		box_anim.addFrame(new AFrameOnImage(70, 0, 25, 32));
		box_anim.addFrame(new AFrameOnImage(103, 0, 25, 32));
		box_anim.addFrame(new AFrameOnImage(134, 0, 25, 32));
		box_anim.addFrame(new AFrameOnImage(166, 0, 25, 32));
		box_anim.addFrame(new AFrameOnImage(198, 0, 25, 32));
		box_anim.addFrame(new AFrameOnImage(230, 0, 25, 32));
		box_anim.addFrame(new AFrameOnImage(262, 0, 25, 32));
		box_anim.addFrame(new AFrameOnImage(293, 0, 25, 32));
		box_anim.addFrame(new AFrameOnImage(326, 0, 25, 32));
		box_anim.addFrame(new AFrameOnImage(358, 0, 25, 32));
		
		box = new Box(100, 0, 25, 32);
		
		bg = new Background();
		
		stStart = new stoneStart(100, 300, 516, 62);
		
		cha_double_jump = ImageIO.read(new File("\\Users\\User\\Desktop\\Javapro\\Bai_Tap_Lon_CongNgheJava\\src\\images\\Double Jump (32x32).png"));
		double_jump = new Animation(60);
		double_jump.addFrame(new AFrameOnImage(6, 0, 27, 32));
		double_jump.addFrame(new AFrameOnImage(37, 0, 27, 32));
		double_jump.addFrame(new AFrameOnImage(69, 0, 27, 32));
		double_jump.addFrame(new AFrameOnImage(100, 0, 27, 32));
		double_jump.addFrame(new AFrameOnImage(131, 0, 27, 32));
		double_jump.addFrame(new AFrameOnImage(163, 0, 27, 32));
		
		jump = ImageIO.read(new File("\\Users\\User\\Desktop\\Javapro\\Bai_Tap_Lon_CongNgheJava\\src\\images\\Jump (32x32).png"));
		fall = ImageIO.read(new File("\\Users\\User\\Desktop\\Javapro\\Bai_Tap_Lon_CongNgheJava\\src\\images\\Fall (32x32).png"));
				
		st = new StoneGroup();
		
		start = ImageIO.read(new File("\\Users\\User\\Desktop\\Javapro\\Bai_Tap_Lon_CongNgheJava\\src\\images\\startGame.png"));
		over = ImageIO.read(new File("\\Users\\User\\Desktop\\Javapro\\Bai_Tap_Lon_CongNgheJava\\src\\images\\gameOver.png"));
		
		gameTimer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameUpdate();
                repaint();
            }
        });
        gameTimer.start();
	}
	public void resetGame() {
		box.setX(100);
	    box.setY(0);
	    box.setJump(false);
	    box.setSpeed(0);
	    stStart.reset();
	    st.reset();
	    point = 0;
	}
	public void gameUpdate() {
		if(CurrentScreen == BEGIN_SCREEN) {
            resetGame();
        } else if(CurrentScreen == GAMEPLAY_SCREEN) {
        	point++;
        	box_anim.update();
    	    if(box.getRect().intersects(stStart.getRect())) {
    	    	box.update(stStart.getY() - (int)box.getH());
    	    } else {
    	    	box.update(400);
    	    }
    	    st.collide(box);
    	    double_jump.update();
    	    bg.Update();
    	    st.update();
    	    stStart.update();
    	    if(box.getY() == 400) {
    	    	CurrentScreen = GAMEOVER_SCREEN;
    	    }
        } else {
            
        }
	}
	@Override
	public void draw(Graphics2D g) {
		bg.Paint(g);
		stStart.draw(g);
		if(box.isJump() == true) {
			if(box.getSpeed() > 0) {
				if(box.JumpCount() == 2) {
					double_jump.paintAnim(box.getX(), box.getY(), cha_double_jump, g);
				} else {
					g.drawImage(jump, box.getX(), box.getY(), 32, 32, null);
				}
			} else {
				g.drawImage(fall, box.getX(), box.getY(), 32, 32, null);
			}
		} else {
			box_anim.paintAnim(box.getX(), box.getY(), cha_run, g);
			double_jump.reset();
			box.resetJump();
		}
		if(CurrentScreen == BEGIN_SCREEN) {
            g.drawImage(start, 200, 150, 200, 31, null);
        }
        if(CurrentScreen == GAMEOVER_SCREEN) {
        	g.drawImage(over, 189, 10, 223, 226, null);
        }
        Font font = new Font("Arial", Font.BOLD, 16);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("POINT: " + point, 20, 50);
		st.draw(g);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(CurrentScreen == BEGIN_SCREEN) {
				CurrentScreen = GAMEPLAY_SCREEN;
			} else if(CurrentScreen == GAMEPLAY_SCREEN) {
				if(box.JumpCount() < 2) {
					box.setJump(true);
					box.setSpeed(15);
					box.jump();
				}
			} else if(CurrentScreen == GAMEOVER_SCREEN){
                CurrentScreen = BEGIN_SCREEN;
            }
		}
	}
	public static void main(String[] args) throws IOException {
		game g = new game();
		g.create();
	}
}
