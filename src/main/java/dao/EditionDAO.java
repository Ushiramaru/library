package dao;

import bean.Edition;

public interface EditionDAO {

    void addEdition(Edition edition);
    void deleteEdition(long id);
    void delete(Edition edition);

}
