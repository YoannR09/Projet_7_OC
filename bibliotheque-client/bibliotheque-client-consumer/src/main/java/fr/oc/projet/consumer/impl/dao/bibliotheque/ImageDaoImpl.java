package fr.oc.projet.consumer.impl.dao.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.ImageDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.model.beans.bibliotheque.Image;

import javax.inject.Named;
import java.util.List;

@Named
public class ImageDaoImpl extends AbstractDaoImpl implements ImageDao {


    @Override
    public Image getImage(Integer pId) {
        return null;
    }

    @Override
    public List<Image> getListImage() {
        return null;
    }
}
