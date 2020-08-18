package recursosGraficosJFX;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import recursosLogicos.MeuNomeEhDado;

public class GraficoFXMLController {
	@FXML
	private MenuBar BarraDeMenu;

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
	private TabPane abas;
	
	private ArrayList<Tab> abasefetivas;

	@FXML
	void AbaBaixo(ActionEvent event) {

	}

	@FXML
	void AbaCima(ActionEvent event) {

	}

	@FXML
	void AbaDireita(ActionEvent event) {

	}

	@FXML
	void AbaEsquerda(ActionEvent event) {

	}

	@FXML
	void ConsultarPeculiaridade(ActionEvent event) {

	}

	@FXML
	void ConsultarRaca(ActionEvent event) {

	}

	@FXML
	void ConsultarSistema(ActionEvent event) {

	}

	@FXML
	void ConsultarSuperRaca(ActionEvent event) {

	}

	@FXML
	void CriarPeculiaridade(ActionEvent event) {

	}

	@FXML
	void CriarRaca(ActionEvent event) {

	}

	@FXML
	void CriarSistema(ActionEvent event) {

	}

	@FXML
	void CriarSuperRaca(ActionEvent event) {

	}

	@FXML
	void FecharTudo(ActionEvent event) {

	}

	@FXML
	void ModoJogador(ActionEvent event) {

	}

	@FXML
	void ModoMestre(ActionEvent event) {

	}

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

	@FXML
	void tevira(ActionEvent event) {
		System.out.println(abas.getTabs());
	}
}
