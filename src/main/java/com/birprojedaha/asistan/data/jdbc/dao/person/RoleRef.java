package com.birprojedaha.asistan.data.jdbc.dao.person;

import org.springframework.data.relational.core.mapping.Table;

@Table("person_role")
public class RoleRef {
    private int roleId;

    public RoleRef(int roleId) {
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }
}
