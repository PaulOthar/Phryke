package recursosLogicosJFX;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class AuxiliarDeFXML {
	public AuxiliarDeFXML(){
		
	}
	
	public AnchorPane PegarFXMLPorNome(String nome){
		try {
			return FXMLLoader.load(getClass().getResource("/recursosGraficosJFX/"+nome+".fxml"));
		}
		catch(Exception e) {
			e.printStackTrace();
			return new AnchorPane();
		}
	}
}
