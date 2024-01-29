package it.edu.iisgubbio.vettore;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class crescenteVettori extends Application {
	
	TextField tNum = new TextField();
	Button pVerifica = new Button("Verifica");
	Label eRis = new Label("Risultato");
	int vettore[];
	
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia, 370, 150);
		finestra.setScene(scena);
		finestra.setTitle("Verifica se sono crescenti");
		finestra.show();
		
		Label eNum = new Label("Vettore (mumeri separati da ' ')");
		
		griglia.add(tNum, 0, 0);
		griglia.add(eNum, 1, 0);
		griglia.add(pVerifica, 0, 1);
		griglia.add(eRis, 0, 2, 2, 1);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setVgap(10);
		griglia.setHgap(10);
		
		pVerifica.setOnAction(e->Verifica());
	}
	
	public void Verifica() {
		String s[];
		String testo;
		testo = tNum.getText();
		s = testo.split(" ");
		vettore = new int[s.length];
		
		Boolean cresce = true;
		
		for(int i = 0; i < s.length; i ++) {
			vettore[i] = Integer.parseInt(s[i]);
		}
		
		for(int i = 1; i < vettore.length-1 && cresce; i ++) {
			if(vettore[i] >= vettore[i+1]) {
				cresce = false;
			}
		}
		if(cresce == true) {
			eRis.setText("I valori SONO crescenti");
		} else {
			eRis.setText("I valori NON SONO crescenti");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
