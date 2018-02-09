package hr.ana.library.business.boundary;

import hr.ana.library.business.entity.Author;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

@Named
@ApplicationScoped
public class AuthorConverter implements Converter {

    @EJB
    private AuthorFacade authorFacade;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Author author = (Author) value;
        String idAsString = String.valueOf(author.getId());
        return idAsString;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.valueOf(value);
        Author author = authorFacade.find(id);
        return author;
    }

}
