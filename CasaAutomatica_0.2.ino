const int senso = 2;
const int botaoSala = 3;
const int botaoBrilho = 4;
const int botaoBanheiro = 5;
const int saida = 6;
const int botaoQuarto = 7;
const int cozinha = 8;
const int sala = 9;
const int quarto = 10;
const int banheiro = 11;
const int garagem = 12;

int luz;
int estado = 1;
int estado2 = 1;
int estado3 = 1;
int brilho = 0;
int contador = 2;
unsigned long time = 0;
unsigned long tempo = 0;
void setup() {
  pinMode(botaoBanheiro, INPUT_PULLUP);
  pinMode(botaoQuarto, INPUT_PULLUP);
  pinMode(botaoBrilho, INPUT_PULLUP);
  pinMode(botaoSala, INPUT_PULLUP);
  pinMode(senso, INPUT);
  
  pinMode(saida, OUTPUT);
  pinMode(cozinha, OUTPUT);
  pinMode(sala, OUTPUT);
  pinMode(quarto, OUTPUT);
  pinMode(banheiro, OUTPUT);
  pinMode(garagem, OUTPUT);
  
  Serial.begin(9600);
}
void loop(){
  luz = analogRead(A0);
  
  if(digitalRead(senso) == HIGH){
    time = millis();
  }
  if(digitalRead(senso) == HIGH || millis() - time < 10000){
    digitalWrite(garagem, HIGH);
    Serial.print("ContadorGaragem: ");
    Serial.print(millis());
    Serial.print(" MovimentoGaragem: ");
    Serial.print(time);
    Serial.println(" LedGaragemON");
    delay(10);
  }
  else{
    digitalWrite(garagem, LOW);
    Serial.println("LedGaragemOFF");
    delay(10);
  }
  
  //Botao do Banheiro      
  if(digitalRead(botaoBanheiro) == 0 && estado == 1){
    digitalWrite(banheiro, HIGH);
    Serial.println("LedBanheiroON");
    estado = 2;
    delay(200);
  }    
  else if(digitalRead(botaoBanheiro) == 0 && estado == 2){
    digitalWrite(banheiro, LOW);
    Serial.println("LedBanheiroOFF");
    estado = 1;
    delay(200);
  }

  //Botao sala e cozinha
  if(digitalRead(botaoSala) == 0 && estado3 == 1){
    digitalWrite(sala, HIGH);
    Serial.println("LedSalaON LedCozinhaOFF");
    estado3 = 2;
    delay(200);
  }
  if(digitalRead(botaoSala) == 0 && estado3 == 2){
    digitalWrite(sala, LOW);
    digitalWrite(cozinha, HIGH);
    Serial.println("LedSalaOFF LedCozinhaON");
    estado3 = 3;
    delay(200);
  }
  if(digitalRead(botaoSala) == 0 && estado3 == 3){
    digitalWrite(sala, HIGH);
    Serial.println("LedSalaON LedCozinhaON");
    estado3 = 4;
    delay(200);
  }    
  else if(digitalRead(botaoSala) == 0 && estado3 == 4){
    digitalWrite(sala, LOW);
    digitalWrite(cozinha, LOW);
    Serial.println("LedSalaOFF LedCozinhaOFF");
    estado3 = 1;
    delay(200);
  }

  //---- Saida ------
  if(luz < 800){
    Serial.print("SensorLuz: ");
    Serial.print(luz);
    Serial.println(" LedSaidaON");
    analogWrite(saida, luz*(-1));
    delay(200);
  }
  else if(luz >= 800){
    Serial.print("SensorLuz: ");
    Serial.print(luz);
    Serial.println(" LedSaidaOFF");
    analogWrite(saida, LOW);
    delay(200);
  }

  //Botao do quarto   
  if(digitalRead(botaoQuarto) == 0 && estado2 == 1){
    digitalWrite(quarto, HIGH);
    Serial.println("LedQuartoON");
    estado2 = 2;
    delay(200);
  }    
  else if(digitalRead(botaoQuarto) == 0 && estado2 == 2){
    digitalWrite(quarto, LOW);
    Serial.println("LedQuartoOFF");
    estado2 = 1;
    delay(200);
  }
  
  //---- Brilho do quarto -------
  if(digitalRead(botaoBrilho) == 0 || millis() - tempo < 10000){
    if(digitalRead(botaoBrilho) == 0){
      brilho = brilho + contador;
      if(brilho > 120){
        contador = 2;
      }
      analogWrite(quarto, brilho);
      tempo = millis();
    }
    if(millis() - tempo < 10000){
      Serial.print("Brilho: ");
      Serial.print(brilho);
      analogWrite(quarto, brilho);
    }
    Serial.print(" ContadorBrilho: ");
    Serial.print(millis());
    Serial.print(" BrilhoInicial: ");
    Serial.print(tempo);
    Serial.println(" LedQuartoON");
    delay(100);
  }
}
