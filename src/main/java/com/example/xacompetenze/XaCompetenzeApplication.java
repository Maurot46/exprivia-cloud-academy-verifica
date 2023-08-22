package com.example.xacompetenze;

import com.example.xacompetenze.models.Patrimonio;
import com.example.xacompetenze.repositories.PatrimonioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class XaCompetenzeApplication {
	@Autowired
	private PatrimonioRepository ps;
	private final Logger log = LoggerFactory.getLogger(XaCompetenzeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(XaCompetenzeApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() throws Exception {
		return args -> {
			log.info("");
			log.info("-------------------------------");
			Patrimonio p = ps.findById(1L);
			log.info("FIND BY ID 1L");
			log.info(p.toString());
			log.info("");

			log.info("-------------------------------");
			Patrimonio p2 = ps.findByName("PATRIMONIO");
			log.info("FIND BY NAME 'PATRIMONIO'");
			log.info(p2.toString());
			log.info("");

			log.info("-------------------------------");
			log.info("FIND BY NAME VALORE");
			ps.findByValue(23000).forEach(valore ->
					log.info(valore.toString())
			);
			log.info("");

			log.info("-------------------------------");
			log.info("FIND BY NAME ANNO DI CREAZIONE");
			ps.findByAnnoCreazione(1981).forEach(anno ->
					log.info(anno.toString())
			);
			log.info("");
		};
	}
}
