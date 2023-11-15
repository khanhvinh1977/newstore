package entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class HoaDon {
    private int id;
    private static LocalDateTime thoigianXuatHoaDon = LocalDateTime.now();
    private List<OrderLine> gioHangList;
    private int phiShip;
    private int totalPrice;
    private int count;

    public HoaDon(LocalDateTime thoigianXuatHoaDon, List<OrderLine> gioHangList, int phiShip) {
        count++;
        this.id = count;
        HoaDon.thoigianXuatHoaDon = thoigianXuatHoaDon;
        this.gioHangList = gioHangList;
        this.phiShip = phiShip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static LocalDateTime getThoigianXuatHoaDon() {
        return thoigianXuatHoaDon;
    }

    public void setThoigianXuatHoaDon(LocalDateTime thoigianXuatHoaDon) {
        HoaDon.thoigianXuatHoaDon = thoigianXuatHoaDon;
    }

    public List<OrderLine> getGioHangList() {
        return gioHangList;
    }

    public void setGioHangList(List<OrderLine> gioHangList) {
        this.gioHangList = gioHangList;
    }

    public int getPhiShip() {
        return phiShip;
    }

    public void setPhiShip(int phiShip) {
        this.phiShip = phiShip;
    }
    @Override
    public String toString() {
        return id+ "," +thoigianXuatHoaDon+ "," +gioHangList+ "," +phiShip+ "," +totalPrice;
    }
}
