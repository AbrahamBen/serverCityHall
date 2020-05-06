package cg.powersoft.server.cityhall.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Enfant implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 70)
    private String nom;
    @Column(length = 70)
    private String prenom;
    @Column(length = 70)
    private String sexe;
    @Temporal(TemporalType.DATE)
    private Date dateNaiss;
    @Column(length = 70)
    private String lieuxNaiss;
    @Temporal(TemporalType.TIME)
    private Date heureNaiss;
    //private Nationalite nationalite;
    @Column(length = 70)
    private String situationMatriParent;
    private String imageDeclaration;
    @ManyToOne
    @NotNull
    private Pere pere;
    @ManyToOne
    private Mere mere;

}
