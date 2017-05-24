package beans;

import config.DatabaseDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class NamesRepository {

    private DatabaseDatasource ds;

    @Autowired
    public NamesRepository(DatabaseDatasource ds){
        this.ds = ds;
    }

    public List<String> getAll() {
        return ds.getDatabase();
    }

}
