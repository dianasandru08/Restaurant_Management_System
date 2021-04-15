import java.util.Objects;

public class Comanda {
    private int id;
    private String data;
    private int ora;
    private int masa;

    public Comanda(int id, String data, int ora, int masa) {
        this.id = id;
        this.data = data;
        this.ora = ora;
        this.masa = masa;
    }
    public boolean isWellFormed() {
        //System.out.println(data);
        String[] parts = data.split("-");
        //System.out.println(parts[0]);
        int ziua= Integer.parseInt(parts[0]);
        int luna= Integer.parseInt(parts[1]);
        int anul= Integer.parseInt(parts[2]);
        if(ziua < 1 || ziua > 31){
            System.out.println(ziua);
            return false;
        }
        if(luna < 1 || luna > 12){
            return false;
        }
        if(anul< 1800 && anul > 2020){ //presupunem ca acest restaurant a fost infiintat in 1800, deci anul cand se poate lua o camanda nu poate fi mai mic de 1800;

            return false;
        }
        if(this.id < 0) {
            return false;
        }
        if(ora < 8 || ora > 22) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public int getOra() {
        return ora;
    }

    public int getMasa() {
        return masa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public void setMasa(int masa) {
        this.masa = masa;
    }

    @Override
    public String toString() {
        return
                "(id=" + id +
                ", data=" + data +
                ", ora=" + ora +
                ", masa=" + masa +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        /*
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comanda comanda = (Comanda) o;
        return id == comanda.id &&
                data == comanda.data &&
                ora == comanda.ora &&
                masa == comanda.masa;

         */
        Comanda com = (Comanda ) o;
        return this.id == com.id;
    }

    @Override
    public int hashCode() {
        Integer ObjID = id;
         return ObjID.hashCode();
    }
}
