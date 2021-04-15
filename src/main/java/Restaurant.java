//import javafx.beans.Observable;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author diana
 * Date: 12 May 2020
 * Clasa Restaurant care este responsabila de majoritatea operatiilor realizate de acest proiect
 */

public class Restaurant  extends ObservableComposite implements IRestaurantProcessing, Serializable {
    private Map<Comanda, ArrayList<MenuItem>> restaurantData;
    private ArrayList<MenuItem> menuOficial;
    private InsertOrderController ioc;

    /**
     * Constructorul fara parametri
     *
     */
    public Restaurant() {
        restaurantData = new HashMap<Comanda, ArrayList<MenuItem>>();
        menuOficial = new ArrayList<MenuItem>();
    }

    /**
     * Getter
     * @return resturneaza "starea" restaurantului, comenzile care au fost preluate, precum si produsele comandate foecare comenzi prin intermediul structurii Map
     */
    public Map<Comanda, ArrayList<MenuItem>> getData(){
        return restaurantData;
    }

    /**
     * Metoda care verifica daca restaurantului este "bine format", verifica daca unule edate introduse in acesta sunt corespunzatoare
     * @return returneaza un boolean: true in cazul in care Restaurantului indeplineste toate cerintele si false in mod contrar
     */
    public boolean isWellFormed() {
        Set<Comanda> comenzi = restaurantData.keySet();
        if(restaurantData.size() != 0) {
            for(Comanda p : comenzi) {
                ArrayList<MenuItem> menus = restaurantData.get(p);
                if(p.isWellFormed()){
                    for(MenuItem a : menus) {
                        if(a.getCantitate()<0) {
                            return false;
                        }
                        if(a.getPret()<0) {
                            return false;
                        }
                        if(a.getDurata()<24){
                            return false;
                        }

                    }
                }
                else
                    return false;
            }
        }

        return true;
    }
/*
    public void createMenuItem(MenuItem m) {
        assert isWellFormed();
        assert m.isWellFormed();
        //assert !isClient(p);
        int sizePre = getNoClients();
        restaurantData.put(m, new ArrayList<Account>());
        int sizePost = getNoClients();
        assert sizePre + 1 == sizePost;
        assert isClient(p);
        assert isWellFormed();
    }

    public boolean isMenuItem(MenuItem m){
        Set<Comanda > comenzi = restaurantData.keySet();
        for(Comanda c : comenzi) {
            ArrayList<MenuItem> menus = restaurantData.get(c);
                for(MenuItem a : menus) {
                    if(a.equals(m))
                        return false;
                }

        }
        return true;

    }

 */

    /**
     * Metoda care genereaza bonul fiscal pentru o anume comanda
     * @param c comanda pentru care se cere generarea bonului fiscal
     * in folderul proiectului se vor genera bonuri cu numele de "Bonx", unde x reprezinta id-ul fiecarei comanzi in parte, care se doreste a fi unic
     */
    public void generateBill(Comanda c){
        Set<Comanda> comenzi = restaurantData.keySet();
        ArrayList<MenuItem> menus = null;
        if(restaurantData.size() != 0) {
            for(Comanda p : comenzi) {
                if(p.equals(c)){
                     menus = restaurantData.get(p);
                }
            }
        String id = "" +c.getId();
        String data = "" + c.getData();
        String ora = "" + c.getOra();
        String masa = "" + c.getMasa();
        String numeCom = "Bon" + c.getId() +".txt";
        try {
            FileWriter myWriter = new FileWriter(numeCom);
            myWriter.write("        BON FISCAL " + "\n");
            myWriter.write(" " +"\n");
            myWriter.write("    Comanda cu numarul: " + id + "\n");
            myWriter.write("    Ora: " + ora + "\n");
            myWriter.write("    Data: " + data + "\n");
            myWriter.write("    Masa: " + masa + "\n");
            myWriter.write("    Produse comandate: " + "\n");
            for(MenuItem m: menus){
                myWriter.write("        " + m.getNume() +"           " +m.computePrice()  + "\n");
            }
            myWriter.write("    TOTAL: " + computePriceOrder(c));
            myWriter.close();
            System.out.println("Am scris cu succes");
        } catch (IOException e) {
            System.out.println("A aparut o eroare la generarea facturii/bonului");
            e.printStackTrace();
        }
    }

    }

    /**
     * Metoda care incearca modificarea unui MenuItem
     * @param m MenuItem-ul care se doreste modificat
     * @param cantitate noua cantitate, daca se doreset modificarea vechii cantitati, in caz contrar la apelul aceste functii pentru paramatrul acesta se va pune valoarea -1
     *
     * @param durata noua durata, daca se doreste modificarea
     * @param pret nou pret, daca se doreste modificarea
     * Assert-urile functioneaza ca "metode" de validare care opresc continuarea operatiilor din metoda respectiva daca conditia nu este respectata
     * @pre retsuarantul este "bine construit", m este un MenuItem, adica se gaseste in meniul oficial al restaurantului
     * @post dupa updatarea menuitem-ului se verifica din nou daca restaurantul este "bine construit", dar inainte de asta se verifica daca noul menuitem este "bine construit"
     */
    public void updateMenuItem(MenuItem m, int cantitate, int durata, float pret){
        assert isWellFormed();
        assert isMenuItem(m);
        //menuOficial.remove(m);
        if (cantitate > -1 ){
            m.setCantitate(cantitate);
        }
        if(durata > -1 ){
            m.setDurata(durata);
        }
        if(pret > -1 ){
            m.setPret(pret);
        }
        assert m.isWellFormed();
        assert isWellFormed();

    }

    /**
     * Metoda care sterge un MenuItem din meniul oficial al restaurantului (nu dintr-o comanda)!
     * @param m MenuItem-ul care se dorseste a fi sters
     *  @pre retsuarantul este "bine construit", m este un MenuItem, adica se gaseste in meniul oficial al restaurantului
     *  @post dupa stergerea menuitem-ului se verifica din nou daca restaurantul este "bine construit", dar prin intermediul assertului se verifica daca MenuItem-ul a fost intr-adevar sters prin verificarea numarului de MenuItem-uri din meniu la inceput si dupa stergerea de fata
     *
     */
    public void deleteMenuItem(MenuItem m){
        assert isWellFormed();
        assert isMenuItem(m);
        int sizePre = menuOficial.size();
        menuOficial.remove(m);
        /*
        ArrayList<MenuItem> menuOficialc = menuOficial;
        for(MenuItem mm: menuOficialc){
            if(mm instanceof CompositeProduct ){
                ArrayList <MenuItem> composite = ((CompositeProduct)mm).getList();
                for(MenuItem mmm: composite){
                    if(mmm.equals(m));
                    menuOficialc.remove(mm);
                }
            }
        }
        menuOficial = menuOficialc;

         */
        int sizePost = menuOficial.size();
        assert sizePre - 1 == sizePost;
        assert isWellFormed();
    }

    public void deleteOtherMenuItem(MenuItem m){
        ArrayList<MenuItem> del = new ArrayList<MenuItem>();
        for(MenuItem mm: menuOficial){
            if(mm instanceof CompositeProduct ){
                ArrayList <MenuItem> composite = ((CompositeProduct)mm).getList();
                for(MenuItem mmm: composite){
                    if(mmm.equals(m));
                    del.add(mm);
                }
            }
        }
        for(MenuItem aux: del){
            menuOficial.remove(aux);
        }
        int sizePost = menuOficial.size();
        assert isWellFormed();
    }

    /**
     * Metoda care incearca adaugarea unui nou MenuItem in meniul restaurantului
     * @param m noul MenuItem care se doreste a fi inclus in meniu
     * @pre verifica daca restaurantul este construit in mod adecvat, pe urma daca MenuItem-ul care se doreste inserta este si el in mod adecvat contruit, iar in cele din urma daca acest MenuItem nu exista deja in meniu(astfel, nu ar mai treui adaugat)
     * @post verifica daca MenuItem a fost adaugat cu succes(prin verificarea dimensiunii meniului inainte si dupa inserare, precum si prim motoda care verifica daca acest produs este un MenuItem)
     */
    public void createMenuItem(MenuItem m){
        assert isWellFormed();
        assert m.isWellFormed() : "Produsul nu are un format corespunzator";
        assert !isMenuItem(m) : "Produsul este deja in meniul oficial al restaurantului";
        int sizePre = menuOficial.size();
        menuOficial.add(m);
        int sizePost = menuOficial.size();
        assert sizePre + 1 == sizePost;
        assert isMenuItem(m) : "Dupa adaugare in meniu, produsul tot nu se gaseste";
        assert isWellFormed();

    }

    /**
     * Metoda care verifica daca un MenuItem se afla sau nu in meniul restaurantului
     * @param m : menuItem-ul pentru care se doreste verificarea
     * @return true/false
     */
    public boolean isMenuItem(MenuItem m){
        for(MenuItem q: menuOficial){
            if(q.equals(m))
                return true;
        }
        return false;
    }

    /**
     * Metoda care pentru o comanda anume calculeaza totalul prin insumarea pretului tuturor produselor comandate
     * @param c :Comanda pentru care se doreste calcularea totalului
     * @pre none
     * @post totalul are o valoare mai mare decat 0
     * @return
     */
    public float computePriceOrder(Comanda c){
        float pret=0;
        ArrayList<MenuItem> menus = restaurantData.get(c);
        assert isOrder(c);
        for(MenuItem m: menus){
            assert m.isWellFormed();
            pret = pret + m.computePrice();
        }
        assert pret >= 0 ;
        return pret;
    }

    /**
     * Getter
     * @return meniul oficial al restaurantului
     */
    public ArrayList<MenuItem> viewMenus (){
        return menuOficial;
    }

    /**
     * Metoda care creeaza o noua comanda
     * @param c Comanda care se doreste a fi creata
     * @param n MenuItem-urile care sunt comandate pentru comanda respectiva
     * @pre verifica daca restaurantul este "construit corect", verifica daca , comanda este construita corest si mai verifica daca comanda nu a fost deja preluata
     * @post verifica daca in final, restaurantul are o "structura" adecvata
     */
   public void createOrder(Comanda c, ArrayList<MenuItem> n ){
        System.out.println("Sunt in createOrderItem");
        System.out.println(menuOficial);
       assert isWellFormed();
       assert c.isWellFormed() : "Comanda nu are formatul corespunzator";
       assert !isOrder(c):"Comanda este deja preluata";
       for(MenuItem mi : n){
           assert isMenuItem(mi) : "Produsul cerut nu este in meniu, nu se poate onora comanda";
       }
       int sizePre = getNoOrders();
       restaurantData.put(c, n);
       System.out.println(this.getData());
       int sizePost = getNoOrders();
       assert sizePre + 1 == sizePost;
       assert isOrder(c);
       for(MenuItem m: n){
           //System.out.println(m);
           if(m instanceof CompositeProduct){
               System.out.println("Cheful trebuie sa intre in bucatarie");
           }
       }
       assert isWellFormed();
   }

    public String mesaj( MenuItem n){

        if(n instanceof CompositeProduct){
                String rez = "Cheful trebuie sa intre in bucatarie pentru a prepara: " + n.getNume();
                return rez;

        }
        String rez1 = "Cheful nu trebuie sa intre in bucatarie";
        return rez1;
    }

    /**
     * Metoda care verifica daca o comanda este sau nu preluata de restaurantul respectiv
     * @param p comanda care se verifica
     * @return
     */
    public boolean isOrder(Comanda p) {
        Set<Comanda> com = restaurantData.keySet();
        for(Comanda c : com) {
            if(c.equals(p)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metoda care calculeaza numarul de comenzi preluate la un moment dat
     * @return
     */
    public int getNoOrders() {
        return restaurantData.keySet().size();
    }

    public int getNoMenuItems(Comanda p) {
        return restaurantData.get(p).size();
    }

    /**
     * Metoda care vizualizeaza toate comenzile preluate la un moment dat
     * @return
     */
    public Set<Comanda> viewOrders() {
        return restaurantData.keySet();
    }
    /*
    public Map<Comanda, ArrayList<MenuItem>> getLast(){
        Set<Comanda> com = restaurantData.keySet();

        Comanda c = com.get(0);
        ArrayList<MenuItem> men = this.viewMenuItemforOrder(c);
        Map<Comanda, ArrayList<MenuItem>> rez = new HashMap<Comanda, ArrayList<MenuItem>>();
        rez.put(c, men);
        return rez;

    }


     */

    /**
     * Metoda care vizualizeaza toate produsele comandate de o anume comada
     * @param p
     * @return
     */
    public ArrayList<MenuItem> viewMenuItemforOrder(Comanda p) {
        return restaurantData.get(p);
    }
    public String toString(){
       String rez ="MENIUL RESTAURANTULUI ESTE: " + menuOficial+ "\n";
        Set<Comanda> comenzi = restaurantData.keySet();
        for(Comanda p : comenzi) {
            rez= rez + "La comanda: "+p.toString() + " Avem comandate urmatoarele produse: ";
            ArrayList<MenuItem> menus = restaurantData.get(p);
            for(MenuItem m: menus){
                rez=rez+m.toString();
            }
            rez=rez+"\n";
        }
       return rez;
    }

    /**
     * Metoda care ajuta la crearea Observer Design Patter
     * Metoda suprascrisa (clasa abstracta ObservableComposite)
     * @return toate produsele compuse comandate la un moment dat in restaurant, adica toate produsele care necesita activitatea chefului
     */
    public ArrayList<MenuItem> notifyComposite() {
        ArrayList<MenuItem> s = new ArrayList<MenuItem>();
        for(Comanda c: this.viewOrders()){
            for(MenuItem m : this.viewMenuItemforOrder(c)){
                if(m instanceof CompositeProduct)
                    s.add(m);
            }
        }
        return s;
    }

    /**
     * Metoda care listeaza toate produsele comandate de la inceput pana la un moment dat in restaurantul respectiv
     * @return
     */
    public ArrayList<MenuItem> allProductsOrdered() {
        ArrayList<MenuItem> s = new ArrayList<MenuItem>();
        for(Comanda c: this.viewOrders()){
            for(MenuItem m : this.viewMenuItemforOrder(c)){
                    s.add(m);
            }
        }
        return s;
    }
}
