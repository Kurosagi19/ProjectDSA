import java.util.*;

public class Order{
    private static Scanner sc = new Scanner(System.in);
    private int id;
    private String date;
    private String custName;
    private String custPhone;
    private int totalAmount;
    private boolean status = false;
    private List<OrderItem> itemList;

    private static Product prd;

    public Order() {
    }

    public Order(int id, String date, String custName, String custPhone) {
        this.id = id;
        this.date = date;
        this.custName = custName;
        this.custPhone = custPhone;
        this.itemList = new ArrayList<>();
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
        for (OrderItem orderItem: itemList) {
            totalAmount += orderItem.getItem().getPrice() * orderItem.getQuantity();
        }
    }
    public void addOrder() {

        System.out.print("Nhập id hoá đơn: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Ngày tạo hoá đơn: ");
        String date = sc.nextLine();
        System.out.print("Tên khách hàng: ");
        String custName = sc.nextLine();
        System.out.print("Số điện thoại khách hàng: ");
        String custPhone = sc.nextLine();
        Order order = new Order(id, date, custName, custPhone);
        int pChoice;
        do {

            main.productMenu();
            pChoice = sc.nextInt();
            switch (pChoice) {
                case 1:
                    int prdId;
                    int quantity;
                    do {
                        main.getPrdList();
                        System.out.print("Nhập id sản phẩm (nhập 0 để thoát): ");
                        prdId = sc.nextInt();
                        if (prdId == 0) {
                            main.mainMenu();
                        } else {
                            System.out.print("Nhập số lượng: ");
                            quantity = sc.nextInt();
                            for (Product p : prd.getPrdList()) {
                                if (prdId == p.getId()) {
                                    order.getItemList().add(new OrderItem(prdId, p, quantity));
                                }
                            }
                            if (prdId < 0 || prdId >= 6) {
                                System.out.println("Mã sản phẩm không hợp lệ. Mời nhập lại: ");
                            }
                        }
                    } while (prdId != 0);
                    order.calcTotal();
                    QueueADT<Order> orderQueueADT = new QueueADTImpl<>(100);
                    orderQueueADT.enqueue(order);
                    pChoice = 0;
                    break;
                case 0:
                    main.mainMenu();
                    break;
            }
        } while (pChoice != 0);
    }

    public void statusUpdate() {

    }

    public void searchOrder() {
        int s;
        System.out.print("Nhập mã hoá đơn cần tìm: ");
        s = sc.nextInt();
        for (int i = 1; i <= 2; i++) {
            if (s == getId()) {
                printOrder();
            }
        }
    }

    public void printOrder() {
        // Hiển thị tất cả order
        System.out.println("----------------------");
        System.out.println("Hoá đơn thứ " + id);
        System.out.printf("Khách hàng -- [%s - %s] \n", custName, custPhone);
        System.out.println("Tổng tiền: " + totalAmount);
        System.out.println("Trạng thái đơn: " + (status == true ? "Đã duyệt" : "Chờ duyệt"));
        // Danh sách sản phẩm trong hoá đơn
        try {
            System.out.println("ID\tSản phẩm\tĐơn giá\tSố lượng\tThành tiền");
            for (OrderItem orderItem : itemList) {
                System.out.print(orderItem.getItem().getId() + "\t");
                System.out.print(orderItem.getItem().getName() + "\t");
                System.out.print(orderItem.getItem().getPrice() + "\t");
                System.out.print(orderItem.getQuantity() + "\t\t\t");
                System.out.print(orderItem.getItem().getPrice() * orderItem.getQuantity());
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Không có sản phẩm trong hoá đơn!");
        }
    }
}
