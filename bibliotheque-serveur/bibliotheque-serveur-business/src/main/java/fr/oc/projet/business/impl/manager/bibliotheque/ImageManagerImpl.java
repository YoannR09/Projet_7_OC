package fr.oc.projet.business.impl.manager.bibliotheque;

import fr.oc.projet.business.contract.manager.bibliotheque.ImageManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.bibliotheque.Image;

import javax.inject.Named;
import java.util.List;

@Named
public class ImageManagerImpl extends AbstractManagerImpl implements ImageManager {
    @Override
    public Image getImage(Integer pId) {
        return getDaoFactory().getImageDao().getImage(pId);
    }

    @Override
    public List<Image> getListImage() {
        return getDaoFactory().getImageDao().getListImage();
    }
}
