import java.time.Year;

public class Sach {
    // Yeu cau 1: Tat ca thuoc tinh deu private
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    // Yeu cau 4: Constructor co tham so day du
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan); // dung setter de kiem tra du lieu hop le
        setSoLuong(soLuong);       // dung setter de kiem tra du lieu hop le
    }

    // Yeu cau 2: Getters
    public String getMaSach() {
        return maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    // Yeu cau 2: Setters
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    // Yeu cau 3: Nam xuat ban phai > 0 va khong lon hon nam hien tai
    public void setNamXuatBan(int namXuatBan) {
        int currentYear = Year.now().getValue();
        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Nam xuat ban khong hop le (phai tu 1 den " + currentYear
                    + "), giu nguyen gia tri cu.");
        }
    }

    // Yeu cau 3: So luong khong am
    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("So luong khong duoc am, giu nguyen gia tri cu.");
        }
    }

    // In ra tat ca thong tin chi tiet cua mot cuon sach
    public void hienThiThongTin() {
        System.out.println("Ma sach      : " + maSach);
        System.out.println("Tieu de      : " + tieuDe);
        System.out.println("Tac gia      : " + tacGia);
        System.out.println("Nam xuat ban : " + namXuatBan);
        System.out.println("So luong     : " + soLuong);
    }
}