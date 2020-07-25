/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author java
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button buttonPrimos;
    @FXML
    private Button buttonPerfeitos;
    @FXML
    private TextArea textAreaPrimos;
    @FXML
    private TextArea textAreaPerfeitos;
    @FXML
    private TextField textFieldPrimos;
    @FXML
    private TextField textFieldPerfeitos;
    
    MinhaThreadPrimos minhaThreadPrimos;
    MinhaThreadPerfeitos minhaThreadPerfeitos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    public void handleButtonPrimos() {
        int limitePrimos = Integer.parseInt(textFieldPrimos.getText());
        minhaThreadPrimos = new MinhaThreadPrimos(limitePrimos, textAreaPrimos);
        Thread t1 = new Thread(minhaThreadPrimos);
        t1.start();
    }

    @FXML
    public void handleButtonPerfeitos() {
        int limitePerfeitos = Integer.parseInt(textFieldPerfeitos.getText());
        minhaThreadPerfeitos = new MinhaThreadPerfeitos(limitePerfeitos, textAreaPerfeitos);
        Thread t2 = new Thread(minhaThreadPerfeitos);
        t2.start();
    }

}
