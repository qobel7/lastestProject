package com.example.qobel.organizator.entity;

import com.example.qobel.organizator.network.Status;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by qobel on 2.07.2017.
 */

public class OrganizationEntity extends Status {

    @SerializedName("name")
    private String name;
    @SerializedName("chipsEntityList")
    private List<ChipsEntity> chipsEntityList;
    @SerializedName("images")
    private List<String> images;
    @SerializedName("registeredUsers")
    private List<UserEntity> registeredUsers;
    @SerializedName("finishedDate")
    private String finishedDate;
    @SerializedName("startDate")
    private String startDate;
    @SerializedName("registerFinishedDate")
    private String registerFinishedDate;
    @SerializedName("isHaveAPrice")
    private String isHaveAPrice;
    @SerializedName("price")
    private String price;
    @SerializedName("city")
    private String city;
    @SerializedName("district")
    private String district;
    @SerializedName("neighbourhood")
    private String neighbourhood;
    @SerializedName("OrganizaterName")
    private String OrganizaterName;
    @SerializedName("badOrganizationCount")
    private String badOrganizationCount;
    @SerializedName("bestOrganizationCount")
    private String bestOrganizationCount;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChipsEntity> getChipsEntityList() {
        return chipsEntityList;
    }

    public void setChipsEntityList(List<ChipsEntity> chipsEntityList) {
        this.chipsEntityList = chipsEntityList;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<UserEntity> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(List<UserEntity> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public String getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(String finishedDate) {
        this.finishedDate = finishedDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getRegisterFinishedDate() {
        return registerFinishedDate;
    }

    public void setRegisterFinishedDate(String registerFinishedDate) {
        this.registerFinishedDate = registerFinishedDate;
    }

    public String isHaveAPrice() {
        return isHaveAPrice;
    }

    public void setHaveAPrice(String haveAPrice) {
        isHaveAPrice = haveAPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getOrganizaterName() {
        return OrganizaterName;
    }

    public void setOrganizaterName(String organizaterName) {
        OrganizaterName = organizaterName;
    }

    public String getBadOrganizationCount() {
        return badOrganizationCount;
    }

    public void setBadOrganizationCount(String badOrganizationCount) {
        this.badOrganizationCount = badOrganizationCount;
    }

    public String getBestOrganizationCount() {
        return bestOrganizationCount;
    }

    public void setBestOrganizationCount(String bestOrganizationCount) {
        this.bestOrganizationCount = bestOrganizationCount;
    }
}
