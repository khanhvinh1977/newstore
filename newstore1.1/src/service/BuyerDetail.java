package service;

import entity.HoaDon;
import entity.OrderLine;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

import static service.HoaDonService.hoaDonList;

public class BuyerDetail {
    public void theodoiBanHang(List<OrderLine> orderLines) {
        List<Object[]> ketQua = new ArrayList<>();
        for (HoaDon hd : hoaDonList) {
            for (OrderLine ct : orderLines) {
                Product sp = ct.getProduct();
                int sl = ct.getQuantity();
                int index = timSanPhamTrongKetQua(sp, ketQua);
                if (index == -1) {
                    ketQua.add(new Object[] {sp, sl});
                } else {
                    int tongSL = (int)ketQua.get(index)[1] + sl;
                    ketQua.set(index, new Object[] {sp, tongSL});
                }
            }
        }
        System.out.println(ketQua);
    }
    int timSanPhamTrongKetQua(Product sp, List<Object[]> ketQua) {
        for (int i = 0; i < ketQua.size(); i++) {
            Object[] item = ketQua.get(i);
            Product spTrongKetQua = (Product) item[0];
            if (spTrongKetQua.equals(sp)) {
                return i;
            }
        }
        return -1;
    }
}
