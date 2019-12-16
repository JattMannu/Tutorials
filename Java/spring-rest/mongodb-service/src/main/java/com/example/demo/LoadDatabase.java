package com.example.demo;

import com.example.demo.configuration.ProfileManager;
import com.example.demo.model.*;
import com.example.demo.repository.ResumeRepository;
import com.example.demo.service.*;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.bson.BsonDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@Slf4j
@Profile("dev")
class LoadDatabase {

//    @Value("classpath:resume.json")
//    private File resourceFile;

    @Autowired
    @Qualifier("resumeFile")
    private File resourceFile;

    @Bean
    CommandLineRunner initDatabase(ResumeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Resume(1, "Bilbo Baggins", "burglar", new PersonalProfile(1, "asd"))));
            log.info("Preloading " + repository.save(new Resume(2, "Frodo Baggins", "thief", new PersonalProfile(2, "asd"))));
        };
    }


    @Bean
    CommandLineRunner initPersonalProfile(PersonalProfileService service) {
        return args -> {
            log.info("Preloading " + service.save(new PersonalProfile(1, "I am working as a postdoctoral fellow in Indian Institute of Technology Ropar, India. I have successfully defended my Ph.D. thesis entitled \\u201cComputational studies of selected gas hydrates and hydrate melts\\u201d under the supervision of Dr. C. N. Ramachandran. My areas of expertize are computational chemistry, quantum chemical studies, electronic structure properties of chemical systems, energy storage and transportation materials, weak interactions, vibrational Raman spectroscopy, nuclear magnetic resonance spectroscopy, classical molecular dynamics")));
        };
    }


    @Bean
    CommandLineRunner initResearchExperiences(ResearchExperiencesService service) throws IOException {

        BsonDocument doc = BsonDocument.parse(Files.readString(resourceFile.toPath()));
        ResearchExperiences researchExperiences = new ResearchExperiences(1);
        List<ResearchExperiences.ResearchExperience> experiences = new LinkedList<>();

        String label = doc.getDocument("researchExperience").getString("title").getValue();
        researchExperiences.setLabel(label);

        doc.getDocument("researchExperience").getArray("data").forEach(bsonValue -> {
            String position = bsonValue.asDocument().getString("title").getValue();
            String supervisor = bsonValue.asDocument().getString("subTitle1").getValue();
            String title = bsonValue.asDocument().getString("subTitle2").getValue();
            if (bsonValue.asDocument().containsKey("points")) {
                List<String> points = bsonValue.asDocument().getArray("points").stream().map(point -> point.asString().getValue()).collect(Collectors.toList());
                experiences.add(researchExperiences.new ResearchExperience(position, supervisor, title, points));
            }
        });

        researchExperiences.setResearchExperiences(experiences);


        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                log.info("Preloading " + service.save(researchExperiences));
            }
        };
    }

    @Bean
    CommandLineRunner initSkills(SkillsService service) throws IOException {

        BsonDocument doc = BsonDocument.parse(Files.readString(resourceFile.toPath()));
        List<Skills.Skill> skills_list = new LinkedList<>();

        Skills skills = new Skills(1);

        String label = doc.getDocument("skills").getString("title").getValue();
        skills.setLabel(label);

        doc.getDocument("skills").getArray("data").forEach(bsonValue -> {
            String url = bsonValue.asDocument().getString("url").getValue();
            String skill = bsonValue.asDocument().getString("skill").getValue();
            skills_list.add(skills.new Skill(url, skill));
            skills.setSkills(skills_list);
        });

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                log.info("Preloading " + service.save(skills));
            }
        };
    }


    @Bean
    CommandLineRunner initAwards(AwardsService service) throws IOException {

        BsonDocument doc = BsonDocument.parse(Files.readString(resourceFile.toPath())).getDocument("awards");

        List<Awards.Award> awardList = new LinkedList<>();
        Awards awards = new Awards(1);

        String label = doc.getString("title").getValue();
        awards.setLabel(label);

        doc.getArray("data").forEach(bsonValue -> {
            awardList.add(awards.new Award(bsonValue.asString().getValue()));
            awards.setAwards(awardList);
        });

        return args -> log.info("Preloading " + service.save(awards));
    }


    @Bean
    CommandLineRunner initFellowships(FellowshipsService service) throws IOException {

        BsonDocument doc = BsonDocument.parse(Files.readString(resourceFile.toPath())).getDocument("fellowships");

        List<Fellowships.Fellowship> fellowshipList = new LinkedList<>();
        Fellowships fellowships = new Fellowships(1);
        fellowships.setLabel(doc.getString("title").getValue());

        doc.getArray("data").forEach(bsonValue -> {
            fellowshipList.add(fellowships.new Fellowship(bsonValue.asString().getValue()));
            fellowships.setFellowships(fellowshipList);
        });

        return args -> log.info("Preloading " + service.save(fellowships));
    }


    @Bean
    CommandLineRunner printActiveProfiles(@Autowired ProfileManager profileManager) {
        return args -> {
            profileManager.getActiveProfiles();
        };
    }



//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
//    }

    @Bean(name = "resumeFile")
    File getResumeFile() throws IOException {
        ClassPathResource cpr = new ClassPathResource("resume.json");
        return cpr.getFile();
    }


}