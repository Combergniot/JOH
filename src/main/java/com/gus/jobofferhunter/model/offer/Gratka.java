package com.gus.jobofferhunter.model.offer;

import javax.persistence.*;

// Na razie bez rozszerzania joboffer;
@Entity
@DiscriminatorValue("gratka")
public class Gratka {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String dateAdded; //data dodania ogłoszenia
    @Column
    private String position; //stanowisko
    @Column
    private String country; //kraj
    @Column
    private String province; //województwo
    @Column
    private String workplace; //miejsce pracy, dokladna lokalizacja
    @Column
    private String employer; //
    @Column
    private String branch; //branża
    @Column
    private String jobType; //typ stanowiska
    @Column
    private String typeOfWork; //rodzaj pracy - do dodania
    @Column
    private String formOfEmployment; //forma zatrudnienia
    @Column
    private String requiredEducation; //minimalne wykształcenie
    @Column
    private String salary; //wynagrodzenie
    @Column
    private String offerFromNewspapper; //wynagrodzenie
    @Column
    private String additionalOptions; //opcje dodatkowe - do dodania
    @Column
    private String dataSearch; //data przeszukania
    @Column
    @Lob //w SQL - będzie to TEXT
    private String description; //treść ogłoszenia
    @Column
    @Lob
    private String url;

    public Gratka(Long id, String dateAdded, String position,
                  String country, String province, String workplace,
                  String employer, String branch, String jobType, String typeOfWork,
                  String formOfEmployment, String requiredEducation, String salary,
                  String offerFromNewspapper, String additionalOptions,
                  String dataSearch, String description, String url) {
        this.id = id;
        this.dateAdded = dateAdded;
        this.position = position;
        this.country = country;
        this.province = province;
        this.workplace = workplace;
        this.employer = employer;
        this.branch = branch;
        this.jobType = jobType;
        this.typeOfWork = typeOfWork;
        this.formOfEmployment = formOfEmployment;
        this.requiredEducation = requiredEducation;
        this.salary = salary;
        this.offerFromNewspapper = offerFromNewspapper;
        this.additionalOptions = additionalOptions;
        this.dataSearch = dataSearch;
        this.description = description;
        this.url = url;
    }

    public Gratka() {
    }

    public Long getId() {
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public String getFormOfEmployment() {
        return formOfEmployment;
    }

    public void setFormOfEmployment(String formOfEmployment) {
        this.formOfEmployment = formOfEmployment;
    }

    public String getRequiredEducation() {
        return requiredEducation;
    }

    public void setRequiredEducation(String requiredEducation) {
        this.requiredEducation = requiredEducation;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getOfferFromNewspapper() {
        return offerFromNewspapper;
    }

    public void setOfferFromNewspapper(String offerFromNewspapper) {
        this.offerFromNewspapper = offerFromNewspapper;
    }

    public String getAdditionalOptions() {
        return additionalOptions;
    }

    public void setAdditionalOptions(String additionalOptions) {
        this.additionalOptions = additionalOptions;
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

    @Override
    public String toString() {
        return "Gratka{" +
                "id=" + id +
                ", dateAdded='" + dateAdded + '\'' +
                ", position='" + position + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", workplace='" + workplace + '\'' +
                ", employer='" + employer + '\'' +
                ", branch='" + branch + '\'' +
                ", jobType='" + jobType + '\'' +
                ", typeOfWork='" + typeOfWork + '\'' +
                ", formOfEmployment='" + formOfEmployment + '\'' +
                ", requiredEducation='" + requiredEducation + '\'' +
                ", salary='" + salary + '\'' +
                ", offerFromNewspapper='" + offerFromNewspapper + '\'' +
                ", additionalOptions='" + additionalOptions + '\'' +
                ", dataSearch='" + dataSearch + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}
