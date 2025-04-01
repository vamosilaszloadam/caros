import java.util.ArrayList;

public class Solution { 
    Store store = new Store();
    ArrayList<Car> carList = store.readCsvFile();
    public Solution() {

    }

    public void sumSalary() {
        // System.out.println(carList.get(0).getPlate());
        double sum = 0;
        for(Car car : carList) {
            // System.out.println(car.getPlate());
            // System.out.println(car.getPrice());
            // sum = sum + car.getPrice();
            sum += car.getPrice();
        }
        System.out.printf("Összeg: %.2f\n", sum);
    }
    //Hány darab Lada van
    public void task02() {
        int counter = 0;
        for(Car car : carList) {
            if(car.getBrand().equals("Lada")) {
                // counter += 1;
                counter++;
            }
        }
        System.out.printf("Ladák száma: %d\n", counter);
    }
    //Citroen van?
    public void task03() {
        int n = carList.size();
        String ker = "Citroen";
        int i = 0;
        while(i<n && (!carList.get(i).getBrand().equals(ker))) {
            i++;
        }
        if(i<n) {
            System.out.println("Van " + ker);
        }else {
            System.out.println("Nincs " + ker);
        }
    }
    //Hányadik helyen van a Citroen?
    public void task04() {
        int n = carList.size();
        String ker = "Citroen";
        int i = 0;
        while(!carList.get(i).getBrand().equals(ker)) {
            i++;
        }
        System.out.println("Hányadik helyen: " + (i + 1));
    }
        //Lada keresése?
        public void task05() {
            int n = carList.size();
            String ker = "Lada";
            int i = 0;
            while(i<n && (!carList.get(i).getBrand().equals(ker))) {
                i++;
            }
            if(i<n) {
                System.out.println("Van " + ker + ". Indexe: " + 1);
            }else {
                System.out.println("Nincs " + ker);
            }
        }
        //A Ladák kiválogatása másik listába
        public void task06() {
            ArrayList<Car> ladaList = new ArrayList<>();
            // int j = 0;
            for(Car car : carList) {
                if(car.getBrand().equals("Lada")){
                    ladaList.add(car);
                }
            }
            // for(int i=0; i<carList.size(); i++) {}
            kiirLista(ladaList);
        }

        public void kiirLista(ArrayList<Car> list) {
            for(Car car : list) {
                System.out.printf("%s %s %.2f\n", car.getPlate(), car.getBrand(), car.getPrice());
            }
        }

        public void szetvalogat() {
            System.out.println("---------------------");
            System.out.println("Szétválogatás");
            ArrayList<Car> dragaLista = new ArrayList<>();
            ArrayList<Car> olcsoLista = new ArrayList<>();

            // int j = 0;
            // int k = 0;
            for(Car car : carList) {
                if(car.getPrice() >=1000) {
                    dragaLista.add(car);
                }else {
                    olcsoLista.add(car);
                }
            }
            System.out.println("Drágák: ");
            kiirLista(dragaLista);
            System.out.println("Olcsók: ");
            kiirLista(olcsoLista);
        }
}
