
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class MinhaThreadPerfeitos implements Runnable {

    private final int limitePerfeitos;
    private final TextArea textAreaPerfeitos;
    private int i;

    public MinhaThreadPerfeitos(int limitePerfeitos, TextArea textArea) {
        textAreaPerfeitos = textArea;
        this.limitePerfeitos = limitePerfeitos;
    }

    @Override
    public void run() {
        //Calculando os números primos
        int somaDivisores;
        for (i = 1; i <= this.limitePerfeitos; i++) {
            somaDivisores = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    somaDivisores = somaDivisores + j;
                }
            }
            if (somaDivisores == i) {
                //this.textAreaPerfeitos.appendText("\n" + i);
                Platform.runLater(() -> textAreaPerfeitos.appendText("\n" + i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MinhaThreadPerfeitos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
