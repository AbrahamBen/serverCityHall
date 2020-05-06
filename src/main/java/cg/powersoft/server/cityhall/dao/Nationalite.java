package cg.powersoft.server.cityhall.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Nationalite implements Serializable {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String description;

    @OneToMany(mappedBy = "nationalite")
    private Collection<Pere>peres;
    @OneToMany(mappedBy = "nationalite")
    private Collection<Mere>meres;

}
