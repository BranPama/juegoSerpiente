public class Fruta {    
    private final int ANCHO_TABLERO;
    private final int AlTO_TABLERO;
    private int posicionX,posicionY;
    
    //metodo construtor
    public Fruta(int anchoTablero,int altoTablero){
        this.ANCHO_TABLERO = anchoTablero;
        this.AlTO_TABLERO = altoTablero;
    }
    public void generarNuevaPosicion(){
        posicionX = aleatorio(ANCHO_TABLERO);
        posicionY = aleatorio(AlTO_TABLERO);
    }
    public int getPosicionX(){
        return posicionX;
    }
    public int getPosicionY(){
        return posicionY;
    }
    private int aleatorio(int max){
        int aleatorio;
        aleatorio = (int)(Math.random()*max/20)*20;
        return aleatorio;
    }
}
