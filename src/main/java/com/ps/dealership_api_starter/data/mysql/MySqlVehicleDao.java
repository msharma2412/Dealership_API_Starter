package com.ps.dealership_api_starter.data.mysql;

import com.ps.dealership_api_starter.data.VehicleDao;
import com.ps.dealership_api_starter.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
abstract class MySqlVehiclesDao implements VehicleDao {
    private DataSource dataSource;

    @Autowired
    public MySqlVehiclesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Vehicle> vehicleSearch(Integer yearMin, Integer yearMax, String make, String model, String vehicleType, String color, Double priceMin, Double priceMax) {
        List<Vehicle> vehicles = new ArrayList<>();

        String sql = "SELECT * FROM vehicles WHERE year >=? AND year <=? AND make LIKE? AND model LIKE? AND vehicle_type LIKE? AND color LIKE? AND price >=? AND price <=?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, yearMin!= null? yearMin : Integer.MIN_VALUE);
            preparedStatement.setInt(2, yearMax!= null? yearMax : Integer.MAX_VALUE);
            preparedStatement.setString(3, make!= null &&!make.isEmpty()? "%" + make + "%" : "%");
            preparedStatement.setString(4, model!= null &&!model.isEmpty()? "%" + model + "%" : "%");
            preparedStatement.setString(5, vehicleType!= null &&!vehicleType.isEmpty()? "%" + vehicleType + "%" : "%");
            preparedStatement.setString(6, color!= null &&!color.isEmpty()? "%" + color + "%" : "%");
            preparedStatement.setDouble(7, priceMin!= null? priceMin : Double.MIN_VALUE);
            preparedStatement.setDouble(8, priceMax!= null? priceMax : Double.MAX_VALUE);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vehicle vehicle = mapResultset(resultSet);
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    @Override
    public Vehicle getByVin(int vin) {
        return null;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return null;
    }

    @Override
    public void updateVehicle(int vin, Vehicle vehicle) {

    }

    @Override
    public void deleteVehicle(int vin) {

    }

    //... other methods...

    protected static Vehicle mapResultset(ResultSet resultSet) throws SQLException {
        Integer vin = resultSet.getInt("vin");
        Integer year = resultSet.getInt("year");
        String make = resultSet.getString("make");
        String model = resultSet.getString("model");
        String type = resultSet.getString("type");
        String color = resultSet.getString("color");
        Double maxPrice = resultSet.getDouble("maxPrice");
        Double minPrice = resultSet.getDouble("minPrice");


        return new Vehicle(vin, year, make, model, type, color, minPrice, maxPrice);
    }
}