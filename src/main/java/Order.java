import java.util.*;

import static java.util.Comparator.comparing;

public class Order {
    private static Scanner sc = new Scanner(System.in);
    private int id;
    private String date;
    private String custName;
    private String custPhone;
    private int totalAmount;
    private boolean status = false;
    private List<OrderItem> itemList;
    private static Product prd;
    static List<Order> orderList = new ArrayList<>();

    public Order(int id, String date, String custName, String custPhone) {
        this.id = id;
        this.date = date;
        this.custName = custName;
        this.custPhone = custPhone;
        this.itemList = new ArrayList<>();
//        this.orderList = new ArrayList<>();
    }

    public Order(int id, String date, String custName, String custPhone, int totalAmount, List<OrderItem> itemList) {
        this.id = id;
        this.date = date;
        this.custName = custName;
        this.custPhone = custPhone;
        this.totalAmount = totalAmount;
        this.itemList = itemList;
    }

    public static List<Order> getOrderList() {
        return orderList;
    }

    public static void setOrderList(List<Order> orderList) {
        Order.orderList = orderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }


    public void calcTotal() {
        // Tính tổng tiền
        for (OrderItem orderItem : itemList) {
            totalAmount += orderItem.getItem().getPrice() * orderItem.getQuantity();
        }
    }

    public void statusUpdate() {

    }

    public static void searchOrder() {
        int s;
        System.out.print("Nhập mã hoá đơn cần tìm: ");
        s = sc.nextInt();
        try {
            // Tìm hoá đơn dựa theo id
            for (Order order : getOrderList()) {
                if (order.getId() == s) {
                    // Hiển thị
                    System.out.println("----------------------");
                    System.out.println("Hoá đơn thứ " + order.getId());
                    System.out.printf("Khách hàng -- [%s - %s] \n", order.getCustName(), order.getCustPhone());
                    System.out.println("Tổng tiền: " + order.getTotalAmount());
                    System.out.println("Trạng thái đơn: " + (order.isStatus() == true ? "Đã duyệt" : "Chờ duyệt"));
                    // Danh sách sản phẩm trong hoá đơn
                    if (!order.getItemList().isEmpty()) {
                        System.out.println("ID\tSản phẩm\tĐơn giá\tSố lượng\tThành tiền");
                        for (OrderItem orderItem : order.getItemList()) {
                            System.out.print(orderItem.getItem().getId() + "\t");
                            System.out.print(orderItem.getItem().getName() + "\t");
                            System.out.print(orderItem.getItem().getPrice() + "\t");
                            System.out.print(orderItem.getQuantity() + "\t\t\t");
                            System.out.print(orderItem.getItem().getPrice() * orderItem.getQuantity());
                            System.out.println();
                        }
                    } else {
                        System.out.println("Không có sản phẩm trong hoá đơn!");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra!");
        }
    }
    public static void sortOrder() {
        for (int i = 0; i <= orderList.size() - 2; i++) {
            for (int j = i + 1; j <= orderList.size() - 1; j++) {
                if (orderList.get(i).getTotalAmount() > orderList.get(j).getTotalAmount()) {
                    Order order = new Order(orderList.get(i).getId(), orderList.get(i).getDate(), orderList.get(i).getCustName(), orderList.get(i).getCustPhone(), orderList.get(i).getTotalAmount(), orderList.get(i).getItemList());
                    orderList.set(i, orderList.get(j));
                    orderList.set(j, order);
                }
            }
        }
        for (Order order : getOrderList()) {
            // Hiển thị tất cả order
            System.out.println("----------------------");
            System.out.println("Hoá đơn thứ " + order.getId());
            System.out.printf("Khách hàng -- [%s - %s] \n", order.getCustName(), order.getCustPhone());
            System.out.println("Tổng tiền: " + order.getTotalAmount());
            System.out.println("Trạng thái đơn: " + (order.isStatus() == true ? "Đã duyệt" : "Chờ duyệt"));
            // Danh sách sản phẩm trong hoá đơn
            if (!order.getItemList().isEmpty()) {
                System.out.println("ID\tSản phẩm\tĐơn giá\tSố lượng\tThành tiền");
                for (OrderItem orderItem : order.itemList) {
                    System.out.print(orderItem.getItem().getId() + "\t");
                    System.out.print(orderItem.getItem().getName() + "\t");
                    System.out.print(orderItem.getItem().getPrice() + "\t");
                    System.out.print(orderItem.getQuantity() + "\t\t\t");
                    System.out.print(orderItem.getItem().getPrice() * orderItem.getQuantity());
                    System.out.println();
                }
            } else {
                System.out.println("Không có sản phẩm trong hoá đơn!");
            }
        }
    }
}
