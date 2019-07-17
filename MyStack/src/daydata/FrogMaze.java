package daydata;

import java.util.Scanner;

public class FrogMaze {
    public static void main(String[] args) {
        String path = " ";
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int p = in.nextInt();
        int[][] maze = new int[n][m];
        boolean[][] realpath = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = in.nextInt();
            }
        }
        Solution(maze,realpath,0,0,path,p);
        System.out.println(path);
    }
    public static void Solution(int[][] maze,boolean[][] realpath,int i,int j,String path,int p){
        if(i==0&&j==maze[0].length-1&&maze[i][j]==1){
            if(p>=0){
                path+="["+i+","+j+"]";
            }else {
                path="Can not escape!";
            }

        }
        if(i>=0&&j>=0&&i < maze.length && j < maze[0].length && maze[i][j] == 1 && !realpath[i][j]){
            realpath[i][j] = true;
            path += "["+i+","+j+"]";
            Solution(maze,realpath,i,j+1,path,p-1);//向右
            Solution(maze,realpath,i+1,j,path,p);//向下
            Solution(maze,realpath,i,j-1,path,p-1);//向左
            Solution(maze,realpath,i-1,j,path,p-3);//向前
        }
    }
}

/*
import java.util.Scanner;



public class FrogMaze {

    public static String path = "";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int m = in.nextInt();

        int p = in.nextInt();

        int[][] grid = new int[n][m];

        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++){

            for(int j=0; j<m; j++){

                grid[i][j] = in.nextInt();

            }

        }

        Helper(grid,0,0,visited,"",p);

        System.out.println(path);

    }

    public static void Helper(int[][] grid,int i,int j, boolean[][] visited,String res,int p) {

        if(i == 0 && j == grid[0].length-1 && grid[i][j] == 1){

            if(p >=0 ){

                path = res + "["+i+","+j+"]";

            }else{

                path =  "Can not escape!";

            }

            return;

        }

        if(i >=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]==1 && !visited[i][j]){

            visited[i][j] = true;

            res += "["+i+","+j+"],";

            Helper(grid,i,j+1,visited,res,p-1);//向右

            Helper(grid,i+1,j,visited,res,p);//向下

            Helper(grid,i,j-1,visited,res,p-1);//向左

            Helper(grid,i-1,j,visited,res,p-3);//向上

        }

    }

}
*/
