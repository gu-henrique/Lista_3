package ltp2;

import java.util.Scanner;

public class ConsultaVoos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] cidades = new String[20];
        int[] distancias = new int[20];
        int numCidades = 0;

        System.out.println("Cadastro de Cidades e Distâncias");
        System.out.println("------------------------------");

        // Cadastro das cidades e distâncias
        while (numCidades < 20) {
            System.out.print("Digite o nome da cidade (ou 'FIM' para encerrar): ");
            String nomeCidade = scanner.nextLine();

            if (nomeCidade.equalsIgnoreCase("FIM")) {
                break;
            }

            System.out.print("Digite a distância até Belo Horizonte (em km, mínimo 500 km): ");
            int distancia = Integer.parseInt(scanner.nextLine());

            if (distancia < 500) {
                System.out.println("Distância inválida. A distância mínima é de 500 km.");
                continue;
            }

            cidades[numCidades] = nomeCidade;
            distancias[numCidades] = distancia;
            numCidades++;
        }

        System.out.println("\nConsulta de Informações de Voos");
        System.out.println("-----------------------------");

        // Módulo de consultas
        while (true) {
            System.out.print("Digite o nome da cidade para consulta (ou 'FIM' para encerrar): ");
            String cidadeConsulta = scanner.nextLine();

            if (cidadeConsulta.equalsIgnoreCase("FIM")) {
                break;
            }

            int indiceCidade = -1;
            for (int i = 0; i < numCidades; i++) {
                if (cidades[i].equalsIgnoreCase(cidadeConsulta)) {
                    indiceCidade = i;
                    break;
                }
            }

            if (indiceCidade == -1) {
                System.out.println("Cidade não encontrada.");
                continue;
            }

            double precoPassagem = distancias[indiceCidade] * 0.25;
            int tempoVooMinutos = (int) (distancias[indiceCidade] / 800 * 60);
            int numEscalas = tempoVooMinutos / 180;

            System.out.println("Resultados para " + cidadeConsulta);
            System.out.println("Preço da Passagem: R$" + precoPassagem);
            System.out.println("Tempo de Voo: " + tempoVooMinutos + " minutos");
            System.out.println("Número de Escalas: " + numEscalas);
        }

        System.out.println("Programa encerrado.");
    }
}
