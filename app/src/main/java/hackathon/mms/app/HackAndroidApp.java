package hackathon.mms.app;

import android.app.Application;

import hackathon.mms.app.repository.DistrictOfficesRepository;

/**
 * Created by ewa on 28.11.2016.
 */

public class HackAndroidApp extends Application {

    public DistrictOfficesRepository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        repository = new DistrictOfficesRepository();
    }

    public DistrictOfficesRepository getRepository() {
        return repository;
    }

    public void setRepository(DistrictOfficesRepository repository) {
        this.repository = repository;
    }
}

