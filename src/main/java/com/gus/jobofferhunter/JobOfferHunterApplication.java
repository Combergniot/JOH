package com.gus.jobofferhunter;

import com.google.common.collect.Sets;
import com.gus.jobofferhunter.model.user.Role;
import com.gus.jobofferhunter.model.user.RoleRepository;
import com.gus.jobofferhunter.model.user.User;
import com.gus.jobofferhunter.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JobOfferHunterApplication implements CommandLineRunner {

    //   @Autowired
    // private MainService mainService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
//    @Autowired
//    private AddFakeData addFakeData;

    public static void main(String[] args) {
        SpringApplication.run(JobOfferHunterApplication.class, args);

    }

    @Override
    public void run(String... strings) throws Exception {
        Role userRole = roleRepository.save(new Role("USER"));

//        userRepository.save(new User("admin", bCryptPasswordEncoder.encode("admin"),
//                Sets.newHashSet(adminRole)));
        userRepository.save(new User("user", bCryptPasswordEncoder.encode("user"),
                Sets.newHashSet(userRole)));

        System.out.println(userRepository.findByUsername("user"));
//        System.out.println(roleRepository.findRolesByUsername("admin"));


//        addFakeData.addData();

    }
}
