package TypeUnit;

import java.util.ArrayList;
import java.util.List;

class Order {
    private String title;
    private Double price;

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getCount() {
        return count;
    }

    private Integer count;

    public Order(String title, Double price, Integer count) {
        this.title = title;
        this.price = price;
        this.count = count;
    }
}
public class StreamTest {
    public static void main(String[] args) {
        List<Order> list = new ArrayList<>();
        list.add(new Order("口红",200.0,10));
        list.add(new Order("电动车",1800.0,2));
        list.add(new Order("电脑",15000.0,1));
        double allPrice = list.stream()
                .map((e) -> e.getCount() * e.getPrice())
                .reduce((sum,x) -> sum + x)
                .get();
        System.out.println(allPrice);
    }
}
