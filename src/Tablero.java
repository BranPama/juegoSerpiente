import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Tablero extends JPanel{
    private final int ANCHO;
    private final int ALTO;
    private Fruta Fruta;
    private int puntuacion = 0;
    private Serpiente serpiente;
    private final Color VERDE_CLARO= Color.gray;
    private final Color VERDE_OSCURO= Color.WHITE;

    //metodo constructivo
    public Tablero(int ancho, int alto, Fruta fruta,Serpiente serpiente){
        this.ANCHO = ancho;
        this.ALTO = alto;
        this.Fruta = fruta;
        this.setPreferredSize(new Dimension(ANCHO,ALTO));
        this.setBackground(Color.BLACK);
        this.serpiente = serpiente;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        dibujarFruta(g);
        dibujarSerpiente(g,serpiente);
    }
    private void dibujarFruta(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(Fruta.getPosicionX(),Fruta.getPosicionY(),20,20);
    }
    private void dibujarSerpiente(Graphics g,Serpiente serpiente){

        for (int i = 0; i < serpiente.getCuerpo().size(); i++) {
            // Alternar colores
            if (i % 2 == 0) {
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.BLACK); 
            }
            g.fillRect(serpiente.getCuerpo().get(i)[0], serpiente.getCuerpo().get(i)[1], 20, 20); // Dibuja en las coordenadas (X, Y) de la parte
    
        }
    }
}
