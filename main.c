/*****************************??���ܱ���С�� By LiCJ??**************************/
#include<reg52.h>

#define HIGH 1
#define LOW 0

int left_moto2 = 2;//left ��
int left_moto4 = 4;
int right_moto7 = 7;//right ��
int right_moto8 = 8;
int pwmleft=5; // pwm������
int pwmright=3; // pwm������
int Rspeed=66;
int BZQL;//����ǰ�� 13
int BZQR;//����ǰ�� 12
int BZL;//������? ? 11
int BZR;//������? ? 10
int a=0;
int pinMode(i,INPUT);
int pinMode(i,OUTPUT);
int digitalWrite(i,INPUT);
int digitalWrite(i,OUTPUT);
int analogWrite(i,INPUT);
int analogWrite(i,OUTPUT);
int INPUT;
int OUTPUT;
int b;

void delay(unsigned int a)
{
	int b;
	for(a =100;a < 0;a--)
	{
		for(b =100 ;b < 0; b-- );
	}
}

void setup()
{ 
/******************************??��������? ?***********************************/
pinMode(left_moto2,1);//�˿�2���
pinMode(left_moto4,1);
pinMode(right_moto7,1); 
pinMode(right_moto8,1);
pinMode(pwmleft,1);
pinMode(pwmright,1); 

/*******************************? ? ������϶�ȡ��? ? **************************/ 
pinMode(13,INPUT);//�˿�13���룬���⴫���������
pinMode(12,INPUT);
pinMode(11,INPUT);
pinMode(10,INPUT);
}

/*******************************? ? ������ģʽ? ? *****************************/
void qian() //ǰ��
{
digitalWrite(right_moto7,1);//���ֶ˿�7����ߵ�ƽ
digitalWrite(right_moto8,0);
digitalWrite(left_moto2,1);
digitalWrite(left_moto4,0);
analogWrite(pwmleft,80);
analogWrite(pwmright,Rspeed);
}
void hou()//����
{
digitalWrite(right_moto7,0);
digitalWrite(right_moto8,1);
digitalWrite(left_moto2,0);
digitalWrite(left_moto4,1);
analogWrite(pwmleft,80);
analogWrite(pwmright,Rspeed);
}
void zuo()//��
{
digitalWrite(left_moto2,1);
digitalWrite(left_moto4,0);
digitalWrite(right_moto7,0);
digitalWrite(right_moto8,0);
analogWrite(pwmleft,0);
analogWrite(pwmright,255);
} 
void you() //��
{
digitalWrite(left_moto2,0);
digitalWrite(left_moto4,0);
digitalWrite(right_moto7,1);
digitalWrite(right_moto8,0);
analogWrite(pwmleft,255);
analogWrite(pwmright,0);
}
void yuanzuo()//ԭ����ת
{
digitalWrite(right_moto7,0);
digitalWrite(right_moto8,1);
digitalWrite(left_moto2,1);
digitalWrite(left_moto4,0);
analogWrite(pwmleft,255);
analogWrite(pwmright,225);
}
void yuanyou() //ԭ����ת
{
digitalWrite(right_moto7,1);
digitalWrite(right_moto8,0);
digitalWrite(left_moto2,0);
digitalWrite(left_moto4,1);
analogWrite(pwmleft,255);
analogWrite(pwmright,225);
}
void ting()// ͣ
{
digitalWrite(right_moto7,0);
digitalWrite(right_moto8,0);
digitalWrite(left_moto2,0);
digitalWrite(left_moto4,0);
analogWrite(pwmleft,0);
analogWrite(pwmright,0);
}

void loop(int b)
{for( b==0;b=10000;b--);
}
{BZQL=pinMode(13);BZQR=pinMode(12);//��ȡǰ��ı���ģ��״̬
BZL=pinMode(11);BZR=pinMode(10);//��ȡ����ı���ģ��״̬
}

/*******************************??ǰ ��??*************************************/
if(BZQL==HIGH&&BZQR==HIGH&&BZL==HIGH&&BZR==HIGH)
{
qian();
}
if(BZQL==HIGH&&BZQR==HIGH&&BZL==LOW&&BZR==LOW)
{
 qian();
}

/*****************************??һ�����ϴ�������״̬??************************/
if(BZQL==LOW&&BZQR==HIGH&&BZL==HIGH&&BZR==HIGH)
{
yuanyou();
}
if(BZQL==HIGH&&BZQR==LOW&&BZL==HIGH&&BZR==HIGH)
{
 yuanyou();
}
if(BZQL==HIGH&&BZQR==HIGH&&BZL==LOW&&BZR==HIGH)
{
 yuanyou();
}
if(BZQL==HIGH&&BZQR==HIGH&&BZL==HIGH&&BZR==LOW)

yuanzuo();
}
/***************************??�������ϴ�������״̬??*************************/


if(BZQL==LOW&&BZQR==HIGH&&BZL==LOW&&BZR==HIGH)
{
 yuanyou();
}
if(BZQL==HIGH&&BZQR==LOW&&BZL==HIGH&&BZR==LOW)
{
yuanzuo();
}
/*********************************************/
if(BZQL==LOW&&BZQR==HIGH&&BZL==HIGH&&BZR==LOW)
{
 hou();
delay(400);
yuanzuo();
a+=1;
}
if(BZQL==LOW&&BZQR==LOW&&BZL==HIGH&&BZR==HIGH&&a>0)
{
 a=0;
 hou();
delay(300);
 yuanzuo();
}
/************************************************/
if(BZQL==HIGH&&BZQR==LOW&&BZL==LOW&&BZR==HIGH)
{
 a=0;
 hou();
delay(400);
you();
}
if(BZQL==LOW&&BZQR==LOW&&BZL==HIGH&&BZR==HIGH&&a==0)
{
 hou();
 delay(300);
 yuanyou();
}

/***************************??�������ϴ�������״̬??*************************/
if(BZQL==LOW&&BZQR==LOW&&BZL==LOW&&BZR==HIGH)
{
 hou();
delay(300);
you();
}
if(BZQL==HIGH&&BZQR==LOW&&BZL==LOW&&BZR==LOW)
{
 hou();
 delay(300);
zuo();
}
if(BZQL==LOW&&BZQR==HIGH&&BZL==LOW&&BZR==LOW)
{
hou();
delay(300);
 you();
}
if(BZQL==LOW&&BZQR==LOW&&BZL==HIGH&&BZR==LOW)
{
hou();
 delay(300);
zuo();
}
/***************************??�ĸ����ϴ�������״̬??*************************/
if(BZQL==LOW&&BZQR==LOW&&BZL==LOW&&BZR==LOW)
{
 hou();
}
}


void main()
{
	

}