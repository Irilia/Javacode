package IOData;

public class SimpleMessage implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("AutoCloseable close 方法");
    }

    public void print(){
        System.out.println("SimpleMessage print 方法调用");
    }

    public static void main(String[] args) {
        //try-with-resources---JDK1.7
        /*try(SimpleMessage message = new SimpleMessage()){
            message.print();
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        //自己关闭流
        SimpleMessage message = null;
        try {
            message = new SimpleMessage();
            message.print();
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            if(message != null){
                try {
                    message.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }




    }
}
