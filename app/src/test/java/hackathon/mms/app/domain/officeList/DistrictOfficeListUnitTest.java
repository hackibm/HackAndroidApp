package hackathon.mms.app.domain.officeList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import hackathon.mms.app.infrastructure.repository.GraphQLRepository;
import hackathon.mms.app.shared.model.DistrictOffice;
import hackathon.mms.app.shared.model.UserLocation;
import rx.Observable;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.schedulers.Schedulers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DistrictOfficeListUnitTest {

    private DistrictOfficeListContract.DistrictOfficeListPresenter presenter;

    @Mock
    DistrictOfficeListFragment fragment;

    @Mock
    UserLocation userLocation;

    @Mock
    GraphQLRepository repository;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    Observable<DistrictOffice> observable;

    List<DistrictOffice> offices;

    @Before
    public void init(){

       RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });


        presenter = new DistrictOfficeListPresenterImpl(fragment, repository);
        offices = new ArrayList<>();
        for(int i = 0; i<10; i++){
            offices.add(new DistrictOffice("test", "TEST", null, null));
        }
        observable = Observable.from(offices);

    }

    /*@After
    public void tearDown() {
        RxAndroidPlugins.getInstance().reset();
    }*/

    @Test
    public void testCheckIsNameIsNotNull() {
        //given
        presenter = new DistrictOfficeListPresenterImpl(fragment, repository);
        offices = new ArrayList<>();
        for(int i = 0; i<10; i++){
            offices.add(new DistrictOffice("test", "TEST", null, null));
        }
        observable = Observable.from(offices);
        when(repository.getDistrictOffices()).thenReturn(observable);

        //when
        List<DistrictOffice> t = presenter.getOfficeList(userLocation);

        //then
        verify(repository).getDistrictOffices();
        Assert.assertNotNull(presenter.getOfficeList(userLocation).get(0).getName());
        //Assert.assertNotNull(presenter.getOfficeList(userLocation));
    }


    @Test
    public void testGetOfficesSuccess() throws InterruptedException {
        //given
        when(repository.getDistrictOffices()).thenReturn(observable);

        //when
        List<DistrictOffice> t = presenter.getOfficeList(userLocation);
        Thread.sleep(1000);
        System.out.println(t);

        //then
        verify(repository).getDistrictOffices();

        Assert.assertNotNull(presenter.getOfficeList(userLocation));
    }





}