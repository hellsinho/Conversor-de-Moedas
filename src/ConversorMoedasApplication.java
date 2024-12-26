import model.Cotacao;
import principal.Principal;
import service.ConsultaCotacao;

import java.util.Scanner;


public class ConversorMoedasApplication {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        Principal console = new Principal();

        String opcao;
        Double quantidadeMoeda;

        do {
            System.out.println(console.menu());
            System.out.println("\nDigite a opção desejada: ");
            opcao = leitura.nextLine();

            if (opcao.equals("7")){
                System.out.println("Encerrando operação! ;)");
                return;
            }

            System.out.println("\nDigite o valor a ser convertido: ");
            quantidadeMoeda = leitura.nextDouble();
            leitura.nextLine();

            console.obterValorConvertido(opcao, quantidadeMoeda);
        } while (true);

    }
}
