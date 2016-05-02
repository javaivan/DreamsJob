package com.ivanmix.model;

public class Role {

    private final String rule;


    public Role(final String rule){
        this.rule = rule;
    }

    public String getRule(){
        return this.rule;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rule='" + rule + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;
        return rule.equals(role.rule);
    }

    @Override
    public int hashCode() {
        return rule.hashCode();
    }
}
