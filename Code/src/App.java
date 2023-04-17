import java.util.Scanner;

public class App {
    public static void main(String [] args) {
        String user, password;
        int menu, menu_admin;

        Login login  = new Login();
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("~~~~~~~~~~LOGIN~~~~~~~~~~");
            System.out.print("|| Masukkan username : ");user = scanner.nextLine();
            System.out.print("|| Masukkan password : ");password = scanner.nextLine();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");

            if (user.equals(login.getUsername_admin()) && password.equals(login.getPassword_admin()) ||
                user.equals(login.getUsername_user()) && password.equals(login.getPassword_user())){
                check = 0;
                if (user.equals(login.getUsername_admin())){
                    System.out.println("Selamat Datang Admin");
                } else if (user.equals(login.getUsername_user())) {
                    System.out.println("Selamat Datang User");
                }
            }else{
                System.out.println("Password atau Username anda salah");
            }
        } while (check == 2);

    }
}
