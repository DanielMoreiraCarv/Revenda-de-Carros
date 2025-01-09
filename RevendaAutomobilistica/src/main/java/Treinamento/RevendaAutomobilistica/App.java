package Treinamento.RevendaAutomobilistica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "Treinamento.RevendaAutomobilistica.Class") // Certifique-se de que este caminho está correto
public class App {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(App.class);
//	        Map<String, Object> defaultProperties = new HashMap<>();
//	        defaultProperties.put("server.port", 8081);  // Define a porta desejada
//	        app.setDefaultProperties(defaultProperties);
		app.run(args);
		
	}

}
