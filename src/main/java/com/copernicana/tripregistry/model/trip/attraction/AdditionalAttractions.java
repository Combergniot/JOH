package com.copernicana.tripregistry.model.trip.attraction;

import com.copernicana.tripregistry.model.trip.Trip;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

//TODO - Przemodelować dodatkowe atrakcje na Set'a a opcje ustawić jako jakiś ENUM? Potem widok :/

@Entity
@DiscriminatorValue("dodatkowe")
public class AdditionalAttractions extends Attraction{

    private boolean bunkier;
    private boolean domLegend;
    private boolean katedra;
    private boolean małaChemia;
    private boolean manufaktura;
    private boolean motoarena;
    private boolean muzeumEtnograficzne;
    private boolean muzeumOkregowe;
    private boolean muzeumDruku;
    private boolean muzeumZabawek;
    private boolean obserwatorium;
    private boolean zoo;

    public AdditionalAttractions(Date date, String hour, String name,
                                 Trip trip, boolean bunkier, boolean domLegend,
                                 boolean katedra, boolean małaChemia, boolean manufaktura,
                                 boolean motoarena, boolean muzeumEtnograficzne, boolean muzeumOkregowe,
                                 boolean muzeumDruku, boolean muzeumZabawek, boolean obserwatorium, boolean zoo) {
        super(date, hour, name, trip);
        this.bunkier = bunkier;
        this.domLegend = domLegend;
        this.katedra = katedra;
        this.małaChemia = małaChemia;
        this.manufaktura = manufaktura;
        this.motoarena = motoarena;
        this.muzeumEtnograficzne = muzeumEtnograficzne;
        this.muzeumOkregowe = muzeumOkregowe;
        this.muzeumDruku = muzeumDruku;
        this.muzeumZabawek = muzeumZabawek;
        this.obserwatorium = obserwatorium;
        this.zoo = zoo;
    }

    public AdditionalAttractions(boolean bunkier, boolean domLegend,
                                 boolean katedra, boolean małaChemia, boolean manufaktura,
                                 boolean motoarena, boolean muzeumEtnograficzne, boolean muzeumOkregowe,
                                 boolean muzeumDruku, boolean muzeumZabawek, boolean obserwatorium, boolean zoo) {
        this.bunkier = bunkier;
        this.domLegend = domLegend;
        this.katedra = katedra;
        this.małaChemia = małaChemia;
        this.manufaktura = manufaktura;
        this.motoarena = motoarena;
        this.muzeumEtnograficzne = muzeumEtnograficzne;
        this.muzeumOkregowe = muzeumOkregowe;
        this.muzeumDruku = muzeumDruku;
        this.muzeumZabawek = muzeumZabawek;
        this.obserwatorium = obserwatorium;
        this.zoo = zoo;
    }

    public AdditionalAttractions() {
    }

    public boolean isBunkier() {
        return bunkier;
    }

    public void setBunkier(boolean bunkier) {
        this.bunkier = bunkier;
    }

    public boolean isDomLegend() {
        return domLegend;
    }

    public void setDomLegend(boolean domLegend) {
        this.domLegend = domLegend;
    }

    public boolean isKatedra() {
        return katedra;
    }

    public void setKatedra(boolean katedra) {
        this.katedra = katedra;
    }

    public boolean isMałaChemia() {
        return małaChemia;
    }

    public void setMałaChemia(boolean małaChemia) {
        this.małaChemia = małaChemia;
    }

    public boolean isManufaktura() {
        return manufaktura;
    }

    public void setManufaktura(boolean manufaktura) {
        this.manufaktura = manufaktura;
    }

    public boolean isMotoarena() {
        return motoarena;
    }

    public void setMotoarena(boolean motoarena) {
        this.motoarena = motoarena;
    }

    public boolean isMuzeumEtnograficzne() {
        return muzeumEtnograficzne;
    }

    public void setMuzeumEtnograficzne(boolean muzeumEtnograficzne) {
        this.muzeumEtnograficzne = muzeumEtnograficzne;
    }

    public boolean isMuzeumOkregowe() {
        return muzeumOkregowe;
    }

    public void setMuzeumOkregowe(boolean muzeumOkregowe) {
        this.muzeumOkregowe = muzeumOkregowe;
    }

    public boolean isMuzeumDruku() {
        return muzeumDruku;
    }

    public void setMuzeumDruku(boolean muzeumDruku) {
        this.muzeumDruku = muzeumDruku;
    }

    public boolean isMuzeumZabawek() {
        return muzeumZabawek;
    }

    public void setMuzeumZabawek(boolean muzeumZabawek) {
        this.muzeumZabawek = muzeumZabawek;
    }

    public boolean isObserwatorium() {
        return obserwatorium;
    }

    public void setObserwatorium(boolean obserwatorium) {
        this.obserwatorium = obserwatorium;
    }

    public boolean isZoo() {
        return zoo;
    }

    public void setZoo(boolean zoo) {
        this.zoo = zoo;
    }
}

