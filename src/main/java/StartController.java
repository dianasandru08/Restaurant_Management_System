import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartController {
    private Restaurant restaurant;
    private StartView startView;

    public StartController(Restaurant restaurant, StartView startView) {
        this.restaurant = restaurant;
        this.startView = startView;
        this.startView.addWaiterButtonActionListener(new WaiterButtonListener());
        this.startView.addAdministratorButtonActionListener(new AdministratorButtonListener());
        this.startView.addChefButtonActionListener(new ChefButtonListener());
    }

    class WaiterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new WaiterController(restaurant, new WaiterView());
        }
    }

    class AdministratorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new AdministratorController(restaurant, new AdministratorView());
        }
    }
    class ChefButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           // new AdministratorController(restaurant, new AdministratorView());
            new ChefController(restaurant, new ChefView());
        }
    }
}
