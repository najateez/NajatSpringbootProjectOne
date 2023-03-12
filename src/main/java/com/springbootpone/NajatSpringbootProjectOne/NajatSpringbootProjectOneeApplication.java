package com.springbootpone.NajatSpringbootProjectOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// in pom.xml page to connect jar dependency to your project library, write in google: oracle maven dependency
//https://mvnrepository.com/artifact/com.oracle/ojdbc14

/* when you want to add any new jar in pom.xml --> put that dependency in pom.xml ,then right click in this page
   --> click Maven -> Reload project->then will be fixed. with no error.
 */

/* Note:
 1) (with spring data): ->spring data is a framework
    - repo.save(entiy); -> for insert and update.
    - repo.findById(id which is in school model property) -> get user from db
    */
@SpringBootApplication
public class NajatSpringbootProjectOneeApplication {

	public static void main(String[] args) {

		SpringApplication.run(NajatSpringbootProjectOneeApplication.class, args);
	}

}
