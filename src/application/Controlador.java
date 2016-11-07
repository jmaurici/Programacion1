package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controlador {

	@FXML
	TextField min;
	@FXML
	TextField max;
	@FXML
	TextArea mensajes;
	
	public void manejaBoton (ActionEvent evt){
		
	mensajes.setText(min.getText() + "," + max.getText());;
		
	}
	
}
