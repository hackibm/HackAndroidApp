package hackathon.mms.app.domain.officeList;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import hackathon.mms.app.infrastructure.repository.GraphQLRepository;
import hackathon.mms.app.shared.model.DistrictOffice;
import rx.Observable;

/**
 * Created by d4w1dk on 02/12/2016.
 */

public class GraphQLIntegrationTests {

    @Test
    public void testAddressNotNull(){

        GraphQLRepository repo = new GraphQLRepository();
        Observable<DistrictOffice> obs = repo.getDistrictOffices();
        for(int i = 0; i < 10; i++) {
            obs.forEach(elem ->{
                System.out.println(elem.getContactInfo().getAddress());
                Assert.assertNotNull(elem.getContactInfo().getAddress());
            }
            );

        }
    }

    @Test
    public void testAddressNotNullSynch(){

        GraphQLRepository repo = new GraphQLRepository();
        List<DistrictOffice> obs = repo.getDistrictOfficesSynch();
        //for(int i = 0; i < 10; i++) {
//            obs.forEach(elem ->{
//                        System.out.println(elem.getContactInfo().getAddress());
//                        Assert.assertNotNull(elem.getContactInfo().getAddress());
//                    }
//            );
        for(DistrictOffice elem : obs){
            System.out.println(elem.getContactInfo().getAddress());
            Assert.assertNotNull(elem.getContactInfo().getAddress());
        }

       // }
    }

}
