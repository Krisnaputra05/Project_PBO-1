package Project_PBO;

import java.util.Scanner;
public class MenuLogin {
    private Scanner scanner;
    private Admin admin;
    private Customer customer;

    public MenuLogin() {
        scanner = new Scanner(System.in);
        admin = new Admin("admin", "222");
        customer = new Customer("customer", "222");
    }

    public void show() {
        System.out.println("=========================================");
        System.out.println("|             ETERNALS FOOD             |");
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("|                Login                  |");
        System.out.println("=========================================");
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            System.out.print("- Silahkan Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("- Silahkan Masukkan password: ");
            String password = scanner.nextLine();

            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                admin.showMenu();
                isLoggedIn = true;
            } else if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                customer.showMenu();
                isLoggedIn = true;
            } else {
                System.out.println("Username atau password anda  salah! Silakan coba lagi.");
            }
        }
        scanner.close();
    }
}