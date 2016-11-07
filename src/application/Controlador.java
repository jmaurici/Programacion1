package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controlador {
	@FXML 
	TextField minimo;
	public void manejaBoton(ActionEvent evt){
		System.out.println(minimo.getText());
	}

}
