package cg.powersoft.server.cityhall.service;

import cg.powersoft.server.cityhall.dao.*;
import cg.powersoft.server.cityhall.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class DeclarationInitServiceImpl implements IDeclarationInitService {

    //Injection des dependances
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private NationaliteRepository nationaliteRepository;
    @Autowired
    private PereRepository pereRepository;
    @Autowired
    private MereRepository mereRepository;
    @Autowired
    private EnfantRepository enfantRepository;
    @Autowired
    private  DeclarationRepository declarationRepository;

    @Override
    public void initDocuments() {
        double prices[] = {2500,500,250};
        Stream.of("Acte de naissance","Copie d'acte de Naissance","Extrait d'acte de Naissance").forEach(doc->{
            Document document = new Document();
            document.setLibDocument(doc);
            for (int i = 0; i < prices.length;i++){
                document.setPrix(prices[new Random().nextInt(prices.length)]);
            }
            documentRepository.save(document);
        });
    }

    @Override
    public void initNationalites() {
        Stream.of("Congolaise","Camerounaise","Espagnole","Americaine","Canadienne","Française").forEach(nameNat->{
            Nationalite nationalite = new Nationalite();
            nationalite.setDescription(nameNat);
            nationaliteRepository.save(nationalite);
        });
    }

    @Override
    public void initPeres() {
        nationaliteRepository.findAll().forEach(nationalites -> {
            Stream.of("Ben","Abraham","Samuel","John","Blaise","Benoit").forEach(NomPere->{
                Pere pere = new Pere();
                pere.setNom(NomPere);
                pere.setNationalite(nationalites);
                pereRepository.save(pere);
            });
        });
    }

    @Override
    public void initMeres() {
        nationaliteRepository.findAll().forEach(nationalites -> {
            Stream.of("Dahlia","Aline","Samuela","John","Blaisga","Benoite").forEach(NomMere->{
                Mere mere = new Mere();
                mere.setNom(NomMere);
                mere.setNationalite(nationalites);
                mereRepository.save(mere);
            });
        });
    }

    @Override
    public void initEnfants() {
        pereRepository.findAll().forEach(nomPere -> {
            mereRepository.findAll().forEach(nomMere->{
                Stream.of("MABOUNDOU","MAKOUANGOU","YUMBA","BATANTOU").forEach(nomEnfant->{
                    Stream.of("Teddy","Sbrina","Willy","Salif").forEach(prenomEnfant->{
                        Stream.of("Masculin,Feminin").forEach(sexeEnfant->{
                            Stream.of("Brazzaville","Pointe-Noire","Dolisie","Ouesso").forEach(LieuNaiss->{
                                Stream.of("1h","2h","3h","4h","5h","6h","7h","8h","9h","10h","11h","12h").forEach(heureNaiss->{
                                    Stream.of("Marie","Fiance","Union libre").forEach(SituationMatriParent->{
                                        Enfant enfant = new Enfant();
                                        enfant.setNom(nomEnfant);
                                        enfant.setPrenom(prenomEnfant);
                                        enfant.setSexe(sexeEnfant);
                                        //enfant.setDateNaiss(new Date());
                                        enfant.setLieuxNaiss(LieuNaiss);
                                        enfant.setSituationMatriParent(SituationMatriParent);
                                        enfant.setPere(nomPere);
                                        enfant.setMere(nomMere);

                                        enfantRepository.save(enfant);
                                    });
                                });
                            });
                        });
                    });
                });

            });
            });

    }

    @Override
    public void initDeclarations() {
        enfantRepository.findAll().forEach(nomEnfant->{
            documentRepository.findAll().forEach(docs->{
                Declaration declaration = new Declaration();
                declaration.setEnfant(nomEnfant);
                declaration.setDocument(docs);
                declarationRepository.save(declaration);
            });
        });
    }
}
