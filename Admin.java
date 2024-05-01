package Project_PBO;

import java.util.Scanner;

public class Admin extends User {
    private Scanner scanner;

    public Admin(String username, String password) {
        super(username, password);
        scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("\n=========================================");
        System.out.println("|         MENU ADMIN ETERNALS FOOD       |");
        System.out.println("=========================================");
        System.out.println("         WELLCOME THE ETERNALS FOOD !    ");
        System.out.println("1. Lihat Restaurant");
        System.out.println("2. Tambah Data Restaurant");
        System.out.println("3. Hapus Data Restaurant");
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
                    Restaurant.createRestaurant();
                    System.out.println("\nData Restaurant berhasil ditambahkan!");
                    showMenu();
                    validChoice = true;
                    break;
                case "3":
                    System.out.println("\n=========================================");
                    System.out.println("|          HAPUS DATA RESTAURANT        |");
                    System.out.println("=========================================");
                    System.out.print("Masukkan ID Restaurant yang akan dihapus: ");
                    String idToDelete = scanner.nextLine();
                    Restaurant.deleteRestaurant(idToDelete);
                    showMenu();
                    validChoice = true;
                    break;
                case "4":
                    MenuLogin MenuLogin = new MenuLogin();
                    MenuLogin.show();
                    validChoice = true;
                    break;
                default:
                    System.out.println("Pilihan anda tidak sesuai, Coba masukan pilihan anda kembali!");
                    System.out.print("Masukan Pilihan Anda (1/2/3/4): ");
                    choice = scanner.nextLine();
                    break;
            }
        }
    }
}