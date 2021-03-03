int nr=10;
int poz=0,s=0,m=0,ms=0,value=0,l=0,h=0;

void display(int p, int c)
{
     PORTA &= 0b11110000;
     PORTC &= 0b00000000;
        switch(c){
 case 0:
          PORTC |= ~0b00111111;break;//codificare cifra 0
          case 1:
          PORTC |= ~0b00000110;break;//codificare cifra 1
          case 2:
          PORTC |= ~0b01011011;break;//codificare cifra 2
          case 3:
          PORTC |= ~0b01001111;break;//codificare cifra 3
          case 4:
          PORTC |= ~0b01100110;break;//codificare cifra 4
          case 5:
          PORTC |= ~0b01101101;break;//codificare cifra 5
          case 6:
          PORTC |= ~0b01111101;break;//codificare cifra 6
          case 7:
          PORTC |= ~0b00000111;break;//codificare cifra 7
          case 8:
          PORTC |= ~0b01111111;break;//codificare cifra 8
          case 9:
          PORTC |= ~0b01101111;break;//codificare cifra 9
}

     switch(p)
     {
     case 1:
            PORTA |= 0b00001000;
            break;
     case 2:
            PORTA |= 0b00000100;
            break;
     case 3:
            PORTA |= 0b00000010;
            break;
     case 4:
            PORTA |= 0b00000001;
            break;
     }
           // Delay_ms(10);
}
void init_timer()
{
              // Global Interrupt Enable
TCCR0 = 0b00001011;     //CTC-3,6; Prescaler-0,1,2
TCNT0 = 0;
OCR0 = 125;
TIMSK |= 0b00000010;    //set interrupt OCM
}
/*
void Timer1_OC_ISR() iv IVT_ADDR_TIMER0_COMP {   //ISR

   digit++;
   switch(digit){
    case 1: display(1,s%10); break;
    case 2: display(2,(s/10)%10); break;
    case 3: display(3,m%10); break;
     case 4: display(4,(m/10)%10); digit=0; break;}
     if (ms == 999){
             s++;
              ms = 0;
               if(s == 60){
                     s = 0;
                      m++; }
                   }else ms++;

}*/

void init_adc(){
ADMUX =0b01000000;   //channel ADC7
ADCSRA =0b10000111; //IE - ADC bit 3, AutoTrigger bit 5
}

int adc(char ch){
ADMUX &=0b11100000;
ADMUX |=ch;
ADCSRA |=1<<6;
while(ADCSRA&(1<<6));
l=ADCL;
h=ADCH;
return h<<8 | l;
}

void Timer0_ISR() iv IVT_ADDR_TIMER0_COMP{
poz++;
switch(poz)
           {   case 1:display(1,value%10);break;
               case 2:display(2,(value/10)%10);break;
               case 3:display(3,(value/100)%10);break;
               case 4:display(4,(value/1000)%10); poz=0;break;
           }
           if (ms==100){
           value=adc(6)/4;    //citim pinul 6 din portA
           } 
           else ms++;
}
           


 
 void main()
 {
  DDRA = 0b00001111;  //seteaza pinii de ie?ire 
  DDRC = 0b11111111;
  //DDRB=0b010000000;
  init_timer();
 init_adc();
  SREG = 1<<7;
//Init_INT0();

  

}