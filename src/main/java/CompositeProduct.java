

import java.util.ArrayList;

public class CompositeProduct extends MenuItem  {

    private ArrayList<MenuItem> list;

    public CompositeProduct(String nume, int cantitate, int durata, ArrayList<MenuItem> lista){
        super(nume,cantitate,durata, 0);
        this.list = lista;  //new ArrayList<BaseProduct>();
    }

    public ArrayList<MenuItem> getList() {
        return list;
    }

    public float computePrice(){
        float price=0;
        for(MenuItem p: list ){
            price = price + p.computePrice();
        }
        return price;
    }
    public void addBase(BaseProduct p){
        list.add(p);
    }

    public void deleteBae(BaseProduct p){
        list.remove(p);
    }
    public void deleteAll(){
        list.clear();
    }
    public String toString(){
      String rez = "";
      rez = "(NUME: " + getNume() + ", CANTITATE: " + getCantitate() + ", DURATA: " + getDurata() + ", PRET: " + computePrice() + ")";
      return rez;
    }
}
