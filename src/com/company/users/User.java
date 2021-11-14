package com.company.users;

import com.company.Database;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class User {
    private String userType;
    private int idNum;
    private String fullName;
    private String email;

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public String getUserType() {
        return userType;
    }

    public int getIdNum() {
        return idNum;
    }

    public String getFullName() {
        return fullName;
    }

    public void placeOrder(int userId /**, Order order**/){
        // code
    }

    public void cancelOrder(int userId, int orderId){
        // code
    }

    public static User createUser(boolean isNewUser, String email) {
        UserFactory userFactory = new UserFactory();
        List<String> cols = new ArrayList<>();
        // JSON for extra attributes for user depending on whether they're employees or customers
        JSONObject extraAttributes = new JSONObject();
        Scanner scanner = new Scanner(System.in);
        User user;
        JSONObject userDetailsJson;
        userDetailsJson = Database.readFromUserTable(email, null);
        extraAttributes.put("user_id", userDetailsJson.getInt("user_id"));

        // if userLogin email is empty then this is a newly registered user
        if(isNewUser) {
            if(Objects.equals(userDetailsJson.getString("user_type"), "customer")) {
                extraAttributes.put("loyalty_points", 0);
                Database.writeToTable("loyalty", extraAttributes);
                userDetailsJson.put("loyalty_points", 0);
            } else {
                extraAttributes.put("employee_type", "clerk");
                userDetailsJson.put("employee_type", "clerk");
                System.out.println("How much should this employee be paid? Enter a salary between 15000 and 50000");
                String amount = scanner.nextLine();
                boolean valid = false;
                while(!valid) {
                    try {
                        double salary = Double.parseDouble(amount);
                        extraAttributes.put("salary", salary);
                        userDetailsJson.put("salary", salary);
                        valid = true;
                    } catch(NumberFormatException ignored) {

                    }
                }
                Database.writeToTable("employeesalary", extraAttributes);
            }
        } else {
            if(Objects.equals(userDetailsJson.getString("user_type"), "customer")) {
                cols.add("loyalty_points");
                extraAttributes = Database.readFromTable("loyalty", userDetailsJson.getInt("user_id"), cols);
                userDetailsJson.put("loyalty_points", extraAttributes.getInt("loyalty_points"));
            } else if(Objects.equals(userDetailsJson.getString("user_type"), "employee")) {
                cols.add("salary");
                cols.add("employee_type");
                JSONObject employeeTypeSalary = Database.readFromTable("employeesalary", userDetailsJson.getInt("user_id"), cols);
                userDetailsJson.put("salary", employeeTypeSalary.getDouble("salary"));
                userDetailsJson.put("employee_type", employeeTypeSalary.getString("employee_type"));
            }
        }
        user = userFactory.createUser(userDetailsJson);
        return user;
    }

}
