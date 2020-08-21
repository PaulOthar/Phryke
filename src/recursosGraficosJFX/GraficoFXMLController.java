package recursosGraficosJFX;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import recursosLogicos.DadosDeBanco;
import recursosLogicos.MeuNomeEhDado;
import formatos.*;

public class GraficoFXMLController implements Initializable {
	//---Inicializador---
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		for (Tab t : abas.getTabs()) {
			abasefetivas.add(t);
		}
		abas.getTabs().clear();
		CriSiOperador.getItems().add(Caracteristica.soma);
		CriSiOperador.getItems().add(Caracteristica.subtracao);
		CriSiOperador.getItems().add(Caracteristica.divisao);
		CriSiOperador.getItems().add(Caracteristica.multiplicacao);
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
	}
	
	
	//---Menu e Abas---
	
	
	@FXML
	private MenuBar BarraDeMenu;
	@FXML
	private TabPane abas;
	private ArrayList<Tab> abasefetivas = new ArrayList<Tab>();
	
	@FXML
	void AbaBaixo(ActionEvent event) {
		abas.setSide(Side.BOTTOM);
	}
	@FXML
	void AbaCima(ActionEvent event) {
		abas.setSide(Side.TOP);
	}
	@FXML
	void AbaDireita(ActionEvent event) {
		abas.setSide(Side.RIGHT);
	}
	@FXML
	void AbaEsquerda(ActionEvent event) {
		abas.setSide(Side.LEFT);
	}
	
	@FXML
	void ConsultarPeculiaridade(ActionEvent event) {
		AbrirAbaPorNome("Consultar Peculiaridade");
	}
	@FXML
	void ConsultarRaca(ActionEvent event) {
		AbrirAbaPorNome("Consultar Raca");
	}
	@FXML
	void ConsultarSistema(ActionEvent event) {
		AbrirAbaPorNome("Consultar Sistema");
	}
	@FXML
	void ConsultarSuperClasse(ActionEvent event) {
		AbrirAbaPorNome("Consultar Super Classe");
	}
	@FXML
	void ConsultarSuperRaca(ActionEvent event) {
		AbrirAbaPorNome("Consultar Super Raca");
	}
	@FXML
	void ConsultarClasse(ActionEvent event) {
		AbrirAbaPorNome("Consultar Classe");
	}
	@FXML
	void CriarClasse(ActionEvent event) {
		AbrirAbaPorNome("Criar Classe");
	}
	@FXML
	void CriarPeculiaridade(ActionEvent event) {
		AbrirAbaPorNome("Criar Peculiaridade");
	}
	@FXML
	void CriarRaca(ActionEvent event) {
		AbrirAbaPorNome("Criar Raca");
	}
	@FXML
	void CriarSistema(ActionEvent event) {
		AbrirAbaPorNome("Criar Sistema");
	}
	@FXML
	void CriarSuperClasse(ActionEvent event) {
		AbrirAbaPorNome("Criar Super Classe");
	}
	@FXML
	void CriarSuperRaca(ActionEvent event) {
		AbrirAbaPorNome("Criar Super Raca");
	}
	@FXML
	void FecharTudo(ActionEvent event) {
		abas.getTabs().clear();
	}
	@FXML
	void ModoJogador(ActionEvent event) {
		AbrirAbaPorNome("Modo Jogador");
	}
	@FXML
	void ModoMestre(ActionEvent event) {
		AbrirAbaPorNome("Modo Mestre");
	}
	@FXML
	void tevira(ActionEvent event) {
		System.out.println(abas.getTabs());
	}
	public void AbrirAbaPorNome(String NomeDaAba) {
		Tab t = PegarAbaPorNome(NomeDaAba);
		if (!abas.getTabs().contains(t)) {
			abas.getTabs().add(t);
		}
	}
	public Tab PegarAbaPorNome(String NomeDaAba) {
		Tab t = new Tab();

		for (Tab i : abasefetivas) {
			if (i.getText().contains(NomeDaAba)) {
				t = i;
			}
		}

		return t;
	}
	
	
	//---Dados(De Jogar)---
	
	
	@FXML
	private TextField qntdados;
	@FXML
	private TextField tipodados;
	@FXML
	private Label dadoexibido;
	@FXML
	private Label resultado;
	@FXML
	private Label maiorv;
	@FXML
	private Label menorv;
	@FXML
	private ComboBox<String> Dados;
	
	
	@FXML
	void BotaoApertado(ActionEvent event) {
		if (!dadoexibido.getText().contains("ERRO")) {
			try {
				int rolagem = 0, soma = 0, maior = 0, menor = 0;
				Dados.getItems().clear();
				for (int i = 0; i < Integer.parseInt(qntdados.getText()); i++) {
					rolagem = MeuNomeEhDado.RolarDado(Integer.parseInt(tipodados.getText()));
					if (i == 0) {
						soma = rolagem;
						menor = rolagem;
					} else {
						soma += rolagem;
					}
					if (rolagem > maior) {
						maior = rolagem;
					}
					if (rolagem < menor) {
						menor = rolagem;
					}
					Dados.getItems().add(rolagem + "");
				}
				resultado.setText("Resultado: " + soma);
				maiorv.setText("Maior: " + maior);
				menorv.setText("Menor: " + menor);

			} catch (Exception e) {
				resultado.setText("Incoerencia");
				return;
			}

		} else {
			return;
		}

	}
	@FXML
	void DadoGerado(KeyEvent event) {
		try {
			int qntd, tipd;

			if (qntdados.getText().isBlank()) {
				qntd = 0;
			} else {
				qntd = Integer.parseInt(qntdados.getText());
			}

			if (tipodados.getText().isBlank()) {
				tipd = 0;
			} else {
				tipd = Integer.parseInt(tipodados.getText());
			}
			dadoexibido.setText(qntd + "D" + tipd);
		} catch (Exception e) {
			dadoexibido.setText("ERRO");
		}
	}
	
	
	//---Criar Sistema(CriSi)---

	//-Basico-
	@FXML
    private TextField CriSiNomeSistema;
    @FXML
    private TextField CriSiVersaoSistema;
    @FXML
    private HTMLEditor CriSiDescricaoSistema;
    
    @FXML
    void CriSiInserirVersaoSistema(ActionEvent event) {
    	CriSiVersaoSistemaVerificado.setText("Versão: "+CriSiVersaoSistema.getText());
    }
    @FXML
    void CriSiInserirNomeSistema(ActionEvent event) {
    	CriSiNomeSistemaVerificado.setText("Nome: "+CriSiNomeSistema.getText());
    }
    
    //-Segmento-
    @FXML
    private TableColumn<String, String> CriSiSegmento;
    @FXML
    private TextField CriSiNomeSegmento;
    @FXML
    private TextField CriSiValorAssociado;
    @FXML
    private TableView<Segmento> CriSiTabelaSegmento;
    @FXML
    private TableColumn<String, String> CriSiValorAssociadoTabela;
    
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
    void CriSiEditarSegmento(ActionEvent event) {
    	Segmento seg = CriSiTabelaSegmento.getSelectionModel().getSelectedItem();
    	CriSiNomeSegmento.setText(seg.getNome());
    	CriSiValorAssociado.setText(seg.getValorAssociado());
    	CriSiTabelaSegmento.getItems().remove(seg);
    	CriSiTabelaSegmentoVerificado.getItems().remove(seg);
    }
    @FXML
    void CriSiRemoverSegmento(ActionEvent event) {
    	Segmento seg = CriSiTabelaSegmento.getSelectionModel().getSelectedItem();
    	CriSiTabelaSegmento.getItems().remove(seg);
    	CriSiTabelaSegmentoVerificado.getItems().remove(seg);
    }
    
    //-Regra-
    @FXML
    private TextField CriSiNomeRegra;
    @FXML
    private HTMLEditor CriSiDescricaoRegra;
    @FXML
    private ComboBox<Regra> CriSiRegrasCriadas;
    
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
    void CriSiEditarRegra(ActionEvent event) {
    	Regra r = CriSiRegrasCriadas.getSelectionModel().getSelectedItem();
    	CriSiRegrasCriadas.getItems().remove(r);
    	CriSiTabelaRegrasVerificado.getItems().remove(r);
    	CriSiNomeRegra.setText(r.getNome());
    	CriSiDescricaoRegra.setHtmlText(r.getRegra());
    }
    @FXML
    void CriSiRemoverRegra(ActionEvent event) {
    	Regra r = CriSiRegrasCriadas.getSelectionModel().getSelectedItem();
    	CriSiRegrasCriadas.getItems().remove(r);
    	CriSiTabelaRegrasVerificado.getItems().remove(r);
    }
    @FXML
    void CriSiSelecionarRegra(ActionEvent event) {

    }
    
    //-Caracteristica-
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
    private TableView<Caracteristica> CriSiTabelaCaracteristicas;
    
    @FXML
    void CriSiCriarCaracteristica(ActionEvent event) {
    	
    	try {
    		Caracteristica c;
    		if(CriSiParametro.getSelectionModel().getSelectedItem().contentEquals("Por Valor")) {
    			c = new Caracteristica(CriSiNomeCaracteristica.getText(),Double.parseDouble(CriSiValorBase.getText()),Double.parseDouble(CriSiValorMinimo.getText()),Double.parseDouble(CriSiValorMaximo.getText()));
    	    	
    		}
    		else {
    			c = new Caracteristica(CriSiNomeCaracteristica.getText(),CriSiReferencia.getSelectionModel().getSelectedItem(),CriSiOperador.getSelectionModel().getSelectedItem(),Double.parseDouble(CriSiModificador.getText()));
    			
    		}
    		CriSiTabelaCaracteristicas.getItems().add(c);
	    	CriSiReferencia.getItems().add(c);
	    	CriSiTabelaCaracteristicasVerificado.getItems().add(c);
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
    void CriSiEditarCaracteristica(ActionEvent event) {
    	Caracteristica c = CriSiTabelaCaracteristicas.getSelectionModel().getSelectedItem();
    	CriSiTabelaCaracteristicas.getItems().remove(c);
    	CriSiReferencia.getItems().remove(c);
    	CriSiTabelaCaracteristicasVerificado.getItems().remove(c);
    	CriSiNomeCaracteristica.setText(c.getNome());
    	CriSiValorBase.setText(c.getValor()+"");
    	CriSiValorMinimo.setText(c.getValorminimo()+"");
    	CriSiValorMaximo.setText(c.getValormaximo()+"");
    }
    @FXML
    void CriSiRemoverCaracteristica(ActionEvent event) {
    	Caracteristica c = CriSiTabelaCaracteristicas.getSelectionModel().getSelectedItem();
    	CriSiTabelaCaracteristicas.getItems().remove(c);
    	CriSiReferencia.getItems().remove(c);
    	CriSiTabelaCaracteristicasVerificado.getItems().remove(c);
    }
    
    //-Verificado-
    
    @FXML
    private TableColumn<String, String> CriSiNomeCaracteristicaVerificado;
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
    private TableColumn<String, String> CriSiSegmentosVerificado;
    @FXML
    private TableView<Caracteristica> CriSiTabelaCaracteristicasVerificado;
    @FXML
    private TableView<Segmento> CriSiTabelaSegmentoVerificado;
    @FXML
    private TableView<Regra> CriSiTabelaRegrasVerificado;
    @FXML
    private TableColumn<String, String> CriSiRegrasVerificado;
    
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
    }
    
    
	//--- ---

        
        

}
