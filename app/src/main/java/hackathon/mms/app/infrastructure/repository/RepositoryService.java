package hackathon.mms.app.infrastructure.repository;

import java.util.List;

import hackathon.mms.app.infrastructure.graphql.DataModel;
import hackathon.mms.app.infrastructure.graphql.DataModelOffice;
import hackathon.mms.app.shared.model.DistrictOffice;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by EKolodziejska on 2016-11-28.
 */

public interface RepositoryService {

    @GET("/graphql")
    Observable<DataModel<DataModelOffice>> getDistrictOffices(@Query("query") String query);
}
