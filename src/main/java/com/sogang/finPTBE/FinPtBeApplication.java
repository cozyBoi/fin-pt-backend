package com.sogang.finPTBE;

import com.sogang.finPTBE.utils.HtmlParseUtil;
import com.sogang.finPTBE.utils.secUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.sogang.finPTBE.repository",
		mongoTemplateRef = "studioMongoTemplate")
public class FinPtBeApplication {
	//TODO SEC API

	public static void main(String[] args) {
		secUtil a = SpringApplication.run(FinPtBeApplication.class, args).getBean(secUtil.class);
//		a.saveTickerJsonToMongo();
		System.out.println(a.getFinancialStatementByTicker("AAPL"));
	}
}

// 투자하기 좋은 상위 10개 회사 추천
// 시총 쓰레시 홀드에서 좋은 상위 10개 회사 (즉, 조건별 : 은행 내부 ... )
// 어제 떨어졌는데 왜 떨어졌는지?
// 질문 제한 (제안하는?)