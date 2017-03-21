package hackathon.mms.app.shared.model;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by d4w1dk on 02/12/2016.
 */

public class Group {
    private String idGrupy;
    private String nazwaGrupy;
    private String liczbaKlwKolejce;
    private String czasObslugi;
    private String liczbaCzynnychStan;
    private String lacznyCzasObslugi;

   /* "nazwaGrupy": "A-DOWODY OSOBISTE",
            "idGrupy": "1",
            "czasObslugi": "0",
            "liczbaCzynnychStan": "0",
            "lacznyCzasObslugi": "0"

    */

    public Group(String nazwaGroupy, String liczbaKlwKolejce,  String czasObslugi, String liczbaCzynnychStan) {
        this.nazwaGrupy = nazwaGroupy;
        this.liczbaKlwKolejce = liczbaKlwKolejce;
        this.czasObslugi = czasObslugi;
        this.liczbaCzynnychStan = liczbaCzynnychStan;
    }

    public Group(String nazwaGroupy, String idGrupy, String liczbaKlwKolejce,  String czasObslugi, String liczbaCzynnychStan, String lacznyCzasObslugi) {
        this.idGrupy = idGrupy;
        this.nazwaGrupy = nazwaGroupy;
        this.liczbaKlwKolejce = liczbaKlwKolejce;
        this.czasObslugi = czasObslugi;
        this.liczbaCzynnychStan = liczbaCzynnychStan;
        this.lacznyCzasObslugi = lacznyCzasObslugi;
    }

    public String getNazwaGroupy() {
        return nazwaGrupy;
    }

    public String getLiczbaKlwKolejce() {
        return liczbaKlwKolejce;
    }

    public String getCzasObslugi() {
        return czasObslugi;
    }

    public String getLiczbaCzynnychStan() {
        return liczbaCzynnychStan;
    }

    public String getIdGrupy() {
        return idGrupy;
    }

    public String getNazwaGrupy() {
        return nazwaGrupy;
    }

    public String getLacznyCzasObslugi() {
        return lacznyCzasObslugi;
    }

    @Override
    public String toString() {
        return "Group{" +
                "nazwaGroupy='" + nazwaGrupy + '\'' +
                ", liczbaKlwKolejce='" + liczbaKlwKolejce + '\'' +
                ", czasObslugi='" + czasObslugi + '\'' +
                ", liczbaCzynnychStan='" + liczbaCzynnychStan + '\'' +
                '}';
    }

    public static class GroupComparatorByServiceTime implements Comparator<Group> {

        private final static String TIME_FORMAT = "HH:mm";

        @Override
        public int compare(Group g1, Group g2) {
            Integer i1 = getServiceTime(g1.getCzasObslugi());
            Integer i2 = getServiceTime(g2.getCzasObslugi());
            return i1.compareTo(i2);
        }

        public static int getServiceTime(String serviceTimeStr) {
            int serviceTime = -1;
            if (serviceTimeStr != null && !serviceTimeStr.equals("")) {
                int index = serviceTimeStr.indexOf(':');
                try {
                    if (index != -1) {
                            int hours = Integer.valueOf(serviceTimeStr.substring(0,index));
                            int minutes = Integer.valueOf(serviceTimeStr.substring(index+1));
                            serviceTime =  hours * 60 +  minutes;
                    }else{
                        serviceTime = Integer.valueOf(serviceTimeStr);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("-------------------->serviceTimeStr: " + serviceTimeStr +" serviceTime: " + serviceTime);
            return serviceTime;
        }

    }
}
