package daydata;
//下面代码输出什么内容
public class SystemUtil {
    public static boolean isAdmin(String userId){
        return userId.toLowerCase()=="admin";
    }
    public static void main(String[] args) {
        System.out.println(isAdmin("Admin"));
    }
}
