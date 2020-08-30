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
		CriSiOperador.getItems().add(Caracteristica.soma);
		CriSiOperador.getItems().add(Caracteristica.subtracao);
		CriSiOperador.getItems().add(Caracteristica.divisao);
		CriSiOperador.getItems().add(Caracteristica.multiplicacao);
		CriSiTipoModificador.getItems().add("Por Valor");
		CriSiTipoModificador.getItems().add("Por Referencia");
		CriSiOperador.getSelectionModel().select(0);
		CriSiParametro.getItems().add("Por Valor");
		CriSiParametro.getItems().add("Por Referencia");
		CriSiParametro.getSelectionModel().select(0);
		CriSiSegmento.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		CriSiValorAssociadoTabela.setCellValueFactory(new PropertyValueFactory<>("ValorAssociado"));
		CriSiSegmentosVerificado.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		CriSiRegrasVerificado.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		CriSiNomeCaracteristicaTabela.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		CriSiValorBaseTabela.setCellValueFactory(new PropertyValueFactory<>("valor"));
		CriSiValorMinimoTabela.setCellValueFactory(new PropertyValueFactory<>("valorminimo"));
		CriSiValorMaximoTabela.setCellValueFactory(new PropertyValueFactory<>("valormaximo"));
		CriSiNomeCaracteristicaVerificado.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		CriSiValorBaseVerificado.setCellValueFactory(new PropertyValueFactory<>("valor"));
		CriSiValorMinimoVerificado.setCellValueFactory(new PropertyValueFactory<>("valorminimo"));
		CriSiValorMaximoVerificado.setCellValueFactory(new PropertyValueFactory<>("valormaximo"));
		
		STATICCriSiNomeSistema = CriSiNomeSistema;
		STATICCriSiVersaoSistema = CriSiVersaoSistema;
		STATICCriSiDescricaoSistema = CriSiDescricaoSistema;
		STATICCriSiTabelaSegmento = CriSiTabelaSegmento;
		STATICCriSiRegrasCriadas = CriSiRegrasCriadas;
		STATICCriSiTabelaCaracteristicas = CriSiTabelaCaracteristicas;
		STATICCriSiReferencia = CriSiReferencia;
		STATICCriSiCaracteristicaModificadora = CriSiCaracteristicaModificadora;
		STATICCriSiTabelaCaracteristicasVerificado = CriSiTabelaCaracteristicasVerificado;
		STATICCriSiNomeSistemaVerificado = CriSiNomeSistemaVerificado;
		STATICCriSiVersaoSistemaVerificado = CriSiVersaoSistemaVerificado;
		STATICCriSiTabelaSegmentoVerificado = CriSiTabelaSegmentoVerificado;
		STATICCriSiTabelaRegrasVerificado = CriSiTabelaRegrasVerificado;
	}
	
	public static void PreencherSistema(Sistema s) {
		STATICCriSiNomeSistemaVerificado.setText("Nome:"+s.getNome());
		STATICCriSiVersaoSistemaVerificado.setText("Versao:"+s.getVersao());
    	for(Caracteristica c : s.getCaracteristicas()) {
    		STATICCriSiTabelaCaracteristicasVerificado.getItems().add(c);
    		STATICCriSiTabelaCaracteristicas.getItems().add(c);
    		STATICCriSiReferencia.getItems().add(c);
    		STATICCriSiCaracteristicaModificadora.getItems().add(c);
    	}
    	for(Segmento seg : s.getSegmentos()) {
    		STATICCriSiTabelaSegmentoVerificado.getItems().add(seg);
    		STATICCriSiTabelaSegmento.getItems().add(seg);
    	}
    	for(Regra r : s.getRegras()) {
    		STATICCriSiTabelaRegrasVerificado.getItems().add(r);
    		STATICCriSiRegrasCriadas.getItems().add(r);
    	}
    	STATICCriSiNomeSistema.setText(s.getNome());
    	STATICCriSiVersaoSistema.setText(s.getVersao());
    	STATICCriSiDescricaoSistema.setHtmlText(s.getDescricao());
	}
	
	@FXML
    private static TextField STATICCriSiNomeSistema;

    @FXML
    private static TextField STATICCriSiVersaoSistema;

    @FXML
    private static HTMLEditor STATICCriSiDescricaoSistema;

    @FXML
    private static TableView<Segmento> STATICCriSiTabelaSegmento;
    
    @FXML
    private static ComboBox<Regra> STATICCriSiRegrasCriadas;

    @FXML
    private static TableView<Caracteristica> STATICCriSiTabelaCaracteristicas;
    
    @FXML
    private static ChoiceBox<Caracteristica> STATICCriSiReferencia;
    
    @FXML
    private static ChoiceBox<Caracteristica> STATICCriSiCaracteristicaModificadora;

    @FXML
    private static TableView<Caracteristica> STATICCriSiTabelaCaracteristicasVerificado;
    
    @FXML
    private static Label STATICCriSiNomeSistemaVerificado;

    @FXML
    private static Label STATICCriSiVersaoSistemaVerificado;

    @FXML
    private static TableView<Segmento> STATICCriSiTabelaSegmentoVerificado;
    
    @FXML
    private static TableView<Regra> STATICCriSiTabelaRegrasVerificado;
	
    //-----
	
    @FXML
    private TextField CriSiNomeSistema;

    @FXML
    private TextField CriSiVersaoSistema;

    @FXML
    private HTMLEditor CriSiDescricaoSistema;

    @FXML
    private TableView<Segmento> CriSiTabelaSegmento;

    @FXML
    private TableColumn<String,String> CriSiSegmento;

    @FXML
    private TableColumn<String,String> CriSiValorAssociadoTabela;

    @FXML
    private TextField CriSiNomeSegmento;

    @FXML
    private TextField CriSiValorAssociado;

    @FXML
    private TextField CriSiNomeRegra;

    @FXML
    private HTMLEditor CriSiDescricaoRegra;

    @FXML
    private ComboBox<Regra> CriSiRegrasCriadas;

    @FXML
    private TableView<Caracteristica> CriSiTabelaCaracteristicas;

    @FXML
    private TableColumn<String,String> CriSiNomeCaracteristicaTabela;

    @FXML
    private TableColumn<String,String> CriSiValorBaseTabela;

    @FXML
    private TableColumn<String,String> CriSiValorMinimoTabela;

    @FXML
    private TableColumn<String,String> CriSiValorMaximoTabela;

    @FXML
    private TextField CriSiNomeCaracteristica;

    @FXML
    private ComboBox<String> CriSiParametro;

    @FXML
    private ChoiceBox<Caracteristica> CriSiReferencia;

    @FXML
    private ChoiceBox<String> CriSiOperador;

    @FXML
    private TextField CriSiModificador;

    @FXML
    private TextField CriSiValorBase;

    @FXML
    private TextField CriSiValorMinimo;

    @FXML
    private TextField CriSiValorMaximo;

    @FXML
    private ComboBox<String> CriSiTipoModificador;

    @FXML
    private ChoiceBox<Caracteristica> CriSiCaracteristicaModificadora;

    @FXML
    private TableView<Caracteristica> CriSiTabelaCaracteristicasVerificado;

    @FXML
    private TableColumn<String,String> CriSiNomeCaracteristicaVerificado;

    @FXML
    private TableColumn<String,String> CriSiValorBaseVerificado;

    @FXML
    private TableColumn<String,String> CriSiValorMinimoVerificado;

    @FXML
    private TableColumn<String,String> CriSiValorMaximoVerificado;

    @FXML
    private Label CriSiNomeSistemaVerificado;

    @FXML
    private Label CriSiVersaoSistemaVerificado;

    @FXML
    private TableView<Segmento> CriSiTabelaSegmentoVerificado;

    @FXML
    private TableColumn<String,String> CriSiSegmentosVerificado;

    @FXML
    private TableView<Regra> CriSiTabelaRegrasVerificado;

    @FXML
    private TableColumn<String,String> CriSiRegrasVerificado;

    @FXML
    void CriSiCriarCaracteristica(ActionEvent event) {
    	try {
    		Caracteristica c;
    		if(CriSiParametro.getSelectionModel().getSelectedItem().contentEquals("Por Valor")) {
    			c = new Caracteristica(CriSiNomeCaracteristica.getText(),Double.parseDouble(CriSiValorBase.getText()),Double.parseDouble(CriSiValorMinimo.getText()),Double.parseDouble(CriSiValorMaximo.getText()));
    		}
    		else {
    			if(CriSiTipoModificador.getSelectionModel().getSelectedItem().contentEquals("Por Valor")) {
    				c = new Caracteristica(CriSiNomeCaracteristica.getText(),CriSiReferencia.getSelectionModel().getSelectedItem(),CriSiOperador.getSelectionModel().getSelectedItem(),Double.parseDouble(CriSiModificador.getText()));
    			}
    			else {
    				c = new Caracteristica(CriSiNomeCaracteristica.getText(),CriSiReferencia.getSelectionModel().getSelectedItem(),CriSiCaracteristicaModificadora.getSelectionModel().getSelectedItem(),CriSiOperador.getSelectionModel().getSelectedItem());
    			}
    			
    		}
    		CriSiTabelaCaracteristicas.getItems().add(c);
	    	CriSiReferencia.getItems().add(c);
	    	CriSiTabelaCaracteristicasVerificado.getItems().add(c);
	    	CriSiCaracteristicaModificadora.getItems().add(c);
    		CriSiNomeCaracteristica.clear();
    		CriSiModificador.clear();
	    	CriSiValorBase.clear();
	    	CriSiValorMinimo.clear();
	    	CriSiValorMaximo.clear();
    	}
    	catch(Exception e) {
    		
    	}
    }

    @FXML
    void CriSiCriarRegra(ActionEvent event) {
    	if(!CriSiNomeRegra.getText().isBlank() && !CriSiDescricaoRegra.getHtmlText().isBlank()) {
    		Regra r = new Regra(CriSiNomeRegra.getText(),CriSiDescricaoRegra.getHtmlText());
        	CriSiRegrasCriadas.getItems().add(r);
        	CriSiTabelaRegrasVerificado.getItems().add(r);
        	CriSiNomeRegra.setText("");;
        	CriSiDescricaoRegra.setHtmlText("");
    	}
    }

    @FXML
    void CriSiCriarSegmento(ActionEvent event) {
    	if(!CriSiNomeSegmento.getText().isBlank() && !CriSiValorAssociado.getText().isBlank()) {
    		Segmento seg = new Segmento(CriSiNomeSegmento.getText(),CriSiValorAssociado.getText());
    		CriSiTabelaSegmento.getItems().add(seg);
    		CriSiTabelaSegmentoVerificado.getItems().add(seg);
    		CriSiNomeSegmento.setText("");
    		CriSiValorAssociado.setText("");
    		
    	}
    }

    @FXML
    void CriSiCriarSistema(ActionEvent event) {
    	Sistema s = new Sistema();
    	s.setNome(CriSiNomeSistema.getText());
    	s.setVersao(CriSiVersaoSistema.getText());
    	s.setDescricao(CriSiDescricaoSistema.getHtmlText());
    	for(Segmento seg : CriSiTabelaSegmento.getItems()) {
    		s.getSegmentos().add(seg);
    	}
    	for(Caracteristica c : CriSiTabelaCaracteristicas.getItems()) {
    		s.getCaracteristicas().add(c);
    	}
    	for(Regra r : CriSiRegrasCriadas.getItems()) {
    		s.getRegras().add(r);
    	}
    	
    	DadosDeBanco.SalvarUnico(s);
    	GraficoFXMLController.SelecionarAbaPorNome("Consultar Sistema");
    	ConsultarSistemaController.STATICConSiSistemasTabela.getItems().add(s);
    	ConsultarSistemaController.STATICConSiSistemasTabela.getSelectionModel().select(s);
    	
    	CriSiNomeSistemaVerificado.setText("Nome:");
    	CriSiVersaoSistemaVerificado.setText("Versao:");
    	CriSiTabelaCaracteristicasVerificado.getItems().clear();
    	CriSiTabelaSegmentoVerificado.getItems().clear();
    	CriSiTabelaRegrasVerificado.getItems().clear();
    	CriSiTabelaCaracteristicas.getItems().clear();
    	CriSiReferencia.getItems().clear();
    	CriSiCaracteristicaModificadora.getItems().clear();
    	CriSiRegrasCriadas.getItems().clear();
    	CriSiTabelaSegmento.getItems().clear();
    	CriSiNomeSistema.clear();
    	CriSiVersaoSistema.clear();
    	CriSiDescricaoSistema.setHtmlText("");
    }

    @FXML
    void CriSiEditarCaracteristica(ActionEvent event) {
    	Caracteristica c = CriSiTabelaCaracteristicas.getSelectionModel().getSelectedItem();
    	if(c != null) {
    		CriSiTabelaCaracteristicas.getItems().remove(c);
        	CriSiReferencia.getItems().remove(c);
        	CriSiTabelaCaracteristicasVerificado.getItems().remove(c);
        	CriSiCaracteristicaModificadora.getItems().remove(c);
        	CriSiNomeCaracteristica.setText(c.getNome());
        	CriSiValorBase.setText(c.getValor()+"");
        	CriSiValorMinimo.setText(c.getValorminimo()+"");
        	CriSiValorMaximo.setText(c.getValormaximo()+"");
    	}
    }

    @FXML
    void CriSiEditarRegra(ActionEvent event) {
    	Regra r = CriSiRegrasCriadas.getSelectionModel().getSelectedItem();
    	if(r != null) {
    		CriSiRegrasCriadas.getItems().remove(r);
        	CriSiTabelaRegrasVerificado.getItems().remove(r);
        	CriSiNomeRegra.setText(r.getNome());
        	CriSiDescricaoRegra.setHtmlText(r.getRegra());
    	}
    }

    @FXML
    void CriSiEditarSegmento(ActionEvent event) {
    	Segmento seg = CriSiTabelaSegmento.getSelectionModel().getSelectedItem();
    	if(seg != null) {
    		CriSiNomeSegmento.setText(seg.getNome());
        	CriSiValorAssociado.setText(seg.getValorAssociado());
        	CriSiTabelaSegmento.getItems().remove(seg);
        	CriSiTabelaSegmentoVerificado.getItems().remove(seg);
    	}
    }

    @FXML
    void CriSiInserirNomeSistema(ActionEvent event) {
    	CriSiNomeSistemaVerificado.setText("Nome: "+CriSiNomeSistema.getText());
    }

    @FXML
    void CriSiInserirVersaoSistema(ActionEvent event) {
    	CriSiVersaoSistemaVerificado.setText("Versão: "+CriSiVersaoSistema.getText());
    }

    @FXML
    void CriSiRemoverCaracteristica(ActionEvent event) {
    	Caracteristica c = CriSiTabelaCaracteristicas.getSelectionModel().getSelectedItem();
    	CriSiTabelaCaracteristicas.getItems().remove(c);
    	CriSiReferencia.getItems().remove(c);
    	CriSiTabelaCaracteristicasVerificado.getItems().remove(c);
    	CriSiCaracteristicaModificadora.getItems().remove(c);
    }

    @FXML
    void CriSiRemoverRegra(ActionEvent event) {
    	Regra r = CriSiRegrasCriadas.getSelectionModel().getSelectedItem();
    	CriSiRegrasCriadas.getItems().remove(r);
    	CriSiTabelaRegrasVerificado.getItems().remove(r);
    }

    @FXML
    void CriSiRemoverSegmento(ActionEvent event) {
    	Segmento seg = CriSiTabelaSegmento.getSelectionModel().getSelectedItem();
    	CriSiTabelaSegmento.getItems().remove(seg);
    	CriSiTabelaSegmentoVerificado.getItems().remove(seg);
    }

    @FXML
    void CriSiSelecionarRegra(ActionEvent event) {

    }

}
