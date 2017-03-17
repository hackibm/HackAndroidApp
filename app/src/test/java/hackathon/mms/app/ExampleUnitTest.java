package hackathon.mms.app;

import org.junit.Test;

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
    public void testAddress1(){
        System.out.println(prepareAddress("ul. Grójecka 17 a, 02-021 Warszawa, Polska"));
    }

    private String prepareAddress(String address){
        String result = address;
        try {
            String[] arr = address.split(",");
            result = arr[0] + ", " + arr[1].split(" ")[1];
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

}