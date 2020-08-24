package recursosLogicosJFX;

import java.net.URL;
import java.util.ResourceBundle;

import formatos.Caracteristica;
import formatos.Regra;
import formatos.Segmento;
import formatos.Sistema;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.HTMLEditor;
import recursosLogicos.DadosDeBanco;

public class CriarSistemaController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
    private TextField CriSiNomeSistema;

    @FXML
    private TextField CriSiVersaoSistema;

    @FXML
    private HTMLEditor CriSiDescricaoSistema;

    @FXML
    private TableView<?> CriSiTabelaSegmento;

    @FXML
    private TableColumn<?, ?> CriSiSegmento;

    @FXML
    private TableColumn<?, ?> CriSiValorAssociadoTabela;

    @FXML
    private TextField CriSiNomeSegmento;

    @FXML
    private TextField CriSiValorAssociado;

    @FXML
    private TextField CriSiNomeRegra;

    @FXML
    private HTMLEditor CriSiDescricaoRegra;

    @FXML
    private ComboBox<?> CriSiRegrasCriadas;

    @FXML
    private TableView<?> CriSiTabelaCaracteristicas;

    @FXML
    private TableColumn<?, ?> CriSiNomeCaracteristicaTabela;

    @FXML
    private TableColumn<?, ?> CriSiValorBaseTabela;

    @FXML
    private TableColumn<?, ?> CriSiValorMinimoTabela;

    @FXML
    private TableColumn<?, ?> CriSiValorMaximoTabela;

    @FXML
    private TextField CriSiNomeCaracteristica;

    @FXML
    private ComboBox<?> CriSiParametro;

    @FXML
    private ChoiceBox<?> CriSiReferencia;

    @FXML
    private ChoiceBox<?> CriSiOperador;

    @FXML
    private TextField CriSiModificador;

    @FXML
    private TextField CriSiValorBase;

    @FXML
    private TextField CriSiValorMinimo;

    @FXML
    private TextField CriSiValorMaximo;

    @FXML
    private ComboBox<?> CriSiTipoModificador;

    @FXML
    private ChoiceBox<?> CriSiCaracteristicaModificadora;

    @FXML
    private TableView<?> CriSiTabelaCaracteristicasVerificado;

    @FXML
    private TableColumn<?, ?> CriSiNomeCaracteristicaVerificado;

    @FXML
    private TableColumn<?, ?> CriSiValorBaseVerificado;

    @FXML
    private TableColumn<?, ?> CriSiValorMinimoVerificado;

    @FXML
    private TableColumn<?, ?> CriSiValorMaximoVerificado;

    @FXML
    private Label CriSiNomeSistemaVerificado;

    @FXML
    private Label CriSiVersaoSistemaVerificado;

    @FXML
    private TableView<?> CriSiTabelaSegmentoVerificado;

    @FXML
    private TableColumn<?, ?> CriSiSegmentosVerificado;

    @FXML
    private TableView<?> CriSiTabelaRegrasVerificado;

    @FXML
    private TableColumn<?, ?> CriSiRegrasVerificado;

    @FXML
    void CriSiCriarCaracteristica(ActionEvent event) {

    }

    @FXML
    void CriSiCriarRegra(ActionEvent event) {

    }

    @FXML
    void CriSiCriarSegmento(ActionEvent event) {

    }

    @FXML
    void CriSiCriarSistema(ActionEvent event) {

    }

    @FXML
    void CriSiEditarCaracteristica(ActionEvent event) {

    }

    @FXML
    void CriSiEditarRegra(ActionEvent event) {

    }

    @FXML
    void CriSiEditarSegmento(ActionEvent event) {

    }

    @FXML
    void CriSiInserirNomeSistema(ActionEvent event) {

    }

    @FXML
    void CriSiInserirVersaoSistema(ActionEvent event) {

    }

    @FXML
    void CriSiRemoverCaracteristica(ActionEvent event) {

    }

    @FXML
    void CriSiRemoverRegra(ActionEvent event) {

    }

    @FXML
    void CriSiRemoverSegmento(ActionEvent event) {

    }

    @FXML
    void CriSiSelecionarRegra(ActionEvent event) {

    }

}
