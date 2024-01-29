package it.edu.iisgubbio.vettore;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class contaKVettori extends Application {
	
	TextField tMax = new TextField();
	TextField tN = new TextField();
	TextField tK = new TextField();
	Button pStampa = new Button("Stampa");
	Label eContaK = new Label("Conta quante volte compare K");
	Label eElenco = new Label("Elenco");
	Label eN = new Label("N");
	Label eMax = new Label("Max");
	Label eK = new Label("k");
	
	int k;
	int vettore[];
	
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia, 300, 170);
		finestra.setScene(scena);
		finestra.setTitle("Esercizio N.8");
		finestra.show();
		
		griglia.add(tMax, 0, 1);
		griglia.add(tN, 0, 0);
		griglia.add(tK, 2, 0);
		griglia.add(pStampa, 0, 2);
		griglia.add(eN, 1, 0);
		griglia.add(eMax, 1, 1);
		griglia.add(eK, 3, 0);
		griglia.add(eElenco, 0, 3, 3, 1);
		griglia.add(eContaK, 0, 4, 3, 1);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		tMax.setPrefWidth(90);
		tN.setPrefWidth(90);
		tK.setPrefWidth(90);
		pStampa.setPrefWidth(63);
		pStampa.setOnAction(e->Stampa());
	}
	
	public void Stampa() {
		String elenco = "";
		int i;
		int dimensione;
		int max;
		int contaK = 0;
		dimensione = Integer.parseInt(tN.getText());
		max = Integer.parseInt(tMax.getText());
		k = Integer.parseInt(tK.getText());
		
		vettore = new int [dimensione];
		for( i = 0; i < vettore.length; i ++) {
			vettore[i] = (int)(Math.random()*max);
		}
		
		for( i = 0; i < vettore.length; i ++) {
			if(vettore[i] == k) {
				contaK = contaK + 1;
			}
			elenco = elenco + vettore[i] + " - ";
		}
		eContaK.setText("il valore k appare "+contaK + " volte");
		eElenco.setText(elenco);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}