package hackathon.mms.app.officeList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


import java.util.ArrayList;
import java.util.List;

import hackathon.mms.app.model.DistrictOffice;
import hackathon.mms.app.model.UserLocation;
import hackathon.mms.app.repository.DistrictOfficesRepository;
import rx.Observable;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
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
    DistrictOfficesRepository repository;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    Observable<DistrictOffice> observable;

    List<DistrictOffice> offices;

    @Before
    public void init(){
        presenter = new DistrictOfficeListPresenterImpl(fragment, repository);
        offices = new ArrayList<>();
        for(int i = 0; i<10; i++){
            offices.add(new DistrictOffice("test", "TEST"));
        }
        observable = Observable.from(offices);

    }


    @Test
    public void testGetOfficesSuccess(){
        //given
        when(repository.getDistrictOffices()).thenReturn(observable);

        //when
        presenter.getOfficeList(userLocation);

        //then
        verify(repository).getDistrictOffices();
        Assert.assertNotNull(presenter.getOfficeList(userLocation));
    }

    @Test
    public void testGetOfficesEmptyReturn(){
        //given
        when(repository.getDistrictOffices()).thenReturn(Observable.empty());

        //when
        presenter.getOfficeList(userLocation);

        //then
        verify(repository).getDistrictOffices();
        Assert.assertNotNull(presenter.getOfficeList(null));
    }

    @Test
    public void testGetOfficesNullReturn(){
        //given
        when(repository.getDistrictOffices()).thenReturn(null);

        //when
        presenter.getOfficeList(userLocation);

        //then
        verify(repository).getDistrictOffices();
        Assert.assertNotNull(presenter.getOfficeList(null));
    }


}