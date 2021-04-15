import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateMenuItemController {
    private Restaurant restaurant;
    private AdministratorView adminView;
    private UpdateMenuItemView updateView;

    public UpdateMenuItemController(Restaurant restaurant,AdministratorView adminView,UpdateMenuItemView updateView) {

        this.restaurant = restaurant;
        this.adminView = adminView;
        this.updateView = updateView;
        this.updateView.addUpdateButtonListener(new UpdateMenuItemController.UpdateButtonListener());
    }

    class UpdateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {

                //MenuItem ac = insertView.getMenuItemToInsert(restaurant.viewMenus());
                // ac.addObserver(p);
                String cs, ds, ps;
                restaurant.updateMenuItem(adminView.getSelectedMenuItem(restaurant.viewMenus()), updateView.getCantitateUpdate(), updateView.getDurataUpdate(), updateView.getPretUpdate());
                if(updateView.getCantitateUpdate() == -1){
                    cs = adminView.getSelectedMenuItem(restaurant.viewMenus()).getCantitate() + "";
                }
                else {
                    cs = updateView.getCantitateUpdate() + "";
                 }

                if(updateView.getDurataUpdate() == -1){
                    ds = adminView.getSelectedMenuItem(restaurant.viewMenus()).getDurata() + "";
                }
                else {
                    ds = updateView.getDurataUpdate() + "";
                }
                if(updateView.getPretUpdate() == -1){
                    ps = adminView.getSelectedMenuItem(restaurant.viewMenus()).getPret() + "";
                }
                else {
                    ps = updateView.getPretUpdate() + "";
                }
                // adminView.Update(updateView.getCantitateUpdate() + "", updateView.getDurataUpdate()+"", updateView.getPretUpdate()+"");
                adminView.Update(cs, ds, ps);
                //restaurant.updateMenuItem(ac);
                //adminView.addRow(ac);
            } catch (IllegalArgumentException ex) {
                System.err.println("Illegal Argument Exception : Insert Client");
            }
            updateView.dispose();
        }
    }
}
