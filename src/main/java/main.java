import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class main{
    public static Scanner sc = new Scanner(System.in);
    private static Product prd;

    static Order orderList;

    static QueueADT<Order> orderQueueADT = new QueueADTImpl<>(100);

    public static void main(String[] args) {
        Product p1 = new Product(1, "Product 1", 1000);
        Product p2 = new Product(2, "Product 2", 2000);
        Product p3 = new Product(3, "Product 3", 3000);
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

                    mainMenu();
                    break;
                case 3:
                    System.out.println("----- DANH SÁCH HOÁ ĐƠN -----");

                    mainMenu();
                    break;
                case 4:

                    mainMenu();
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không đúng! Vui lòng chọn lại hoặc cook!");
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

    public static void productMenu() {
        System.out.println("----- Thêm sản phẩm vào hoá đơn -----");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("0. Thoát ra menu chính");
        System.out.print("Mời nhập lựa chọn: ");
    }

    public static void getPrdList() {
        try {
            System.out.println("ID\tTên sản phẩm\tĐơn giá\t");
            for (Product p : prd.getPrdList()) {
                System.out.print(p.getId() + "\t");
                System.out.print(p.getName() + "\t\t");
                System.out.print(p.getPrice() + "\t");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Không có sản phẩm nào :))");
        }
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
        for (int i = 0; i < n; i++) {
            System.out.print("Product's ID: ");
            int prdId = sc.nextInt();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            Product prd = findProductById(prdId);

            if (prd != null) {
                order.getItemList().add(new OrderItem(id, prd, quantity));
            } else {
                System.out.println("Product does not exist with ID: " + prdId);
            }
        }
        order.calcTotal();
        order.printOrder();
        orderList.(order);
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

//    private static void showOrder() {
//        for (int i = 0; i < Order.orderList.size()-2; i++){
//            for (int j = i+1; j < Order.orderList.size()-1; j++){
//                if (Order.)
//            }
//        }
//    }
}
