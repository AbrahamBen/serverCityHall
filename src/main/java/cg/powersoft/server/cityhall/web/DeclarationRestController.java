package cg.powersoft.server.cityhall.web;

import cg.powersoft.server.cityhall.dao.Document;
import cg.powersoft.server.cityhall.dao.Enfant;
import cg.powersoft.server.cityhall.dao.Mere;
import cg.powersoft.server.cityhall.dao.Pere;
import cg.powersoft.server.cityhall.entities.DocumentRepository;
import cg.powersoft.server.cityhall.entities.EnfantRepository;
import cg.powersoft.server.cityhall.entities.MereRepository;
import cg.powersoft.server.cityhall.entities.PereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
/*
Cette API gere les images du systeme
 */
@RestController
public class DeclarationRestController {

    //Injection de depedances
    @Autowired
    MereRepository mereRepository;
    @Autowired
    PereRepository pereRepository;
    @Autowired
    EnfantRepository enfantRepository;

    //Traite l'image de l'enfant

    @GetMapping(path = "/childPicture/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getChildPicture(@PathVariable(name="id")Long id)  throws Exception{
        Enfant enfant = enfantRepository.findById(id).get();
        String imageName = enfant.getImageDeclaration();
        File file = new File(System.getProperty("user.home")+"/Pictures/"+imageName);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }


    //Traite l'image du pere
    @GetMapping(path = "/fatherdPicture/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getFatherPicture(@PathVariable(name="id")Long id)  throws Exception{
        Pere pere = pereRepository.findById(id).get();
        String imageName = pere.getImagePieceIdentite();
        File file = new File(System.getProperty("user.home")+"declaration/pictures/"+imageName);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    //Traite l'image de la mere
    @GetMapping(path = "/matherdPicture/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getMatherPicture(@PathVariable(name="id")Long id)  throws Exception{
        Mere mere = mereRepository.findById(id).get();
        String imageName = mere.getImagePieceIdentite();
        File file = new File(System.getProperty("user.home")+"declaration/pictures/"+imageName);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }




}
