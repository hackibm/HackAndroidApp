package hackathon.mms.app.repository;

import java.util.List;

import hackathon.mms.app.model.DistrictOffice;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by EKolodziejska on 2016-11-28.
 */

public interface RepositoryService {

    @GET("graphql")
    Observable<List<DistrictOffice>> getDistrictOffices();
}
