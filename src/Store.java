import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    public ArrayList<Car> readCsvFile() {
        try {
            return tryReadCsvFile();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    public ArrayList<Car> tryReadCsvFile() throws FileNotFoundException {
        ArrayList<Car> carList = new ArrayList<>();
        File file = new File("cars2.csv");
        try(Scanner sc = new Scanner(file)) {
            sc.nextLine();
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                // System.out.println(line);
                String[] array = line.split(",");
                // System.out.println(array[1].replace("\"", "").trim());
                Car car = new Car();
                car.setId(Integer.parseInt(array[0].trim()));
                car.setPlate(array[1].replace("\"", "").trim());
                car.setBrand(array[2].replace("\"", "").trim());
                car.setYear(Integer.parseInt(array[3].trim()));
                car.setPrice(Double.parseDouble(array[4]));
                // System.out.println(car.getPlate());
                // System.out.println(car.getId()+" "+car.getPlate()+" "+car.getBrand()+" "+car.getYear()+" "+car.getPrice()+"\n");
                carList.add(car);
            }
            return carList;
        }
    }
}
