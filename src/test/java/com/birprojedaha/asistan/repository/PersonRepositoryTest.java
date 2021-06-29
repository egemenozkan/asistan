package com.birprojedaha.asistan.repository;


import com.birprojedaha.asistan.data.jdbc.dao.Address;
import com.birprojedaha.asistan.data.jdbc.dao.person.Person;
import com.birprojedaha.asistan.data.jdbc.dao.person.Role;
import com.birprojedaha.asistan.data.jdbc.repository.PersonRepository;
import com.birprojedaha.asistan.data.jdbc.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    RoleRepository roleRepository;

    @Test
    public void save() {
        Person person = new Person();
        person.setFirstName("Abc");
        person.setLastName("Def");
        person.setEmail("abc.def@email.com");
        Address address = new Address();
        address.setCity("Ayt");
        person.setAddress(address);
        Person personNew = (Person)personRepository.save(person);
        assertEquals(person.getFirstName(), personNew.getFirstName());
    }

    @Test
    public void updateAddress() {

        boolean result = personRepository.updateAddress("Ank", 13);
        Optional<Person> person = personRepository.findById(13);
        assertEquals(person.get().getAddress().getCity(), "Ank");
    }

    @Test
    public void addRoles() {
        Role role = new Role();
        role.setName("ADMIN");
        Role admin = roleRepository.save(role);
        assertEquals("ADMIN", admin.getName());

        Person person = new Person();
        person.setFirstName("Abc");
        person.setLastName("Def");
        person.addRole(admin);
        person.setEmail("abc.def@email.com");
        Address address = new Address();
        address.setCity("Ayt");
        person.setAddress(address);
        Person personNew = (Person)personRepository.save(person);
        assertEquals(person.getFirstName(), personNew.getFirstName());


    }

    @Test
    public void findById() {
        Optional<Person> person = personRepository.findById(19);
        List<Role> roles = roleRepository.findByPersonId(19);
        assertEquals(person.get().getRoleIds().size(), roles.size());

        roles.stream().forEach(r -> {
            System.out.println(r.getId() + " " + r.getName());
        });

    }


}
