package hackathon.mms.app.infrastructure.repository;


import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import hackathon.mms.app.infrastructure.graphql.DataModel;
import hackathon.mms.app.infrastructure.graphql.DataModelOffice;
import hackathon.mms.app.shared.model.DistrictOffice;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by ewa on 28.11.2016.
 */
public class GraphQLRepository {

    private final RepositoryService repositoryService;
    private final RepositoryService2 repositoryService2;

    public GraphQLRepository() {

        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(90, TimeUnit.SECONDS )
                .build();
        GsonBuilder builder = new GsonBuilder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UriBuilder.BASE_REPOSIOTRY_URI)
                .addConverterFactory(GsonConverterFactory.create(builder.create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        this.repositoryService = retrofit.create(RepositoryService.class);
        this.repositoryService2 = retrofit.create(RepositoryService2.class);
    }

    public Observable<DistrictOffice> getDistrictOffices(){

        String query = " { districtOffices:offices {id, name, contactInfo{address} } }";

        Observable<DataModel<DataModelOffice>> observable = repositoryService.getDistrictOffices( query);

        return observable.flatMap(dataModel -> Observable.from(dataModel.getData().getDistrictOffices()));
    }

    public List<DistrictOffice> getDistrictOfficesSynch(){

        List<DistrictOffice> result = null;

        String query = " { districtOffices:offices {id, name, contactInfo{address} } }";

        Call<DataModel<DataModelOffice>> call = repositoryService2.getDistrictOffices(query);

        try {
            DataModel<DataModelOffice> resp = call.execute().body();
            result = resp.getData().getDistrictOffices();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

}
