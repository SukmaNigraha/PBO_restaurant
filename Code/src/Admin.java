import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Admin {
    static HashMap<String, Restaurant> restaurants = new HashMap<>();
    public static ArrayList<Order> orders = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static void MenuAdmin() {
        System.out.println("||~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
        System.out.println("||            ADMIN          ||");
        System.out.println("||~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
        System.out.println("||1. Tambah Restaurant       ||");
        System.out.println("||2. Hapus Restaurant        ||");
        System.out.println("||3. Lihat  Restaurant       ||");
        System.out.println("||4. Kembali                 ||");
        System.out.println("||~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
    }

    // tambah restaurant
    public static void addRestaurant() {
        System.out.print("Masukkan ID restaurant : ");
        int id = App.validInt();

        System.out.print("Masukkan nama restaurant: ");
        String name = scanner.next();

        System.out.print("Masukkan alamat restaurant : ");
        String alamat = scanner.next();
        Restaurant restaurant = new Restaurant(id, name, alamat);

        String inputMenu = "";
        while (!inputMenu.equals("selesai")){
            System.out.print("Masukan menu (format: menuName|menuPrice) enter, lalu ketik \"selesai\" untuk selesai: ");
            inputMenu = scanner.next();
            if(!inputMenu.equals("selesai")){
                String[] menuData = inputMenu.split("\\|");
                restaurant.setMenus(new Menu(menuData[0], Integer.parseInt(menuData[1])));
            }
        }
        restaurants.put(name,restaurant);
        System.out.println("Tambah restaurant berhasil!");
    }


// hapus restaurant
        public static void removeRestaurant() {
            System.out.print("Masukan nomor id restaurant : ");
            int idRestaurant = App.validInt();

            if (idRestaurant > 0 && idRestaurant <= restaurants.size()) {
                restaurants.remove(idRestaurant - 1);
                System.out.println("Restaurant terhapus!");
            } else {
                System.out.println("Id restaurant tidak ditemukan!");
            }
        }

// Lihat restaurant
        public static void viewRestaurant () {
            System.out.println("||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
            System.out.println("||            RESTAURANT            ||");
            System.out.println("||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
            for (String namaRestaurant : restaurants.keySet()) {
                System.out.println("ID Restaurant : " + restaurants.get(namaRestaurant).getId()
                        + " || Nama : " + namaRestaurant + " || Alamat : " + restaurants.get(namaRestaurant).getAlamat());
                System.out.println("Menu : ");
                for (Menu menu : restaurants.get(namaRestaurant).getMenus()) {
                    System.out.println(menu.getNama() + " || " + menu.getHarga());
                }
            }
        }

        public static void viewMenu () {
            System.out.println("||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
            System.out.println("||            RESTAURANT            ||");
            System.out.println("||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
            for (String namarestaurant : restaurants.keySet()) {
                System.out.println(namarestaurant + " || " + restaurants.get(namarestaurant).getAlamat());
            }
            System.out.print("Masukan nama restaurant : ");
            String pilih_restaurant = scanner.next();
            if (!restaurants.containsKey(pilih_restaurant)) {
                System.out.println("Menu tidak ada!");
            }
            Restaurant res = restaurants.get(pilih_restaurant);
            Order newOrder = new Order(res);
            String menu = "";
            while (!menu.equals("2")) {
                System.out.println("==== " + res.getNama() + " ====");
                System.out.println("Menu : ");
                int nomorMenu = 1;
                for (Menu menu1 : res.getMenus()) {
                    System.out.println(nomorMenu + ". " + menu1.getNama() + " - " + menu1.getHarga());
                    nomorMenu++;
                }
                System.out.print("Masukan nomor menu : ");
                int indexMenu = App.validInt();
                System.out.print("Jumlah beli : ");
                int jumlah_beli = App.validInt();
                scanner.nextLine();

                newOrder.addMenu(res.getMenus().get(indexMenu - 1), jumlah_beli);

                System.out.print("Tambah menu lagi?  (1 = iya / 2 = tidak) : ");
                menu = scanner.next();
            }
            System.out.print("Masukan jarak pengantaran makanan (dalam km) : ");
            int jarak = App.validInt();

            newOrder.setDistance(jarak);
            orders.add(newOrder);
            System.out.println("Order menu berhasil!");
        }

        public static void viewOrder () {
            System.out.println("||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
            System.out.println("||              ORDERS              ||");
            System.out.println("||~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
            for (int i = 0; i < orders.size(); i++) {
                Order order = orders.get(i);
                System.out.println((i + 1) + ". " + order.getRestaurant().getNama());
                System.out.println("Menu : ");
                for (Menu menu : order.getMenus().keySet()) {
                    System.out.println(menu.getNama() + " X " + order.getMenus().get(menu));
                }
                System.out.println("Ongkir 1.000.km || Jarak : " + order.getDistance() + " km");
                System.out.println("Total Bayar : " + order.getTotalPrice());
            }
        }
    }