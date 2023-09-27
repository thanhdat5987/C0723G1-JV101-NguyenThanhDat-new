package ss_17.bai_tap.product_management.view;

import ss_17.bai_tap.product_management.controller.ProductController;
import ss_17.bai_tap.product_management.model.Product;

import java.util.List;
import java.util.Scanner;

public class ProductManagementView {
    private Scanner scanner = new Scanner(System.in);
    private final ProductController productController = new ProductController();

    public void displayMenu() {
        int choose = 0;
        while (choose != 4) {
            try {
                System.out.println("-----Menu-----");
                System.out.println("Please enter your choice:");
                System.out.println("1. Add product");
                System.out.println("2. Display products list");
                System.out.println("3. Search product");
                System.out.println("4. Exit program");
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        displayProductsList();
                        break;
                    case 3:
                        searchProduct();
                        break;
                    case 4:
                        System.exit(4);
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter menu by number");
            }
        }
    }

    public void addProduct() {
        int newId;
        do {
            try {
                System.out.println("Input product Id");
                newId = Integer.parseInt(scanner.nextLine());
                if (!checkId(newId)) {
                    break;
                }
                System.out.println("Id has been exist");
            } catch (NumberFormatException e) {
                System.out.println("NumberFormat Exception: invalid input string, please enter again");
            }
        } while (true);
        System.out.println("Enter name of product:");
        String newName = scanner.nextLine();
        int newPrice;
        do {
            try {
                System.out.println("Enter price of product");
                newPrice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("NumberFormat Exception: invalid input string, please enter again");
            }
        } while (true);
        System.out.println("Enter brand of product: ");
        String newBrand = scanner.nextLine();
        System.out.println("Enter product description: ");
        String newProductDescription = scanner.nextLine();
        Product newProduct = new Product(newId, newName, newPrice, newBrand, newProductDescription);
        productController.addProduct(newProduct);
    }

    public void displayProductsList() {
        List<Product> products = productController.displayProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void searchProduct() {
        String findingName;
        int productIndex;
        do {
            try {
                System.out.println("Enter product name that you want to find ");
                findingName = scanner.nextLine();
                productIndex = findIndexByName(findingName);
                if (productIndex == -1) {
                    System.out.println("Can't find product");
                    return;
                } else {
                    System.out.println(productController.getProduct(productIndex));
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + "please re-enter name of product");
            }
        } while (true);
    }

    boolean checkId(int id) {
        List<Product> products = productController.displayProducts();
        for (Product product : products) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    int findIndexByName(String name) {
        List<Product> products = productController.displayProducts();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

}
