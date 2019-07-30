package Dynamic;

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
/*
public class Solution {
    public int JumpFloorII(int target) {
        if(target < 0){
            return 0;
        }
        return 1 <<(target-1);
    }
}
*/

/**
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
/*public class Solution {
    public int RectCover(int target) {
        if(target <= 0){
            return 0;
        }else if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }
        return RectCover(target-1) + RectCover(target-2);
    }
}*/


/**
 * 连续最大子数组和
 * HZ偶尔会拿些专业问题来忽悠那些非计3算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，
 * 返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
//状态F（i）：以第i项结尾的最大连续子序列的和
/*
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int max = array[0];
        int sum = array[0];
        for(int i=1; i<array.length; i++){
            sum = Math.max(sum,0)+array[i];
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
}
*/

/*

word-break
Given a string s and a dictionary of words dict,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.
For example, given
s ="leetcode",
dict =["leet", "code"].
Return true because"leetcode"can be segmented as"leet code".
 */
//状态：前i个字符能否被分割
/*
import java.util.Set;
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s==null || s.length() == 0 || dict.size()==0){
            return false;
        }
        int len = s.length();
        boolean[] flag = new boolean[len+1];
        flag[0] =  true;
        for(int i=1; i<=len; i++){
            for(int j=0;j<i;j++){
                if(flag[j] && dict.contains(s.substring(j,i))){
                    flag[i] = true;
                    break;
                }
            }
            if(flag[len]){
                break;
            }
        }
        return flag[len];
    }
}
*/

/**
 *三角矩阵(Triangle)
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 * The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
//状态：dp[i][j]表示到这一点的最短路径
/*
import java.util.*;
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1;i<dp[0].length; i++){
            dp[i][0] = triangle.get(i).get(0) + dp[i-1][0];
            dp[i][i] = triangle.get(i).get(i) + dp[i-1][i-1];
        }
        for(int i=1;i<dp[0].length; i++){
            for(int j=1;j<i;j++){
                dp[i][j] = triangle.get(i).get(j)+ Math.min(dp[i-1][j],dp[i-1][j-1]);
            }
        }
        int min = dp[dp.length-1][0];
        for(int j=1; j<dp.length;j++){
            min = Math.min(min,dp[dp.length-1][j]);
        }
        return min;
    }
}
*/
//状态：dp[i][j]表示这个点到最后一行的最短路径
/*
import java.util.*;
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        int len = dp.length;
        for(int j=0; j<len;j++){
            dp[len-1][j] = triangle.get(len-1).get(j);
        }
        for(int i=len-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}
*/

/**
 * 路径总数(Unique Paths)
 */
/*
public class Solution {
    public int uniquePaths(int m, int n) {
        if(m<=0 || n<=0){
            return 0;
        }
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }
        for(int j=1; j<n; j++){
            dp[0][j] = 1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] +dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
*/

/**
 * 路径总数(Unique Paths II)
 */
/*
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0){
            return 0;
        }
        for(int i=0; i<obstacleGrid.length; i++){
            obstacleGrid[i][0] = obstacleGrid[i][0]==1 ? 0 :(i-1>=0?obstacleGrid[i-1][0]:1);
        }
        for(int j=1; j<obstacleGrid[0].length; j++){
            obstacleGrid[0][j] = obstacleGrid[0][j]==1 ? 0 :obstacleGrid[0][j-1];
        }
        for(int i=1; i<obstacleGrid.length; i++){
            for(int j=1; j<obstacleGrid[0].length; j++){
                obstacleGrid[i][j] = obstacleGrid[i][j]==1 ? 0 :
                        obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}*/

/**
 * 最小路径和(Minimum Path Sum)
 */
/*
public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null ||grid.length==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        for(int i=1; i<m; i++){
            grid[i][0] += grid[i-1][0];
        }
        for(int j=1; j<n; j++){
            grid[0][j] += grid[0][j-1];
        }
        for(int i=1; i<m; i++){
            for(int j=1;  j<n; j++){
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}
*/

/**
 * 背包问题
 */
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        int[][] dp = new int[A.length+1][m+1];//前i个物品背包大小为j的最大价值
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j=1; j<=m; j++){
            dp[0][j] = 0;
        }
        for(int i=1;i<dp.length; i++){
            for(int j=1; j<=m; j++){
                if(A[i-1] > j){//选择不拿
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-A[i-1]]+V[i-1]);//不拿和拿时的最大价值
                }
            }
        }
        return dp[dp.length-1][m];
    }
}

