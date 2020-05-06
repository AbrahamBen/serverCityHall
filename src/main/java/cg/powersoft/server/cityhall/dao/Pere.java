package cg.powersoft.server.cityhall.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Pere implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String nom;
    @Column(length = 50)
    private String prenom;
    private Date dateNaiss;
    @Column(length = 100)
    private String lieuNaiss;
    @ManyToOne
    private Nationalite nationalite;
    @Column(length = 150)
    private String domicile;
    @Column(length = 50)
    private String profession;
    private String niveauInstruction;
    @OneToMany(mappedBy = "pere")
    private Collection<Enfant>enfants;
    private String imagePieceIdentite;

}
