import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Scanner;

public class main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Order order = new Order();
        int choice;
        do {
            System.out.println("===== PHẦN MỀM QUẢN LÝ HOÁ ĐƠN BÁN HÀNG =====");
            System.out.println("1. Tạo hoá đơn");
            System.out.println("2. Duyệt hoá đơn");
            System.out.println("3. Hiển thị ra tất cả hoá đơn theo giá tăng dần");
            System.out.println("4. Tìm kiếm đơn hàng theo mã hoá đơn");
            System.out.println("0. Thoát chương trình");
            System.out.print("Mời nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("----- TẠO HOÁ ĐƠN -----");
                    order.addOrder();
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("----- DANH SÁCH HOÁ ĐƠN -----");
                    order.printOrder();
                    break;
                case 4:

                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không đúng! Vui lòng chọn lại hoặc cook!");
            }
        } while (choice != 0);
    }
}
