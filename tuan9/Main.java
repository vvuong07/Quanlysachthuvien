package tuan9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLySach ql = new QuanLySach();
        int chon;
        do {
            System.out.println("\n===== QUAN LY SACH =====");
            System.out.println("1. Nhap danh sach sach");
            System.out.println("2. Xuat danh sach sach");
            System.out.println("3. Tong thanh tien tung loai");
            System.out.println("4. Trung binh cong don gia sach tham khao");
            System.out.println("5. Xuat sach giao khoa cua nha xuat ban X");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            try {
                chon = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                chon = -1;
            }
            switch (chon) {
                case 1 -> ql.nhapDanhSach(sc);
                case 2 -> ql.xuatDanhSach();
                case 3 -> {
                    System.out.printf("Tong thanh tien sach giao khoa: %,.0f%n", ql.tongThanhTienSGK());
                    System.out.printf("Tong thanh tien sach tham khao: %,.0f%n", ql.tongThanhTienSTK());
                }
                case 4 -> System.out.printf("Trung binh don gia sach tham khao: %,.2f%n", ql.trungBinhDonGiaSTK());
                case 5 -> {
                    System.out.print("Nhap nha xuat ban X: ");
                    ql.xuatSGKTheoNXB(sc.nextLine().trim());
                }
                case 0 -> System.out.println("Tam biet!");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }
}
