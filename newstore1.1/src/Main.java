import entity.Product;
import service.GioHangService;
import service.HoaDonService;
import service.ProductService;
import service.UserService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void ghiProductListFile(List<Product> productList) {
        FileWriter writer;
        try {
            writer = new FileWriter("products.txt");
            for (Product product : productList) {
                writer.write(product.toString()+"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        HoaDonService hoaDonService = new HoaDonService();
        GioHangService gioHangService = new GioHangService();
        ProductService productService = new ProductService();
        List<Product> productList = new ArrayList<>();

        productList.add(new Product(1, "Rau muong", 15));
        productList.add(new Product(2, "Rau cai", 15));
        productList.add(new Product(3, "Rau Xa Lach", 15));
        ghiProductListFile(productList);
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Moi ban chon");
            System.out.println("1. Dang ky   "
                    + " 2. Dang nhap "
                    + " 3. Hiển thị danh sách sản phẩm  "
                    + " 4. Them san pham vao gio hang "
                    + " 5. Dich vu mua ban  "
                    + " 6. Xem gio hang"
                    + " 7. Cut  ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    Scanner input = new Scanner(System.in);
                    System.out.println("nhap username");
                    String username = input.nextLine();
                    System.out.println("nhap password");
                    String password = input.nextLine();
                    UserService.dangKy(username, password);
                    break;
                }
                case 2: {
                    Scanner input = new Scanner(System.in);
                    System.out.println("nhap username");
                    String username = input.nextLine();
                    System.out.println("nhap password");
                    String password = input.nextLine();
                    UserService.dangNhap(username, password);
                    break;
                }
                case 3: {
                    productService.displayProductList();
                    break;
                }
                case 4: {
                    gioHangService.addToGioHang();
                    break;
                }
                case 5: {
                    GioHangService.displaySanPhamTrongGioHang();
                    System.out.println("1. Tiep tuc mua hang 2. Xoa san pham da chon 3. In hoa don");
                    int choices = scanner.nextInt();
                    switch (choices) {
                        case 1: {
                            gioHangService.addToGioHang();
                            break;
                        }
                        case 2: {
                            gioHangService.xoaSanPhamTrongGioHang();
                            break;
                        }
                        case 3: {
                            hoaDonService.inRaHoaDon();
                            break;
                        }
                    }
                    break;
                }
                case 6: {
                    GioHangService.displaySanPhamTrongGioHang();
                }
            }
        } while (choice != 7);
    }
}