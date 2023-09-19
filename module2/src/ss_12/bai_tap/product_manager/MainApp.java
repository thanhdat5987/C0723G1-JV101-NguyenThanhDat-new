package ss_12.bai_tap.product_manager;

import ss_12.bai_tap.product_manager.view.ProductManagementView;

public class MainApp {
    public static void main(String[] args) {
        ProductManagementView productManagementView = new ProductManagementView();
        productManagementView.displayMenu();
    }
}
