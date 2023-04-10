package first_package;


import java.util.Scanner;

public class main {

    public static void main (String [] args) {
        String user, password;
        int check = 2;

        login login  = new login();
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("----------login----------");
            System.out.print("|| Masukkan username : ||");user = scanner.nextLine();
            System.out.print("|| Masukkan password : ||");password = scanner.nextLine();
            System.out.println("-------------------------");

            if (user.equals(login.getUsername_admin()) && password.equals(login.getPassword_admin()) ||
                user.equals(login.getUsername_user()) && password.equals(login.getPassword_user())){
                check = 0;
                if (user.equals(login.getUsername_admin())){
                    System.out.println("Selamat Datang Admin");
                } else if (user.equals(login.getUsername_user())) {
                    System.out.println("Selamat datang user");
                }
            }else{
                System.out.println("Password atau Username anda salah");
            }
        } while (check == 2);

    }
}
