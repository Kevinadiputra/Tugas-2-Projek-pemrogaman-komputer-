import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements ActionListener{

	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
	static final int DELAY = 100;
	final int x[] = new int [GAME_UNITS];
	final int y[] = new int [GAME_UNITS];
	int bodyParts = 6;
	int applesEaten;
	int appleX;
	int appleY;
	char direction = 'R';
	boolean running = false;
	Timer timer;
	Random random;
	JFrame frame = new JFrame();


	GamePanel(){

		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();


	}
	public void startGame(){

		newApple();
		running = true;


		timer = new Timer(DELAY,this);
		timer.start();

	}
	public void paintComponent(Graphics g){

		super.paintComponent(g);
		draw(g);

	}
	public void draw(Graphics g){

		if(running){
			// garis(ubah menjadi comand untuk menghilangkan garis)start
			for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++){
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			}
			// garis end
			g.setColor(Color.red);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

			for(int i = 0; i< bodyParts;i++){
				if(i == 0){
					g.setColor(Color.green);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
				else{
					g.setColor(new Color(45,180,0));
					g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);

				}
			}
			g.setColor(Color.red);
		g.setFont(new Font("Hack", Font.BOLD, 40));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Score: "+ applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: "+ applesEaten))/2, g.getFont().getSize());
		}
		else {
			gameOver(g);
		}

	}
	public void newApple(){

		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;

	}
	public void move(){

		for(int i = bodyParts;i>0;i--){
			x[i] = x[i-1];
			y[i] = y[i-1];
		}

		switch(direction){
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;	
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;	
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;	
		}


	}
	public void checkApple(){

		if((x[0]==appleX) && (y[0]==appleY) ){
			bodyParts++;
			applesEaten++;
			newApple();
		}

	}
	public void checkCollisions(){
		// cek jika kepala bertemu dengan tubuh
		for(int i = bodyParts;i>0;i--){
			if((x[0]==x[i])&& (y[0] == y[i])){
				running = false;
			}
		}
		// cek jika kepala menyentuh border kiri
		if(x[0]<0){
			running = false;
		}
		// cek jika kepala menyentuh border kanan
		if(x[0]>SCREEN_WIDTH){
			running = false;
		}
		// cek jika kepala menyentuh border atas
		if(y[0]<0){
			running = false;
		}
		// cek jika kepala menyentuh boder bawah
		if(y[0]>SCREEN_HEIGHT){
			running = false;
		}

		if (!running){
			timer.stop();
		}


	}
	public void gameOver(Graphics g){
		// score
		g.setColor(Color.red);
		g.setFont(new Font("Hack", Font.BOLD, 40));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score: "+ applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+ applesEaten))/2, g.getFont().getSize());
		

		// Game over text
		g.setColor(Color.red);
		g.setFont(new Font("Hack", Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);

		// Mulai Ulang
		g.setColor(Color.red);
		g.setFont(new Font("Hack", Font.BOLD, 20));
		g.drawString("Tekan spasi untuk Mulai ulang", SCREEN_WIDTH/4, SCREEN_HEIGHT/2+50);

		

	}
	public void resetGame(){
		bodyParts = 6;
		applesEaten = 0;
		direction = 'R';
		running = true;
		newApple();

		x[0]= SCREEN_WIDTH/2 -(SCREEN_WIDTH/2 % UNIT_SIZE);
		y[0]= SCREEN_HEIGHT/2 - (SCREEN_HEIGHT/2 % UNIT_SIZE);

		for(int i=1;i<bodyParts;i++){
			x[i]=x[0]-1*UNIT_SIZE;
			y[i]=y[0];
		}
		startGame();
	}
	@Override
	public void actionPerformed(ActionEvent e){

		if(running){
			move();
			checkApple();
			checkCollisions();
		}
		repaint();

	}

	public class MyKeyAdapter extends KeyAdapter{
		// @Override
		public void keyPressed(KeyEvent e){

			if(e.getKeyCode()==KeyEvent.VK_SPACE && !running){
				resetGame();
				repaint();
			}

			switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT:
				if(direction !='R'){
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction !='L'){
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if(direction !='D'){
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction !='U'){
					direction = 'D';
				}
				break;			
			}

		}

	}
}