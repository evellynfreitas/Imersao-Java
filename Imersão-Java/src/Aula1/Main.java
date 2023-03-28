package Aula1;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Main {

	public static void main(String[] args) {
		
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		URI endereco = URI.create(url);
		HttpClient cliente = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build(); 
	}

}
