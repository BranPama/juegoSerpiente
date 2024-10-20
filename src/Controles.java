import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controles extends KeyAdapter{
    private String direccion = "derecha";

    public Controles() {
        this.direccion = "derecha";
    }

    public  String getDireccion(){
     return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();

        switch (tecla) {
            case KeyEvent.VK_LEFT:
                direccion= "izquierda";
                break;
            case KeyEvent.VK_RIGHT:
                direccion= "derecha";
                break;
            case KeyEvent.VK_UP:
                direccion= "arriba";
                break;
            case KeyEvent.VK_DOWN:
                direccion= "abajo";
                break;
        }
    }
}
