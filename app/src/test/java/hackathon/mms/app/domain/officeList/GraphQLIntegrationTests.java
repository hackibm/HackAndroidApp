package hackathon.mms.app.domain.officeList;

import org.junit.Assert;
import org.junit.Test;

import hackathon.mms.app.infrastructure.repository.GraphQLRepository;
import hackathon.mms.app.shared.model.DistrictOffice;
import rx.Observable;

/**
 * Created by d4w1dk on 02/12/2016.
 */

public class GraphQLIntegrationTests {

    @Test
    public void testAddressNotNull() throws InterruptedException {

        GraphQLRepository repo = new GraphQLRepository();
        Observable<DistrictOffice> obs = repo.getDistrictOffices();
        for(int i = 0; i < 10; i++) {
            obs.forEach(elem ->{
                System.out.println(elem.getContactInfo().getAddress());
                Assert.assertNotNull(elem.getContactInfo().getAddress());
                Assert.assertNotNull(elem.getContactInfo().getPhone());
            }
            );

        }
    }

    @Test
    public void testDetailsNotNull(){

        GraphQLRepository repo = new GraphQLRepository();
        Observable<DistrictOffice> obs = repo.getDistrictOfficeByID("831ef31a-b2a3-4cbb-aaa5-cb90fe05ad8c");
        for(int i = 0; i < 10; i++) {
            obs.forEach(elem -> {
                System.out.println(elem.getGroups().size());

                System.out.println(elem.getGroups().get(0));
                Assert.assertNotNull(elem.getGroups());
                Assert.assertNotNull(elem.getGroups().get(0).getNazwaGroupy());
            });

        }
    }




}
