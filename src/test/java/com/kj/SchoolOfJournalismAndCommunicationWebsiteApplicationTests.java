package com.kj;

import com.kj.dto.NewsPaging;
import com.kj.service.NewsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SchoolOfJournalismAndCommunicationWebsiteApplicationTests {

    @Autowired
    NewsService newsService;

    @Test
    void contextLoads() {
    }

}
