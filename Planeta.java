public class Planeta extends CuerpoCeleste{
    public Planeta(String nombre, double periodoOrbital) {
        super(nombre, periodoOrbital, TipoCuerpoCeleste.PLANETA);
    }

    @Override
    public boolean addSatelite(CuerpoCeleste satelite) {
        if (satelite.getTipoCuerpo()==TipoCuerpoCeleste.LUNA){ //si el cuerpo celeste es de tipo LUNA se añadirá el satelite
            return super.addSatelite(satelite);
        }else {
            System.out.println("El cuerpo del satélite que se quiere agregar no es de tipo LUNA.");
            return false;
        }
    }
}
