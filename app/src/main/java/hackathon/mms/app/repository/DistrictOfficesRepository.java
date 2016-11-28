package hackathon.mms.app.repository;


import java.util.List;

import hackathon.mms.app.model.DistrictOffice;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ewa on 28.11.2016.
 */
public class DistrictOfficesRepository {

    private final RepositoryService repositoryService;


    public DistrictOfficesRepository(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public void makeCall(Call call, Callback callback) {
        if (!call.isExecuted())
            call.enqueue(callback);
    }


    public Observable<DistrictOffice> getDistrictOffices(){

        Observable<List<DistrictOffice>> observable = repositoryService.getDistrictOffices();
        return observable.flatMap(Observable::from); //.map(CommentConverter::fromCommentTO);
    }

}
