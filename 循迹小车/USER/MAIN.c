#include "main.h"

void main()
{
	
	Timer0_init();                //定时器0中断初始化        制造PWM波，控制占空比控制输出电压
  UartInit();                  //串口初始化
	 while(1)
	{
		Bluetooth_driver();//蓝牙
	}	





	}