#include "main.h"

void main()
{
	
	Timer0_init();                //��ʱ��0�жϳ�ʼ��        ����PWM��������ռ�ձȿ��������ѹ
  UartInit();                  //���ڳ�ʼ��
	 while(1)
	{
		Bluetooth_driver();//����
	}	





	}