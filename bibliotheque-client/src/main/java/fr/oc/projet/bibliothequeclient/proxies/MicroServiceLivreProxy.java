package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Livre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-livre", url = "localhost:9094")
public interface MicroServiceLivreProxy {

    @GetMapping(value = "/Livre/{id}")
    Livre getLivre(@PathVariable("id") int id);

    @GetMapping(value = "/Livre/Categorie/{categorieId}")
    List<Livre> findLivreByCategorieId(@PathVariable("categorieId") int categorieId);


    @GetMapping(value = "/Livre/TitreAuteurISBN/{titre},{auteur},{isbn}")
    List<Livre> findLivresByTitreAndAuteurAndIsbn(@PathVariable("titre") String titre, @PathVariable("auteur") String auteur, @PathVariable("isbn") String isbn );


    @GetMapping(value = "/Livre/AuteurISBN/{auteur},{isbn}")
    List<Livre> findLivresByAuteurContainingAndIsbnContaining(@PathVariable("auteur") String auteur, @PathVariable("isbn") String isbn);


    @GetMapping(value = "/Livre/TitreISBN/{titre},{isbn}")
    List<Livre> findLivresByTitreContainingAndIsbnContaining(@PathVariable("titre") String titre,@PathVariable("isbn") String isbn );


    @GetMapping(value = "/Livre/TitreAuteur/{titre},{auteur}")
    List<Livre> findLivresByTitreContainingAndAuteurContaining(@PathVariable("titre") String titre,@PathVariable("auteur") String auteur);



    @GetMapping(value = "/Livre/Titre/{titre}")
     List<Livre> findLivresByTitreContaining(@PathVariable("titre") String titre);


    @GetMapping(value = "/Livre/Auteur/{auteur}")
    List<Livre> findLivresByAuteurContaining(@PathVariable("auteur") String auteur);

    @GetMapping(value = "/Livre/ISBN/{isbn}")
    List<Livre> findLivresByIsbnContaining(@PathVariable("isbn") String isbn);

    @GetMapping(value = "/Livre/TitreAuteurISBNCategorie/{titre},{auteur},{isbn},{categorieId}")
    List<Livre> findLivresByTitreAndAuteurAndIsbnAndCategorieId(@PathVariable("titre") String titre,@PathVariable("auteur") String auteur,@PathVariable("isbn") String isbn,@PathVariable("categorieId") int categorieId);

    @GetMapping(value = "/Livre/AuteurISBNCategorie/{auteur},{isbn},{categorieId}")
    List<Livre> findLivresByAuteurContainingAndIsbnContainingAndCategorieId(@PathVariable("auteur") String auteur, @PathVariable("isbn") String isbn,@PathVariable("categorieId") int categorieId);

    @GetMapping(value = "/Livre/TitreISBNCategorie/{titre},{isbn},{categorieId}")
    List<Livre> findLivresByTitreContainingAndIsbnContainingAndCategorieId(@PathVariable("titre") String titre,@PathVariable("isbn") String isbn,@PathVariable("categorieId") int categorieId );


    @GetMapping(value = "/Livre/TitreAuteurCategorie/{titre},{auteur},{categorieId}")
    List<Livre> findLivresByTitreContainingAndAuteurContainingAndCategorieId(@PathVariable("titre") String titre,@PathVariable("auteur") String auteur,@PathVariable("categorieId") int categorieId);


    @GetMapping(value = "/Livre/TitreCategorie/{titre},{categorieId}")
    List<Livre> findLivresByTitreContainingAndCategorieId(@PathVariable("titre") String titre,@PathVariable("categorieId") int categorieId);


    @GetMapping(value = "/Livre/AuteurCategorie/{auteur},{categorieId}")
     List<Livre> findLivresByAuteurContainingAndCategorieId(@PathVariable("auteur") String auteur,@PathVariable("categorieId") int categorieId);


    @GetMapping(value = "/Livre/ISBNCategorie/{isbn},{categorieId}")
    List<Livre> findLivresByIsbnContainingAndCategorieId(@PathVariable("isbn") String isbn,@PathVariable("categorieId") int categorieId);


}
