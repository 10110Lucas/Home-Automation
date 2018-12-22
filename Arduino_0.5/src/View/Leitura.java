package View;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Arduino.ArduinoSerial;
import Model.Arduino;
import Service.ArduinoService;
import gnu.io.CommPortIdentifier;

public class Leitura extends JFrame {
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
	
	public Leitura() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("  Consumo");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lucas\\Downloads\\Projeto Inegrado\\Projeto Inegrado\\imagens\\favicon.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 335);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel painelSensorLuminosidade = new JLabel("Luz de Fora:");
		painelSensorLuminosidade.setForeground(Color.WHITE);
		painelSensorLuminosidade.setBackground(Color.LIGHT_GRAY);
		painelSensorLuminosidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		painelSensorLuminosidade.setHorizontalAlignment(SwingConstants.LEFT);
		
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
		
		JLabel labelLuz = new JLabel("Luminosidade Media:");
		labelLuz.setForeground(Color.WHITE);
		labelLuz.setHorizontalAlignment(SwingConstants.LEFT);
		labelLuz.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel labelPotencia = new JLabel("Potencia:");
		labelPotencia.setForeground(Color.WHITE);
		labelPotencia.setHorizontalAlignment(SwingConstants.LEFT);
		labelPotencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel painelSensorMovimento = new JLabel("Sensor Garagem:");
		painelSensorMovimento.setHorizontalAlignment(SwingConstants.LEFT);
		painelSensorMovimento.setForeground(Color.WHITE);
		painelSensorMovimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		painelSensorMovimento.setBackground(Color.LIGHT_GRAY);
		
		JLabel painelSala = new JLabel("Luz Sala:");
		painelSala.setHorizontalAlignment(SwingConstants.LEFT);
		painelSala.setForeground(Color.WHITE);
		painelSala.setFont(new Font("Tahoma", Font.PLAIN, 14));
		painelSala.setBackground(Color.LIGHT_GRAY);
		
		JLabel painelContador = new JLabel("Contador:");
		painelContador.setHorizontalAlignment(SwingConstants.LEFT);
		painelContador.setForeground(Color.WHITE);
		painelContador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		painelContador.setBackground(Color.LIGHT_GRAY);
		
		JLabel painelMovimento = new JLabel("Ultimo Movimento:");
		painelMovimento.setHorizontalAlignment(SwingConstants.LEFT);
		painelMovimento.setForeground(Color.WHITE);
		painelMovimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		painelMovimento.setBackground(Color.LIGHT_GRAY);
		
		JLabel painelBrilho = new JLabel("Brilho Quarto:");
		painelBrilho.setHorizontalAlignment(SwingConstants.LEFT);
		painelBrilho.setForeground(Color.WHITE);
		painelBrilho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		painelBrilho.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("");
		
		JLabel painelQuarto = new JLabel("Luz Quarto:");
		painelQuarto.setHorizontalAlignment(SwingConstants.LEFT);
		painelQuarto.setForeground(Color.WHITE);
		painelQuarto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		painelQuarto.setBackground(Color.LIGHT_GRAY);
		
		JLabel painelBanheiro = new JLabel("Luz Banheiro:");
		painelBanheiro.setHorizontalAlignment(SwingConstants.LEFT);
		painelBanheiro.setForeground(Color.WHITE);
		painelBanheiro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		painelBanheiro.setBackground(Color.LIGHT_GRAY);
		
		JLabel painelContador2 = new JLabel("Contador:");
		painelContador2.setHorizontalAlignment(SwingConstants.LEFT);
		painelContador2.setForeground(Color.WHITE);
		painelContador2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		painelContador2.setBackground(Color.LIGHT_GRAY);
		
		JLabel painelUltimoS = new JLabel("Ultimo s:");
		painelUltimoS.setHorizontalAlignment(SwingConstants.LEFT);
		painelUltimoS.setForeground(Color.WHITE);
		painelUltimoS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		painelUltimoS.setBackground(Color.LIGHT_GRAY);
		
		JLabel painelCozinha = new JLabel("Luz Cozinha:");
		painelCozinha.setHorizontalAlignment(SwingConstants.LEFT);
		painelCozinha.setForeground(Color.WHITE);
		painelCozinha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		painelCozinha.setBackground(Color.LIGHT_GRAY);
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JSeparator separator_2 = new JSeparator();
		
		JSeparator separator_3 = new JSeparator();
		
		JSeparator separator_4 = new JSeparator();
		
		JLabel painelLuzForaLuminosidade = new JLabel("Luz de Fora:");
		painelLuzForaLuminosidade.setHorizontalAlignment(SwingConstants.LEFT);
		painelLuzForaLuminosidade.setForeground(Color.WHITE);
		painelLuzForaLuminosidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		painelLuzForaLuminosidade.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(504)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(184)
							.addComponent(data, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(233)
									.addComponent(painelBanheiro))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(painelSala, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(labelConsumo, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(labelLuz, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(labelPotencia, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblTempo, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnIniciar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnParar, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(painelCozinha, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
									.addGap(39)
									.addComponent(painelQuarto))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(painelContador, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
										.addComponent(painelMovimento, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
										.addComponent(painelSensorMovimento, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(painelUltimoS, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
										.addComponent(painelContador2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
										.addComponent(painelBrilho, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
								.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
								.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(painelSensorLuminosidade, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
									.addGap(60)
									.addComponent(painelLuzForaLuminosidade, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
								.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(data, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(painelSala, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(painelBanheiro, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(painelCozinha, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(painelQuarto, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(painelSensorLuminosidade)
						.addComponent(painelLuzForaLuminosidade, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(painelSensorMovimento, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(painelContador, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(painelMovimento, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(painelUltimoS))
							.addGap(8))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(painelBrilho)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(painelContador2)
							.addGap(33)))
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTempo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelConsumo)
						.addComponent(labelLuz, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(labelPotencia))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIniciar)
						.addComponent(btnParar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(209))
		);
		contentPane.setLayout(gl_contentPane);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{painelSala, data, painelSensorMovimento, painelSensorLuminosidade, painelBrilho, painelContador, painelMovimento, lblTempo, btnIniciar, btnParar, labelConsumo, labelLuz, labelPotencia, lblNewLabel}));
		
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
								 painelSala.setText("Botao de Luz: Procurando...");
						painelSensorMovimento.setText("Sensor Movimento: Procurando...");
						painelSensorLuminosidade.setText("Sensor de Luz: Procurando...");
					}else {
						
						//--------  LUZES   ----------------------------------------------
						if(leitura.equals("LedBanheiroON")) {
							painelBanheiro.setText("Luz Banheiro: Ligado");
						}
						if(leitura.equals("LedBanheiroOFF")) {
							painelBanheiro.setText("Luz Banheiro: Desligado");
						}
						if(leitura.contains("LedSalaON")) {
							painelSala.setText("Luz Sala: Ligado");
						}
						if(leitura.contains("LedSalaOFF")) {
							painelSala.setText("Luz Sala: Desligado");
						}
						if(leitura.contains("LedCozinhaON")) {
							painelCozinha.setText("Luz Cozinha: Ligado");
						}
						if(leitura.contains("LedCozinhaOFF")) {
							painelCozinha.setText("Luz Cozinha: Desligado");
						}
						
						//   Luz de Fora
						if(leitura.contains("LedSaidaON")) {
							painelSensorLuminosidade.setText("Luz de Fora: Ligado");
						}
						if(leitura.contains("LedSaidaOFF")) {
							painelSensorLuminosidade.setText("Luz de Fora: Desligado");
						}
						if(leitura.contains("SensorLuz")) {
							int x = leitura.indexOf("SensorLuz:")+11;
							int y = leitura.indexOf("LedSaidaO")-1;
							painelLuzForaLuminosidade.setText("Luz de Fora: " + leitura.substring(x, y));
						}
						
						//   Sensor da Garagem
						if(leitura.contains("LedGaragemON")) {
							painelSensorMovimento.setText("Sensor Garagem: Ligado");
						}
						if(leitura.contains("LedGaragemOFF")) {
							painelSensorMovimento.setText("Sensor Garagem: Desligado");
						}
						if(leitura.contains("ContadorGaragem:")) {
							int x = leitura.indexOf("ContadorGaragem:")+17;
							int y = leitura.indexOf("Mov")-1;
							int millis = Integer.parseInt(leitura.substring(x, y));
							millis = millis / 1000;
							painelContador.setText("Contador: " + millis + " s");
						}
						if(leitura.contains("MovimentoGaragem:")) {
							int x = leitura.indexOf("MovimentoGaragem:")+18;
							int y = leitura.indexOf("LedGaragemO")-1;
							int time = Integer.parseInt(leitura.substring(x, y));
							time = time / 1000;
							painelMovimento.setText("Ultimo Movimento: " + time + " s");
						}
						
						//    Luz do Quarto
						if(leitura.contains("LedQuartoON")) {
							painelQuarto.setText("Luz Quarto: Ligado");
						}
						if(leitura.contains("LedQuartoOFF")) {
							painelQuarto.setText("Luz Quarto: Desligado");
						}
						
						//  Brilho da Luz do Quarto
						if(leitura.contains("Brilho:")) {
							int x = leitura.indexOf("Brilho: ")+8;
							int y = leitura.indexOf("ContadorBrilho:")-1;
							String brilho = leitura.substring(x, y);
							painelBrilho.setText("Brilho Quarto: " + brilho);
						}
						
						
						if(leitura.contains("ContadorBrilho:")) {
							int x = leitura.indexOf("ContadorBrilho:") + 16;
							int y = leitura.indexOf("BrilhoInicial:")-1;
							int ms = Integer.parseInt(leitura.substring(x, y));
							ms = ms / 1000;
							painelContador2.setText("Contador: " + ms + " s");
						}
						if(leitura.contains("BrilhoInicial:")) {
							int x = leitura.indexOf("BrilhoInicial:")+15;
							int y = leitura.indexOf("LedQuartoON")-1;
							int tim = Integer.parseInt(leitura.substring(x, y));
							tim = tim / 1000;
							painelUltimoS.setText("Ultimo s: " + tim + " s");
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
					if(leitura.contains("Brilho:")) {
						media++;
						System.out.println("Teste concluido " + a++);
						int x = leitura.indexOf("Brilho: ")+8;
						int y = leitura.indexOf("ContadorBrilho:")-1;
						brilho = brilho + Integer.parseInt(leitura.substring(x, y));
						System.out.println("Teste concluido " + a++ + "brilho " + brilho);
						luminosidade = brilho / media;
						consumo = consumo + potencia;
					}					
					System.out.println("Teste concluido " + a++ + " media " + luminosidade);
					
					if(leitura.contains("LedQuartoON")) {
						consumo = consumo + potencia;
						System.out.println("Teste consumo1: "+consumo);
					}if(leitura.contains("LedBanheiroON")) {
						consumo = consumo + potencia;
						System.out.println("Teste consumo2: "+consumo);
					}if(leitura.contains("LedGaragemON")) {
						consumo = consumo + potencia;
						System.out.println("Teste consumo3: "+consumo);
					}if(leitura.contains("LedSalaON")) {
						consumo = consumo + potencia;
						System.out.println("Teste consumo5: "+consumo);
					}if(leitura.contains("LedCozinhaON")) {
						consumo = consumo + potencia;
						System.out.println("Teste consumo6: "+consumo);
					}if(leitura.contains("LedSaidaON")) {
						consumo = consumo + potencia;
						System.out.println("Teste consumo7: "+consumo);
					}
					lblTempo.setText("Duracao: "+tempo);
					if(consumo > 999) {
						labelConsumo.setText("Consumo: "+ decimal2.format(consumo) + " kW/h");
					}else if(consumo < 999){
						labelConsumo.setText("Consumo: "+ decimal.format(consumo) + " W/h");
					}
					labelLuz.setText("Luminosidade Media: " + luminosidade);
					labelPotencia.setText("Potencia: " + decimal.format(potencia * 1000) + " mW");
				}
			}
		};
		
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arduino.read() != null) {
					gravando.start();
				}else {
					painelSensorLuminosidade.setText("Arduino não encontrado!");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					painelSensorLuminosidade.setText("Arduino não encontrado!");
				}
			}
		});
		
		btnParar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				if(ss > 0 || mm > 0) {
					gravando.stop();
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
					
					System.exit(1);
				}else {
					painelSensorLuminosidade.setText("");
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
