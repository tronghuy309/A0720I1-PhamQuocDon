package controllers;

import javafx.scene.control.skin.CellSkinBase;
import models.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileCsv {
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static void writeServicesToCSV(List<Services> serviceList, String filePath) {
        //**Method writing service list to the file following the file path.
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            for (Services service : serviceList) {
                //Writing header to the file
                if (serviceList.indexOf(service) == 0) {
                    fileWriter.append(service.getHeader());
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }
                //Writing service data to the file
                fileWriter.append(service.writeToCSV());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Services> readServiceListFromCSV(String filePath) {
        //** Method reading list of services from the file following the file path.
        BufferedReader br = null;
        List<Services> serviceList = new ArrayList<>();

        //Check the file exists or not. If not, create new file following the file path
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(filePath);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //Reading data from the file
        try {
            String line;
            String serviceId = null;
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[1].equals("Service Name")) {
                    //Skip reading header
                    //Identify class of elements in the list through first field of header.
                    serviceId = splitData[0];
                    continue;
                }

                //Base on service ID to identify class of elements, initialize service object and add to the list
                assert serviceId != null;
                switch (serviceId){
                    case "Villa Id":{
                        Villa villa = new Villa(splitData[0], splitData[1], Double.parseDouble(splitData[2]), Double.parseDouble(splitData[3]),
                                Integer.parseInt(splitData[4]), splitData[5], splitData[6], splitData[7], Double.parseDouble(splitData[8]), Integer.parseInt(splitData[9]));
                        serviceList.add(villa);
                        break;
                    }
                    case "House Id":{
                        House house = new House(splitData[0], splitData[1], Double.parseDouble(splitData[2]), Double.parseDouble(splitData[3]),
                                Integer.parseInt(splitData[4]), splitData[5], splitData[6], splitData[7], Integer.parseInt(splitData[8]));
                        serviceList.add(house);
                        break;
                    }
                    case "Room Id": {
                        Room room = new Room(splitData[0], splitData[1], Double.parseDouble(splitData[2]), Double.parseDouble(splitData[3]),
                                Integer.parseInt(splitData[4]), splitData[5], splitData[6]);
                        serviceList.add(room);
                        break;
                    }
                }
            }
            return serviceList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return serviceList;
    }

    public static void writeCustomerToCSV(List<Customer> customerList, String filePath) {
        //**Method writing service list to the file following the file path.
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            for (Customer customer : customerList) {
                //Writing header to the file
                if (customerList.indexOf(customer) == 0) {
                    fileWriter.append(customer.getHeader());
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }
                //Writing service data to the file
                fileWriter.append(customer.writeToCSV());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Services> readCustomerListFromCSV(String filePath) {
        //** Method reading list of customers from the file following the file path.
        BufferedReader br = null;
        List<Customer> customerList = new ArrayList<>();

        //Check the file exists or not. If not, create new file following the file path
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(filePath);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //Reading data from the file
        try {
            String line;
            String serviceId = null;
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[1].equals("Service Name")) {
                    //Skip reading header
                    //Identify class of elements in the list through first field of header.
                    serviceId = splitData[0];
                    continue;
                }

                //Base on service ID to identify class of elements, initialize service object and add to the list
                assert serviceId != null;
                switch (serviceId){
                    case "Villa Id":{
                        Villa villa = new Villa(splitData[0], splitData[1], Double.parseDouble(splitData[2]), Double.parseDouble(splitData[3]),
                                Integer.parseInt(splitData[4]), splitData[5], splitData[6], splitData[7], Double.parseDouble(splitData[8]), Integer.parseInt(splitData[9]));
                        serviceList.add(villa);
                        break;
                    }
                    case "House Id":{
                        House house = new House(splitData[0], splitData[1], Double.parseDouble(splitData[2]), Double.parseDouble(splitData[3]),
                                Integer.parseInt(splitData[4]), splitData[5], splitData[6], splitData[7], Integer.parseInt(splitData[8]));
                        serviceList.add(house);
                        break;
                    }
                    case "Room Id": {
                        Room room = new Room(splitData[0], splitData[1], Double.parseDouble(splitData[2]), Double.parseDouble(splitData[3]),
                                Integer.parseInt(splitData[4]), splitData[5], splitData[6]);
                        serviceList.add(room);
                        break;
                    }
                }
            }
            return serviceList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return serviceList;
    }
}
