import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaiterController  {
    private Restaurant restaurant;
    private WaiterView waiterView;

    public WaiterController(Restaurant rest, WaiterView waiterView) {
        this.restaurant = rest;
        this.waiterView = waiterView;
        this.waiterView.createTable(this.restaurant.viewOrders());
        this.waiterView.addCreateButtonListener(new CreateButtonListener());
        this.waiterView.addPriceButtonListener(new PriceButtonListener());
        this.waiterView.addBillButtonListener(new BillButtonListener());
        //this.waiterView.addShowButtonListener(new ShowButtonListener());

    }
    class CreateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            new InsertOrderController(restaurant, waiterView, new InsertOrderView());
        }
    }

    class PriceButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                restaurant.computePriceOrder(waiterView.getSelectedOrder());
                waiterView.setP(restaurant.computePriceOrder(waiterView.getSelectedOrder()));
                System.out.println(restaurant.computePriceOrder(waiterView.getSelectedOrder()));
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.err.println("No row selected for delete!");
            }
        }
    }

    class BillButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                restaurant.generateBill(waiterView.getSelectedOrder());
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.err.println("No row selected for update!");
            }
        }
    }

    /*
    class ShowButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                //new AccountsViewController(bank, adminView.getSelectedPerson(), new AccountsView());
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.err.println("No client selected!");
            }
        }
    }

     */
}
