package com.zzti.zut.entity;

public class MaintenanceInfo {
    private int id;
    private int maintenanceSN;
    private int areaID;
    private int equipmentID;
    private int reportUserID;
    private String reportContent;
    private String imageURL;
    private String location;
    private int status;
    private String startTime;
    private int maintenanceUserID;
    private String acceptTime;
    private String maintenanceContent;
    private String endTime;
    private String reportUserName;
    private String maintenanceUserName;
    private String equipmentType;
    private String building;
    private String floor;
    private String equipmentName;

    public MaintenanceInfo() {
    }

    public MaintenanceInfo(int id, int maintenanceUserID) {
        this.id = id;
        this.maintenanceUserID = maintenanceUserID;
    }

    public MaintenanceInfo(int id, String maintenanceContent) {
        this.id = id;
        this.maintenanceContent = maintenanceContent;
    }

    public MaintenanceInfo(int maintenanceSN, int areaID, int equipmentID, int reportUserID, String reportContent, String imageURL, String location) {
        this.maintenanceSN = maintenanceSN;
        this.areaID = areaID;
        this.equipmentID = equipmentID;
        this.reportUserID = reportUserID;
        this.reportContent = reportContent;
        this.imageURL = imageURL;
        this.location = location;
    }

    public MaintenanceInfo(int id, int maintenanceSN, int areaID, int equipmentID, int reportUserID, String reportContent, String imageURL, String location) {
        this.id = id;
        this.maintenanceSN = maintenanceSN;
        this.areaID = areaID;
        this.equipmentID = equipmentID;
        this.reportUserID = reportUserID;
        this.reportContent = reportContent;
        this.imageURL = imageURL;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaintenanceSN() {
        return maintenanceSN;
    }

    public void setMaintenanceSN(int maintenanceSN) {
        this.maintenanceSN = maintenanceSN;
    }

    public int getAreaID() {
        return areaID;
    }

    public void setAreaID(int areaID) {
        this.areaID = areaID;
    }

    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }

    public int getReportUserID() {
        return reportUserID;
    }

    public void setReportUserID(int reportUserID) {
        this.reportUserID = reportUserID;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getMaintenanceUserID() {
        return maintenanceUserID;
    }

    public void setMaintenanceUserID(int maintenanceUserID) {
        this.maintenanceUserID = maintenanceUserID;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getMaintenanceContent() {
        return maintenanceContent;
    }

    public void setMaintenanceContent(String maintenanceContent) {
        this.maintenanceContent = maintenanceContent;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getReportUserName() {
        return reportUserName;
    }

    public void setReportUserName(String reportUserName) {
        this.reportUserName = reportUserName;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getMaintenanceUserName() {
        return maintenanceUserName;
    }

    public void setMaintenanceUserName(String maintenanceUserName) {
        this.maintenanceUserName = maintenanceUserName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }
}
