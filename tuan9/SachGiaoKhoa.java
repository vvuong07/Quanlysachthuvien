package tuan9;

import java.time.LocalDate;
import java.util.Scanner;

public class SachGiaoKhoa extends Sach {
    private boolean moi; // true: moi, false: cu

    public SachGiaoKhoa() {
    }

    public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong,
                        String nhaXuatBan, boolean moi) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.moi = moi;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        while (true) {
            System.out.print("Tinh trang (moi/cu): ");
            String s = sc.nextLine().trim().toLowerCase();
            if (s.equals("moi")) { moi = true; break; }
            if (s.equals("cu")) { moi = false; break; }
            System.out.println("Chi nhap moi hoac cu!");
        }
    }

    @Override
    public double thanhTien() {
        return moi ? soLuong * donGia : soLuong * donGia * 0.5;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" | Tinh trang: %s | Thanh tien: %,.0f%n", moi ? "Moi" : "Cu", thanhTien());
    }

    public boolean isMoi() { return moi; }
}
