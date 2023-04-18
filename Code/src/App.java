import java.util.*;

public class App {
    public static void main(String[] args) {
        String user, password;
        int menu1, menu2;

        // objek
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        Admin restaurant = new Admin();
        Admin menu3 = new Admin();
        boolean log_in = false;
        // menu login
        while (log_in == false) {
            System.out.println("||~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
            System.out.println("||           LOGIN           ||");
            System.out.println("||~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
            System.out.print("||Masukkan username : ");
            user = scanner.next();
            System.out.print("||Masukkan password : ");
            password = scanner.next();
            System.out.println("||~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
            //menu customer
            if (user.equals(login.getUsername_user()) && password.equals(login.getPassword_user()) || user.equals(login.getUsername_admin()) && password.equals(login.getPassword_admin())) {
                int ulang;
                log_in = true;
                if (user.equals(login.getUsername_user())) {
                    do {
                        System.out.println("||~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
                        System.out.println("||      Welcome Customer     ||");
                        System.out.println("||~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
                        System.out.println("|| 1. Order                  ||");
                        System.out.println("|| 2. Lihat Orderan          ||");
                        System.out.println("|| 3. Kembali Login          ||");
                        System.out.println("|| 4. LogOut                 ||");
                        System.out.println("||~~~~~~~~~~~~~~~~~~~~~~~~~~~||");
                        System.out.print("|| Masukan Opsi : ");
                        menu2 = validInt();
                        switch (menu2) {
                            case 1:
                                restaurant.viewMenu();
                                break;
                            case 2:
                                restaurant.viewOrder();
                                break;
                            case 3:
                                log_in = false;
                                break;
                            case 4:
                                System.out.println("Anda berhasil logout!");
                                System.exit(0);
                                break;
                        }
                        String pesan = (log_in == false) ? "Apakah anda ingin Login ulang ? (1 = Tidak/ 2 = Iya) : " : "Apakah anda ingin memilih menu lain? (1 = iya /2 = tidak) : ";
                        System.out.print(pesan);
                        ulang = validInt();
                    } while (ulang == 1);
                } else if (user.equals(login.getUsername_admin())) {
                    do {
                        restaurant.MenuAdmin();
                        System.out.print("Masukkan opsi : ");
                        menu1 = validInt();

                        switch (menu1) {
                            case 1:
                                restaurant.addRestaurant();
                                break;
                            case 2:
                                restaurant.removeRestaurant();
                                break;
                            case 3:
                                restaurant.viewRestaurant();
                                break;
                            case 4:
                                log_in = false;
                                break;
                            case 5:
                                System.out.println("Anda berhasil logout!");
                                System.exit(0);
                                break;
                        }
                        String pesan = (log_in == false) ? "Login ulang ? (1 = Tidak/ 2 = Iya) : " : "Apakah anda ingin memilih menu lain? (1 = iya /2 = tidak) : ";
                        System.out.print(pesan);
                        ulang = scanner.nextInt();
                    } while (ulang == 1);
                }

            } else {
                System.out.println("* Username/Password salah!*");
            }

        }
    }

    public static int validInt(){
        int inp;
        Scanner scan = new Scanner(System.in);
        System.out.print("\t=> ");
        while(true){
            try{
                inp = scan.nextInt();
                scan.nextLine();
                return inp;
                // break;
            }catch(InputMismatchException e){
                System.out.print("\tInput salah!, Ulang\n\t=> ");
                scan.nextLine();
            }
        }
    }

}

