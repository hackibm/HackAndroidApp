package hackathon.mms.app.domain.officeList;

import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import hackathon.mms.app.infrastructure.repository.GraphQLRepository;
import hackathon.mms.app.shared.model.DistrictOffice;
import hackathon.mms.app.shared.model.UserLocation;
import rx.Observable;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DistrictOfficeListUnitTest {


    @Mock
    UserLocation userLocation;

    @Mock
    GraphQLRepository repository;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    Observable<DistrictOffice> observable;

    List<DistrictOffice> offices;



    /*@After
    public void tearDown() {
        RxAndroidPlugins.getInstance().reset();
    }*/









}