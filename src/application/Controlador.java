package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

import control.Ejercicios2;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modelo.Intento;
import modelo.Persona;

public class Controlador implements Initializable {
	@FXML
	TextField fxml_minimo;
	@FXML
	TextField fxml_maximo;
	@FXML
	TextField fxml_numeroJugar;
	@FXML
	TextArea fxml_intentos;
	@FXML
	Label fxml_mensajes;
	@FXML
	Button fxml_btGenerar;
	@FXML
	Button fxml_btJugar;
	@FXML
	ListView<Persona> fxml_lista;
	int numeroAdivinar;

	public void jugar() {
		fxml_btGenerar.setDisable(true);
	}

	public void manejaBoton(ActionEvent evt) {
		// System.out.println(minimo.getText());
		// recoger minimo y maximo
		// VALIDAR minimo y maximo (numeros enteros y minimo<maximo)
		// si validación OK -> generar número entre minimo y maximo

		try {
			int minimo = Integer.parseInt(fxml_minimo.getText());
			int maximo = Integer.parseInt(fxml_maximo.getText());
			if (minimo >= maximo)
				fxml_mensajes.setText("min < max  !!");
			else{
				numeroAdivinar = minimo + new Random().nextInt(maximo - minimo);
				fxml_mensajes.setText("Numero generado");
				fxml_btGenerar.setDisable(true);
			}
		} catch (NumberFormatException excepcion) {

			fxml_mensajes.setText("Intervalo incorrecto");
		}

	}

	public void manejaBotonJugar(ActionEvent evt) {
		try {
			int numeroJugado = Integer.parseInt(fxml_numeroJugar.getText());
			Intento intento = new Intento(numeroJugado, new Date());
			if (numeroJugado > numeroAdivinar)
				intento.setRespuesta("Pruebe menor");
			else if (numeroJugado < numeroAdivinar)
				intento.setRespuesta("Pruebe mayor");
			else{
				intento.setRespuesta("¡HAS ACERTADO!");
				fxml_btGenerar.setDisable(false);
				fxml_btJugar.setDisable(true);
			}
			fxml_intentos.appendText(intento.toString());
			
		} catch (NumberFormatException excepcion) {
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Ejercicios2 ej2 = new Ejercicios2();
		ej2.insertarEnPersonas();
		fxml_lista.setItems(FXCollections.observableArrayList(ej2.getPersonas()));
	}

}
