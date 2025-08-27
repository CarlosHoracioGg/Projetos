import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Servidor {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/api/pharmacies", new FarmaciaHandler());
        server.setExecutor(null);
        System.out.println("Servidor rodando em http://localhost:8080/api/pharmacies");
        server.start();
    }

    static class FarmaciaHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                String json = """
                    [
                        {
                            "name": "Farmácia Solidária Central",
                            "address": "Rua A, 123 - Centro",
                            "description": "Atende a comunidade carente",
                            "lat": -23.55052,
                            "lng": -46.633308
                        },
                        {
                            "name": "Farmácia Esperança",
                            "address": "Av. B, 456 - Bairro X",
                            "description": "Medicamentos a baixo custo",
                            "lat": -23.553,
                            "lng": -46.64
                        },
                        {
                            "name": "Farmácia Popular da Saúde",
                            "address": "Rua C, 789 - Bairro Y",
                            "description": "Doações de medicamentos",
                            "lat": -23.547,
                            "lng": -46.63
                        }
                    ]
                """;

                exchange.getResponseHeaders().add("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, json.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(json.getBytes());
                os.close();
            } else {
                exchange.sendResponseHeaders(405, -1); // Método não permitido
            }
        }
    }
}
