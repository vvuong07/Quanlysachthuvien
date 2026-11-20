import java.time.Year;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== Nhap thong tin sach (tu tuan 3) =====
        System.out.print("Nhap ma sach: ");
        String maSach = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        String tenSach = sc.nextLine();

        System.out.print("Nhap tac gia: ");
        String tacGia = sc.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        int namXuatBan = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Nhap don gia: ");
        double donGia = Double.parseDouble(sc.nextLine().trim());

        System.out.print("Nhap so luong: ");
        int soLuong = Integer.parseInt(sc.nextLine().trim());

        System.out.println("Chon loai sach:");
        System.out.println("  1. Sach giao khoa");
        System.out.println("  2. Sach tham khao");
        System.out.println("  3. Sach chuyen nganh");
        System.out.println("  4. Sach khac");
        System.out.print("Nhap lua chon (1-4): ");
        int chonLoai = Integer.parseInt(sc.nextLine().trim());

        // ===== Bai 1: Kiem tra tinh hop le =====
        int namHienTai = Year.now().getValue();
        boolean hopLe = true;

        if (donGia <= 0) {
            System.out.println("Loi: don gia phai lon hon 0.");
            hopLe = false;
        }
        if (soLuong < 0) {
            System.out.println("Loi: so luong phai lon hon hoac bang 0.");
            hopLe = false;
        }
        if (namXuatBan < 1900 || namXuatBan > namHienTai) {
            System.out.println("Loi: nam xuat ban phai tu 1900 den " + namHienTai + ".");
            hopLe = false;
        }

        if (!hopLe) {
            System.out.println("Thong tin sach khong hop le. Ket thuc chuong trinh.");
            sc.close();
            return;
        }

        // ===== Bai 2: Phan loai gia =====
        String phanLoaiGia;
        if (donGia < 50000) {
            phanLoaiGia = "Sach gia thap";
        } else if (donGia <= 100000) {
            phanLoaiGia = "Sach gia trung binh";
        } else if (donGia <= 200000) {
            phanLoaiGia = "Sach gia cao";
        } else {
            phanLoaiGia = "Sach gia dac biet";
        }

        // ===== Bai 3: Phan loai ton kho =====
        String tinhTrangTonKho;
        if (soLuong == 0) {
            tinhTrangTonKho = "Het sach";
        } else if (soLuong <= 5) {
            tinhTrangTonKho = "Sap het";
        } else if (soLuong <= 20) {
            tinhTrangTonKho = "Con it";
        } else {
            tinhTrangTonKho = "Con nhieu";
        }

        // ===== Bai 4: Dung switch chon loai sach =====
        String tenLoaiSach;
        switch (chonLoai) {
            case 1:
                tenLoaiSach = "Sach giao khoa";
                break;
            case 2:
                tenLoaiSach = "Sach tham khao";
                break;
            case 3:
                tenLoaiSach = "Sach chuyen nganh";
                break;
            case 4:
                tenLoaiSach = "Sach khac";
                break;
            default:
                tenLoaiSach = "Khong hop le (xep vao Sach khac)";
        }

        // ===== Tinh tien (tu tuan 3) =====
        double thanhTien = donGia * soLuong;
        double phiVanChuyen = thanhTien * 0.05;
        double tongTienNhap = thanhTien + phiVanChuyen;

        // ===== Hien thi ket qua =====
        System.out.println();
        System.out.println("===== THONG TIN SACH =====");
        System.out.println("Ma sach       : " + maSach);
        System.out.println("Ten sach      : " + tenSach);
        System.out.println("Tac gia       : " + tacGia);
        System.out.println("Nam xuat ban  : " + namXuatBan);
        System.out.printf("Don gia       : %,.0f VND (%s)%n", donGia, phanLoaiGia);
        System.out.println("So luong      : " + soLuong + " (" + tinhTrangTonKho + ")");
        System.out.println("Loai sach     : " + tenLoaiSach);
        System.out.printf("Thanh tien    : %,.0f VND%n", thanhTien);
        System.out.printf("Phi van chuyen: %,.0f VND%n", phiVanChuyen);
        System.out.printf("Tong tien nhap: %,.0f VND%n", tongTienNhap);

        sc.close();
    }
}