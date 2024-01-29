package it.edu.iisgubbio.vettore;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class sommaSottrazioneMoltiplicazioneVettori extends Application {
	
	TextField tMax = new TextField();
	TextField tN = new TextField();
	Button pStampa = new Button("Stampa");
	Label eSomma = new Label("Somma");
	Label eElenco = new Label("Elenco");
	Label eN = new Label("N");
	Label eMax = new Label("Max");
	ComboBox<String> segno = new ComboBox<>();
	
	int vettore[];
	
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia, 300, 170);
		finestra.setScene(scena);
		finestra.setTitle("Esercizio N.Giamma");
		finestra.show();
		
		segno.getItems().add("+");
		segno.getItems().add("-");
		segno.getItems().add("*");
		
		griglia.add(tMax, 0, 1);
		griglia.add(tN, 0, 0);
		griglia.add(segno, 2, 0);
		griglia.add(pStampa, 0, 2);
		griglia.add(eN, 1, 0);
		griglia.add(eMax, 1, 1);
		griglia.add(eElenco, 0, 3, 2, 1);
		griglia.add(eSomma, 0, 4, 2, 1);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		tMax.setPrefWidth(90);
		tN.setPrefWidth(90);
		pStampa.setPrefWidth(63);
		pStampa.setOnAction(e->Stampa());
	}
	
	public void Stampa() {
		String elenco = "";
		int i;
		int dimensione;
		int max;
		int somma = 0;
		int sottrazione = 0;
		int moltiplicazione = 1;
		dimensione = Integer.parseInt(tN.getText());
		max = Integer.parseInt(tMax.getText());
		
		vettore = new int [dimensione];
		for( i = 0; i < vettore.length; i ++) {
			vettore[i] = (int)(Math.random()*max);
		}
		
		String x = "";
		String selez1 = segno.getValue();
		segno.getSelectionModel().select(selez1);
		x = selez1;
		
		switch (x) {
		case "+":
			for( i = 0; i < vettore.length; i ++) {
				somma = somma + vettore[i];
				elenco = elenco + vettore[i] + " - ";
			}
			eSomma.setText("Somma: "+somma);
			eElenco.setText(elenco);
			break;
		case "-":
			for( i = 0; i < vettore.length; i ++) {
				sottrazione = sottrazione - vettore[i];
				elenco = elenco + vettore[i] + " - ";
			}
			eSomma.setText("Sottrazione: "+sottrazione);
			eElenco.setText(elenco);
			break;
		case "*":
			for( i = 0; i < vettore.length; i ++) {
				moltiplicazione = moltiplicazione * vettore[i];
				elenco = elenco + vettore[i] + " - " ;
			} 
	 		eSomma.setText("Moltiplicazione: "+moltiplicazione);
			eElenco.setText(elenco);
			break;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}