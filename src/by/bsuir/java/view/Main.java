package by.bsuir.java.view;

import by.bsuir.java.controller.Controller;
import by.bsuir.java.controller.command.CommandName;
import by.bsuir.java.controller.exception.ControllerException;
import by.bsuir.java.entity.Account;
import by.bsuir.java.entity.Role;
import by.bsuir.java.entity.Sale;
import by.bsuir.java.view.scanner.DataScanner;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.InputMismatchException;

public class Main {

    private static Account currentAccount = new Account();
    private static Controller controller = new Controller();

    public static void main(String[] args) {
        try {
            showLoginForm();
        } catch (InputMismatchException e){
            System.out.println(e.getMessage());
        } catch (ControllerException e) {
            e.printStackTrace();
        }
    }

    private static void showLoginForm() throws ControllerException {
        String response;
        while (true) {
            System.out.println("-------------------------");
            System.out.println("1 - Log in");
            System.out.println("2 - Register");
            System.out.println("0 - Quit");
            System.out.println("-------------------------\n");

            switch (DataScanner.enterInt()) {
                case 1: {
                    response = signIn();
                    if (response.equals("Error during sign in")){
                        System.out.println(response);
                    } else{
                        String[] data = response.split(",");
                        currentAccount.setId(Integer.parseInt(data[0]));
                        currentAccount.setLogin(data[1]);
                        currentAccount.setPassword(data[2]);
                        currentAccount.setRole(Role.valueOf(data[3]));
                        if (currentAccount.getRole() == Role.USER){
                            showUserMainMenu();
                        }
                        else{
                            showAdminMainMenu();
                        }
                    }

                    break;
                }
                case 2: {
                    response = signUp();
                    if (!response.equals(CommandName.WRONG_REQUEST.name())){
                        System.out.println("You successfully registered!");
                    }
                    else {
                        System.out.println("Registration error");
                    }
                    break;
                }
                case 0: {
                    System.out.println("Leaving the program...");
                    System.exit(0);
                    break;
                }
            }
        }
    }

    private static String signIn() throws ControllerException {
        System.out.println("Enter login: ");
        String login = DataScanner.enterString();
        System.out.println("Enter password: ");
        String password = DataScanner.enterString();
        String command = CommandName.SIGN_IN.name();
        String request = String.format("%s$LOGIN=%s&PASSWORD=%s", command, login, password);
        return controller.executeTask(request);
    }

    private static String signUp() throws ControllerException {
        System.out.println("Enter login: ");
        String login = DataScanner.enterString();
        System.out.println("Enter password: ");
        String password = DataScanner.enterString();
        String command = CommandName.REGISTER.name();
        System.out.println("Enter firstName: ");
        String name = DataScanner.enterString();
        System.out.println("Enter lastName: ");
        String surname = DataScanner.enterString();
        System.out.println("Enter patronymic: ");
        String patronymic = DataScanner.enterString();
        System.out.println("Enter passport: ");
        String passport = DataScanner.enterString();
        System.out.println("Enter email: ");
        String email = DataScanner.enterString();
        System.out.println("Enter phone: ");
        String phone = DataScanner.enterString();
        String request = String.format("%s$LOGIN=%s&PASSWORD=%s&SURNAME=%s&NAME=%s&PATRONYMIC=%s&PASSPORT=%s&EMAIL=%s&PHONE=%s&ROLE=%s", command, login, password,surname,name,patronymic,passport,email,phone,Role.USER);
        return controller.executeTask(request);
    }


    private static void showAdminMainMenu() throws ControllerException {
        while (true) {
            System.out.println("-------------------------");
            System.out.println("1 - All tours");
            System.out.println("2 - All sales");
            System.out.println("3 - All returns");
            System.out.println("4 - Add discount");
            System.out.println("5 - Add hotel");
            System.out.println("6 - Delete tour");
            System.out.println("0 - Quit");
            System.out.println("-------------------------\n");

            switch (DataScanner.enterInt()) {
                case 1: {
                    String request = String.format("%s$", CommandName.ALL_TOURS);
                    System.out.println(controller.executeTask(request));
                    break;
                }
                case 2: {
                    String request = String.format("%s$", CommandName.ALL_SALES);
                    System.out.println(controller.executeTask(request));
                    break;
                }
                case 3: {
                    String request = String.format("%s$", CommandName.ALL_RETURNS);
                    System.out.println(controller.executeTask(request));
                    break;
                }
                case 4: {
                    addDiscount();
                    break;
                }
                case 5:{
                    addHotel();
                    break;
                }
                case 6:{
                    String request = String.format("%s$", CommandName.ALL_TOURS);
                    String response = controller.executeTask(request);
                    System.out.println(response);
                    System.out.println("Enter id of tour: ");
                    Integer tourID = DataScanner.enterInt();
                    request = String.format("%s$%s", CommandName.DELETE_TOUR, tourID);
                    System.out.println(controller.executeTask(request));
                    break;
                }
                case 0: {
                    System.out.println("Leaving the program...");
                    System.exit(0);
                    break;
                }
            }
        }
    }

    private static void showUserMainMenu() throws ControllerException {
        while (true) {
            System.out.println("-------------------------");
            System.out.println("1 - All tours");
            System.out.println("2 - Order tour");
            System.out.println("3 - Return tour");
            System.out.println("0 - Quit");
            System.out.println("-------------------------\n");

            switch (DataScanner.enterInt()) {
                case 1: {
                    String request = String.format("%s$", CommandName.ALL_TOURS);
                    System.out.println(controller.executeTask(request));
                    break;
                }
                case 2: {
                    orderTour();
                    break;
                }
                case 3:{
                    returnTour();
                    break;
                }
                case 0: {
                    System.out.println("Leaving the program...");
                    System.exit(0);
                    break;
                }
            }
        }
    }




    private static String orderTour() throws ControllerException{
        String request = String.format("%s$", CommandName.ALL_TOURS);
        System.out.println(controller.executeTask(request));
        System.out.println("Enter id of tour: ");
        Integer tourID = DataScanner.enterInt();
        request = String.format("%s$SALE_TIME=%s&COUNT=%s&CLIENT_ID=%s&EMPLOYEE_ID=%s&TOUR_ID=%s", CommandName.ADD_SALE, new Timestamp(new Date().getTime()),1,currentAccount.getId(),1, tourID);
        return controller.executeTask(request);
    }

    private static String returnTour() throws ControllerException{
        String request = String.format("%s$%s", CommandName.MY_TOURS, currentAccount.getId());
        System.out.println(controller.executeTask(request));
        System.out.println("Enter id of tour: ");
        Integer tourID = DataScanner.enterInt();
        System.out.println("Enter a reason for return: ");
        String reason = DataScanner.enterString();
        request = String.format("%s$SALE_TIME=%s&COUNT=%s&REASON=%s&CLIENT_ID=%s&EMPLOYEE_ID=%s&TOUR_ID=%s", CommandName.ADD_RETURN, new Timestamp(new Date().getTime()),1,reason,currentAccount.getId(),1, tourID);
        controller.executeTask(request);
        request = String.format("%s$%s", CommandName.DELETE_SALE, tourID);
        return controller.executeTask(request);
    }

    private static String addDiscount() throws ControllerException {
        System.out.println("Enter discount name:");
        String name = DataScanner.enterString();
        System.out.println("Enter a discount size:");
        double size = DataScanner.enterDouble();
        String command = CommandName.ADD_DISCOUNT.name();
        String request = String.format("%s$NAME=%s&SIZE=%s", command, name,size);
        return controller.executeTask(request);
    }

    private static String addHotel() throws ControllerException{

        System.out.println("Enter hotel name: ");
        String name = DataScanner.enterString();
        System.out.println("Enter hotel type: ");
        String type = DataScanner.enterString();
        System.out.println("Enter hotel description: ");
        String description = DataScanner.enterString();
        String request = String.format("%s$", CommandName.ALL_COUNTRIES);
        System.out.println(controller.executeTask(request));
        System.out.println("Enter country id: ");
        Integer countryID = DataScanner.enterInt();
        request = String.format("%s$NAME=%s&TYPE=%s&DESCRIPTION=%s&COUNTRY_ID=%s", CommandName.ADD_HOTEL, name, type, description, countryID);
        return controller.executeTask(request);
    }

}
