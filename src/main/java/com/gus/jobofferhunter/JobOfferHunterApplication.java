package com.gus.jobofferhunter;

import com.google.common.collect.Sets;
import com.gus.jobofferhunter.model.user.Role;
import com.gus.jobofferhunter.model.user.RoleRepository;
import com.gus.jobofferhunter.model.user.User;
import com.gus.jobofferhunter.model.user.UserRepository;
import com.gus.jobofferhunter.repository.GratkaRepository;
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
    private GratkaRepository gratkaRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public static void main(String[] args) throws Exception {
        SpringApplication.run(JobOfferHunterApplication.class, args);

    }

    @Override
    public void run(String... strings) throws Exception {

        Role userRole = roleRepository.save(new Role("USER"));
//        userRepository.save(new User("admin", bCryptPasswordEncoder.encode("admin"),
//                Sets.newHashSet(adminRole)));
        userRepository.save(new User("test", bCryptPasswordEncoder.encode("test"),
                Sets.newHashSet(userRole)));
        System.out.println(userRepository.findByUsername("test"));
//        System.out.println(roleRepository.findRolesByUsername("admin"))


//        final String USER_AGENT =
//                "Mozilla/5.0 (Windows NT 6.1; WOW64) " +
//                        "AppleWebKit/537.36 (KHTML, like Gecko) " +
//                        "Chrome/45.0.2454.101 Safari/537.36";
//        final String REFERRER = "http://www.google.com";
//              List<String> urls = new ArrayList<>();
//
//        int queryNumber = 1;
//            for (int i = 0; i <= 270; i++) {
//            Document doc = Jsoup.connect("http://praca.gratka.pl/lista/wszystkie--" + queryNumber)
//                    .proxy("10.51.55.34", 8080)
//                    .userAgent(USER_AGENT)
//                    .referrer(REFERRER)
////                    .timeout(12000)
//                    .followRedirects(true)
//                    .get();
//
//            Element content = doc.getElementById("wyniki-wyszukiwania");
//            Elements url = content.select("a.stanowisko");
//
//
//            for (Element element : url) {
//                String link = element.attr("href");
//
//
//                urls.add("http://praca.gratka.pl" + link);
//
//            }
//
//            queryNumber++;
//
//        }
//
//         for (int i = 0; i < urls.size(); i++) {
//            Document document = Jsoup.connect(urls.get(i))
//                    .proxy("10.51.55.34", 8080)
//                    .userAgent(USER_AGENT)
//                    .referrer(REFERRER)
////                    .timeout(12000)
//                    .followRedirects(true)
//                    .get();
//
//            Elements jobOfferURL = document.select("section#info-ogolne");
//            Elements alterantive = document.select("article#ogloszenie-praca");
//
//            for (Element element : jobOfferURL) {
//                Gratka gratka = new Gratka();
//                gratka.setPosition(element.select("header").text());
//                if (gratka.getPosition().isEmpty()) {
//                    gratka.setPosition(alterantive.select("h1").text());
//                }
//
//                gratka.setDateAdded(
//                        element.getElementsContainingOwnText("Data ogłoszenia").next().text());
//                gratka.setCountry(
//                        element.getElementsContainingOwnText("Kraj").next().text());
//                gratka.setProvince(
//                        element.getElementsContainingOwnText("Region").next().text());
//                gratka.setWorkplace(
//                        element.getElementsContainingOwnText("Lokalizacja").next().text());
//                gratka.setEmployer(
//                        element.getElementsContainingOwnText("Pracodawca").next().text());
//                gratka.setBranch(
//                        element.getElementsContainingOwnText("Branża").next().text());
//                gratka.setJobType(
//                        element.getElementsContainingOwnText("Typ stanowiska").next().text());
//                gratka.setTypeOfWork(
//                        element.getElementsContainingOwnText("Rodzaj pracy").next().text());
//                gratka.setFormOfEmployment(
//                        element.getElementsContainingOwnText("Forma zatrudnienia").next().text());
//                gratka.setRequiredEducation(
//                        element.getElementsContainingOwnText("Minimalne wykształcenie")
//                                .next().text());
//                gratka.setSalary(element.getElementsContainingOwnText("Wynagrodzenie")
//                        .next().text());
//                gratka.setOfferFromNewspapper(
//                        element.getElementsByTag("img").attr("alt"));
//                gratka.setAdditionalOptions(element.getElementsContainingOwnText("Opcje dodatkowe").next().text());
//
//                gratkaRepository.save(gratka);
//            }
//
//        }

    }
}
