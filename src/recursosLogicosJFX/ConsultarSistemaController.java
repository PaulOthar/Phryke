package recursosLogicosJFX;

import java.net.URL;
import java.util.ResourceBundle;

import formatos.Caracteristica;
import formatos.Formato;
import formatos.Regra;
import formatos.Segmento;
import formatos.Sistema;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import recursosLogicos.DadosDeBanco;

public class ConsultarSistemaController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
    private TableView<?> ConSiSistemasTabela;

    @FXML
    private TableColumn<?, ?> ConSiNomeSistemaTabela;

    @FXML
    private TableColumn<?, ?> ConSiVersaoSistemaTabela;

    @FXML
    private WebView ConSiDescricaoSistema;

    @FXML
    private Label ConSiNomeSistema;

    @FXML
    private Label ConSiVersaoSistema;

    @FXML
    private TableView<?> ConSiCaracteristicasTabela;

    @FXML
    private TableColumn<?, ?> ConSiNomeCaracteristicaTabela;

    @FXML
    private TableColumn<?, ?> ConSiValorBaseCaracteristicaTabela;

    @FXML
    private TableColumn<?, ?> ConSiValorMinimoCaracteristicaTabela;

    @FXML
    private TableColumn<?, ?> ConSiValorMaximoCaracteristicaTabela;

    @FXML
    private TableView<?> ConSiCaracteristicasReferenciaTabela;

    @FXML
    private TableColumn<?, ?> ConSiNomeCaracteristicaReferenciaTabela;

    @FXML
    private TableColumn<?, ?> ConSiNomeReferenciaReferenciaTabela;

    @FXML
    private TableColumn<?, ?> ConSiModificadorReferenciaTabela;

    @FXML
    private TableView<?> ConSiSegmentoTabela;

    @FXML
    private TableColumn<?, ?> ConSiNomeSegmentoTabela;

    @FXML
    private TableColumn<?, ?> ConSiValorAssociadoSegmentoTabela;

    @FXML
    private ComboBox<?> ConSiRegrasSistema;

    @FXML
    private WebView ConSiTextoRegrasSistema;

    @FXML
    void ConSiEditarSistema(ActionEvent event) {

    }

    @FXML
    void ConSiRemoverSistema(ActionEvent event) {

    }

    @FXML
    void ConSiSelecionarRegra(ActionEvent event) {

    }

    @FXML
    void ConSiSelecionarSistema(MouseEvent event) {

    }
	
}
