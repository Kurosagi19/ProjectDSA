import java.util.Scanner;

public class main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Order order = new Order();
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
                            do {
                                order.getItemList();
                                System.out.print("Nhập id sản phẩm từ 1 đến 5 (nhập 0 để thoát): ");
                                prdId = sc.nextInt();
                                int x = 0;
                                for (int i = 1; i <= 5; i++) {
                                    if (prdId == i) {
                                        // Code thêm sản phẩm vào hoá đơn đang tạo
                                    }
                                }
                                if (x == 0 && prdId <= 0 || x == 0 && prdId >= 6) {
                                    System.out.print("Mã sản phẩm không hợp lệ. Mời nhập lại (từ 1 đến 5): ");
                                }
                            } while (prdId != 0);
                            order.calcTotal();
                            break;
                            case 0:
                                mainMenu();
                                break;
                        }
                    } while (pChoice != 0);
                    break;
                case 2:
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
}
