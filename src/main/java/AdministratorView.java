import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdministratorView extends JFrame {
    private JTable table;
    private JScrollPane tableHolder;
    private JButton insertBtn;
    private JButton deleteBtn;
    private JButton updateBtn;
    private JButton showMenusBtn;

    public AdministratorView() {

        setTitle("Administrator View");
        setBounds(520, 100, 615, 340);
        setLayout(null);

        insertBtn = new JButton("Insert");
        insertBtn.setBounds(30, 250, 100, 30);
        add(insertBtn);

        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(175, 250, 100, 30);
        add(deleteBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(325, 250, 100, 30);
        add(updateBtn);

        showMenusBtn = new JButton("Menu");
        showMenusBtn.setBounds(470, 250, 100, 30);
        add(showMenusBtn);

        setVisible(true);
    }

    public void createTable(ArrayList<MenuItem> menus) {

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Id");
        tableModel.addColumn("Nume");
        tableModel.addColumn("Cantiate");
        tableModel.addColumn("Durata");
        tableModel.addColumn("Pret");
       // tableModel.addColumn("Compozitie");

        int i = 1;
        int aux = 0;
        for(MenuItem p : menus) {
            String[] oneRow = new String[6];
            oneRow[0] = i + "";
            oneRow[1] = p.getNume();
            oneRow[2] = p.getCantitate()+ "" ;
            oneRow[3] = p.getDurata()+"";
            oneRow[4] = p.getPret()+"";
            //oneRow[5]= p.getPret() + " " + p.getCantitate();
            //System.out.println(oneRow[5]);
            i++;
            tableModel.addRow(oneRow);
        }

        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.setFillsViewportHeight(true);
        tableHolder = new JScrollPane(table);
        tableHolder.setBounds(10, 10, 580, 220);
        add(tableHolder);
    }


    public MenuItem getSelectedMenuItem(ArrayList<MenuItem> menus) {
        int selectedRow = table.getSelectedRow();
        TableModel tableModel = table.getModel();
        String nume = (String)tableModel.getValueAt(selectedRow, 1);
        System.out.println(nume);
        /*
        String cantitateS = (String)tableModel.getValueAt(selectedRow, 2);
        String durataS = (String)tableModel.getValueAt(selectedRow, 3);
        String pretS = (String)tableModel.getValueAt(selectedRow, 4);
        int cantitate = Integer.parseInt(cantitateS);
        int durata = Integer.parseInt(durataS);
        float pret = Float.parseFloat(pretS);
         */
        for(MenuItem m: menus){
            if((m.getNume().equals(nume))){
                return m;
            }
        }
        return null;
        //return new BaseProduct(nume, cantitate, durata, pret);
    }



    public void addInsertButtonListener(ActionListener e) {
        insertBtn.addActionListener(e);
    }

    public void addDeleteButtonListener(ActionListener e) {
        deleteBtn.addActionListener(e);
    }

    public void addUpdateButtonListener(ActionListener e) {
        updateBtn.addActionListener(e);
    }

    public void addAccountsButtonListener(ActionListener e) {
        showMenusBtn.addActionListener(e);
    }

    public void addRow(MenuItem p) {
        String[] row = new String[]{((Integer)(table.getRowCount() + 1)).toString(), p.getNume(), p.getCantitate()+"", p.getDurata()+"", p.computePrice() + ""};
        TableModel tM = table.getModel();
        ((DefaultTableModel)tM).addRow(row);
        table.setModel(tM);
    }

    public void Update(String cantitate, String durata, String pret) {
       // createTable(menus);
        DefaultTableModel tM =  (DefaultTableModel) table.getModel();
        //((DefaultTableModel)tM).fireTableDataChanged();
        int selectedRowIndex = table.getSelectedRow();
        tM.setValueAt(cantitate, selectedRowIndex, 2);
        tM.setValueAt(durata, selectedRowIndex, 3);
        tM.setValueAt(pret, selectedRowIndex, 4);

    }

    public void deleteSelectedRow() {
        TableModel tM = table.getModel();
        ((DefaultTableModel)tM).removeRow(table.getSelectedRow());
        table.setModel(tM);
    }

}
