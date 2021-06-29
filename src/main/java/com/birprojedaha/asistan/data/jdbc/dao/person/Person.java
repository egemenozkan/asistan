package com.birprojedaha.asistan.data.jdbc.dao.person;

import com.birprojedaha.asistan.data.jdbc.dao.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Table("person")
public class Person implements Serializable {
    private static final long serialVersionUID = 4356249321371181368L;

    @Id
    protected int id;
    @Column("first_name")
    protected String firstName;
    @Column("last_name")
    protected String lastName;
    protected String email;
    @MappedCollection(idColumn = "person_id")
    protected Address address;

    @MappedCollection(idColumn = "person_id")
    protected Set<RoleRef> roles = new HashSet<>();

    public Person(int id) {
        this.id = id;
    }

    public Person() {
    }

    public void addRole(Role role) {
        roles.add(new RoleRef(role.getId()));
    }

    public Set<Integer> getRoleIds() {
        return this.roles.stream().map(RoleRef::getRoleId).collect(Collectors.toSet());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
