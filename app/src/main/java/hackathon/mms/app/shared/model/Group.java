package hackathon.mms.app.shared.model;

/**
 * Created by d4w1dk on 02/12/2016.
 */

public class Group {
    private String nazwaGrupy;
    private String liczbaKlwKolejce;
    private String czasObslugi;
    private String liczbaCzynnychStan;




    public Group(String nazwaGroupy, String liczbaKlwKolejce,  String czasObslugi, String liczbaCzynnychStan) {
        this.nazwaGrupy = nazwaGroupy;
        this.liczbaKlwKolejce = liczbaKlwKolejce;
        this.czasObslugi = czasObslugi;
        this.liczbaCzynnychStan = liczbaCzynnychStan;
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
