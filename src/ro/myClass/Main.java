package ro.myClass;

import ro.myClass.animals.*;
import ro.myClass.controllers.ControllerAnimalStore;
import ro.myClass.user.User;
import ro.myClass.views.ViewLogin;
import ro.myClass.views.ViewUser;

public class Main {
    public static void main(String[] args) {
        ControllerAnimalStore controllerAnimalStore = new ControllerAnimalStore();

        ViewLogin viewLogin = new ViewLogin();

        viewLogin.play();
    }
}