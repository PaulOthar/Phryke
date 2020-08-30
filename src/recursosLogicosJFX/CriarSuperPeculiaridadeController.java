package recursosLogicosJFX;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import formatos.Caracteristica;
import formatos.Modificador;
import formatos.Peculiaridade;
import formatos.Segmento;
import formatos.Sistema;
import formatos.SuperPeculiaridade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;
import recursosLogicos.DadosDeBanco;

public class CriarSuperPeculiaridadeController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		CriSuPeMDCCT.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		CriSuPeMDCMT.setCellValueFactory(new PropertyValueFactory<>("modificador"));
		CriSuPePIUMCT.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		CriSuPePIUMMT.setCellValueFactory(new PropertyValueFactory<>("modificador"));
		CriSuPePIUVCT.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		CriSuPePIUVM.setCellValueFactory(new PropertyValueFactory<>("modificador"));
		CriSuPePIPT.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		CriSuPePICT.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		CriSuPePIMT.setCellValueFactory(new PropertyValueFactory<>("modificador"));
		CriSuPeVCT.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		CriSuPeVMT.setCellValueFactory(new PropertyValueFactory<>("modificador"));
		CriSuPeVPT.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		
		CriSuPeBINS.setItems(ConsultarSistemaController.SistemasCarregados);
		CriSuPePIUVT.setItems(CriSuPePIUMT.getItems());
		CriSuPeVTC.setItems(CriSuPePITC.getItems());
		CriSuPeVTP.setItems(CriSuPePITP.getItems());
		CriSuPeMDCCE.setItems(CriSuPePIUMCE.getItems());
		
		
		CriSuPeMDCTDP.getItems().add("Caracteristica Existente");
		CriSuPeMDCTDP.getItems().add("Caracteristica Inexistente");
		CriSuPeMDCTDP.getSelectionModel().select(0);
		
		CriSuPePIUMTDP.getItems().add("Caracteristica Existente");
		CriSuPePIUMTDP.getItems().add("Caracteristica Inexistente");
		CriSuPePIUMTDP.getSelectionModel().select(0);
		
		CriSuPePITDP.getItems().add("Peculiaridade Comum");
		CriSuPePITDP.getItems().add("Peculiaridade Unica");
		CriSuPePITDP.getSelectionModel().select(0);
	}
	
	@FXML
    private ComboBox<Sistema> CriSuPeBINS;

    @FXML
    private ComboBox<Segmento> CriSuPeBINSeg;

    @FXML
    private TextField CriSuPeBN;

    @FXML
    private TextField CriSuPeBVA;

    @FXML
    private HTMLEditor CriSuPeBD;

    @FXML
    private TableView<Modificador> CriSuPeMDCT;

    @FXML
    private TableColumn<String,String> CriSuPeMDCCT;

    @FXML
    private TableColumn<String,String> CriSuPeMDCMT;

    @FXML
    private ComboBox<String> CriSuPeMDCTDP;

    @FXML
    private ComboBox<Caracteristica> CriSuPeMDCCE;

    @FXML
    private TextField CriSuPeMDCM;

    @FXML
    private TextField CriSuPeMDCNC;

    @FXML
    private TextField CriSuPePIUBN;

    @FXML
    private TextField CriSuPePIUBVA;

    @FXML
    private ComboBox<Segmento> CriSuPePIUBS;

    @FXML
    private HTMLEditor CriSuPePIUBD;

    @FXML
    private TableView<Modificador> CriSuPePIUMT;

    @FXML
    private TableColumn<String,String> CriSuPePIUMCT;

    @FXML
    private TableColumn<String,String> CriSuPePIUMMT;

    @FXML
    private ComboBox<String> CriSuPePIUMTDP;

    @FXML
    private ComboBox<Caracteristica> CriSuPePIUMCE;

    @FXML
    private TextField CriSuPePIUMNC;

    @FXML
    private TextField CriSuPePIUMM;

    @FXML
    private TableView<Modificador> CriSuPePIUVT;

    @FXML
    private TableColumn<String,String> CriSuPePIUVCT;

    @FXML
    private TableColumn<String,String> CriSuPePIUVM;

    @FXML
    private WebView CriSuPePIUVD;

    @FXML
    private Label CriSuPePIUVN;

    @FXML
    private Label CriSuPePIUVVA;

    @FXML
    private Label CriSuPePIUVS;

    @FXML
    private TableView<Peculiaridade> CriSuPePITP;

    @FXML
    private TableColumn<String,String> CriSuPePIPT;

    @FXML
    private ComboBox<Peculiaridade> CriSuPePIP;

    @FXML
    private ComboBox<Segmento> CriSuPePIS;

    @FXML
    private ComboBox<String> CriSuPePITDP;

    @FXML
    private ComboBox<Peculiaridade> CriSuPePIPU;

    @FXML
    private TableView<Modificador> CriSuPePITC;

    @FXML
    private TableColumn<String,String> CriSuPePICT;

    @FXML
    private TableColumn<String,String> CriSuPePIMT;

    @FXML
    private Label CriSuPeVN;

    @FXML
    private Label CriSuPeVVA;

    @FXML
    private TableView<Modificador> CriSuPeVTC;

    @FXML
    private TableColumn<String,String> CriSuPeVCT;

    @FXML
    private TableColumn<String,String> CriSuPeVMT;

    @FXML
    private TableView<Peculiaridade> CriSuPeVTP;

    @FXML
    private TableColumn<String,String> CriSuPeVPT;

    @FXML
    private WebView CriSuPeVD;

    private ArrayList<String> nomes = new ArrayList<String>();
    
    @FXML
    void CriSuPeBINS(ActionEvent event) {
    	CriSuPeBINSeg.getItems().clear();
    	CriSuPePIUBS.getItems().clear();
    	nomes.clear();
    	Sistema s = CriSuPeBINS.getSelectionModel().getSelectedItem();
    	if(s.getSegmentos() != null) {
    		for(Segmento seg : s.getSegmentos()) {
        		CriSuPeBINSeg.getItems().add(seg);
        		CriSuPePIUBS.getItems().add(seg);
        	}
    	}
    	if(s.getCaracteristicas() != null) {
    		for(Caracteristica c : s.getCaracteristicas()) {
        		nomes.add(c.getNome());
        		CriSuPeMDCCE.getItems().add(c);
        	}
    	}
    }

    @FXML
    void CriSuPeMDCE(ActionEvent event) {
    	Modificador m = CriSuPeMDCT.getSelectionModel().getSelectedItem();
    	if(m != null) {
    		CriSuPeMDCT.getItems().remove(m);
        	CriSuPeMDCM.setText(m.getModificador()+"");
        	if(nomes.contains(m.getNome())) {
        		for(Caracteristica carac : CriSuPeMDCCE.getItems()) {
        			if(carac.getNome().contentEquals(m.getNome())) {
        				CriSuPeMDCCE.getSelectionModel().select(carac);
        			}
        		}
        		CriSuPeMDCTDP.getSelectionModel().select(0);
        	}
        	else {
        		CriSuPeMDCNC.setText(m.getNome());
        		CriSuPeMDCTDP.getSelectionModel().select(1);
        	}
    	}
    }

    @FXML
    void CriSuPeMDCI(ActionEvent event) {
    	Modificador m = new Modificador();
    	try {
    		if(CriSuPeMDCTDP.getSelectionModel().getSelectedIndex() == 0) {
        		m.setNome(CriSuPeMDCCE.getSelectionModel().getSelectedItem().getNome());
        		m.setModificador(Double.parseDouble(CriSuPeMDCM.getText()));
        	}
        	else {
        		m.setNome(CriSuPeMDCNC.getText());
        		m.setModificador(Double.parseDouble(CriSuPeMDCM.getText()));
        	}
    		CriSuPeMDCT.getItems().add(m);
    		CriSuPeMDCM.clear();
    		CriSuPeMDCNC.clear();
    	}
    	catch(Exception e) {
    		
    	}
    }

    @FXML
    void CriSuPeMDCR(ActionEvent event) {
    	Modificador m = CriSuPeMDCT.getSelectionModel().getSelectedItem();
    	if(m != null) {
    		CriSuPeMDCT.getItems().remove(m);
    	}
    }

    @FXML
    void CriSuPePIEPU(ActionEvent event) {
    	
    }

    @FXML
    void CriSuPePIExPU(ActionEvent event) {
    	CriSuPePIPU.getItems().remove(CriSuPePIPU.getSelectionModel().getSelectedItem());
    }

    @FXML
    void CriSuPePIIP(ActionEvent event) {
    	Peculiaridade p;
    	if(CriSuPePITDP.getSelectionModel().getSelectedIndex() == 0) {
    		p = CriSuPePIP.getSelectionModel().getSelectedItem();
    	}
    	else {
    		p = CriSuPePIPU.getSelectionModel().getSelectedItem();
    	}
    	if(p == null) {
    		return;
    	}
    	CriSuPePITP.getItems().add(p);
    	for(Modificador m : p.getModificadores()) {
    		CriSuPePITC.getItems().add(m);
    	}
    }

    @FXML
    void CriSuPePIRP(ActionEvent event) {
    	if(CriSuPePITP.getSelectionModel().getSelectedItem() != null) {
    		Peculiaridade p = CriSuPePITP.getSelectionModel().getSelectedItem();
        	CriSuPePITP.getItems().remove(p);
        	for(Modificador m : p.getModificadores()) {
        		CriSuPePITC.getItems().remove(m);
        	}
    	}
    }

    @FXML
    void CriSuPePIUME(ActionEvent event) {
    	Modificador m = CriSuPePIUMT.getSelectionModel().getSelectedItem();
    	if(m != null) {
    		CriSuPePIUMT.getItems().remove(m);
    		CriSuPePIUMM.setText(m.getModificador()+"");
        	if(nomes.contains(m.getNome())) {
        		for(Caracteristica carac : CriSuPePIUMCE.getItems()) {
        			if(carac.getNome().contentEquals(m.getNome())) {
        				CriSuPePIUMCE.getSelectionModel().select(carac);
        			}
        		}
        		CriSuPePIUMTDP.getSelectionModel().select(0);
        	}
        	else {
        		CriSuPePIUMNC.setText(m.getNome());
        		CriSuPePIUMTDP.getSelectionModel().select(1);
        	}
    	}
    }

    @FXML
    void CriSuPePIUMI(ActionEvent event) {
    	Modificador m = new Modificador();
    	try {
    		if(CriSuPePIUMTDP.getSelectionModel().getSelectedIndex() == 0) {
        		m.setNome(CriSuPePIUMCE.getSelectionModel().getSelectedItem().getNome());
        	}
        	else {
        		m.setNome(CriSuPePIUMNC.getText());
        	}
    		m.setModificador(Double.parseDouble(CriSuPePIUMM.getText()));
    		CriSuPePIUMT.getItems().add(m);
    		CriSuPePIUMNC.clear();
    		CriSuPePIUMM.clear();
    	}
    	catch(Exception e) {
    		
    	}
    }
    
    @FXML
    void CriSuPePIUMR(ActionEvent event) {
    	Modificador m = CriSuPePIUMT.getSelectionModel().getSelectedItem();
    	if(m != null) {
    		CriSuPePIUMT.getItems().remove(m);
    	}
    }
    
    @FXML
    void CriSuPePIUVCPU(ActionEvent event) {
    	Peculiaridade p = new Peculiaridade();
    	try {
    		p.setNome(CriSuPePIUBN.getText());
        	p.setValorAssociado(Double.parseDouble(CriSuPePIUBVA.getText()));
        	p.setSegmento(CriSuPePIUBS.getSelectionModel().getSelectedItem().getNome());
        	p.setDetalhe(CriSuPePIUBD.getHtmlText());
        	
        	for(Modificador m : CriSuPePIUMT.getItems()) {
        		p.getModificadores().add(m);
        	}
        	
        	CriSuPePIUBN.clear();
        	CriSuPePIUBVA.clear();
        	CriSuPePIUBD.setHtmlText("");
        	CriSuPePIUMT.getItems().clear();
        	
        	CriSuPePIPU.getItems().add(p);
    	}
    	catch(Exception e) {
    		
    	}
    	
    }

    @FXML
    void CriSuPeVCSP(ActionEvent event) {
    	SuperPeculiaridade p = new SuperPeculiaridade();
    	try {
    		p.setNome(CriSuPeBN.getText());
        	p.setValorAssociado(Double.parseDouble(CriSuPeBVA.getText()));
        	p.setDetalhe(CriSuPeBD.getHtmlText());
        	p.setSistema(CriSuPeBINS.getSelectionModel().getSelectedItem().getNome());
        	p.setSegmento(CriSuPeBINSeg.getSelectionModel().getSelectedItem().getNome());
        	
        	for(Modificador m : CriSuPeMDCT.getItems()) {
        		p.getModificadores().add(m);
        	}
        	for(Peculiaridade pe : CriSuPeVTP.getItems()) {
        		p.getPeculiaridades().add(pe);
        	}
        	DadosDeBanco.SalvarUnico(p);
        	CriSuPeBN.clear();
        	CriSuPeBVA.clear();
        	CriSuPeBD.setHtmlText("");
    	}
    	catch(Exception e) {
    		
    	}
    }

}
