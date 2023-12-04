import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static Scanner sc = new Scanner(System.in);
    private static Product prd;
    public static void main(String[] args) {
        Product p1 = new Product(1, "Product 1", 1000);
        Product p2 = new Product(2, "Product 2", 2000);
        Product p3 = new Product(3, "Product 3", 3000);
        prd.getPrdList().add(p1);
        prd.getPrdList().add(p2);
        prd.getPrdList().add(p3);

        Order order = new Order();
        QueueADT<Order> orders = new QueueADTImpl<>(100);
        mainMenu();
        int choice;
        do {
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("----- TẠO HOÁ ĐƠN -----");
                    order.addOrder();
                    int pChoice;
                    do {
                        productMenu();
                        pChoice = sc.nextInt();
                        switch(pChoice) {
                            case 1:
                            int prdId;
                            int quantity;
                            do {
                                getPrdList();
                                System.out.print("Nhập id sản phẩm từ 1 đến 5 (nhập 0 để thoát): ");
                                prdId = sc.nextInt();
                                System.out.print("Nhập số lượng: ");
                                quantity = sc.nextInt();
                                if (prdId == 0) {
                                    mainMenu();
                                }
                                for (int i = 1; i <= 5; i++) {
                                    for (Product p : prd.getPrdList()) {
                                        if (prdId == i) {
                                            order.getItemList().add(new OrderItem(i, p, quantity));
                                        }
                                    }
                                }
                                if (prdId < 0 || prdId >= 6) {
                                    System.out.println("Mã sản phẩm không hợp lệ. Mời nhập lại: ");
                                }
                            } while (prdId != 0);
                            order.calcTotal();
                            pChoice = 0;
                            break;
                            case 0:
                                break;
                        }
                    } while (pChoice != 0);
                    break;
                case 2:
                    order.statusUpdate();
                    mainMenu();
                    break;
                case 3:
                    System.out.println("----- DANH SÁCH HOÁ ĐƠN -----");
                    order.printOrder();
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
}
