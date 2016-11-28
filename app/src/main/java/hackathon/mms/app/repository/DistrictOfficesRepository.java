package hackathon.mms.app.repository;


import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import hackathon.mms.app.model.DistrictOffice;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ewa on 28.11.2016.
 */
public class DistrictOfficesRepository {

    private final RepositoryService repositoryService;


    public DistrictOfficesRepository() {

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

        Observable<List<DistrictOffice>> observable = repositoryService.getDistrictOffices();
        return observable.flatMap(Observable::from); //.map(CommentConverter::fromCommentTO);
    }

}
