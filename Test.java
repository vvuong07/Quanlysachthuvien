import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    static Scanner sc = new Scanner(System.in);

    // Yeu cau 4: danh sach Sach quan ly bang ArrayList
    static ArrayList<Sach> danhSach = new ArrayList<>();

    // ===== Cac ham nhap lieu (dung vong lap de nhap lai khi sai) =====
    static String nhapChuoi(String thongBao) {
        String s;
        do {
            System.out.print(thongBao);
            s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.out.println("Khong duoc de trong!");
            }
        } while (s.isEmpty());
        return s;
    }

    static int nhapSoNguyen(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen hop le!");
            }
        }
    }

    static int nhapNamXuatBan() {
        int namHienTai = Year.now().getValue();
        int nam;
        do {
            nam = nhapSoNguyen("Nhap nam xuat ban: ");
            if (nam <= 0 || nam > namHienTai) {
                System.out.println("Nam xuat ban phai tu 1 den " + namHienTai + "!");
            }
        } while (nam <= 0 || nam > namHienTai);
        return nam;
    }

    static int nhapSoLuong() {
        int sl;
        do {
            sl = nhapSoNguyen("Nhap so luong: ");
            if (sl < 0) {
                System.out.println("So luong phai lon hon hoac bang 0!");
            }
        } while (sl < 0);
        return sl;
    }

    static Sach timTheoMa(String ma) {
        for (Sach s : danhSach) {
            if (s.maSach.equalsIgnoreCase(ma)) {
                return s;
            }
        }
        return null;
    }

    // ===== Yeu cau 3: Tao doi tuong tu lop Sach =====
    static void yeuCau3() {
        System.out.println("===== YEU CAU 3: TAO DOI TUONG TU LOP SACH =====");

        Sach s1 = new Sach();
        s1.maSach = "S001";
        s1.tieuDe = "Lap trinh Java";
        s1.tacGia = "Nguyen Van A";
        s1.namXuatBan = 2023;
        s1.soLuong = 10;

        Sach s2 = new Sach();
        s2.maSach = "S002";
        s2.tieuDe = "Cau truc du lieu";
        s2.tacGia = "Tran Thi B";
        s2.namXuatBan = 2021;
        s2.soLuong = 5;

        System.out.println("--- Sach 1 ---");
        s1.hienThiThongTin();
        System.out.println("--- Sach 2 ---");
        s2.hienThiThongTin();

        // Dua 2 sach mau vao danh sach de dung cho Yeu cau 4
        danhSach.add(s1);
        danhSach.add(s2);
        System.out.println("(Da them 2 sach mau vao danh sach)");
    }

    // ===== Yeu cau 4: Quan ly danh sach Sach bang ArrayList =====
    static void themSach() {
        String ma;
        while (true) {
            ma = nhapChuoi("Nhap ma sach: ");
            if (timTheoMa(ma) == null) {
                break;
            }
            System.out.println("Ma sach da ton tai, vui long nhap ma khac!");
        }
        Sach s = new Sach();
        s.maSach = ma;
        s.tieuDe = nhapChuoi("Nhap tieu de: ");
        s.tacGia = nhapChuoi("Nhap tac gia: ");
        s.namXuatBan = nhapNamXuatBan();
        s.soLuong = nhapSoLuong();
        danhSach.add(s);
        System.out.println("Da them sach " + s.maSach + ".");
    }

    static void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach sach dang trong.");
            return;
        }
        System.out.println("===== DANH SACH SACH (" + danhSach.size() + " cuon) =====");
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println("--- Sach " + (i + 1) + " ---");
            danhSach.get(i).hienThiThongTin();
        }
    }

    static void timSach() {
        String tuKhoa = nhapChuoi("Nhap ma hoac tieu de sach can tim: ").toLowerCase();
        int dem = 0;
        for (Sach s : danhSach) {
            if (s.maSach.toLowerCase().equals(tuKhoa) || s.tieuDe.toLowerCase().contains(tuKhoa)) {
                if (dem == 0) {
                    System.out.println("Ket qua tim kiem:");
                }
                System.out.println("-----");
                s.hienThiThongTin();
                dem++;
            }
        }
        if (dem == 0) {
            System.out.println("Khong tim thay sach phu hop.");
        }
    }

    static void xoaSach() {
        String ma = nhapChuoi("Nhap ma sach can xoa: ");
        Sach s = timTheoMa(ma);
        if (s == null) {
            System.out.println("Khong tim thay sach co ma " + ma + ".");
        } else {
            danhSach.remove(s);
            System.out.println("Da xoa sach " + s.maSach + ".");
        }
    }

    static void suaSach() {
        String ma = nhapChuoi("Nhap ma sach can sua: ");
        Sach s = timTheoMa(ma);
        if (s == null) {
            System.out.println("Khong tim thay sach co ma " + ma + ".");
            return;
        }
        System.out.println("Thong tin hien tai:");
        s.hienThiThongTin();
        System.out.println("Nhap thong tin moi (giu nguyen ma sach):");
        s.tieuDe = nhapChuoi("Nhap tieu de: ");
        s.tacGia = nhapChuoi("Nhap tac gia: ");
        s.namXuatBan = nhapNamXuatBan();
        s.soLuong = nhapSoLuong();
        System.out.println("Da sua sach " + s.maSach + ".");
    }

    static void tinhTongSoLuong() {
        int tong = 0;
        for (Sach s : danhSach) {
            tong += s.soLuong;
        }
        System.out.println("Tong so luong sach: " + tong);
    }

    public static void main(String[] args) {
        yeuCau3();

        int chon;
        do {
            System.out.println();
            System.out.println("========== QUAN LY SACH THU VIEN ==========");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi danh sach sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("0. Thoat");
            chon = nhapSoNguyen("Nhap lua chon: ");

            switch (chon) {
                case 1:
                    themSach();
                    break;
                case 2:
                    hienThiDanhSach();
                    break;
                case 3:
                    timSach();
                    break;
                case 4:
                    xoaSach();
                    break;
                case 5:
                    suaSach();
                    break;
                case 6:
                    tinhTongSoLuong();
                    break;
                case 0:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);

        sc.close();
    }
}
