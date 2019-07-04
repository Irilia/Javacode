package daydata;

import java.util.Scanner;

public class CreditGPA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] gradePoint = new int[n];//每门课学分
        int[] coursePoint = new int[n];//每门课分数

        for (int i = 0; i < n; i++) {
            gradePoint[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            coursePoint[i] = in.nextInt();
        }
        in.close();
        System.out.println(gradePointAverage(gradePoint,coursePoint));

    }

    public static double pointOfEachCourse(int grede){
        double point = 0.0;
        if(grede>=90&&grede<=100){
            point = 4.0;
        }else if(grede>=85&&grede<=89){
            point = 3.7;
        }else if(grede>=82&&grede<=84){
            point = 3.3;
        }else if(grede>=78&&grede<=81){
            point = 3.0;
        }else if(grede>=75&&grede<=77){
            point = 2.7;
        }else if(grede>=72&&grede<=74){
            point = 2.3;
        }else if(grede>=68&&grede<=71){
            point = 2.0;
        }else if(grede>=64&&grede<=67){
            point = 1.5;
        }else if(grede>=60&&grede<=63){
            point = 1.0;
        }else if(grede<60){
            point = 0;
        }
        return (double) point;
    }
    //计算平均绩点
    public static double gradePointAverage(int[] gradePoint,int[] coursePoint){
        double gradePointTotal = 0;
        double gradeOfEachCourseTotal = 0;
        for (int i = 0; i < gradePoint.length; i++) {
            gradePointTotal+=pointOfEachCourse(coursePoint[i])*gradePoint[i];
            gradeOfEachCourseTotal+=gradePoint[i];
        }
        return (double) gradePointTotal/gradeOfEachCourseTotal;
    }
}
