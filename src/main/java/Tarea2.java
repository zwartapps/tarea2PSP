import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Tarea2 {

    public static void main(String[] args) {

        /*Creamos nuevo objeto Ventana y usamos las clases Runnable y Thread para la programacion
        concurrente*/
        Ventana v = new Ventana();
        v.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Runnable r = new Ventana();
        Thread t = new Thread(r);
        t.start();
    }

}

