package hackathon.mms.app.infrastructure.repository;

import hackathon.mms.app.infrastructure.graphql.DataModel;
import hackathon.mms.app.infrastructure.graphql.DataModelOffice;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;



public interface RepositoryService2 {

    @GET("/graphql")
    Call<DataModel<DataModelOffice>> getDistrictOffices(@Query("query") String query);
}
