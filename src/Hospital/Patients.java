package Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patients {
    private Connection connection;
    private Scanner scanner;

    public Patients(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void addPatients(){
        System.out.println("Enter Patient's Name:");
        String pName = scanner.nextLine();
        System.out.println("Enter Patient's Age:");
        int age = scanner.nextInt();
        System.out.println("Enter Patient's Gender:");
        String pGender = scanner.nextLine();

        try{
            String query = "INSERT INTO patients(name,age,gender) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,pName);
            preparedStatement.setInt(2,age);
            preparedStatement.setString(3,pGender);
            int affected = preparedStatement.executeUpdate();
            if (affected>0){
                System.out.println("Patient Added Successfully");
            }else {
                System.out.println("Some error Occurred!!!");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void viewPatients(){
        String query = "SELECT * FROM patients";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
