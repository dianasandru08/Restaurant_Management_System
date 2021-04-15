import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class InsertController implements Serializable {
    private Restaurant restaurant;
    private AdministratorView adminView;
    private InsertMenuItemView insertView;
    private RestaurantSerializator ser;

    public InsertController(Restaurant restaurant,AdministratorView adminView,InsertMenuItemView insertView) {

        this.restaurant = restaurant;
        this.adminView = adminView;
        this.insertView = insertView;
        this.insertView.addInsertButtonListener(new InsertButtonListener());
    }

    class InsertButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                //Comanda p = insertView.getOrderToInsert();
                MenuItem ac = insertView.getMenuItemToInsert(restaurant.viewMenus());
               // ac.addObserver(p);
                restaurant.createMenuItem(ac);
                //bank.addAccount(ac, p);
                adminView.addRow(ac);
                //ser.serialization(restaurant);
            } catch (Exception ex) {
                ex.printStackTrace();
                System.err.println("Illegal Argument Exception : Insert MenuItem");
            }
            insertView.dispose();
        }
    }
}
