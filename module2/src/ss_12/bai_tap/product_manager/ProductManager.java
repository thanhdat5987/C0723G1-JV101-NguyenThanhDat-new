package ss_12.bai_tap.product_manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private final Scanner scanner = new Scanner(System.in);
    List<Product> productList = new ArrayList<>();

    public void displayMenu() {
        System.out.println("Please enter your choice: ");
        System.out.println("1. Add product");
        System.out.println("2. Edit product");
        System.out.println("3. Delete product");
        System.out.println("4. Delete product");
        System.out.println("0. Exit");
        System.out.print("Enter your choice please: ");
    }

    public int inputChoose() {
        int choose;
        do {
            displayMenu();
            System.out.println("Please select feature: ");
            choose = Integer.parseInt(scanner.nextLine());
        } while (choose <= 0 || choose > 4);
        return choose;
    }

    public void handleProductManagementOption(int choose) {
        switch (choose) {
            case 1:
                addProduct();
                break;
            case 2:
                editProduct();
                break;
            case 3:
                deleteProduct();
                break;
            case 4:
                displayProduct();
            case 0:
                System.exit(1);
            default:
                System.out.println("No choice");
                break;
        }
    }

    public void render() {
        while (true) {
            handleProductManagementOption(inputChoose());
        }
    }

    public void addProduct() {
        System.out.println("Please input product's ID: ");
        int newProductId = Integer.parseInt(scanner.nextLine());
        for (Product product : productList) {
            if (product.getProductId() == newProductId) {
                System.out.println("ID has been existed");
                break;
            }
        }
        System.out.println("Please input product's Name: ");
        String newProductName = scanner.nextLine();
        System.out.println("Please input product's Price");
        int newProductPrice = scanner.nextInt();
        Product newProduct = new Product(newProductId, newProductName, newProductPrice);
        productList.add(newProduct);
    }

    public void editProduct() {
        System.out.println("Please input ID of product that you want to edit: ");
        int editingId = Integer.parseInt(scanner.nextLine());
        for (Product product : productList) {
            if (product.getProductId() == editingId) {
                System.out.println("Please edit name of product with id =" + editingId + ": ");
                String editingName = scanner.nextLine();
                product.setProductName(editingName);
                System.out.println("Please edit price of product with id =" + editingId + ": ");
                int editingPrice = scanner.nextInt();
                product.setProductPrice(editingPrice);
                break;
            }
        }
        System.out.println("We couldn't find for ID");
    }

    public void deleteProduct() {
        System.out.println("Please input ID of product that you want to delete: ");

        int deletingId = Integer.parseInt(scanner.nextLine());
        for (Product product : productList) {
            if (product.getProductId() == deletingId) {
                productList.remove(product);
                break;
            }
        }
        System.out.println("We couldn't find for ID");
    }

    public void displayProduct() {
        System.out.println(productList);
    }
}

