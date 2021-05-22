package com.example.placements;

public class Company {
    int company_id;
    String company_name, company_package, profile, description, offer,location, logo, url, cgpa;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_package() {
        return company_package;
    }

    public void setCompany_package(String company_package) {
        this.company_package = company_package;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Company{" +
                "company_id=" + company_id +
                ", company_name='" + company_name + '\'' +
                ", company_package='" + company_package + '\'' +
                ", profile='" + profile + '\'' +
                ", description='" + description + '\'' +
                ", offer='" + offer + '\'' +
                ", location='" + location + '\'' +
                ", logo='" + logo + '\'' +
                ", url='" + url + '\'' +
                ", cgpa='" + cgpa + '\'' +
                '}';
    }
}
