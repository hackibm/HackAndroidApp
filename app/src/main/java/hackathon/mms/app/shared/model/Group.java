package hackathon.mms.app.shared.model;

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
}
