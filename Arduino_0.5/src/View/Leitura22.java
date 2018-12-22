package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Arduino.ArduinoSerial;
import Model.Arduino;
import Service.ArduinoService;
import gnu.io.CommPortIdentifier;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Leitura22 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ArduinoSerial arduino;
	int HH = 00, mm = 00, ss = 00;
	String date = "";
	String tempo = "" + HH + ":" + mm +":" + ss;
	String porta = "";
	String leitura;
	int luminosidade = 0;
	double consumo;
	double v = 0.2084, i = 0.019;//1000  40.10^(-3)  1,234
	double potencia = v * i;
	int a = 0;
	int brilho = 0;
	int media = 0;
	
	public Leitura22() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("  Consumo");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lucas\\Downloads\\Projeto Inegrado\\Projeto Inegrado\\imagens\\favicon.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 315);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel painelSensorLuz = new JLabel("Sensor de Luz: Desativado.");
		painelSensorLuz.setForeground(Color.WHITE);
		painelSensorLuz.setBackground(Color.LIGHT_GRAY);
		painelSensorLuz.setFont(new Font("Tahoma", Font.PLAIN, 14));
		painelSensorLuz.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setMnemonic('I');
		btnIniciar.setForeground(Color.WHITE);
		btnIniciar.setBackground(new Color(0, 0, 0));
		btnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		JButton btnParar = new JButton("Parar");
		btnParar.setMnemonic('P');
		btnParar.setBackground(new Color(0, 0, 0));
		btnParar.setForeground(Color.WHITE);
		
		
		JLabel lblTempo = new JLabel("Duracao: 00 : 00 : 00");
		lblTempo.setForeground(Color.WHITE);
		lblTempo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTempo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel data = new JLabel("Tempo");
		data.setForeground(Color.WHITE);
		data.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		data.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel labelConsumo = new JLabel("Consumo:");
		labelConsumo.setForeground(Color.WHITE);
		labelConsumo.setHorizontalAlignment(SwingConstants.LEFT);
		labelConsumo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel labelLuz = new JLabel("Luminosidade:");
		labelLuz.setForeground(Color.WHITE);
		labelLuz.setHorizontalAlignment(SwingConstants.LEFT);
		labelLuz.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel labelPotencia = new JLabel("Potencia:");
		labelPotencia.setForeground(Color.WHITE);
		labelPotencia.setHorizontalAlignment(SwingConstants.LEFT);
		labelPotencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel painelMovimento = new JLabel("Sensor Movimento: Desativado.");
		painelMovimento.setHorizontalAlignment(SwingConstants.LEFT);
		painelMovimento.setForeground(Color.WHITE);
		painelMovimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		painelMovimento.setBackground(Color.LIGHT_GRAY);
		
		JLabel painel = new JLabel("Botao de Luz: Desativado.");
		painel.setHorizontalAlignment(SwingConstants.LEFT);
		painel.setForeground(Color.WHITE);
		painel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		painel.setBackground(Color.LIGHT_GRAY);
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel painelMovimentando = new JLabel("Percorrendo:");
		painelMovimentando.setHorizontalAlignment(SwingConstants.LEFT);
		painelMovimentando.setForeground(Color.WHITE);
		painelMovimentando.setFont(new Font("Tahoma", Font.PLAIN, 13));
		painelMovimentando.setBackground(Color.LIGHT_GRAY);
		
		JLabel painelMovimentado = new JLabel("Ultimo Movimento:");
		painelMovimentado.setHorizontalAlignment(SwingConstants.LEFT);
		painelMovimentado.setForeground(Color.WHITE);
		painelMovimentado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		painelMovimentado.setBackground(Color.LIGHT_GRAY);
		
		JLabel painelBrilho = new JLabel("Brilho:");
		painelBrilho.setHorizontalAlignment(SwingConstants.LEFT);
		painelBrilho.setForeground(Color.WHITE);
		painelBrilho.setFont(new Font("Tahoma", Font.PLAIN, 13));
		painelBrilho.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(painel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 493, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(painelBrilho, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(painelMovimentando, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(painelMovimentado, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)))
									.addComponent(lblTempo, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, 493, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnIniciar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btnParar, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(labelConsumo, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(labelLuz, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(labelPotencia, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(11, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(painelMovimento, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
								.addComponent(painelSensorLuz, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(data, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(201))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(34)
							.addComponent(painel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addComponent(data, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(painelMovimento, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(painelSensorLuz, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(painelMovimentado, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(painelMovimentando, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(painelBrilho, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblTempo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(labelPotencia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(labelLuz, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(labelConsumo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIniciar)
						.addComponent(btnParar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{painel, data, painelMovimento, painelSensorLuz, separator_1, painelBrilho, painelMovimentando, painelMovimentado, lblTempo, separator, btnIniciar, btnParar, labelConsumo, labelLuz, labelPotencia, lblNewLabel}));
		
		DateFormat hor = new SimpleDateFormat("HH:mm:ss dd/MM/YYYY");
		DateFormat data2 = new SimpleDateFormat("dd/MM/YYYY");
		arduino = new ArduinoSerial(porta());
		arduino.initialize();
		
		Thread lendoArduino = new Thread() {
			@Override
			public void run() {
				while(true) {
					data.setText(hor.format(new Date()));
					leitura = ""+arduino.read();
					if(leitura == null) {
						System.out.println("Test " + arduino.read());
						arduino.initialize();
								 painel.setText("Botao de Luz: Procurando...");
						painelMovimento.setText("Sensor Movimento: Procurando...");
						painelSensorLuz.setText("Sensor de Luz: Procurando...");
					}else {
						//label que estiver rodando os valores do arduino						
						if(leitura.contains("Botao de Luz:")) {
							painel.setText(leitura);
							painelMovimento.setText("Sensor Movimento: Desativado.");
							painelSensorLuz.setText("Sensor de Luz: Desativado.");
						}
						else if(leitura.contains("Sensor Movimento")) {
							painel.setText("Botao de Luz: Desativado.");
							
							int x = leitura.indexOf('S');
							int y = leitura.length();
							String movimento= ""+leitura.substring(x, y);
							painelMovimento.setText(movimento);
							
	//						Sensor Movimento: 3 LEDs Apagados
	//						Brilhando: N Millis: N Time: N Sensor Movimento: 3 LEDs Ativados
	//		a = 10          123456789a123456789a123456789a123456789a123456789a123456789a1234
	//						4321a987654321a987654321a987654321a987654321a987654321a987654321
							
							painelSensorLuz.setText("Sensor de Luz: Desativado.");
						}
						else if(leitura.contains("Sensor de Luz")) {
							painel.setText("Botao de Luz: Desativado.");
							painelMovimento.setText("Sensor Movimento: Desativado.");
							painelSensorLuz.setText(leitura);
						}
						if(leitura.contains("Brilho:")) {
							int x = leitura.indexOf("Brilho: ")+8;
							int y = leitura.indexOf("M")-1;
							String brilho = leitura.substring(x, y);
							painelBrilho.setText("Brilho: " + brilho);
						}
						if(leitura.contains("Millis:")) {
							int x = leitura.indexOf("s: ")+3;
							int y = leitura.indexOf('T')-1;
							int millis = Integer.parseInt(leitura.substring(x, y));
							millis = millis / 1000;
							painelMovimentando.setText("Percorrendo: " + millis + " s");
						}
						if(leitura.contains("Time:")) {
							int x = leitura.indexOf("e: ")+3;
							int y = leitura.indexOf("S")-1;
							int time = Integer.parseInt(leitura.substring(x, y));
							time = time / 1000;
							painelMovimentado.setText("Ultimo Movimento: " + time + " s");
						}
					}
				}
			}
		};
		lendoArduino.start();
		
		Thread gravando = new Thread() {
			@Override
			public void run() {
				DecimalFormat decimal = new DecimalFormat("0.00");
				DecimalFormat decimal2 = new DecimalFormat("#,##");
				
				while(true) {
					if (Thread.interrupted())
						try {
							throw new InterruptedException();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					leitura = arduino.read();
					try {
						//------ tempo do loop em milisegundos --------
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ss++;
					if(ss > 59) {
						mm++;
						ss = 00;
					}else if(mm > 59) {
						HH++;
						mm = 00;
					}if(HH < 10 && mm < 10 && ss < 10) {
						tempo = "0"+ HH + " : 0" + mm +" : 0" + ss;
					}else if(HH < 10 && mm < 10 && ss > 9) {
						tempo = "0"+ HH + " : 0" + mm +" : " + ss;
					}else if(HH < 10 && mm > 9 && ss < 10) {
						tempo = "0"+ HH + " : " + mm +" : 0" + ss;
					}else if(HH > 9 && mm < 10 && ss < 10) {
						tempo = ""+ HH + " : 0" + mm +" : 0" + ss;
					}else if(HH < 10 && mm > 9 && ss > 9) {
						tempo = "0"+ HH + " : " + mm +" : " + ss;
					}else {
						tempo = ""+ HH + " : " + mm +" : " + ss;
					}
					
					
					//Obter luminosidade media
					if(leitura.contains("Brilho")) {
						media++;
						System.out.println("Teste concluido " + a++);
						int x = leitura.indexOf("o:")+3;
						int y = leitura.indexOf("M")-1;
						brilho = brilho + Integer.parseInt(leitura.substring(x, y));
						System.out.println("Teste concluido " + a++ + "brilho " + brilho);
						luminosidade = brilho / media;
						consumo = consumo + potencia;
					}					
					System.out.println("Teste concluido " + a++ + " media " + luminosidade);
					
					if(leitura.contains("1 LED")) {
						consumo = consumo + potencia;
						System.out.println("Teste consumo1: "+consumo);
					}if(leitura.contains("2 LEDs")) {
						consumo = consumo + potencia * 2;
						System.out.println("Teste consumo2: "+consumo);
					}if(leitura.contains("3 LEDs At")) {
						consumo = consumo + potencia * 3;
						System.out.println("Teste consumo3: "+consumo);
					}
					lblTempo.setText("Duracao: "+tempo);
					if(consumo > 999) {
						labelConsumo.setText("Consumo: "+ decimal2.format(consumo) + " kW/h");
					}else if(consumo < 999){
						labelConsumo.setText("Consumo: "+ decimal.format(consumo) + " W/h");
					}
					labelLuz.setText("Luminosidade: " + luminosidade);
					labelPotencia.setText("Potencia: " + decimal.format(potencia * 1000) + " mW");
				}
			}
		};
		
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arduino.read() != null) {
					gravando.start();
				}else {
					painelSensorLuz.setText("Arduino não encontrado!");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					painelSensorLuz.setText("Arduino não encontrado!");
				}
			}
		});
		
		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(ss > 0 || mm > 0) {
//					gravando.stop();
					gravando.interrupt();
					lblTempo.setText("00 : 00 : 00");
					labelConsumo.setText("Consumo: ");
					labelLuz.setText("Luminosidade: ");
					labelPotencia.setText("Potencia: ");
					
					date = data2.format(new Date());
					ArduinoService service = new ArduinoService();
					Arduino arduino = new Arduino();
					
					arduino.setData(date);
					arduino.setConsumo(consumo);
					arduino.setTempoDeUso(tempo);
					arduino.setLuminosidade(luminosidade);
					arduino.setPotencia(potencia);
					
					service.criar(arduino);
					
					consumo = 0;
					HH = 00;
					mm = 00;
					ss = 00;
					luminosidade = 0;
				}else {
					painelSensorLuz.setText("");
				}
			}
		});
	}
	
	public String porta() {
		//Identificar a porta
		CommPortIdentifier serialPortId;
	    //static CommPortIdentifier sSerialPortId;
	    @SuppressWarnings("rawtypes")
		Enumeration enumComm;
	    //SerialPort serialPort;
	    enumComm = CommPortIdentifier.getPortIdentifiers();
	    while (enumComm.hasMoreElements()) {
	     	serialPortId = (CommPortIdentifier) enumComm.nextElement();
	     	if(serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
	    		arduino = new ArduinoSerial(""+serialPortId.getName());
	    		porta = serialPortId.getName();
	    		System.out.println(porta);
	    	}
	    }
		return porta;
	}
}