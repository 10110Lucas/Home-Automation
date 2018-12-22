package View;

import java.awt.EventQueue;
import java.io.Serializable;

public class AppArduino implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public AppArduino(){}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Leitura frame = new Leitura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}