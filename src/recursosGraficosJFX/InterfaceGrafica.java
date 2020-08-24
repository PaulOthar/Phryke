package recursosGraficosJFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InterfaceGrafica extends Application {
	public static void Rodar(String[] args) {
		launch(args);
	}

	
	@Override
	public void start(Stage palco) throws Exception {
		Parent raiz = FXMLLoader.load(getClass().getResource("GraficoFXML.fxml"));
		Scene cena = new Scene(raiz);
		palco.setTitle("Teste");
		palco.setScene(cena);
		palco.show();
	}
}
