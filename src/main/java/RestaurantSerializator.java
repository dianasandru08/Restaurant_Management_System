import java.io.*;
import java.util.ArrayList;

public class RestaurantSerializator {
    //MenuItem object = new BaseProduct("lamaie", 4, 48, 3);


    public RestaurantSerializator() {

    }
    // Serialization

      public void serialization(Restaurant restaurant){
          String filename = "filen.ser";
          try
          {    System.out.println("Ajung aici");
              //Saving of object in a file
              FileOutputStream file = new FileOutputStream(filename);
              ObjectOutputStream out = new ObjectOutputStream(file);
              // Method for serialization of object
              out.writeObject(restaurant);
              out.close();
              file.close();

              System.out.println("Object has been serialized");
          }
          catch(IOException ex)
          {
              System.out.println("IOException is caught");
          }
      }
/*
      public void serializationProduct(){
          BaseProduct lamaie = new BaseProduct("lamaie", 4, 48, 3);
          BaseProduct apa = new BaseProduct("apa", 3, 48, 5);
          BaseProduct zahar = new BaseProduct("zahar", 100, 124, 1);
          ArrayList<BaseProduct> limonadaCom = new ArrayList<BaseProduct>();
          limonadaCom.add(lamaie);
          limonadaCom.add(zahar);
          limonadaCom.add(apa);
          MenuItem limonada = new CompositeProduct("limonada", 34, 24, limonadaCom);
          serialization(lamaie);
          serialization(apa);
          serialization(zahar);
          serialization(limonada);

      }

 */
      public Restaurant deserialization(){
        Restaurant restaurant = null;
          try
          {
              // Reading the object from a file
              FileInputStream file = new FileInputStream("file.ser");
              ObjectInputStream in = new ObjectInputStream(file);

              // Method for deserialization of object
              restaurant =(Restaurant)in.readObject();

              in.close();
              file.close();

          }

          catch(Exception ex)
          {
              restaurant = new Restaurant();
              System.out.println("IOException is caught");
          }
        return restaurant;
      }

}
