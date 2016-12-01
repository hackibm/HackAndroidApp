package hackathon.mms.app.infrastructure.repository;


import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import hackathon.mms.app.infrastructure.graphql.DataModel;
import hackathon.mms.app.infrastructure.graphql.DataModelOffice;
import hackathon.mms.app.shared.model.DistrictOffice;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ewa on 28.11.2016.
 */
public class GraphQLRepository {

    private final RepositoryService repositoryService;


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
    }

    public Observable<DistrictOffice> getDistrictOffices(){

        String query = " { districtOffices:offices {id name } }";

        Observable<DataModel<DataModelOffice>> observable = repositoryService.getDistrictOffices( query);

        return observable.flatMap(dataModel -> Observable.from(dataModel.getData().getDistrictOffices()));
    }

}
