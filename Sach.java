public class Sach {
    // Cac thuoc tinh cua lop Sach
    String maSach;
    String tieuDe;
    String tacGia;
    int namXuatBan;
    int soLuong;

    // Yeu cau 2: In ra tat ca thong tin chi tiet cua mot cuon sach
    public void hienThiThongTin() {
        System.out.println("Ma sach      : " + maSach);
        System.out.println("Tieu de      : " + tieuDe);
        System.out.println("Tac gia      : " + tacGia);
        System.out.println("Nam xuat ban : " + namXuatBan);
        System.out.println("So luong     : " + soLuong);
    }
}