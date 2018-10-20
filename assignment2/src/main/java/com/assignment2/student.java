package com.assignment2;

public class student {
    private int num;
    private double Rtg;
    private String name, fieldId, fed, club;

    public student(int num, String name, String fieldId, String fed, double rtg, String club) {
        this.num = num;
        this.name = name;
        this.fieldId = fieldId;
        this.fed = fed;
        this.Rtg = rtg;
        this.club = club;
    }
    public student(){
        super();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFed() {
        return fed;
    }

    public void setFed(String fed) {
        this.fed = fed;
    }

    public double getRtg() {
        return Rtg;
    }

    public void setRtg(double rtg) {
        this.Rtg = rtg;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
