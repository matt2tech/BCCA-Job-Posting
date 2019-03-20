package com.bcca.app.forms;

import java.util.Date;

public class JobForm {
    private Integer id;
    private String name;
    private String company;
    private String position;
    private String location;
    private String desc;
    private String exp;
    private String industry;
    private Date date;
    private String benefits;
    private String logo;
    private String qualifications;
    private String hireSite;

    public JobForm(Integer id, String name, String company, String position, String location, String desc, String exp, String industry, Date date, String benefits, String logo, String qualifications, String hireSite) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.position = position;
        this.location = location;
        this.desc = desc;
        this.exp = exp;
        this.industry = industry;
        this.date = date;
        this.benefits = benefits;
        this.logo = logo;
        this.qualifications = qualifications;
        this.hireSite = hireSite;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getHireSite() {
        return hireSite;
    }

    public void setHireSite(String hireSite) {
        this.hireSite = hireSite;
    }

    public Boolean isValid() {
        return (name != null && company != null && position != null && location != null && desc != null && exp != null && industry != null && logo != null && hireSite != null);
    }

    public String preview() {
        if (desc.length() < 200) {
            return desc;
        } else {
            return desc.substring(0, 197) + "...";
        }
    }

    public String[] qualificationsText() {
        if (qualifications.isEmpty()) {
            return "Not Available".split("\n");
        } else {
            return qualifications.split("\n");
        }
    }

    public String[] benefitsText() {
        if (benefits.isEmpty()) {
            return "Not Available".split("\n");
        } else {
            return benefits.split("\n");
        }
    }
}
