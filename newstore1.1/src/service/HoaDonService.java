package service;

import entity.GioHang;
import entity.HoaDon;
import entity.OrderLine;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

import static service.GioHangService.danhsachGioHang;
import static service.GioHangService.displaySanPhamTrongGioHang;

public class HoaDonService {
    List<OrderLine> orderLines;
    static List<HoaDon> hoaDonList;

    public List<OrderLine> orderLines() {
        orderLines = new ArrayList<>();
        List<GioHang> gioHangList = displaySanPhamTrongGioHang();
        for (GioHang gioHang : gioHangList) {
            OrderLine orderLine = new OrderLine(gioHang.getProduct(), gioHang.getSubToTal(), gioHang.getQuantity(), gioHang.getTotalPrice());
            orderLines.add(orderLine);
        }
        return orderLines;
    }

    public void inRaHoaDon() {
        hoaDonList = new ArrayList<>();
        int phiShip;
        int totalPrice = GioHangService.totalPrice();
        if (totalPrice > 100) {
            phiShip = 0;
        } else {
            phiShip = 2;
        }
        HoaDon hoaDon = new HoaDon(HoaDon.getThoigianXuatHoaDon(), orderLines(), phiShip);
        System.out.println(hoaDon);
        hoaDonList.add(hoaDon);
        System.out.println(hoaDonList);
    }
}
