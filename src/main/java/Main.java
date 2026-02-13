import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import condutores.enums.TipoCombustivel;
import condutores.enums.TipoControle;
import condutores.enums.TipoInfracao;
import condutores.enums.TipoMovimento;
import condutores.models.Condutor;
import condutores.models.Veiculo;
import condutores.models.evento.Evento;
import condutores.models.evento.EventoAbastecimento;
import condutores.models.evento.EventoEntradaSaida;
import condutores.models.evento.EventoManutencao;
import condutores.models.evento.EventoMulta;
import condutores.models.evento.EventoSinistro;

/**
 * @author Gilson Andrei Oliveira SIlva (gilson.silva@publicatecnologia.com.br)
 */
public class Main {
	public static void main(String[] args) {

		// Condutores
		Condutor condutor1 = new Condutor(
				1,
				"395.119.508",
				"Gilson Andrei Oliveira SIlva",
				Date.valueOf("2026-03-10"),
				"123456",
				"AB",
				Date.valueOf("2026-03-10")

		);

		Condutor condutor2 = new Condutor(
				2,
				"123.456.789-00",
				"Ana Paula Cardoso",
				Date.valueOf("2002-03-10"),
				"2222222222",
				"FG",
				Date.valueOf("2002-03-10")
		);

		//Exibir Condutores
		condutor1.exibirDetalhes();
		condutor2.exibirDetalhes();

		// 2) Criar Veículos
		Veiculo veiculo1 = new Veiculo(
				101,
				Date.valueOf("2026-01-01"),
				2022,
				"QTK-4242",
				"ONIX PLUS 1.0",
				TipoControle.QUILOMETROS,
				59600.69
		);

		Veiculo veiculo2 = new Veiculo(
				102,
				Date.valueOf("2020-01-01"),
				2020,
				"ABC-9999",
				"CAÇAMBA",
				TipoControle.HORAS,
				25000.00
		);

		//Exibir Condutores
		veiculo1.exibirDetalhes();
		veiculo1.exibirDetalhes();

		// Eventos
		Evento evento1 = new EventoEntradaSaida(
				Date.valueOf("2020-01-01"),
				"Garagem",
				"SAÍDA DE TESTE",
				veiculo1,
				TipoMovimento.SAIDA,
				condutor1
		);

		Evento evento2 = new EventoMulta(
				Date.valueOf("2020-01-01"),
				"JOSE MACHADO",
				"MULTA DE TESTES",
				veiculo2,
				condutor1,
				TipoInfracao.GRAVE,
				5,
				295.00
		);

		Evento evento3 = new EventoAbastecimento(
				Date.valueOf("2020-01-01"),
				"POSTO DE TESTE",
				"TANQUE CHEIO",
				veiculo2,
				46010.0,
				TipoCombustivel.GASOLINA,
				6.19,
				42.5
		);

		Evento evento4 = new EventoManutencao(
				Date.valueOf("2020-01-01"),
				"CHEFE DO OLEO",
				"Revisão",
				veiculo1,
				1250.0,
				"Serviços teste"
		);

		Evento evento5 = new EventoSinistro(
				Date.valueOf("2020-01-01"),
				"RODOVIA BEIRA MAR",
				"BATIDA DE FRENTE",
				veiculo2,
				condutor2,
				false,
				true,
				"Laudo: PT"
		);

		// Lista genérica do tipo Evento e nela atribuida X tipos de eventos (Evento Sinistro, Multa etc)
		List<Evento> eventos = new ArrayList<>();
		eventos.add(evento1);
		eventos.add(evento2);
		eventos.add(evento3);
		eventos.add(evento4);
		eventos.add(evento5);

		// Exibir os eventos
		System.out.println("########################################");
		System.out.println("########### LISTA DE EVENTOS ###########");
		System.out.println("########################################");

		for (Evento evento : eventos) {
			evento.exibirDetalhes();//Exibir detalhes irá chamar de acordo com o tipo passado, exemplo se for multa chama da MUlta, se for sinistro chama o do sinistro
		}
	}
}