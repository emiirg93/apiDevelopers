package com.api.developers.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String firstName;
    private String lastName;
    private Long edad;
    private String espacialidad;
    private String description;

    public Developer() {
    }

    public Developer(String firstName, String lastName, Long edad, String espacialidad, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.edad = edad;
        this.espacialidad = espacialidad;
        this.description = description;
    }

    public Long getId() {
        return id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getEdad() {
        return edad;
    }

    public void setEdad(Long edad) {
        this.edad = edad;
    }

    public String getEspacialidad() {
        return espacialidad;
    }

    public void setEspacialidad(String espacialidad) {
        this.espacialidad = espacialidad;
    }

    public Map<String,Object> makeDeveloperDTO(){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id",this.getId());
        dto.put("nombre",this.getFirstName());
        dto.put("apellido",this.getLastName());
        dto.put("edad",this.getEdad());
        dto.put("especialidad",this.getEspacialidad());
        dto.put("descripcion",this.getDescription());

        return dto;
    }
}
