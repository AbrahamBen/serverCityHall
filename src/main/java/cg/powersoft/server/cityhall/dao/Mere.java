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
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Mere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaiss;
    private String lieuNaiss;
    @ManyToOne
    private Nationalite nationalite;
    private String domicile;
    private String profession;
    private String niveauInstruction;
    private String imagePieceIdentite;
    @OneToMany(mappedBy = "mere")
    private Collection<Enfant> enfants;

}
