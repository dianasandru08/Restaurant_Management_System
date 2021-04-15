import java.util.ArrayList;

/**
 * Interfata care este implementata de clasa restaurant
 * Contine toate metodele principael care se ocupa de functionalitatile proiectului
 */

public interface IRestaurantProcessing {

    public void createMenuItem(MenuItem m);
    public void deleteMenuItem(MenuItem m);
    public void updateMenuItem(MenuItem m, int cantitate, int durata, float pret);
    //------------------------------------
    public void createOrder(Comanda c, ArrayList<MenuItem> n );
    public float computePriceOrder(Comanda c);
    public void generateBill(Comanda c);

}
