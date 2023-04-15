package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="specialities")
public class Speciality extends BaseEntity {
    @Column(name="description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
