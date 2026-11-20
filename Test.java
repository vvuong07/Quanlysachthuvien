import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    static Scanner sc = new Scanner(System.in);

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
            if (s.getMaSach().equalsIgnoreCase(ma)) {
                return s;
            }
        }
        return null;
    }

    // ===== Minh hoa tinh dong goi: constructor, getter, setter =====
    static void minhHoaDongGoi() {
        System.out.println("===== MINH HOA TINH DONG GOI =====");

        // Khoi tao bang constructor day du tham so
        Sach s1 = new Sach("S001", "Lap trinh Java", "Nguyen Van A", 2023, 10);
        Sach s2 = new Sach("S002", "Cau truc du lieu", "Tran Thi B", 2021, 5);

        System.out.println("--- Sach 1 (tao bang constructor) ---");
        s1.hienThiThongTin();

        // Doc du lieu qua getter (khong the truy cap truc tiep vi thuoc tinh la private)
        System.out.println("Doc qua getter: tieu de = " + s2.getTieuDe()
                + ", so luong = " + s2.getSoLuong());

        // Thu gan gia tri khong hop le qua setter -> bi tu choi
        System.out.println("Thu setNamXuatBan(3000):");
        s1.setNamXuatBan(3000);
        System.out.println("Thu setSoLuong(-5):");
        s1.setSoLuong(-5);
        System.out.println("Sau khi thu, gia tri van la: nam = " + s1.getNamXuatBan()
                + ", so luong = " + s1.getSoLuong());

        // Gan gia tri hop le qua setter -> thanh cong
        s1.setSoLuong(25);
        System.out.println("Sau setSoLuong(25): so luong = " + s1.getSoLuong());

        danhSach.add(s1);
        danhSach.add(s2);
        System.out.println("(Da them 2 sach mau vao danh sach)");
    }

    // ===== Quan ly danh sach Sach bang ArrayList =====
    static void themSach() {
        String ma;
        while (true) {
            ma = nhapChuoi("Nhap ma sach: ");
            if (timTheoMa(ma) == null) {
                break;
            }
            System.out.println("Ma sach da ton tai, vui long nhap ma khac!");
        }
        String tieuDe = nhapChuoi("Nhap tieu de: ");
        String tacGia = nhapChuoi("Nhap tac gia: ");
        int nam = nhapNamXuatBan();
        int sl = nhapSoLuong();
        Sach s = new Sach(ma, tieuDe, tacGia, nam, sl);
        danhSach.add(s);
        System.out.println("Da them sach " + s.getMaSach() + ".");
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
            if (s.getMaSach().toLowerCase().equals(tuKhoa)
                    || s.getTieuDe().toLowerCase().contains(tuKhoa)) {
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
            System.out.println("Da xoa sach " + s.getMaSach() + ".");
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
        s.setTieuDe(nhapChuoi("Nhap tieu de: "));
        s.setTacGia(nhapChuoi("Nhap tac gia: "));
        s.setNamXuatBan(nhapNamXuatBan());
        s.setSoLuong(nhapSoLuong());
        System.out.println("Da sua sach " + s.getMaSach() + ".");
    }

    static void tinhTongSoLuong() {
        int tong = 0;
        for (Sach s : danhSach) {
            tong += s.getSoLuong();
        }
        System.out.println("Tong so luong sach: " + tong);
    }

    public static void main(String[] args) {
        minhHoaDongGoi();

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