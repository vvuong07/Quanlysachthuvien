package tuan9;

import java.time.LocalDate;
import java.util.Scanner;

public class SachThamKhao extends Sach {
    private double thue;

    public SachThamKhao() {
    }

    public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong,
                        String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        thue = docSo(sc, "Thue: ", false);
    }

    @Override
    public double thanhTien() {
        return soLuong * donGia + thue;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" | Thue: %,.0f | Thanh tien: %,.0f%n", thue, thanhTien());
    }

    public double getThue() { return thue; }
}
