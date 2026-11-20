package tuan9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Sach {
    protected static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    protected String maSach;
    protected LocalDate ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;

    public Sach() {
    }

    public Sach(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }

    public void nhap(Scanner sc) {
        System.out.print("Ma sach: ");
        maSach = sc.nextLine().trim();
        while (true) {
            try {
                System.out.print("Ngay nhap (ngay thang nam, vd 15 9 2026): ");
                String[] p = sc.nextLine().trim().split("\\s+");
                ngayNhap = LocalDate.of(Integer.parseInt(p[2]), Integer.parseInt(p[1]), Integer.parseInt(p[0]));
                break;
            } catch (Exception e) {
                System.out.println("Ngay khong hop le, nhap lai!");
            }
        }
        donGia = docSo(sc, "Don gia: ", false);
        soLuong = (int) docSo(sc, "So luong: ", true);
        System.out.print("Nha xuat ban: ");
        nhaXuatBan = sc.nextLine().trim();
    }

    /** Doc mot so khong am, nhap sai thi yeu cau nhap lai. */
    protected static double docSo(Scanner sc, String nhan, boolean nguyen) {
        while (true) {
            try {
                System.out.print(nhan);
                String s = sc.nextLine().trim();
                double v = nguyen ? Integer.parseInt(s) : Double.parseDouble(s);
                if (v >= 0) return v;
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Gia tri khong hop le, nhap lai!");
        }
    }

    public double thanhTien() {
        return soLuong * donGia;
    }

    public void xuat() {
        System.out.printf("Ma: %-8s | Ngay nhap: %s | Don gia: %,.0f | SL: %d | NXB: %s",
                maSach, ngayNhap.format(FMT), donGia, soLuong, nhaXuatBan);
    }

    public String getMaSach() { return maSach; }
    public LocalDate getNgayNhap() { return ngayNhap; }
    public double getDonGia() { return donGia; }
    public int getSoLuong() { return soLuong; }
    public String getNhaXuatBan() { return nhaXuatBan; }
}
