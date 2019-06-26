#ifndef __MAIN_H_
#define __MAIN_H_

#include <STC89C5XRC.H>

typedef  unsigned int uint;
typedef  unsigned char uchar;

sbit  FNA = P0^0;
sbit  FNB = P0^1;
sbit  IN1 = P0^2;
sbit  IN2 = P0^3;
sbit  IN3 = P0^4;
sbit  IN4 = P0^5;

sbit  A_D01 = P1^0;
sbit  B_D01 = P1^1;

extern uchar volatile n;
extern uchar volatile FN_ratio;
extern uchar volatile receiveData;




void Car_GoAhead();
void Car_retreat();
void Car_TURNLEFT();
void Car_TURNRIGHT();
void Timer0_init();
void Bluetooth_driver();
void Tcrt_light();
void UartInit();
void Car_STOP();
#endif
