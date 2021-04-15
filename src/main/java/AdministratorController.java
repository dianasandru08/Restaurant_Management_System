import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministratorController {
    private Restaurant restaurant;
    private AdministratorView administratorView;

    public AdministratorController(Restaurant rest, AdministratorView adminView) {
        this.restaurant = rest;
        this.administratorView = adminView;
        this.administratorView.createTable(this.restaurant.viewMenus());
        this.administratorView.addInsertButtonListener(new InsertButtonListener());
        this.administratorView.addDeleteButtonListener(new DeleteButtonListener());
        this.administratorView.addUpdateButtonListener(new UpdateButtonListener());
        this.administratorView.addAccountsButtonListener(new AccountsButtonListener());
    }

    class InsertButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            new InsertController(restaurant, administratorView, new InsertMenuItemView());
        }
    }

    class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                restaurant.deleteMenuItem(administratorView.getSelectedMenuItem(restaurant.viewMenus()));
               // restaurant.deleteOtherMenuItem(administratorView.getSelectedMenuItem(restaurant.viewMenus()));
                administratorView.deleteSelectedRow();
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.err.println("No row selected for delete!");
            }
        }
    }

    class UpdateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                //restaurant.updateMenuItem(administratorView.getSelectedMenuItem(restaurant.viewMenus()));
               new UpdateMenuItemController(restaurant, administratorView, new UpdateMenuItemView());
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.err.println("No row selected for update!");
            }
        }
    }

    class AccountsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                //new AccountsViewController(bank, adminView.getSelectedPerson(), new AccountsView());
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.err.println("No client selected!");
            }
        }
    }
}
