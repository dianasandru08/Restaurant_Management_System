import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

public class ChefController {
    private Restaurant restaurant;
    private ChefView chefView;

    public ChefController(Restaurant rest, ChefView adminView) {
        this.restaurant = rest;
        this.chefView = adminView;
        this.chefView.createTable(this.restaurant.notifyComposite());
        //Map<Comanda, ArrayList<MenuItem>> mmm = restaurant.getLast();
        //ArrayList<Comanda> cmm =(ArrayList) mmm.keySet();
        ArrayList<MenuItem> mm = restaurant.allProductsOrdered();
        if(mm.size() > 0){
            this.chefView.set(restaurant.mesaj(mm.get(mm.size()-1)));
        }
        else
            this.chefView.set("Nu este niciun produs comandat, cheful nu gateste inca.");


    }

}
