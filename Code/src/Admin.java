import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private static ArrayList<String> restaurants = new ArrayList<String>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        
        do {
            System.out.println("==========ADMIN============");
            System.out.println("|1. Tambah Restaurant");
            System.out.println("|2. Hapus Restaurant");
            System.out.println("|3. Lihat  Restaurant");
            System.out.println("|4. Kembali");
            System.out.println("===========================");
            System.out.print("Pilih Nomor : ");
            
            choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    addRestaurant();
                    break;
                case 2:
                    removeRestaurant();
                    break;
                case 3:
                    viewRestaurants();
                    break;
                case 4:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Pilihan Salah. Silahkan coba lagi.");
            }
            
            System.out.println();
            
        } while(choice != 4);
    }
    // tambah restaurant
    public static void addRestaurant() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID restaurant");
        int id = scanner.nextLine();

        System.out.print("Masukkan nama restaurant: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan alamat restaurant :");
        String alamat = scanner.nextLine();

        Restaurant restaurant = new Restaurant(id, name, alamat);
        restaurants.add(restaurant);
        System.out.println(name + " added to the list of restaurants.");
    }
    

        }


