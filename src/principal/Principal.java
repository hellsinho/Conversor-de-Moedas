package principal;

import service.ConsultaCotacao;

public class Principal {

    private ConsultaCotacao consultor = new ConsultaCotacao();
    public String menu(){
        String menu = "\n*********************************\n" +
                "Seja bem-vindo/a ao Converso de Moedas =]\n\n" +
                "1) Dólar => Peso argentino\n" +
                "2) Dólar => Real brasileiro\n" +
                "3) Dólar => Peso colombiano\n" +
                "4) Real => Dólar\n" +
                "5) Peso argentino => Dólar\n" +
                "6) Peso colombiano => Dólar\n" +
                "7) sair\n" +
                "Escolha uma opção válida\n" +
                "*********************************\n";

        return menu;
    }

    private void obterConversao(String moedaPrincipal, String moedaConvertida, Double qtdConvertida){
        var consulta = consultor.buscaCotacao(moedaPrincipal);
        var valores = consulta.conversion_rates();
        System.out.println("Valor do "+ moedaPrincipal + ": "+ valores.get(moedaPrincipal));
        System.out.println("Valor Convertido em "+ moedaConvertida + ": "+ valores.get(moedaConvertida)*qtdConvertida);
    }

    public void obterValorConvertido(String opcao, Double quantidadeMoeda){
        switch (opcao){
            case "1":
                obterConversao("USD", "ARS", quantidadeMoeda);
                break;
            case "2":
                obterConversao("USD", "BRL", quantidadeMoeda);
                break;
            case "3":
                obterConversao("USD", "COP", quantidadeMoeda);
                break;
            case "4":
                obterConversao("BRL", "USD", quantidadeMoeda);
                break;
            case "5":
                obterConversao("ARS", "USD", quantidadeMoeda);
                break;
            case "6":
                obterConversao("COP", "USD", quantidadeMoeda);
                break;
            default:
                System.out.println("Operacão inválida!");
                break;

        }
    }
}
