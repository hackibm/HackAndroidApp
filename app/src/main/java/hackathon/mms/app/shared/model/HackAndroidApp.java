package hackathon.mms.app.shared.model;

import android.app.Application;

import hackathon.mms.app.infrastructure.repository.GraphQLRepository;

/**
 * Created by ewa on 28.11.2016.
 */

public class HackAndroidApp extends Application {

    public GraphQLRepository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        repository = new GraphQLRepository();
    }

    public GraphQLRepository getRepository() {
        return repository;
    }

    public void setRepository(GraphQLRepository repository) {
        this.repository = repository;
    }
}

