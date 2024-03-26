import java.util.HashSet;
import java.util.Set;

public class CuerpoCeleste {
    public enum TipoCuerpoCeleste{
        ESTRELLA, PLANETA, PLANETA_ENANO, LUNA, COMETA, ASTEROIDE;
    }
    private String nombre;
    private double periodoOrbital;
    private Set<CuerpoCeleste> satelites;
    private TipoCuerpoCeleste tipoCuerpo;

    public CuerpoCeleste(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        this.nombre = nombre;
        this.periodoOrbital = periodoOrbital;
        this.satelites = new HashSet<>();
        this.tipoCuerpo = tipoCuerpo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;
    }

    public TipoCuerpoCeleste getTipoCuerpo() {
        return tipoCuerpo;
    }

    public Set<CuerpoCeleste> getSatelites() {
        return new HashSet<>(satelites);
    }

    public boolean addSatelite(CuerpoCeleste satelite){
        return satelites.add(satelite);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CuerpoCeleste that = (CuerpoCeleste) o;

        if (Double.compare(that.periodoOrbital, periodoOrbital) != 0) return false;
        if (!nombre.equals(that.nombre)) return false;
        if (satelites != null ? !satelites.equals(that.satelites) : that.satelites != null) return false;
        return tipoCuerpo == that.tipoCuerpo;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = nombre.hashCode();
        temp = Double.doubleToLongBits(periodoOrbital);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (satelites != null ? satelites.hashCode() : 0);
        result = 31 * result + tipoCuerpo.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return nombre+": "+tipoCuerpo+", "+periodoOrbital;
    }
}
