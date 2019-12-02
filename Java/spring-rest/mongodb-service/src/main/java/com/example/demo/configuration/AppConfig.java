package com.example.demo.configuration;


import com.example.demo.model.Resume;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Configuration
public class AppConfig  implements BeanFactoryPostProcessor {

    //mongodb://<dbuser>:<dbpassword>@ds036648.mlab.com:36648/surinderpal_cms
    //mongodb://<dbuser>:<dbpassword>@ds012889.mlab.com:12889/rubbish
//    public @Bean MongoClient mongoClient() {
//        MongoClient client = new MongoClient("ds012889.mlab.com", 12889);
//        return client;
//    }
//
//    protected String getDatabaseName() {
//        return "surinderpal_cms";
//    }
//
//    @Bean
//    public MongoDbFactory mongoDbFactory() {
//        return new SimpleMongoClientDbFactory(
//                MongoClients.create(new ConnectionString("simmi1:simmi1@ds012889.mlab.com:12889")), "rubbish");
//    }

    @Bean
    public RestTemplate geRestTemplate() {
        return new RestTemplate();
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void initIndicesAfterStartup(MongoTemplate mongoTemplate, MongoMappingContext mongoMappingContext) {
//
//        IndexOperations indexOps = mongoTemplate.indexOps(Resume.class);
//
//        IndexResolver resolver = new MongoPersistentEntityIndexResolver(mongoMappingContext);
//        resolver.resolveIndexFor(Resume.class).forEach(indexOps::ensureIndex);
//    }


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        log.info("postProcessBeanFactory Triggered");

    }
}
