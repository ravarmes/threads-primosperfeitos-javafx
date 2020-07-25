
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.TextArea;


public class MinhaThreadPrimos implements Runnable {

    private final int limitePrimos;
    private final TextArea textAreaPrimos;
    private int i;

    public MinhaThreadPrimos(int limitePrimos, TextArea textArea) {
        textAreaPrimos = textArea;
        this.limitePrimos = limitePrimos;
    }

    @Override
    public void run() {
        //Calculando os números primos
        int qtdDivisores;
        for (i = 1; i <= this.limitePrimos; i++) {
            qtdDivisores = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    qtdDivisores++;
                }
            }
            if (qtdDivisores == 2) {
                //this.textAreaPrimos.appendText("\n" + i);
                Platform.runLater(() -> textAreaPrimos.appendText("\n" + i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MinhaThreadPrimos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
