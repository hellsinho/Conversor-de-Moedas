package service;

import com.google.gson.Gson;
import model.Cotacao;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCotacao {

    public Cotacao buscaCotacao(String moedaConvertida){
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/107931c6c2d1fa74056c8954/latest/" + moedaConvertida);

        HttpRequest request = HttpRequest.newBuilder()
                .uri((endereco))
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Cotacao.class);

        } catch (Exception e){
            throw new RuntimeException("Não foi possível obter a cotação a partir da moeda indicada!");
        }
    }
}
