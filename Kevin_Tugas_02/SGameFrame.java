import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SGameFrame extends JFrame{

	SGameFrame(){
		GamePanel panel = new GamePanel();

		this.add(new GamePanel());
		this.setTitle("Snake");
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		JFrame frame = new JFrame();
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				
					String pesanterimakasih = "Terima Kasih telah mencoba proyek saya!\n\nNama: Kevin Adiputra Mahesa\nNim: 09011282328115\nKelas: SK1A\nSumber pengetahuan: youtube, Chrome, Chat Gpt";
					JOptionPane.showMessageDialog(frame, pesanterimakasih);
					System.out.println(pesanterimakasih);
				
				System.exit(0);
			}
		});
	}
}