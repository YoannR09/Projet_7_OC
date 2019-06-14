package fr.oc.projet.consumer.contract.dao.bibliotheque;

import fr.oc.projet.model.beans.bibliotheque.Image;

import java.util.List;

public interface ImageDao {

    Image getImage(Integer pId);

    List<Image> getListImage();

}
