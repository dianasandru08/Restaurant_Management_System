import java.io.Serializable;
import java.util.Objects;

public abstract class MenuItem implements Serializable {
    private String nume;
    private int cantitate;
    private int durata;
    private float pret;

    public MenuItem(String nume, int cantitate, int durata, float pret) {
        this.nume = nume;
        this.cantitate = cantitate;
        this.durata = durata;
        this.pret=pret;
    }
    public boolean isWellFormed() {
        if(this.cantitate<0) {
            return false;
        }
        if(this.pret<0) {
            return false;
        }
        if(this.durata<24){
            return false;
        }
        return true;
    }

    public String getNume() {
        return nume;
    }

    public int getCantitate() {
        return cantitate;
    }

    public int getDurata() {
        return durata;
    }
    public float getPret() {
        return pret;
    }
    public void setPret(float nou){
        pret = nou;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }
    public abstract float computePrice();

    @Override
    public String toString() {
        return "(" +
                "nume= " + nume +
                ", cantitate=" + cantitate +
                ", durata=" + durata +
                ", pret=" + pret + ")" ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return cantitate == menuItem.cantitate &&
                durata == menuItem.durata &&
                Float.compare(menuItem.pret, pret) == 0 &&
                Objects.equals(nume, menuItem.nume);
    }


}
