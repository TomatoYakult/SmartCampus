package com.zzti.zut.entity;

public class EquipmentInfo {
    private int id;
    private int equipmentSN;
    private String equipmentName;
    private String equipmentType;
    private String responsiblePerson;
    private String remark;
    private int del;
    private String createTime;
    private String updateTime;

    public EquipmentInfo() {
    }

    public EquipmentInfo(int id, int del) {
        this.id = id;
        this.del = del;
    }

    public EquipmentInfo(int equipmentSN, String equipmentName, String equipmentType, String responsiblePerson, String remark) {
        this.equipmentSN = equipmentSN;
        this.equipmentName = equipmentName;
        this.equipmentType = equipmentType;
        this.responsiblePerson = responsiblePerson;
        this.remark = remark;
    }

    public EquipmentInfo(int id, int equipmentSN, String equipmentName, String equipmentType, String responsiblePerson, String remark) {
        this.id = id;
        this.equipmentSN = equipmentSN;
        this.equipmentName = equipmentName;
        this.equipmentType = equipmentType;
        this.responsiblePerson = responsiblePerson;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEquipmentSN() {
        return equipmentSN;
    }

    public void setEquipmentSN(int equipmentSN) {
        this.equipmentSN = equipmentSN;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
