package ro.myClass.controller;

import org.junit.Test;
import ro.myClass.controllers.ControllerUser;
import ro.myClass.user.User;

import static org.junit.Assert.assertEquals;

public class ControllerUserTest {

   @Test
   public void add() {
      ControllerUser controllerUser = new ControllerUser();
      User user = new User("Alin", "Rares", 18, "alinrares@gmail.com", "alinrares@gmail.com2022");
      int size = controllerUser.size();
      controllerUser.add(user);
      assertEquals(size + 1, controllerUser.size());
   }

   @Test
   public void findUser() {
      ControllerUser controllerUser = new ControllerUser();
      User user = new User("Alin", "Rares", 18, "alinrares@gmail.com", "alinrares@gmail.com2022");

      assertEquals(-1, controllerUser.findUser(user.getFirstName(), user.getLastName()));
      assertEquals(0, controllerUser.findUser("Popovici", "Darius"));

   }

   @Test
   public void updateFirstName() {
      ControllerUser controllerUser = new ControllerUser();

      assertEquals(true, controllerUser.updateFirstName("Popovici", "Darius", "Ilie"));
      assertEquals(false, controllerUser.updateFirstName("bogdan", "mircea", "ionel"));

   }

   @Test
   public void verifyEmail() {
      ControllerUser controllerUser = new ControllerUser();

      assertEquals(true, controllerUser.verifyEmail("Popovici", "Darius", "popovicidarius@gmail.com"));
      assertEquals(false, controllerUser.verifyEmail("Denis", "Farcas", "denisdenis@gmail.com"));
   }

   @Test
   public void updatePassword() {
      ControllerUser controllerUser = new ControllerUser();

      assertEquals(true, controllerUser.updatePassword("Popovici", "Darius", "dariusdarius"));
      assertEquals(false, controllerUser.updatePassword("Denis", "Farcas", "denisdenis@gmail.com"));
   }

   @Test
   public void login() {
      ControllerUser controllerUser = new ControllerUser();

      assertEquals(true, controllerUser.loginUser("popovicidarius@gmail.com", "popovicidarius@gmail.com2022"));
      assertEquals(false, controllerUser.loginUser("aaaaa@gmail.com", "b2b2b2"));
   }

   @Test
   public void returnUser(){
      ControllerUser controllerUser = new ControllerUser();
      User user = controllerUser.returnUserbyEmail("popovicidarius@gmail.com");
      assertEquals(null,controllerUser.returnUserbyEmail("aaaaa@gmail.com"));
      assertEquals(user,controllerUser.returnUserbyEmail("popovicidarius@gmail.com"));
   }
}
