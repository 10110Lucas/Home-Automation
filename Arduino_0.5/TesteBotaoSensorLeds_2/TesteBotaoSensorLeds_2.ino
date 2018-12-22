const int senso = 2;
const int botao = 4;
const int bott2 = 7;
const int azul = 12;
const int gren = 11;
const int redi = 10;
int luz;
int vari = 1;
int estado = 1;
int brilho = 0;
int contador = 1;
unsigned long time = 0;
void setup() {
  pinMode(botao, INPUT_PULLUP);
  pinMode(bott2, INPUT_PULLUP);
  pinMode(senso, INPUT);
  pinMode(azul, OUTPUT);
  pinMode(gren, OUTPUT);
  pinMode(redi, OUTPUT);
  Serial.begin(9600);
}
void loop(){
  luz = analogRead(A0);

  if(digitalRead(botao) == 0 && vari == 1){
    if(digitalRead(botao) == 0 && estado == 1){
      digitalWrite(azul, HIGH);
      Serial.println("Botao de Luz: 1 LED Ativado.");
      estado = 2;
      delay(200);
    }    
    else if(digitalRead(botao) == 0 && estado == 2){
      digitalWrite(azul, HIGH);
      digitalWrite(gren, HIGH);
      Serial.println("Botao de Luz: 2 LEDs Ativados");
      estado = 3;
      delay(200);
    }    
    else if(digitalRead(botao) == 0 && estado == 3){
      digitalWrite(azul, HIGH);
      digitalWrite(gren, HIGH);
      digitalWrite(redi, HIGH);
      Serial.println("Botao de Luz: 3 LEDs Ativados");
      estado = 4;
      delay(200);
    }    
    else if(digitalRead(botao) == 0 && estado == 4){
      digitalWrite(azul, LOW);
      digitalWrite(gren, LOW);
      digitalWrite(redi, LOW);
      Serial.println("Botao de Luz: 3 LEDs Apagados");
      estado = 1;
      delay(200);
    }
  }
  else if(vari == 2){
    if(digitalRead(senso) == HIGH){
      time = millis();
    }
    if(digitalRead(senso) == HIGH || millis() - time < 10000){
      digitalWrite(azul, HIGH);
      digitalWrite(gren, HIGH);
      digitalWrite(redi, HIGH);
      Serial.print("Millis: ");
      Serial.print(millis());
      Serial.print(" Time: ");
      Serial.print(time);
      Serial.println(" Sensor Movimento: 3 LEDs Ativados");
      delay(10);
    }
    else{
      digitalWrite(azul, LOW);
      digitalWrite(gren, LOW);
      digitalWrite(redi, LOW);
      Serial.println("Sensor Movimento: 3 LEDs Apagados");
      delay(10);
    }
  }
  else if(vari == 3){
    if(digitalRead(botao) == 0){
      
      while(digitalRead(botao) == 0 || millis() - time < 10000){
        if(digitalRead(botao) == 0){          
          brilho = brilho + contador;
          if(brilho > 254){
            contador = -1;
          }
          else if(brilho < 2){
            contador = 1;
          }
          Serial.print("Brilhando: ");
          Serial.println(brilho);
          analogWrite(azul, brilho);
          analogWrite(gren, brilho);
          analogWrite(redi, brilho);
          time = millis();
        }
        if(millis() - time < 20000){
          Serial.print("Brilho: ");
          Serial.print(brilho);
          analogWrite(azul, brilho);
          analogWrite(gren, brilho);
          analogWrite(redi, brilho);
        }
        Serial.print(" Millis: ");
        Serial.print(millis());
        Serial.print(" Time: ");
        Serial.print(time);
        Serial.println(" S");
        delay(100);
      }
      //delay(20000);
    }
    
    if(luz >= 500 && luz <= 1023){
      Serial.print("Sensor de Luz: ");
      Serial.println(luz);
      digitalWrite(azul, LOW);
      digitalWrite(gren, LOW);
      analogWrite(redi, luz);
      delay(200);
    }
    else if(luz < 500 && luz > 299){
      Serial.print("Sensor de Luz: ");
      Serial.println(luz);
      digitalWrite(azul, LOW);
      analogWrite(gren, luz);
      analogWrite(redi, luz);
      delay(200);
    }
    else if(luz < 300 && luz >= 0){
      Serial.print("Sensor de Luz: ");
      Serial.println(luz);
      digitalWrite(azul, HIGH);
      analogWrite(gren, luz*(-1));
      analogWrite(redi, luz*(-1));
      delay(200);
    }
  }
  if(digitalRead(bott2) == 0){
    vari++;
    delay(200);
    if(vari > 3){
      vari = 1;
    }
    if(vari == 1){
      Serial.println("Botao de Luz: Habilitado!!");
      delay(200);
    }
    if(vari == 2){
      Serial.println("Sensor Movimento: Habilitado!!");
      delay(200);
    }
    if(vari == 3){
      Serial.println("Sensor de Luz: Habilitado!!");
      delay(200);
    }
  }
}
