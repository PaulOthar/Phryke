package recursosLogicosJFX;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import recursosLogicos.MeuNomeEhDado;

public class GraficoFXMLController implements Initializable {
	//---Inicializador---
	private AuxiliarDeFXML fxml = new AuxiliarDeFXML();
	@FXML
    private AnchorPane CriarSistema;
	@FXML
    private AnchorPane ConsultarSistema;
	@FXML
    private AnchorPane CriarSuperPeculiaridade;
	@FXML
	private TabPane abas;
	private ArrayList<Tab> abasefetivas = new ArrayList<Tab>();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		CriarSistema.getChildren().setAll(fxml.PegarFXMLPorNome("CriarSistema"));
		ConsultarSistema.getChildren().setAll(fxml.PegarFXMLPorNome("ConsultarSistema"));
		CriarSuperPeculiaridade.getChildren().setAll(fxml.PegarFXMLPorNome("CriarSuperPeculiaridade"));
		
		for (Tab t : abas.getTabs()) {
			abasefetivas.add(t);
		}
		abas.getTabs().clear();
	}
	
	
	@FXML
    private AnchorPane ACheetos;
	
	
	//---Menu e Abas---
	
	
	@FXML
	private MenuBar BarraDeMenu;
	
	
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
	void ConsultarSuperPeculiaridade(ActionEvent event) {
		AbrirAbaPorNome("Consultar Super Peculiaridade");
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
	void CriarSuperPeculiaridade(ActionEvent event) {
		AbrirAbaPorNome("Criar Super Peculiaridade");
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
	public void SelecionarAbaPorNome(String NomeDaAba) {
		AbrirAbaPorNome(NomeDaAba);
		abas.getSelectionModel().select(PegarAbaPorNome(NomeDaAba));
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
}
