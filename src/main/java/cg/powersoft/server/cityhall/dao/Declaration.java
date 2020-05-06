package cg.powersoft.server.cityhall.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Declaration implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private double total;

    @OneToOne
    private Enfant enfant;
   @OneToOne
    private Document document;
}
