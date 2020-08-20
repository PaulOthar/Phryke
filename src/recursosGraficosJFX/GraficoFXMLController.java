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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import recursosLogicos.MeuNomeEhDado;

public class GraficoFXMLController implements Initializable {
	//---Inicializador---
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		for (Tab t : abas.getTabs()) {
			abasefetivas.add(t);
		}
		abas.getTabs().clear();
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

	
	@FXML
    private TextField CriSiNomeSistema;
    @FXML
    private TextField CriSiVersaoSistema;
    @FXML
    private HTMLEditor CriSiDescricaoSistema;
    @FXML
    private TableColumn<?, ?> CriSiSegmento;
    @FXML
    private TextField CriSiNomeSegmento;
    @FXML
    private TextField CriSiNomeRegra;
    @FXML
    private HTMLEditor CriSiDescricaoRegra;
    @FXML
    private ComboBox<?> CriSiRegrasCriadas;
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
    private TableColumn<?, ?> CriSiSegmentosVerificado;
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
    
	
	//--- ---
    
    
    
}
