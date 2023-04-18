import java.util.Scanner;

public class App {
    public static void main(String [] args) {
        String user, password;
        int menu, menu_admin;

        // para objek
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        Admin restaurant = new Admin();
        Admin menu = new Costumer();
        Costumer  order = new Costumer();
        boolean log_in = false;

        while(log_in == false)
            System.out.println("~~~~~~~~~~LOGIN~~~~~~~~~~");
            System.out.print("|| Masukkan username : ");user = scanner.nextLine();
            System.out.print("|| Masukkan password : ");password = scanner.nextLine();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");

        if (user.equals(login.getUsername_user()) && password.equals(login.getPassword_user()) || user.equals(login.getUsername_admin()) && password.equals(login.getPassword_admin())) {
            int ulang;
            log_in = true;
            if (user.equals(log_in.getUsername_user())) {
                do {
                    order.MenuOrder();

                    System.out.print("Masukan opsi yang anda inginkan ? ");
                    menu_admin scanner.nextInt();
                    switch (menu_admin){
                        case 1:
                            restaurant.viewMenu();
                            break;
                        case 2:
                            log_in = false;
                            break;
                    }
                    String pesan = (log_in == false) ? "Login ulang ? (1 = Tidak/ 2 = Iya) : " : "Apakah anda ingin memilih menu lain? (1 = iya /2 = tidak) : ";
                    System.out.print(pesan);ulang= scanner.nextInt();
                }while(ulang == 1);
            } else if (user.equals(login.getUsername_admin())) {
                do {
                    restaurant.MenuAdmin();
                    System.out.print("Masukan opsi yang anda inginkan : ");
                    menu = scanner.nextInt();

                    switch (menu) {
                        case 1:
                            restaurant.viewRestaurant();
                            break;
                        case 2:
                            restaurant.addRestaurant();
                            break;
                        case 3:
                            restaurant.removeRestaurant();
                            break;
                        case 4:
                            log_in= false;
                            break;
                    }
                    String pesan = (log_in == false) ? "Login ulang ? (1 = Tidak/ 2 = Iya) : " : "Apakah anda ingin memilih menu lain? (1 = iya /2 = tidak) : ";
                    System.out.print(pesan);ulang= scanner.nextInt();
                }while(ulang == 1);
            }

        }else{
            System.out.println("* Username/Password salah!*");
        }

    }
}

