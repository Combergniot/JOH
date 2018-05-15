package com.gus.jobofferhunter;

import com.gus.jobofferhunter.data.*;
import com.gus.jobofferhunter.model.user.RoleRepository;
import com.gus.jobofferhunter.model.user.UserRepository;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JobOfferHunterApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JobOfferHunterApplication.class);

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    GratkaDataCollector gratkaDataCollector;
    @Autowired
    MoneyPlDataCollector moneyPlDataCollector;
    @Autowired
    OlxDataCollector olxDataCollector;
    @Autowired
    PracujPlDataCollector pracujPlDataCollector;
    @Autowired
    GoldenLineDataCollector goldenLineDataCollector;
    @Autowired
    LinkedinDataCollector linkedinDataCollector;
    @Autowired
    JobsPlDataCollector jobsPlDataCollector;
    @Autowired
    AllTheJobsCollector allTheJobsCollector;
    @Autowired
    GumtreeCollector gumtreeCollector;
    @Autowired
    CareerJetCollector careerJetCollector;
    @Autowired
    InfoPracaCollector infoPracaCollector;


    public static void main(String[] args) {
        SpringApplication.run(JobOfferHunterApplication.class, args);

    }

    @Override
    public void run(String... strings) throws Exception {

//        Role userRole = roleRepository.save(new Role("USER"));
////        userRepository.save(new User("admin", bCryptPasswordEncoder.encode("admin"),
////                Sets.newHashSet(adminRole)));
//        userRepository.save(new User("test2", bCryptPasswordEncoder.encode("test2"),
//                Sets.newHashSet(userRole)));
//        System.out.println(userRepository.findByUsername("test2"));
////        System.out.println(roleRepository.findRolesByUsername("admin"))

    infoPracaCollector.downloadAll();

    }
}
