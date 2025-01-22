import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Juego implements ActionListener {
   private Timer temporizador;
   private Serpiente serpiente;
   private Fruta fruta;
   private Tablero tablero;
   private Controles controles;
   int puntuacion = 0;

   // metodo contructor
   public Juego() {
      //instancias de las clases
      fruta = new Fruta(600, 600);
      serpiente = new Serpiente(600, 600);
      controles = new Controles();
      serpiente.generarNuevaSerpiente();
      tablero = new Tablero(600, 600, fruta, serpiente);
      temporizador = new Timer(130, this);
      temporizador.start();
      
      //instaincias de los metodos
      configurarVentana(tablero);
      fruta.generarNuevaPosicion();
      aumentarPuntuacion();
   }

   //Metodo Principal
   public static void main(String[] args) {
      new Juego();
   }

   private void configurarVentana(Tablero tablero) {
      JFrame ventana = new JFrame();
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.add(tablero);
      ventana.addKeyListener(controles); // Agregar el KeyListene// Agregar el KeyListene
      // ajuata la ventana al ancho del tablero
      ventana.pack();
      // no se redimenciona
      ventana.setResizable(false);
      // ubica la vnetana en el centro
      ventana.setLocationRelativeTo(null);
      ventana.setVisible(true);
   }

   // ejecuta este metado cada que pasa el retardo
   @Override
   public void actionPerformed(ActionEvent e) {

      if (serpiente.estaViva()) {
         System.out.println("Esta viva la serpiente");
         serpiente.actualizarDirecion(controles.getDireccion());

         if (colisionFruta()) {
            serpiente.mover(true);
            fruta.generarNuevaPosicion();
            puntuacion += 1;
            tablero.actualizarPuntuacion(puntuacion);
         } else {
            serpiente.mover(false);
         }

         tablero.repaint();

      } else {
         temporizador.stop();
         JOptionPane.showMessageDialog(null, "Game Over!" + " Puntaje " + puntuacion);
         puntuacion = 0;
         tablero.actualizarPuntuacion(puntuacion);
      }
   }

   public void aumentarPuntuacion() {
      tablero.actualizarPuntuacion(this.puntuacion); // Notificar a Tablero
   }

   private boolean colisionFruta() {
      int[] cabeza = serpiente.getCuerpo().get(0);
      int[] posicionfruta = { fruta.getPosicionX(), fruta.getPosicionY() };
      System.out.println("cabeza" + Arrays.toString(cabeza));

      if (Arrays.equals(cabeza, posicionfruta)) {

         return true;
      } else {
         return false;
      }
   }
}