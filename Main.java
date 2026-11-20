import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    // Bai 3 + Bai 4: moi phan tu la 1 chuoi "ma|ten|tacGia|nam|donGia|soLuong"
    static ArrayList<String> danhSachSach = new ArrayList<>();

    // ===== Cac ham nhap lieu (dung vong lap de nhap lai khi sai) =====
    static String nhapChuoi(String thongBao) {
        String s;
        do {
            System.out.print(thongBao);
            s = sc.nextLine().trim().replace("|", " ");
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

    static int nhapSoLuongKhongAm(String thongBao) {
        int sl;
        do {
            sl = nhapSoNguyen(thongBao);
            if (sl < 0) {
                System.out.println("So luong phai lon hon hoac bang 0!");
            }
        } while (sl < 0);
        return sl;
    }

    // ===================== BAI 1: MANG int[] soLuong =====================
    static void bai1() {
        System.out.println("===== BAI 1: MANG SO LUONG 5 CUON SACH =====");
        int[] soLuong = new int[5];

        for (int i = 0; i < soLuong.length; i++) {
            soLuong[i] = nhapSoLuongKhongAm("Nhap so luong cuon sach thu " + (i + 1) + ": ");
        }

        System.out.println("Danh sach so luong:");
        int tong = 0;
        int max = soLuong[0];
        int viTriMax = 0;
        for (int i = 0; i < soLuong.length; i++) {
            System.out.println("  Cuon " + (i + 1) + ": " + soLuong[i]);
            tong += soLuong[i];
            if (soLuong[i] > max) {
                max = soLuong[i];
                viTriMax = i;
            }
        }
        System.out.println("Tong so luong      : " + tong);
        System.out.println("So luong lon nhat  : " + max + " (cuon thu " + (viTriMax + 1) + ")");
    }

    // ===================== BAI 2: ArrayList<String> ma sach =====================
    static void bai2() {
        ArrayList<String> dsMa = new ArrayList<>();
        int chon;
        do {
            System.out.println();
            System.out.println("===== BAI 2: QUAN LY MA SACH (ArrayList<String>) =====");
            System.out.println("1. Them ma sach");
            System.out.println("2. Hien thi ma sach");
            System.out.println("3. Tim ma sach");
            System.out.println("4. Xoa ma sach");
            System.out.println("0. Quay lai");
            chon = nhapSoNguyen("Nhap lua chon: ");

            switch (chon) {
                case 1:
                    String maMoi = nhapChuoi("Nhap ma sach can them: ");
                    if (dsMa.contains(maMoi)) {
                        System.out.println("Ma sach da ton tai!");
                    } else {
                        dsMa.add(maMoi);
                        System.out.println("Da them ma sach " + maMoi + ".");
                    }
                    break;
                case 2:
                    if (dsMa.isEmpty()) {
                        System.out.println("Danh sach ma sach dang trong.");
                    } else {
                        System.out.println("Co " + dsMa.size() + " ma sach:");
                        for (int i = 0; i < dsMa.size(); i++) {
                            System.out.println("  " + (i + 1) + ". " + dsMa.get(i));
                        }
                    }
                    break;
                case 3:
                    String maTim = nhapChuoi("Nhap ma sach can tim: ");
                    int viTri = dsMa.indexOf(maTim);
                    if (viTri >= 0) {
                        System.out.println("Tim thay ma " + maTim + " o vi tri " + (viTri + 1) + ".");
                    } else {
                        System.out.println("Khong tim thay ma " + maTim + ".");
                    }
                    break;
                case 4:
                    String maXoa = nhapChuoi("Nhap ma sach can xoa: ");
                    if (dsMa.remove(maXoa)) {
                        System.out.println("Da xoa ma sach " + maXoa + ".");
                    } else {
                        System.out.println("Khong tim thay ma " + maXoa + ".");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }

    // ============ BAI 3: ArrayList<String> danhSachSach (cac ham dung chung) ============
    static String taoChuoiSach(String ma, String ten, String tacGia, int nam, double gia, int sl) {
        return ma + "|" + ten + "|" + tacGia + "|" + nam + "|" + gia + "|" + sl;
    }

    static int timViTriTheoMa(String ma) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] p = danhSachSach.get(i).split("\\|");
            if (p[0].equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    static void inMotSach(int stt, String dong) {
        String[] p = dong.split("\\|");
        System.out.printf("%-4d %-8s %-22s %-16s %-6s %,12.0f %8s%n",
                stt, p[0], p[1], p[2], p[3], Double.parseDouble(p[4]), p[5]);
    }

    static void themSach() {
        String ma;
        while (true) {
            ma = nhapChuoi("Nhap ma sach: ");
            if (timViTriTheoMa(ma) < 0) {
                break;
            }
            System.out.println("Ma sach da ton tai, vui long nhap ma khac!");
        }
        String ten = nhapChuoi("Nhap ten sach: ");
        String tacGia = nhapChuoi("Nhap tac gia: ");
        int nam = nhapNamXuatBan();
        double gia = nhapDonGia();
        int sl = nhapSoLuongKhongAm("Nhap so luong: ");
        danhSachSach.add(taoChuoiSach(ma, ten, tacGia, nam, gia, sl));
        System.out.println("Da them sach " + ma + ".");
    }

    static void hienThiSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach dang trong.");
            return;
        }
        System.out.println("===== DANH SACH SACH (" + danhSachSach.size() + " cuon) =====");
        System.out.printf("%-4s %-8s %-22s %-16s %-6s %12s %8s%n",
                "STT", "Ma", "Ten sach", "Tac gia", "Nam", "Don gia", "So luong");
        for (int i = 0; i < danhSachSach.size(); i++) {
            inMotSach(i + 1, danhSachSach.get(i));
        }
    }

    static void timSach() {
        String tuKhoa = nhapChuoi("Nhap ma hoac ten sach can tim: ").toLowerCase();
        int dem = 0;
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] p = danhSachSach.get(i).split("\\|");
            if (p[0].toLowerCase().equals(tuKhoa) || p[1].toLowerCase().contains(tuKhoa)) {
                if (dem == 0) {
                    System.out.println("Ket qua tim kiem:");
                }
                inMotSach(i + 1, danhSachSach.get(i));
                dem++;
            }
        }
        if (dem == 0) {
            System.out.println("Khong tim thay sach phu hop.");
        }
    }

    static void xoaSach() {
        String ma = nhapChuoi("Nhap ma sach can xoa: ");
        int viTri = timViTriTheoMa(ma);
        if (viTri < 0) {
            System.out.println("Khong tim thay sach co ma " + ma + ".");
        } else {
            danhSachSach.remove(viTri);
            System.out.println("Da xoa sach " + ma + ".");
        }
    }

    static void suaSach() {
        String ma = nhapChuoi("Nhap ma sach can sua: ");
        int viTri = timViTriTheoMa(ma);
        if (viTri < 0) {
            System.out.println("Khong tim thay sach co ma " + ma + ".");
            return;
        }
        String maCu = danhSachSach.get(viTri).split("\\|")[0];
        System.out.println("Thong tin hien tai:");
        inMotSach(viTri + 1, danhSachSach.get(viTri));
        System.out.println("Nhap thong tin moi (giu nguyen ma sach):");
        String ten = nhapChuoi("Nhap ten sach: ");
        String tacGia = nhapChuoi("Nhap tac gia: ");
        int nam = nhapNamXuatBan();
        double gia = nhapDonGia();
        int sl = nhapSoLuongKhongAm("Nhap so luong: ");
        danhSachSach.set(viTri, taoChuoiSach(maCu, ten, tacGia, nam, gia, sl));
        System.out.println("Da sua sach " + maCu + ".");
    }

    static void tinhTongSoLuong() {
        int tong = 0;
        for (String dong : danhSachSach) {
            tong += Integer.parseInt(dong.split("\\|")[5]);
        }
        System.out.println("Tong so luong sach: " + tong);
    }

    static void tinhTongGiaTri() {
        double tong = 0;
        for (String dong : danhSachSach) {
            String[] p = dong.split("\\|");
            tong += Double.parseDouble(p[4]) * Integer.parseInt(p[5]);
        }
        System.out.printf("Tong gia tri sach: %,.0f VND%n", tong);
    }

    static void bai3() {
        int chon;
        do {
            System.out.println();
            System.out.println("===== BAI 3: QUAN LY SACH (ArrayList<String> danhSachSach) =====");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("0. Quay lai");
            chon = nhapSoNguyen("Nhap lua chon: ");

            switch (chon) {
                case 1:
                    themSach();
                    break;
                case 2:
                    hienThiSach();
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
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }

    // ===================== BAI 4: MENU HOAN CHINH =====================
    static void bai4() {
        int chon;
        do {
            System.out.println();
            System.out.println("========== BAI 4: QUAN LY SACH THU VIEN ==========");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            chon = nhapSoNguyen("Nhap lua chon: ");

            switch (chon) {
                case 1:
                    themSach();
                    break;
                case 2:
                    hienThiSach();
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
                case 7:
                    tinhTongGiaTri();
                    break;
                case 8:
                    System.out.println("Quay lai menu chinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 8);
    }

    // ===================== MENU CHINH =====================
    public static void main(String[] args) {
        int chon;
        do {
            System.out.println();
            System.out.println("############ TUAN 6: MANG VA ARRAYLIST ############");
            System.out.println("1. Bai 1: Mang so luong 5 cuon sach");
            System.out.println("2. Bai 2: ArrayList ma sach");
            System.out.println("3. Bai 3: ArrayList danh sach sach");
            System.out.println("4. Bai 4: Menu quan ly sach hoan chinh");
            System.out.println("0. Thoat chuong trinh");
            chon = nhapSoNguyen("Nhap lua chon: ");

            switch (chon) {
                case 1:
                    bai1();
                    break;
                case 2:
                    bai2();
                    break;
                case 3:
                    bai3();
                    break;
                case 4:
                    bai4();
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