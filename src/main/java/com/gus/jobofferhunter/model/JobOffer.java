package com.gus.jobofferhunter.model;

import javax.persistence.*;

@Entity
@Table(name = "offer")
public class JobOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String dateAdded; //data dodania ogłoszenia
    @Column
    private String webPage; //serwis pobrania np. olx.pl
    @Column
    private String tittle; //tytuł - tag ogłoszenia
    @Column
    private String position; //stanowisko
    @Column
    private String workplace; //miejsce pracy
    @Column
    private String province; //województwo
    @Column
    private String branch; //branża
    @Column
    private String dataSearch; //data przeszukania
    @Column
    @Lob //w SQL - będzie to TEXT
    private String description; //treść ogłoszenia
    @Column
    @Lob
    private String url; // url - do całej oferty

    public JobOffer() {
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDataSearch() {
        return dataSearch;
    }

    public void setDataSearch(String dataSearch) {
        this.dataSearch = dataSearch;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    //Builder

    public JobOffer withId(final Long id) {
        this.id = id;
        return this;
    }

    public JobOffer withDateAdded(final String dateAdded) {
        this.dateAdded = dateAdded;
        return this;
    }

    public JobOffer withWebPage(final String webPage) {
        this.webPage = webPage;
        return this;
    }

    public JobOffer withTittle(final String tittle) {
        this.tittle = tittle;
        return this;
    }

    public JobOffer withPosition(final String position) {
        this.position = position;
        return this;
    }

    public JobOffer withWorkplace(final String workplace) {
        this.workplace = workplace;
        return this;
    }

    public JobOffer withProvince(final String province) {
        this.province = province;
        return this;
    }

    public JobOffer withBranch(final String branch) {
        this.branch = branch;
        return this;
    }

    public JobOffer withDataSearch(final String dataSearch) {
        this.dataSearch = dataSearch;
        return this;
    }

    public JobOffer withDescription(final String description) {
        this.description = description;
        return this;
    }

    public JobOffer withUrl(final String url) {
        this.url = url;
        return this;
    }

//    public JobOffer build() {
//        JobOffer jobOffer = new JobOffer();
//        jobOffer.setId(id);
//        jobOffer.setDateAdded(dateAdded);
//        jobOffer.setWebPage(webPage);
//        jobOffer.setTittle(tittle);
//        jobOffer.setPosition(position);
//        jobOffer.setWorkplace(workplace);
//        jobOffer.setProvince(province);
//        jobOffer.setBranch(branch);
//        jobOffer.setDataSearch(dataSearch);
//        jobOffer.setDescription(description);
//        jobOffer.setUrl(url);
////        return jobOffer;
//    }

    @Override
    public String toString() {
        return "JobOffer{" +
                "id=" + id +
                ", dateAdded='" + dateAdded + '\'' +
                ", webPage='" + webPage + '\'' +
                ", tittle='" + tittle + '\'' +
                ", position='" + position + '\'' +
                ", workplace='" + workplace + '\'' +
                ", province='" + province + '\'' +
                ", branch='" + branch + '\'' +
                ", dataSearch='" + dataSearch + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}