package hackathon.mms.app.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by EKolodziejska on 2016-11-28.
 */

public class RepositoryModule {

    public DistrictOfficesRepository provideRepository(RepositoryService repositoryService) {
        return new DistrictOfficesRepository(repositoryService);
    }

    public RepositoryService provideRepositoryService(Retrofit retrofit) {
        return retrofit.create(RepositoryService.class);
    }

    Retrofit provideRetrofit(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(UriBuilder.BASE_REPOSIOTRY_URI)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
    }

    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()

                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(90, TimeUnit.SECONDS )
                .build();
    }

    Gson provideGson() {
        return new GsonBuilder()
                .create();
    }
}
