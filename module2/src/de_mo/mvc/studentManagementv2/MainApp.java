package de_mo.mvc.studentManagementv2;

import de_mo.mvc.studentManagementv1.view.StudentManagementView;

public class MainApp {
    public static void main(String[] args) {
        StudentManagementView studentManagementView = new StudentManagementView();
        studentManagementView.render();
    }
}
