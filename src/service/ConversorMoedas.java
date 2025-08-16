package service;

import com.google.gson.Gson;
import model.TaxasCambio;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoedas {
    private static final String CHAVE_API = "fc4265a85d1daed90f14ed2f";
    private static final String URL_API_BASE = "https://v6.exchangerate-api.com/v6/";
    private final HttpClient cliente = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public double converterMoeda(String moedaOrigem, String moedaDestino, double valor) throws Exception {
        TaxasCambio resposta = obterTaxasCambio(moedaOrigem);
        if (resposta == null || !"success".equals(resposta.result())) {
            throw new RuntimeException("Falha ao obter taxas de câmbio: " + (resposta != null ? resposta.result() : "A resposta da API é nula"));
        }
        Double taxa = resposta.conversion_rates().get(moedaDestino);
        if (taxa == null) {
            throw new RuntimeException("Moeda de destino não suportada: " + moedaDestino);
        }
        return valor * taxa;
    }

    private TaxasCambio obterTaxasCambio(String moedaBase) throws Exception {
        String url = URL_API_BASE + CHAVE_API + "/latest/" + moedaBase;
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        if (resposta.statusCode() != 200) {
            throw new RuntimeException("Erro na requisição: Código HTTP " + resposta.statusCode() + " - " + resposta.body());
        }
        return gson.fromJson(resposta.body(), TaxasCambio.class);
    }
}
