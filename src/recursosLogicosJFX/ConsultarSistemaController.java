package recursosLogicosJFX;

import java.net.URL;
import java.util.ResourceBundle;

import formatos.Caracteristica;
import formatos.Formato;
import formatos.Regra;
import formatos.Segmento;
import formatos.Sistema;
import javafx.collections.ObservableList;
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
	public static ObservableList<Sistema> SistemasCarregados;
	private Sistema s = new Sistema();
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		SistemasCarregados = ConSiSistemasTabela.getItems();
		for(Formato s : DadosDeBanco.Carregar(new Sistema())) {
			SistemasCarregados.add((Sistema) s);
		}
		
		ConSiNomeSistemaTabela.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		ConSiVersaoSistemaTabela.setCellValueFactory(new PropertyValueFactory<>("versao"));
		ConSiNomeCaracteristicaTabela.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		ConSiValorBaseCaracteristicaTabela.setCellValueFactory(new PropertyValueFactory<>("valor"));
		ConSiValorMinimoCaracteristicaTabela.setCellValueFactory(new PropertyValueFactory<>("valorminimo"));
		ConSiValorMaximoCaracteristicaTabela.setCellValueFactory(new PropertyValueFactory<>("valormaximo"));
		ConSiNomeCaracteristicaReferenciaTabela.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		ConSiNomeReferenciaReferenciaTabela.setCellValueFactory(new PropertyValueFactory<>("Creferencia1"));
		ConSiModificadorReferenciaTabela.setCellValueFactory(new PropertyValueFactory<>("aparencia"));
		ConSiNomeSegmentoTabela.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		ConSiValorAssociadoSegmentoTabela.setCellValueFactory(new PropertyValueFactory<>("ValorAssociado"));
		
		STATICConSiSistemasTabela = ConSiSistemasTabela;
	}
	
	@FXML
	public static TableView<Sistema> STATICConSiSistemasTabela;
	
	@FXML
    private TableView<Sistema> ConSiSistemasTabela;

    @FXML
    private TableColumn<String,String> ConSiNomeSistemaTabela;

    @FXML
    private TableColumn<String,String> ConSiVersaoSistemaTabela;

    @FXML
    private WebView ConSiDescricaoSistema;

    @FXML
    private Label ConSiNomeSistema;

    @FXML
    private Label ConSiVersaoSistema;

    @FXML
    private TableView<Caracteristica> ConSiCaracteristicasTabela;

    @FXML
    private TableColumn<String,String> ConSiNomeCaracteristicaTabela;

    @FXML
    private TableColumn<String,String> ConSiValorBaseCaracteristicaTabela;

    @FXML
    private TableColumn<String,String> ConSiValorMinimoCaracteristicaTabela;

    @FXML
    private TableColumn<String,String> ConSiValorMaximoCaracteristicaTabela;

    @FXML
    private TableView<Caracteristica> ConSiCaracteristicasReferenciaTabela;

    @FXML
    private TableColumn<String,String> ConSiNomeCaracteristicaReferenciaTabela;

    @FXML
    private TableColumn<String,String> ConSiNomeReferenciaReferenciaTabela;

    @FXML
    private TableColumn<String,String> ConSiModificadorReferenciaTabela;

    @FXML
    private TableView<Segmento> ConSiSegmentoTabela;

    @FXML
    private TableColumn<String,String> ConSiNomeSegmentoTabela;

    @FXML
    private TableColumn<String,String> ConSiValorAssociadoSegmentoTabela;

    @FXML
    private ComboBox<Regra> ConSiRegrasSistema;

    @FXML
    private WebView ConSiTextoRegrasSistema;

    @FXML
    void ConSiEditarSistema(ActionEvent event) {
    	Sistema s = ConSiSistemasTabela.getSelectionModel().getSelectedItem();
    	DadosDeBanco.Excluir(s);
    	ConSiSistemasTabela.getItems().remove(s);
    	CriarSistemaController.PreencherSistema(s);
    	GraficoFXMLController.SelecionarAbaPorNome("Criar Sistema");
    }

    @FXML
    void ConSiRemoverSistema(ActionEvent event) {
    	Sistema s = ConSiSistemasTabela.getSelectionModel().getSelectedItem();
    	DadosDeBanco.Excluir(s);
    	ConSiSistemasTabela.getItems().remove(s);
    }

    @FXML
    void ConSiSelecionarRegra(ActionEvent event) {
    	try{
    		ConSiTextoRegrasSistema.getEngine().loadContent(ConSiRegrasSistema.getSelectionModel().getSelectedItem().getRegra());
    	}
    	catch(Exception e) {
    		
    	}
    }

    @FXML
    void ConSiSelecionarSistema(MouseEvent event) {
    	if(ConSiSistemasTabela.getSelectionModel().getSelectedItem() != s) {
    		
    		ConSiNomeSistema.setText("Nome:");
    		ConSiVersaoSistema.setText("Versao:");
    		ConSiDescricaoSistema.getEngine().loadContent("");
    		ConSiCaracteristicasTabela.getItems().clear();
    		ConSiSegmentoTabela.getItems().clear();
    		ConSiCaracteristicasReferenciaTabela.getItems().clear();
    		ConSiRegrasSistema.getItems().clear();
    		ConSiTextoRegrasSistema.getEngine().loadContent("");
    		
    		try {
        		s = ConSiSistemasTabela.getSelectionModel().getSelectedItem();
        		ConSiNomeSistema.setText("Nome:"+s.getNome());
        		ConSiVersaoSistema.setText("Versao:"+s.getVersao());
        		ConSiDescricaoSistema.getEngine().loadContent(s.getDescricao());
        		for(Caracteristica c : s.getCaracteristicas()) {
        			if(c.getOperador().isBlank()) {
        				ConSiCaracteristicasTabela.getItems().add(c);
        			}
        			else {
        				if(c.isReferenciadoC()) {
        					c.GerarAparencia(c.getOperador(), c.getCreferencia2());
        				}
        				else {
        					c.GerarAparencia(c.getOperador(), c.getModificador());
        				}
        				ConSiCaracteristicasReferenciaTabela.getItems().add(c);
        			}
        		}
        		for(Segmento seg : s.getSegmentos()) {
        			ConSiSegmentoTabela.getItems().add(seg);
        		}
        		for(Regra r : s.getRegras()) {
        			ConSiRegrasSistema.getItems().add(r);
        		}
        	}
        	catch(Exception e) {
        		
        	}
    	}
    }
	
}
