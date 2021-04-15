public class BaseProduct extends MenuItem {

    public BaseProduct(String nume, int cantitate, int durata, float pret){
        super(nume,cantitate,durata,pret);
    }
    public float computePrice(){
        return this.getPret();
    }
}
