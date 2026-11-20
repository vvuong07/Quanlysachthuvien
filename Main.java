import java.time.Year;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    // Du lieu n cuon sach (dung mang song song)
    static String[] maSach;
    static String[] tenSach;
    static String[] tacGia;
    static int[] namXuatBan;
    static double[] donGia;
    static int[] soLuong;
    static int[] loaiSach;
    static int soSach = 0;

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

    static double nhapSoThuc(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so hop le!");
            }
        }
    }

    static int nhapNamXuatBan() {
        int namHienTai = Year.now().getValue();
        int nam;
        do {
            nam = nhapSoNguyen("Nhap nam xuat ban: ");
            if (nam < 1900 || nam > namHienTai) {
                System.out.println("Nam xuat ban phai tu 1900 den " + namHienTai + "!");
            }
        } while (nam < 1900 || nam > namHienTai);
        return nam;
    }

    static double nhapDonGia() {
        double gia;
        do {
            gia = nhapSoThuc("Nhap don gia: ");
            if (gia <= 0) {
                System.out.println("Don gia phai lon hon 0!");
            }
        } while (gia <= 0);
        return gia;
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

    static int nhapLoaiSach() {
        int chon;
        do {
            System.out.println("Chon loai sach: 1. Giao khoa  2. Tham khao  3. Chuyen nganh  4. Khac");
            chon = nhapSoNguyen("Nhap lua chon (1-4): ");
            if (chon < 1 || chon > 4) {
                System.out.println("Lua chon phai tu 1 den 4!");
            }
        } while (chon < 1 || chon > 4);
        return chon;
    }

    static String nhapMaSachMoi(int viTri) {
        while (true) {
            String ma = nhapChuoi("Nhap ma sach: ");
            boolean trung = false;
            for (int j = 0; j < viTri; j++) {
                if (maSach[j].equalsIgnoreCase(ma)) {
                    trung = true;
                    break;
                }
            }
            if (!trung) {
                return ma;
            }
            System.out.println("Ma sach da ton tai, vui long nhap ma khac!");
        }
    }

    // ===== Cac ham phan loai (tu tuan 4) =====
    static String phanLoaiGia(double gia) {
        if (gia < 50000) {
            return "Gia thap";
        } else if (gia <= 100000) {
            return "Gia trung binh";
        } else if (gia <= 200000) {
            return "Gia cao";
        } else {
            return "Gia dac biet";
        }
    }

    static String phanLoaiTonKho(int sl) {
        if (sl == 0) {
            return "Het sach";
        } else if (sl <= 5) {
            return "Sap het";
        } else if (sl <= 20) {
            return "Con it";
        } else {
            return "Con nhieu";
        }
    }

    static String tenLoaiSach(int loai) {
        switch (loai) {
            case 1:
                return "Giao khoa";
            case 2:
                return "Tham khao";
            case 3:
                return "Chuyen nganh";
            default:
                return "Khac";
        }
    }

    // ===== Bai 1: Nhap n sach bang vong lap =====
    static void nhapNSach() {
        int n;
        do {
            n = nhapSoNguyen("Nhap so luong sach can nhap (n): ");
            if (n <= 0) {
                System.out.println("n phai lon hon 0!");
            }
        } while (n <= 0);

        maSach = new String[n];
        tenSach = new String[n];
        tacGia = new String[n];
        namXuatBan = new int[n];
        donGia = new double[n];
        soLuong = new int[n];
        loaiSach = new int[n];
        soSach = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("--- Nhap sach thu " + (i + 1) + " ---");
            maSach[i] = nhapMaSachMoi(i);
            tenSach[i] = nhapChuoi("Nhap ten sach: ");
            tacGia[i] = nhapChuoi("Nhap tac gia: ");
            namXuatBan[i] = nhapNamXuatBan();
            donGia[i] = nhapDonGia();
            soLuong[i] = nhapSoLuong();
            loaiSach[i] = nhapLoaiSach();
            soSach++;
        }
        System.out.println("Da nhap xong " + soSach + " cuon sach.");
    }

    static void hienThiDanhSach() {
        if (soSach == 0) {
            System.out.println("Chua co sach nao. Hay chon 1 de nhap sach.");
            return;
        }
        System.out.println("===== DANH SACH SACH =====");
        System.out.printf("%-4s %-8s %-22s %-16s %-6s %12s %-15s %-10s %-12s%n",
                "STT", "Ma", "Ten sach", "Tac gia", "Nam", "Don gia", "Phan loai gia", "So luong", "Loai");
        for (int i = 0; i < soSach; i++) {
            System.out.printf("%-4d %-8s %-22s %-16s %-6d %,12.0f %-15s %-10s %-12s%n",
                    i + 1, maSach[i], tenSach[i], tacGia[i], namXuatBan[i], donGia[i],
                    phanLoaiGia(donGia[i]),
                    soLuong[i] + " (" + phanLoaiTonKho(soLuong[i]) + ")",
                    tenLoaiSach(loaiSach[i]));
        }
    }

    // ===== Bai 2: Tinh tong so luong va tong gia tri =====
    static void tinhTong() {
        if (soSach == 0) {
            System.out.println("Chua co sach nao. Hay chon 1 de nhap sach.");
            return;
        }
        int tongSoLuong = 0;
        double tongGiaTri = 0;
        for (int i = 0; i < soSach; i++) {
            tongSoLuong += soLuong[i];
            tongGiaTri += donGia[i] * soLuong[i];
        }
        double phiVanChuyen = tongGiaTri * 0.05;
        System.out.println("Tong so luong sach : " + tongSoLuong);
        System.out.printf("Tong gia tri sach  : %,.0f VND%n", tongGiaTri);
        System.out.printf("Phi van chuyen (5%%) : %,.0f VND%n", phiVanChuyen);
        System.out.printf("Tong tien nhap     : %,.0f VND%n", tongGiaTri + phiVanChuyen);
    }

    // ===== Bai 4: Tim sach theo ma =====
    static void timSachTheoMa() {
        if (soSach == 0) {
            System.out.println("Chua co sach nao. Hay chon 1 de nhap sach.");
            return;
        }
        String ma = nhapChuoi("Nhap ma sach can tim: ");
        boolean timThay = false;
        for (int i = 0; i < soSach; i++) {
            if (maSach[i].equalsIgnoreCase(ma)) {
                System.out.println("Da tim thay sach:");
                System.out.println("  Ma sach       : " + maSach[i]);
                System.out.println("  Ten sach      : " + tenSach[i]);
                System.out.println("  Tac gia       : " + tacGia[i]);
                System.out.println("  Nam xuat ban  : " + namXuatBan[i]);
                System.out.printf("  Don gia       : %,.0f VND (%s)%n", donGia[i], phanLoaiGia(donGia[i]));
                System.out.println("  So luong      : " + soLuong[i] + " (" + phanLoaiTonKho(soLuong[i]) + ")");
                System.out.println("  Loai sach     : " + tenLoaiSach(loaiSach[i]));
                System.out.printf("  Thanh tien    : %,.0f VND%n", donGia[i] * soLuong[i]);
                timThay = true;
                break;
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay sach co ma \"" + ma + "\".");
        }
    }

    // ===== Bai 3: Menu lap den khi chon Thoat =====
    public static void main(String[] args) {
        int chon;
        do {
            System.out.println();
            System.out.println("========== QUAN LY SACH THU VIEN ==========");
            System.out.println("1. Nhap n sach");
            System.out.println("2. Hien thi danh sach sach");
            System.out.println("3. Tinh tong so luong va tong gia tri");
            System.out.println("4. Tim sach theo ma");
            System.out.println("0. Thoat");
            chon = nhapSoNguyen("Nhap lua chon: ");

            switch (chon) {
                case 1:
                    nhapNSach();
                    break;
                case 2:
                    hienThiDanhSach();
                    break;
                case 3:
                    tinhTong();
                    break;
                case 4:
                    timSachTheoMa();
                    break;
                case 0:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
            }
        } while (chon != 0);

        sc.close();
    }
}