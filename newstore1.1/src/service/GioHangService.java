package service;

import entity.GioHang;
import entity.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static service.ProductService.docProductListTuFile;

public class GioHangService {
    ProductService productService= new ProductService();
    Scanner scanner = new Scanner(System.in);
    int count = 1;
    static List<GioHang> danhsachGioHang;
    public GioHangService() {
        danhsachGioHang = new ArrayList<>();
    }
    public void addToGioHang() {
        productService.displayProductList();
        System.out.println("nhap id san pham muon mua");
        int nhapIdSanPhamMuonMua = scanner.nextInt();
        System.out.println("nhap so luong");
        int nhapSoLuong = scanner.nextInt();
        List<Product> products = docProductListTuFile();
        for (Product product: products) {
            int idproducct = product.getId();
            if (idproducct == nhapIdSanPhamMuonMua) {
                if (danhsachGioHang.isEmpty()) {
                    GioHang item1 = new GioHang(product, nhapSoLuong * product.getPrice(), nhapSoLuong);
                    danhsachGioHang.add(item1);
                }
                else {
                    boolean isItemExist = false;
                    for (GioHang gioHang : danhsachGioHang) {
                        if (gioHang.getProduct().getId() == product.getId()) {
                            isItemExist = true;
                            gioHang.setQuantity(gioHang.getQuantity() + nhapSoLuong);
                            gioHang.setSubToTal(gioHang.getQuantity() * product.getPrice());
                            break;
                        }
                    }
                    if (!isItemExist) {
                        GioHang item1 = new GioHang(product, nhapSoLuong * product.getPrice(), nhapSoLuong);
                        danhsachGioHang.add(item1);
                    }
                    break;
                }
            }
        }
        int totalPrice = totalPrice();
        System.out.println("Tong tien: " + totalPrice);
    }
    public static List<GioHang> displaySanPhamTrongGioHang() {
        System.out.println("Gio hang cua may con lai la");
        for (GioHang gioHang: danhsachGioHang) {
            System.out.println(gioHang);
        }
        return danhsachGioHang;
    }
    public static int totalPrice() {
        int sum = 0;
        for (GioHang gioHang: danhsachGioHang) {
            sum += gioHang.getSubToTal();
        }
        return sum;
    }
    public void xoaSanPhamTrongGioHang() {
        System.out.println("chon san pham muon xoa");
        int idSanPhamMuonXoa = scanner.nextInt();
        for (GioHang gioHang: danhsachGioHang) {
            if (gioHang.getProduct().getId() == idSanPhamMuonXoa) {
                danhsachGioHang.remove(idSanPhamMuonXoa-1);
                break;
            }
        }
    }
}
