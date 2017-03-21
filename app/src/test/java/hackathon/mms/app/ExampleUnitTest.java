package hackathon.mms.app;

import android.util.Log;

import junit.framework.Assert;

import org.junit.Test;



import hackathon.mms.app.infrastructure.repository.GraphQLRepository;
import hackathon.mms.app.shared.model.DistrictOffice;
import hackathon.mms.app.shared.model.Group;
import rx.Observable;
import rx.schedulers.Schedulers;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    //  @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void testAddress1() {
        System.out.println(prepareAddress("ul. Grójecka 17 a, 02-021 Warszawa, Polska"));
    }

    @Test
    public void testParseServiceTime() {
        Assert.assertEquals(71, Group.GroupComparatorByServiceTime.getServiceTime("01:11"));
        Assert.assertEquals(11, Group.GroupComparatorByServiceTime.getServiceTime("11"));
    }


    private String prepareAddress(String address) {
        String result = address;
        try {
            String[] arr = address.split(",");
            result = arr[0] + ", " + arr[1].split(" ")[1];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



   // @Test
/*
    public void testGetOfficesForCaseId() {
        Observable<DistrictOffice> caseListObs = new GraphQLRepository().getOfficesForCase("identityCard");

        caseListObs
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toList().subscribe(list -> {
//            Log.i("list:", list.get(0).getName());
//            caseList.addAll(list);
            for(DistrictOffice s: list){
                Log.i("1", s.getName());
            }

        });

        try {
            Thread.sleep(5000);
        }catch(Exception ex){

        }

    }
*/
}