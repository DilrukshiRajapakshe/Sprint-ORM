package rest.repository;

import org.hibernate.Session;

public interface SuperRepository {

    Session getSession();

}
