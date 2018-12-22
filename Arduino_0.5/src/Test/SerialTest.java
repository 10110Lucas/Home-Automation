package Test;

import Arduino.ArduinoSerial;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
// Documentação: https://playground.arduino.cc/Interfacing/Java

/**
 * Classe que le do Arduino dados enviados pelo USB 
 **/
public class SerialTest implements SerialPortEventListener {
	
	@Override
	public void serialEvent(SerialPortEvent arg0) {
		
	}
	
	public static void main(String[] args) throws Exception {
		
		ArduinoSerial arduino = new ArduinoSerial("COM6");
		
		Thread t = new Thread() {
			public void run() {
				
				try {
					arduino.initialize();
					
					while(true) {
						Thread.sleep(700);
						System.out.println(arduino.read());
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
	}
}