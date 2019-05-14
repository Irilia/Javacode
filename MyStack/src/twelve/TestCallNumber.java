package twelve;

public class TestCallNumber {
    public static void main(String[] args) {
        System.out.println(CallNumber(10));
    }

    public static int CallNumber(int count){
        if(count == 0){
            throw new UnsupportedOperationException("count must bigger than 0");
        }
        boolean[] status = new boolean[count];
        for (int i = 0; i < status.length; i++) {
            status[i] = true;
        }
        int index = -1;
        int counter = 0;
        int number = 0;
        while(counter<status.length-1){
            //index要成环
            index = (index+1) % status.length;
            if(!status[index]){
                continue;
            }
            //number在1-3内成环
            number = (number+1)%3;
            if(number == 0){
                status[index] = false;
                counter++;
            }
        }
        for (int i = 0; i < status.length; i++) {
            if(status[i]){
                return i+1;
            }
        }
        return -1;
    }

}
