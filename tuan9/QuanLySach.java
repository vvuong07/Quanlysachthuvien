package tuan9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySach {
    private final List<Sach> ds = new ArrayList<>();

    public void nhapDanhSach(Scanner sc) {
        System.out.print("Nhap so luong sach giao khoa: ");
        int n = (int) Sach.docSo(sc, "", true);
        for (int i = 1; i <= n; i++) {
            System.out.println("--- Sach giao khoa " + i + " ---");
            SachGiaoKhoa s = new SachGiaoKhoa();
            s.nhap(sc);
            ds.add(s);
        }
        System.out.print("Nhap so luong sach tham khao: ");
        int m = (int) Sach.docSo(sc, "", true);
        for (int i = 1; i <= m; i++) {
            System.out.println("--- Sach tham khao " + i + " ---");
            SachThamKhao s = new SachThamKhao();
            s.nhap(sc);
            ds.add(s);
        }
    }

    public void xuatDanhSach() {
        if (ds.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }
        for (Sach s : ds) s.xuat();
    }

    public double tongThanhTienSGK() {
        double t = 0;
        for (Sach s : ds) if (s instanceof SachGiaoKhoa) t += s.thanhTien();
        return t;
    }

    public double tongThanhTienSTK() {
        double t = 0;
        for (Sach s : ds) if (s instanceof SachThamKhao) t += s.thanhTien();
        return t;
    }

    /** Trung binh cong don gia sach tham khao; tra ve 0 neu khong co sach nao. */
    public double trungBinhDonGiaSTK() {
        double tong = 0;
        int dem = 0;
        for (Sach s : ds) {
            if (s instanceof SachThamKhao) {
                tong += s.getDonGia();
                dem++;
            }
        }
        return dem == 0 ? 0 : tong / dem;
    }

    public void xuatSGKTheoNXB(String nxb) {
        boolean coSach = false;
        for (Sach s : ds) {
            if (s instanceof SachGiaoKhoa && s.getNhaXuatBan().equalsIgnoreCase(nxb)) {
                s.xuat();
                coSach = true;
            }
        }
        if (!coSach) System.out.println("Khong co sach giao khoa cua nha xuat ban " + nxb);
    }
}
