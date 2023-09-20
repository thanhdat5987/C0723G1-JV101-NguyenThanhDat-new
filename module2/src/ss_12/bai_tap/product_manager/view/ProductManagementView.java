package ss_12.bai_tap.product_manager.view;

import ss_12.bai_tap.product_manager.controller.ProductController;
import ss_12.bai_tap.product_manager.model.Product;

import java.util.Scanner;

public class ProductManagementView {
    private Scanner scanner = new Scanner(System.in);
    private ProductController<Product> productController = new ProductController<>();
    private int indexName;
    private int indexId;

    public void displayMenu() {
        System.out.println("Please choose function:");
        System.out.println("1. Add a new product");
        System.out.println("2. Edit a product");
        System.out.println("3. Delete a product");
        System.out.println("4. Display product list");
        System.out.println("5. Search a product by Name");
        System.out.println("6. Sort product list down by price");
        System.out.println("7. Sort product list down by price");
        System.out.println("8. Exit");

        int choose = Integer.parseInt(scanner.nextLine());

        switch (choose) {
            case 1:
                addProduct();
                displayMenu();
                break;
            case 2:
                editProduct();
                displayMenu();
                break;
            case 3:
                deleteProduct();
                displayMenu();
                break;
            case 4:
                displayProductList();
                displayMenu();
                break;
            case 5:
                searchProduct();
                displayMenu();
                break;
            case 6:
                sortProductListDown();
                displayMenu();
                break;
            case 7:
                sortProductListUp();
                displayMenu();
                break;
            case 8:
                System.exit(8);
        }
    }

    private void addProduct() {
        System.out.println("Please input product's ID: ");
        int newProductId = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<productController.displayProducts().size();i++){
            if(productController.displayProducts().get(i).getProductId()==newProductId){
                System.out.println("Id has been exist");
                return;
            }
        }
        System.out.println("Please input product's Name: ");
        String newProductName = scanner.nextLine();
        System.out.println("Please input product's Price");
        int newProductPrice = Integer.parseInt(scanner.nextLine());
        Product newproduct = new Product(newProductId, newProductName, newProductPrice);
        productController.addProduct(newproduct);
    }

    private void editProduct() {
        System.out.println("Please input ID of product that you want to edit: ");
        int editingId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productController.displayProducts().size(); i++) {
            if (productController.displayProducts().get(i).getProductId() == editingId) {
                System.out.println("Please edit name of product with id =" + editingId + ": ");
                String editingName = scanner.nextLine();
                productController.displayProducts().get(i).setProductName(editingName);
                System.out.println("Please edit price of product with id =" + editingId + ": ");
                int editingPrice = scanner.nextInt();
                productController.displayProducts().get(i).setProductPrice(editingPrice);
                Product newproduct = new Product(editingId, editingName, editingPrice);
                productController.editProduct(i, newproduct);
                break;
            }
        }
        System.out.println("Can't find ID");
    }

    private void deleteProduct() {
        System.out.println("Please input ID of product that you want to delete: ");
        int deletingId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productController.displayProducts().size(); i++) {
            if (productController.displayProducts().get(i).getProductId() == deletingId) {
                productController.deleteProduct(i);
                return;
            }

        }
        System.out.println("Can't find ID");
    }

    private void displayProductList() {
        for (int i = 0; i < productController.displayProducts().size(); i++) {
            System.out.println(productController.displayProducts().get(i));
        }
    }

    private void searchProduct() {
        System.out.println("Please input name of product that you want to search: ");
        String searchingId = scanner.nextLine();
        for (int i = 0; i < productController.displayProducts().size(); i++) {
            if (productController.displayProducts().get(i).getProductName().equals(searchingId)) {
                System.out.println(productController.getProduct(i));
                return;
            }
        }
        System.out.println("Can't find product");
    }

    private void sortProductListDown() {
        Product tempProduct;
        for (int i = 0; i < productController.displayProducts().size() - 1; i++) {
            for (int j = i + 1; j < productController.displayProducts().size(); j++)
                if (productController.displayProducts().get(i).getProductPrice() <= productController.displayProducts().get(j).getProductPrice()) {
                    tempProduct = productController.displayProducts().get(i);
                    productController.displayProducts().set(i, productController.displayProducts().get(j));
                    productController.displayProducts().set(j, tempProduct);
                }
        }
        displayProductList();
    }

    private void sortProductListUp() {
        Product tempProduct;
        for (int i = 0; i < productController.displayProducts().size() - 1; i++) {
            for (int j = i + 1; j < productController.displayProducts().size(); j++)
                if (productController.displayProducts().get(i).getProductPrice() >= productController.displayProducts().get(j).getProductPrice()) {
                    tempProduct = productController.displayProducts().get(i);
                    productController.displayProducts().set(i, productController.displayProducts().get(j));
                    productController.displayProducts().set(j, tempProduct);
                }
        }
        displayProductList();
    }
}

