import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main {
        public static void main(String[] args) {
                ArrayList<MenuItem> b = new ArrayList<>();
                MenuItem apa = new BaseProduct("apa", 3, 48, 5);
                MenuItem lamaie = new BaseProduct("lamaie", 5, 48, 2);
                b.add(apa);
                b.add(lamaie);
                RestaurantSerializator ser = new RestaurantSerializator();

                MenuItem limonada = new CompositeProduct("limonada", 1, 24, b);
                MenuItem zahar = new BaseProduct("zahar", 1, 124, 1);
                System.out.println(limonada);
                Restaurant rest = new Restaurant();
                //rest = ser.deserialization();
                //rest.createMenuItem(apa);
                //rest.createMenuItem(lamaie);
                //rest.createMenuItem(limonada);
                //ser.serialization(rest);
                if(limonada instanceof CompositeProduct){
                        System.out.println("Corect");
                }
                System.out.println(rest);
                //rest.deleteMenuItem(apa);
                //rest.updateMenuItem(zahar, -1, -1, 3);
                //rest.createMenuItem(zahar);
                System.out.println(rest);
                Comanda c1= new Comanda(1, "01-08-2000", 22, 9);
                ArrayList<MenuItem> com1 = new ArrayList<MenuItem>();
                com1.add(apa);
                com1.add(lamaie);
                Comanda c2= new Comanda(2, "07-04-2019", 22, 8);
                ArrayList<MenuItem> com2 = new ArrayList<MenuItem>();
                com2.add(lamaie);
                //com2.add(zahar);
                /*
                Comanda c3= new Comanda(1, "02.04.2020", 12, 9);
                ArrayList<MenuItem> com3 = new ArrayList<MenuItem>();
                com3.add(apa);

                 */

                //boolean bl = c1.isWellFormed();
                //System.out.println(bl);
                int nr=0;
                /*
               rest.createOrder(c1,com1);
               rest.generateBill(c1, nr++);
               rest.createOrder(c2,com2);
                rest.generateBill(c2, nr++);

                 */
               //rest.createOrder(c2, com2);
                //boolean bll = rest.isOrder(c1);
                //System.out.println(bll);

                //RestaurantSerializator sr = new RestaurantSerializator();

                //rest.deleteMenuItem(apa);
                //rest.deleteOtherMenuItem(apa);
               // rest.createOrder(c3,com3);
                //float totCom1 = rest.computePriceOrder(c1);
                //float totCom2 = rest.computePriceOrder(c2);
               // System.out.println(totCom1);
                //System.out.println(totCom2);
                //rest.updateMenuItem(lamaie, -1, -1, 10);
                //rest.createOrder(c1, com1);
                System.out.println(rest.getData());
               new StartController(rest, new StartView());
        }
}




