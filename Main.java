import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, CuerpoCeleste> sistemaSolar=new HashMap<>();
    private static Set<CuerpoCeleste> planetas= new HashSet<>();

    public static void main(String[] args) {
        //crear planeta
        CuerpoCeleste mercurio=new CuerpoCeleste("Mercurio", 88, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste venus=new CuerpoCeleste("Venus", 225, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste laTierra=new CuerpoCeleste("La Tierra", 365, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste marte=new CuerpoCeleste("Marte",687, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste jupiter=new CuerpoCeleste("Jupiter", 4332, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste saturno=new CuerpoCeleste("Saturno", 10759, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste urano=new CuerpoCeleste("Urano", 30660, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste neptuno=new CuerpoCeleste("Neptuno", 165, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        CuerpoCeleste pluton=new CuerpoCeleste("Pluton", 248, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);

        //agregar cada planeta a la lista planetas
        planetas.add(mercurio);
        planetas.add(venus);
        planetas.add(laTierra);
        planetas.add(marte);
        planetas.add(jupiter);
        planetas.add(saturno);
        planetas.add(urano);
        planetas.add(neptuno);
        planetas.add(pluton);

        //agergar cada planeta a la lista sistemaSolar
        sistemaSolar.put(mercurio.getNombre(), mercurio);
        sistemaSolar.put(venus.getNombre(), venus);
        sistemaSolar.put(laTierra.getNombre(), laTierra);
        sistemaSolar.put(marte.getNombre(), marte);
        sistemaSolar.put(jupiter.getNombre(), jupiter);
        sistemaSolar.put(saturno.getNombre(), saturno);
        sistemaSolar.put(urano.getNombre(), urano);
        sistemaSolar.put(neptuno.getNombre(), neptuno);
        sistemaSolar.put(pluton.getNombre(), pluton);

        //crear lunas
        CuerpoCeleste luna=new CuerpoCeleste("Luna", 27, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste deimos=new CuerpoCeleste("Deimos", 1.3, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste phobos=new CuerpoCeleste("Phobos", 0.3, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste io=new CuerpoCeleste("Io",1.8, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste europa=new CuerpoCeleste("Europa",3.5, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste ganymede=new CuerpoCeleste("Ganymede",16.7, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        CuerpoCeleste callisto=new CuerpoCeleste("Callisto", 16.7, CuerpoCeleste.TipoCuerpoCeleste.LUNA);

        //agregar las lunas a sistemaSolar
        sistemaSolar.put(luna.getNombre(), luna);
        sistemaSolar.put(deimos.getNombre(), deimos);
        sistemaSolar.put(phobos.getNombre(), phobos);
        sistemaSolar.put(io.getNombre(), io);
        sistemaSolar.put(ganymede.getNombre(), ganymede);
        sistemaSolar.put(europa.getNombre(), europa);
        sistemaSolar.put(callisto.getNombre(), callisto);

        //agregar lunas a LaTierra
        laTierra.addSatelite(luna);

        //agregar lunas a Marte
        marte.addSatelite(phobos);
        marte.addSatelite(deimos);

        //agregar lunas a Jupiter
        jupiter.addSatelite(io);
        jupiter.addSatelite(europa);
        jupiter.addSatelite(ganymede);
        jupiter.addSatelite(callisto);

        // Imprimir nombres de los planetas almacenados en el conjunto
        System.out.println("-Planetas en el sistema solar:");
        for (CuerpoCeleste planeta : planetas) {
            System.out.println(planeta.getNombre());
        }
        System.out.println();

        // Imprimir las lunas de Marte
        System.out.println("-Lunas de Marte:");
        for (CuerpoCeleste l : marte.getSatelites()) {
            System.out.println(l.getNombre());
        }
        System.out.println();

        // Obtener la unión de todas las lunas
        Set<CuerpoCeleste> lunas = new HashSet<>();
        for (CuerpoCeleste cuerpo : sistemaSolar.values()) {
            lunas.addAll(cuerpo.getSatelites());
        }
        System.out.println("-Unión de todas las lunas:");
        for (CuerpoCeleste lu : lunas) {
            System.out.println(lu.getNombre());
        }
        System.out.println();

        //Imprimir planetas nuevamente
        //Pluton no se podría agregar porque ya hay un planeta con ese nombre
        System.out.println("-Planetas en el sistema solar después de agregar Plutón:");
        for (CuerpoCeleste planeta : planetas) {
            System.out.println(planeta);
        }
        System.out.println();

        //Crear Plutón como un planeta enano en vez de un planeta
        CuerpoCeleste plutonEnano = new CuerpoCeleste("Plutón", 884, CuerpoCeleste.TipoCuerpoCeleste.PLANETA_ENANO);
        planetas.add(plutonEnano);
        sistemaSolar.put(plutonEnano.getNombre(), plutonEnano);

        //Tenemos el conjunto planetas ya creado y creamos el conjunto planetasEnanos
        Set<CuerpoCeleste> planetasEnanos = new HashSet<>();

        //Añadimos algunos cuerpos celestes a planetasEnanos
       planetasEnanos.add(plutonEnano);

        //Diferencia: elementos en planetas pero no en planetasEnanos
        Set<CuerpoCeleste> diferencia = new HashSet<>(planetas);
        diferencia.removeAll(planetasEnanos);

        //Intersección: elementos comunes en planetas y planetasEnanos
        Set<CuerpoCeleste> interseccion = new HashSet<>(planetas);
        interseccion.retainAll(planetasEnanos);

        //Imprimir los resultados
        System.out.println("-Elementos en planetas pero no en planetasEnanos:");
        for (CuerpoCeleste cuerpo : diferencia) {
            System.out.println(cuerpo.getNombre());
        }
        System.out.println();

        System.out.println("-Elementos en planetas y en planetasEnanos:\n");
        for (CuerpoCeleste cuerpo : interseccion) {
            System.out.println(cuerpo.getNombre());
        }
    }
}
