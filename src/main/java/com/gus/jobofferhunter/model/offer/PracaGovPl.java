package com.gus.jobofferhunter.model.offer;


import javax.persistence.*;

@Entity
@DiscriminatorValue("cbop")
public class PracaGovPl {

    //Nazewnictwo identyczne z JSON generowanym przez stronę

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String hash;
    @Column
    private String nrOferty;
    @Column
    private String stanowisko;
    @Column
    private String miejscePracyCzlonPierwszy;
    @Column
    private String miejscePracyCzlonDrugi;
    @Column
    private String rodzajWynagrodzenia;
    @Column
    private String wynagrodzenie;
    @Column
    private String wynagrodzenieOpis;
    @Column
    private String pracodawca;
    @Column
    private String skroconyRodzajZatrudnienia;
    @Column
    private String rodzajZatrudnienia;
    @Column
    private String wymiarEtatu;
    @Column
    private String dataDodania;
    @Column
    private String systemCzasuPracy;
    @Column
    private String rodzajZakresuObowiazkow;
    @Column
    private String zakresObowiazkow;
    @Column
    private String wymagania;
    @Column
    private String zrodloNazwa;
    @Column
    private String zrodloNazwaOpisSkr;
    @Column
    private String zrodloKod;
    @Column
    private String typOferty;
    @Column
    private String typStawki;
    @Column
    private String rodzajOferty;
    @Column
    private String kraj;
    @Column
    private String kodKraju;
    @Column
    private String miejscowosc;
    @Column
    private String kodMiejscowosci;
    @Column
    private String wymagWyksztList; // Prerobić na listę stringów
    @Column
    private String wymagZawodList;
    @Column
    private String wymagJezykList;
    @Column
    private String wymagUmiejetnoscList;
    @Column
    private String wymagInne;
    @Column
    private String stazOgol;
    @Column
    private String dataModyfikacji;
    @Column
    private String dataWaznosci;
    @Column
    private String dataRozpoczeciaPracy;
    @Lob
    private String url;

    public PracaGovPl(Long id, String hash,
                      String nrOferty, String stanowisko,
                      String miejscePracyCzlonPierwszy, String miejscePracyCzlonDrugi,
                      String rodzajWynagrodzenia, String wynagrodzenie, String wynagrodzenieOpis,
                      String pracodawca, String skroconyRodzajZatrudnienia, String rodzajZatrudnienia,
                      String wymiarEtatu, String dataDodania, String systemCzasuPracy, String rodzajZakresuObowiazkow,
                      String zakresObowiazkow, String wymagania, String zrodloNazwa, String zrodloNazwaOpisSkr,
                      String zrodloKod, String typOferty, String typStawki, String rodzajOferty, String kraj,
                      String kodKraju, String miejscowosc, String kodMiejscowosci, String wymagWyksztList,
                      String wymagZawodList, String wymagJezykList, String wymagUmiejetnoscList, String wymagInne,
                      String stazOgol, String dataModyfikacji, String dataWaznosci,
                      String dataRozpoczeciaPracy, String url) {
        this.id = id;
        this.hash = hash;
        this.nrOferty = nrOferty;
        this.stanowisko = stanowisko;
        this.miejscePracyCzlonPierwszy = miejscePracyCzlonPierwszy;
        this.miejscePracyCzlonDrugi = miejscePracyCzlonDrugi;
        this.rodzajWynagrodzenia = rodzajWynagrodzenia;
        this.wynagrodzenie = wynagrodzenie;
        this.wynagrodzenieOpis = wynagrodzenieOpis;
        this.pracodawca = pracodawca;
        this.skroconyRodzajZatrudnienia = skroconyRodzajZatrudnienia;
        this.rodzajZatrudnienia = rodzajZatrudnienia;
        this.wymiarEtatu = wymiarEtatu;
        this.dataDodania = dataDodania;
        this.systemCzasuPracy = systemCzasuPracy;
        this.rodzajZakresuObowiazkow = rodzajZakresuObowiazkow;
        this.zakresObowiazkow = zakresObowiazkow;
        this.wymagania = wymagania;
        this.zrodloNazwa = zrodloNazwa;
        this.zrodloNazwaOpisSkr = zrodloNazwaOpisSkr;
        this.zrodloKod = zrodloKod;
        this.typOferty = typOferty;
        this.typStawki = typStawki;
        this.rodzajOferty = rodzajOferty;
        this.kraj = kraj;
        this.kodKraju = kodKraju;
        this.miejscowosc = miejscowosc;
        this.kodMiejscowosci = kodMiejscowosci;
        this.wymagWyksztList = wymagWyksztList;
        this.wymagZawodList = wymagZawodList;
        this.wymagJezykList = wymagJezykList;
        this.wymagUmiejetnoscList = wymagUmiejetnoscList;
        this.wymagInne = wymagInne;
        this.stazOgol = stazOgol;
        this.dataModyfikacji = dataModyfikacji;
        this.dataWaznosci = dataWaznosci;
        this.dataRozpoczeciaPracy = dataRozpoczeciaPracy;
        this.url = url;
    }

    public PracaGovPl() {
    }


}
