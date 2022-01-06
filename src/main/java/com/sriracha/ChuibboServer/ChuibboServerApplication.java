package com.sriracha.ChuibboServer;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableBatchProcessing // 배치 기능 활성화
@EnableScheduling // 스케쥴러 기능 활성화
@SpringBootApplication
@EnableElasticsearchRepositories("com.sriracha.ChuibboServer.repository.elastic")
public class ChuibboServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChuibboServerApplication.class, args);
	}

}
