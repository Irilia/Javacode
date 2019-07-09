/*****************************??智能避障小车 By LiCJ??**************************/
#include<reg52.h>

#define HIGH 1
#define LOW 0

int left_moto2 = 2;//left 左
int left_moto4 = 4;
int right_moto7 = 7;//right 右
int right_moto8 = 8;
int pwmleft=5; // pwm调速左
int pwmright=3; // pwm调速右
int Rspeed=66;
int BZQL;//避障前左 13
int BZQR;//避障前右 12
int BZL;//避障左? ? 11
int BZR;//避障右? ? 10
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
/******************************??电机输出口? ?***********************************/
pinMode(left_moto2,1);//端口2输出
pinMode(left_moto4,1);
pinMode(right_moto7,1); 
pinMode(right_moto8,1);
pinMode(pwmleft,1);
pinMode(pwmright,1); 

/*******************************? ? 红外避障读取口? ? **************************/ 
pinMode(13,INPUT);//端口13输入，红外传感器输入口
pinMode(12,INPUT);
pinMode(11,INPUT);
pinMode(10,INPUT);
}

/*******************************? ? 电机输出模式? ? *****************************/
void qian() //前进
{
digitalWrite(right_moto7,1);//数字端口7输出高电平
digitalWrite(right_moto8,0);
digitalWrite(left_moto2,1);
digitalWrite(left_moto4,0);
analogWrite(pwmleft,80);
analogWrite(pwmright,Rspeed);
}
void hou()//后退
{
digitalWrite(right_moto7,0);
digitalWrite(right_moto8,1);
digitalWrite(left_moto2,0);
digitalWrite(left_moto4,1);
analogWrite(pwmleft,80);
analogWrite(pwmright,Rspeed);
}
void zuo()//左
{
digitalWrite(left_moto2,1);
digitalWrite(left_moto4,0);
digitalWrite(right_moto7,0);
digitalWrite(right_moto8,0);
analogWrite(pwmleft,0);
analogWrite(pwmright,255);
} 
void you() //右
{
digitalWrite(left_moto2,0);
digitalWrite(left_moto4,0);
digitalWrite(right_moto7,1);
digitalWrite(right_moto8,0);
analogWrite(pwmleft,255);
analogWrite(pwmright,0);
}
void yuanzuo()//原地左转
{
digitalWrite(right_moto7,0);
digitalWrite(right_moto8,1);
digitalWrite(left_moto2,1);
digitalWrite(left_moto4,0);
analogWrite(pwmleft,255);
analogWrite(pwmright,225);
}
void yuanyou() //原地右转
{
digitalWrite(right_moto7,1);
digitalWrite(right_moto8,0);
digitalWrite(left_moto2,0);
digitalWrite(left_moto4,1);
analogWrite(pwmleft,255);
analogWrite(pwmright,225);
}
void ting()// 停
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
{BZQL=pinMode(13);BZQR=pinMode(12);//读取前面的避障模块状态
BZL=pinMode(11);BZR=pinMode(10);//读取侧面的避障模块状态
}

/*******************************??前 进??*************************************/
if(BZQL==HIGH&&BZQR==HIGH&&BZL==HIGH&&BZR==HIGH)
{
qian();
}
if(BZQL==HIGH&&BZQR==HIGH&&BZL==LOW&&BZR==LOW)
{
 qian();
}

/*****************************??一个避障传感器的状态??************************/
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
/***************************??两个避障传感器的状态??*************************/


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

/***************************??三个避障传感器的状态??*************************/
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
/***************************??四个避障传感器的状态??*************************/
if(BZQL==LOW&&BZQR==LOW&&BZL==LOW&&BZR==LOW)
{
 hou();
}
}


void main()
{
	

}