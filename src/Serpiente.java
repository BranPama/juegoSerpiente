import java.util.ArrayList;
import java.util.Arrays;

public class Serpiente {
    private ArrayList <int[]> cuerpo = new ArrayList();
    private String direccion;
    private final int ANCHO_TABLERO;
    private final int ALTO_TABLERO;

    //metodo constructor 
    public Serpiente(int ancho, int alto){
        this.ANCHO_TABLERO = ancho;
        this.ALTO_TABLERO = alto;
        this.direccion = "derecha";

    }
    public void generarNuevaSerpiente(){
        int[] cabeza = {100,100};
        cuerpo.add(cabeza);
    }
    public ArrayList <int[]> getCuerpo(){
        return new ArrayList<>(cuerpo);

    }
    public void mover(boolean crece){
        moverCabeza();
        
        if (!crece && cuerpo.size() > 1) {
            cuerpo.remove(cuerpo.size()-1);
        }else if(crece){
            crecer();
        }
    }
    private void moverCabeza(){
        int[] cabeza = Arrays.copyOf(cuerpo.get(0),2 );
        switch (direccion) {
            case "izquierda":
                cabeza[0]-= 20;
                break;
            case "derecha":
                cabeza[0]+= 20;
                break;
            case "arriba":
                cabeza[1]-= 20;
                break;
            case "abajo":
                cabeza[1]+= 20;
                break;
        }
        cuerpo.add(0,cabeza);
    }
    public void actualizarDirecion(String nuevaDireccion){
        if ((direccion.equals("izquierda") && !nuevaDireccion.equals("derecha")) ||
        (direccion.equals("derecha") && !nuevaDireccion.equals("izquierda")) ||
        (direccion.equals("arriba") && !nuevaDireccion.equals("abajo")) ||
        (direccion.equals("abajo") && !nuevaDireccion.equals("arriba"))) {
        direccion = nuevaDireccion;
    }
    }

    public boolean estaViva(){
        if (colisionTablero()||colisionSerpiente()){
            return false;
        }
        return true;
    }

    private boolean colisionTablero(){
        int[] cabeza=cuerpo.get(0); 
        if(cabeza[0]<0||cabeza[0]>=ANCHO_TABLERO||cabeza[1]<0||cabeza[1]>=ALTO_TABLERO){
            return true;
        }
        return false;
    }

    private boolean colisionSerpiente(){
        int[] cabeza=cuerpo.get(0); 
        for(int i=1;i<cuerpo.size();i++){
            if (Arrays.equals(cabeza, cuerpo.get(i))) {
                return true;
        }
     }
      return false;

    }
    public void crecer() {
        int[] ultimaPosicion = cuerpo.get(cuerpo.size() - 1);
    
        // Agrega un nuevo bloque en la misma posición (esto genera el "crecimiento")
        cuerpo.add(ultimaPosicion);
    }

    
}
