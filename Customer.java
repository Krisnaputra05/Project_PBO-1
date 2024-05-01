package Project_PBO;

import java.util.Scanner;

public class Customer extends User {
    private Scanner scanner;

    public Customer(String username, String password) {
        super(username, password);
        scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("\n=======================================");
        System.out.println("|      MENU CUSTOMER ETERNALS FOOD      |");
        System.out.println("=========================================");
        System.out.println("        WELLCOME THE ETERNALS FOOD        ");
        System.out.println("1. Lihat Restaurant");
        System.out.println("2. Tambah Pesanan");
        System.out.println("3. Lihat Pesanan");
        System.out.println("4. Kembali ke Menu Login");
        System.out.println("=========================================");
        System.out.print("Masukan Pilihan Anda (1/2/3/4): ");
        String choice = scanner.nextLine();

        boolean validChoice = false;
        while (!validChoice) {
            switch (choice) {
                case "1":
                    Restaurant.showRestaurants();
                    showMenu();
                    validChoice = true;
                    break;
                case "2":
                    Order.createOrder();
                    showMenu();
                    validChoice = true;
                    break;
                case "3":
                    Order.showOrders();
                    showMenu();
                    validChoice = true;
                    break;
                case "4":
                    MenuLogin MenuLogin = new MenuLogin();
                    MenuLogin.show();
                    validChoice = true;
                    break;
                default:
                    System.out.println("Pilihan tidak sesuai, Coba masukan pilihan kembali!");
                    System.out.print("Masukan Pilihan Anda (1/2/3/4): ");
                    choice = scanner.nextLine();
                    break;
            }
        }
    }
}