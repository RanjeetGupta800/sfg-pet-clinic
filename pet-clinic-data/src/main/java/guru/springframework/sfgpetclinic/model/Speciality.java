package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.BaseEntity;

public class Speciality extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
