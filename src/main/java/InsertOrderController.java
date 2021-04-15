import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InsertOrderController  {
    private Restaurant restaurant;
    private WaiterView waiterView;
    private InsertOrderView insertView;

    public InsertOrderController(Restaurant restaurant,WaiterView adminView,InsertOrderView insertView) {

        this.restaurant = restaurant;
        this.waiterView = adminView;
        this.insertView = insertView;
        this.insertView.addCreateButtonListener(new InsertOrderController.CreateButtonListener());
    }


    class CreateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                ArrayList<MenuItem> com = new ArrayList<MenuItem>();
                Comanda p = insertView.getOrdertoCreate();
                System.out.println(restaurant.viewMenus());
                com = insertView.getProdComandate(restaurant.viewMenus());
                // ac.addObserver(p);
                System.out.println(com);
                System.out.println("Produse comandate:");
                restaurant.createOrder(p, com);
                //bank.addAccount(ac, p);
                System.out.println(restaurant.getData());
                waiterView.addRow(p);
            } catch (IllegalArgumentException ex) {
                System.err.println("Illegal Argument Exception : Insert Oder");
            }
            insertView.dispose();
        }
    }
}
