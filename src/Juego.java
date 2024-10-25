import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Juego implements ActionListener{
    private Timer temporizador;
    private  Serpiente serpiente;
    private  Fruta fruta;
    private  Tablero tablero;
    private  Controles controles;
    private int puntuacion = 0;

    //metodo contructor
    public Juego(){
      fruta= new Fruta(600,600);
      serpiente= new Serpiente(600,600);
      controles= new Controles();
      serpiente.generarNuevaSerpiente();
      fruta.generarNuevaPosicion();
      tablero = new Tablero(600,600,fruta,serpiente); 
      configurarVentana(tablero);
      temporizador = new Timer(130, this);
      temporizador.start(); 

    }
    public static void main(String[] args) {
      new Juego();
    }
    private void configurarVentana(Tablero tablero){
      JFrame ventana=new JFrame();
       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ventana.add(tablero);
       ventana.addKeyListener(controles); // Agregar el KeyListene// Agregar el KeyListene
       //ajuata la ventana al ancho del tablero
       ventana.pack();
       //no se redimenciona
       ventana.setResizable(false);
       //ubica la vnetana en el centro
       ventana.setLocationRelativeTo(null);
       ventana.setVisible(true);
    }

    //ejecuta este metado cada que pasa el retardo
    @Override
    public void actionPerformed(ActionEvent e) {
      
       if(serpiente.estaViva()){
        System.out.println("Esta viva la serpiente");
        serpiente.actualizarDirecion(controles.getDireccion());

        
         if(colisionFruta()){
            serpiente.mover(true);
            fruta.generarNuevaPosicion();
            puntuacion++;
         }else{
            serpiente.mover(false);

         }

         tablero.repaint();

       }else{
        temporizador.stop();
        puntuacion = 0;

            JOptionPane.showMessageDialog(null, "Game Over!");
            puntuacion=0;
       }
    }
    private boolean colisionFruta(){
        int[] cabeza=serpiente.getCuerpo().get(0); 
        int[] posicionfruta={fruta.getPosicionX(),fruta.getPosicionY()};
        System.out.println("cabeza"+Arrays.toString(cabeza));

            if (Arrays.equals(cabeza, posicionfruta)) {

                return true;
           }else{
            return false;
           }

    }
}