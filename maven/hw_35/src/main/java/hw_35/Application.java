package hw_35;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger("log");

	public static void main(String[] args) {
		log.info("==========================================================================");
		log.info("application start ...");
		log.info("Time: "+ new Timestamp(System.currentTimeMillis()));
		log.debug("application finish ...");
		log.debug("==========================================================================");
		SpringApplication.run(Application.class, args);
	}

}
