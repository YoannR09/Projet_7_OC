package fr.oc.projet.business.contract.manager.bibliotheque;

import fr.oc.projet.model.beans.bibliotheque.Image;

import java.util.List;

public interface ImageManager {

    Image getImage(Integer pId);

    List<Image> getListImage();

}
