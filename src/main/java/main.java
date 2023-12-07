import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class main{
    public static Scanner sc = new Scanner(System.in);
    private static Product prd;
    static final QueueADT<Order> orderQueueADT = new QueueADTImpl<>(100);

    public static void main(String[] args) {
        Product p1 = new Product(1, "Laptop Acer", 10000000);
        Product p2 = new Product(2, "Laptop Asus", 20000000);
        Product p3 = new Product(3, "Macbook Pro", 30000000);
        prd.getPrdList().add(p1);
        prd.getPrdList().add(p2);
        prd.getPrdList().add(p3);

        mainMenu();
        int choice;
        do {
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("----- TẠO HOÁ ĐƠN -----");
                    addOrder();
                    break;
                case 2:
                    System.out.println("----- DUYỆT HOÁ ĐƠN -----");
                    Order.statusUpdate();
                    mainMenu();
                    break;
                case 3:
                    System.out.println("----- DANH SÁCH HOÁ ĐƠN -----");
                    try {
                        Order.sortOrder();
                    } catch (Exception e) {
                        System.out.println("Không có hoá đơn nào!");
                    }
//                    for (Order order : Order.getOrderList()) {
//                        System.out.println(order.getId());
//                    }
                    mainMenu();
                    break;
                case 4:
                    System.out.println("----- TÌM KIẾM HOÁ ĐƠN -----");
                    Order.searchOrder();
                    mainMenu();
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không đúng! Vui lòng chọn lại!");
                    mainMenu();
                    break;
            }
        } while (choice != 0);
    }

    // Các menu
    public static void mainMenu() {
        System.out.println("===== PHẦN MỀM QUẢN LÝ HOÁ ĐƠN BÁN HÀNG =====");
        System.out.println("1. Tạo hoá đơn");
        System.out.println("2. Duyệt hoá đơn");
        System.out.println("3. Hiển thị ra tất cả hoá đơn theo giá tăng dần");
        System.out.println("4. Tìm kiếm đơn hàng theo mã hoá đơn");
        System.out.println("0. Thoát chương trình");
        System.out.print("Mời nhập lựa chọn: ");
    }

    private static void addOrder() {
        int id = new Random().nextInt(1000);
        System.out.print("Ngày tạo hoá đơn: ");
        String date = sc.nextLine();
        System.out.print("Tên khách hàng: ");
        String custName = sc.nextLine();
        System.out.print("Số điện thoại khách hàng: ");
        String custPhone = sc.nextLine();
        Order order = new Order(id, date, custName, custPhone);
        System.out.print("Số sản phẩm muốn thêm: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            System.out.println("Thêm sản phẩm thứ " + i + " :");
            System.out.print("Mã sản phẩm: ");
            int prdId = sc.nextInt();
            System.out.print("Số lượng: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            Product prd = findProductById(prdId);
            if (prd != null) {
                order.getItemList().add(new OrderItem(id, prd, quantity));
            } else {
                System.out.println("ID sản phẩm " + prdId + " không đúng! Vui lòng nhập lại!");
            }
        }
        order.calcTotal();
//        order.printOrder();
        Order.getOrderList().add(order);
        orderQueueADT.enqueue(order);
        mainMenu();
    }

    private static Product findProductById(int prdId) {
        for (Product p : prd.getPrdList()) {
            if (prdId == p.getId()) {
                return p;
            }
        }
        return null;
    }
}
