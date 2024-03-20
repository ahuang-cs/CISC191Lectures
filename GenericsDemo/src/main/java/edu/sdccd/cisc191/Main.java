package edu.sdccd.cisc191;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static final String CUSTOMERS_FILENAME = "customers.csv";
    public static final String EMPLOYEES_FILENAME = "employees.csv";
    public static void main(String[] args) {
        try {
            UserController<Employee> employeeController = initController(Employee.class, EMPLOYEES_FILENAME);

            Scanner kb = new Scanner(System.in);
            System.out.print("Enter your id: ");
            String userId = kb.nextLine();
            System.out.print("Enter your name: ");
            String userName = kb.nextLine();

            Employee user = employeeController.authenticate(Long.parseLong(userId), userName);
            if(user.isAdministrator()) {
                System.out.println(userName + " has logged in with admin rights!");

            } else {
                System.err.println(userName + " has logged in.");
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

    }

    private static <T extends User> UserController<T> initController(Class<T> clazz, String fileName) throws Exception {
        UserController<T> userController = new UserController<>();

        InputStream is = Main.class.getClassLoader().getResourceAsStream(fileName);
        if(is == null) throw new Exception(fileName + " could not be found");

        Reader userReader = new BufferedReader(new InputStreamReader(is));
        CsvToBean<T> csvToUser = new CsvToBeanBuilder<T>(userReader)
                .withType(clazz)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<T> itr = csvToUser.stream().iterator();
        while(itr.hasNext()) {
            userController.addUser(itr.next());
        }
        return userController;
    }
}
