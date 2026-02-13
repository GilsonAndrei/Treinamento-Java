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
				"João Silva",
				Date.valueOf("1994-03-10"),
				"CNH123456",
				"B",
				Date.valueOf("2026-03-10")
		);

		Condutor condutor2 = new Condutor(
				2,
				"987.654.321-00",
				"Maria Souza",
				Date.valueOf("2002-03-10"),
				"CNH999888",
				"D",
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
				"ABC-1D23",
				"Fiat Strada",
				TipoControle.QUILOMETROS,
				45230.5
		);

		Veiculo veiculo2 = new Veiculo(
				102,
				Date.valueOf("2020-01-01"),
				2020,
				"XYZ-9Z99",
				"Trator X",
				TipoControle.HORAS,
				1287.0
		);

		//Exibir Condutores
		veiculo1.exibirDetalhes();
		veiculo1.exibirDetalhes();

		// Eventos
		Evento evento1 = new EventoEntradaSaida(
				Date.valueOf("2020-01-01"),
				"Garagem",
				"Saída para rota de entregas",
				veiculo1,
				TipoMovimento.SAIDA,
				condutor1
		);

		Evento evento2 = new EventoMulta(
				Date.valueOf("2020-01-01"),
				"Av. Central",
				"Excesso de velocidade",
				veiculo2,
				condutor1,
				TipoInfracao.GRAVE,
				5,
				195.23
		);

		Evento evento3 = new EventoAbastecimento(
				Date.valueOf("2020-01-01"),
				"Posto Shell",
				"Abastecimento completo",
				veiculo2,
				46010.0,
				TipoCombustivel.GASOLINA,
				6.19,
				42.5
		);

		Evento evento4 = new EventoManutencao(
				Date.valueOf("2020-01-01"),
				"Oficina do Zé",
				"Revisão preventiva",
				veiculo1,
				1250.0,
				"Troca de óleo, filtros e verificação geral"
		);

		Evento evento5 = new EventoSinistro(
				Date.valueOf("2020-01-01"),
				"Rodovia BR-101",
				"Colisão leve na lateral",
				veiculo2,
				condutor2,
				false,
				true,
				"Laudo: danos na porta direita; terceiro envolvido acionou seguro."
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