package Project_PBO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class Restaurant {
    private String id;
    private String name;
    private String alamat;
    static ArrayList<Restaurant> restaurants = new ArrayList<>();
    private List<Menu> menus;

    public Restaurant(String id, String name, String alamat, List<Menu> menus) {
        this.id = id;
        this.name = name;
        this.alamat = alamat;
        this.menus = menus;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlamat() {
        return alamat;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public static void addRestaurant(Restaurant restaurant){
        restaurants.add(restaurant);
    }

    public static void deleteRestaurant(String id) {
        Iterator<Restaurant> iterator = restaurants.iterator();
        while (iterator.hasNext()) {
            Restaurant restaurant = iterator.next();
            if (restaurant.getId().equals(id)) {
                iterator.remove();
                System.out.println("\nData Restaurant dengan ID " + id + " berhasil dihapus.");
                return;
            }
        }
        System.out.println("Data Restaurant dengan ID " + id + " tidak ditemukan.");
    }

    public static void createRestaurant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=========================================");
        System.out.println("|         Tambah Data Restaurant        |");
        System.out.println("=========================================");
        System.out.print("Masukkan ID Restaurant: ");
        String id = scanner.nextLine();

        System.out.print("Masukkan Nama Restaurant: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan Alamat Restaurant: ");
        String alamat = scanner.nextLine();

        List<Menu> menus = new ArrayList<>();
        boolean addMoreMenu = true;
        while (addMoreMenu) {
            System.out.print("Masukkan ID Menu: ");
            String menuId = scanner.nextLine();

            System.out.print("Masukkan Nama Menu: ");
            String menuName = scanner.nextLine();

            System.out.print("Masukkan Harga Menu: ");
            int menuPrice = scanner.nextInt();
            scanner.nextLine();

            menus.add(new Menu(menuId, menuName, menuPrice));

            System.out.print("Tambah Menu Lagi? (y/n): ");
            String addMore = scanner.nextLine();
            if (!addMore.equalsIgnoreCase("y")) {
                addMoreMenu = false;
            }
        }

        Restaurant restaurant = new Restaurant(id, name, alamat, menus);

        System.out.println("\nData Restaurant:");
        System.out.println("ID: " + restaurant.getId());
        System.out.println("Nama: " + restaurant.getName());
        System.out.println("Kode: " + restaurant.getAlamat());
        System.out.println("Menu: ");
        for (Menu menu : restaurant.getMenus()) {
            System.out.println("ID: " + menu.getId() + " - " + menu.getName() + " - Rp " + menu.getPrice());
        }

        addRestaurant(restaurant);
    }

    public static void showRestaurants() {
        if (restaurants.isEmpty()) {
            System.out.println("\n=========================================");
            System.out.println("|Belum ada data restaurant yang disimpan|");
            System.out.println("=========================================");
        } else {
            System.out.println("\n=========================================");
            System.out.println("|             Data Restaurant           |");
            System.out.println("=========================================");
            for (Restaurant restaurant : restaurants) {
                System.out.println("\nID: " + restaurant.getId());
                System.out.println("Nama: " + restaurant.getName());
                System.out.println("Alamat: " + restaurant.getAlamat());
                System.out.println("Menu: ");
                for (Menu menu : restaurant.getMenus()) {
                    System.out.println("ID: " + menu.getId() + " - " + menu.getName() + " - Rp " + menu.getPrice());
                }
            }
        }
    }

}

class Menu {
    private String id;
    private String name;
    private int price;

    public Menu(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}