package Aula1;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class FilmesBemAvaliados {

	public static void main(String[] args) throws Exception, InterruptedException {
		
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		URI uri = URI.create(url);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(uri).GET().build(); 
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);
		
		System.out.println("Top 10 filmes mais bem avaliados:\n");

		for(Map<String,String> filme: listaDeFilmes) {
			System.out.println(filme.get("rank")+") "+filme.get("title")+": "+ filme.get("imDbRating"));
		}
			
	
	}
}
