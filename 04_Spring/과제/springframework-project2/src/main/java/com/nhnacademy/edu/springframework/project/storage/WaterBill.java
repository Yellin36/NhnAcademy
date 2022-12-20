package com.nhnacademy.edu.springframework.project.storage;

public class WaterBill {
    private int num;
    private String city;
    private String sector;
    private int unitPrice;
    private int billTotal;

    public WaterBill(int num, String city, String sector) {
        this.num = num;
        this.city = city;
        this.sector = sector;
    }

    public int getNum() {
        return num;
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getBillTotal() {
        return billTotal;
    }

    public void setUnitPrice(int unitPrice) { this.unitPrice = unitPrice;  }


    public void setBillTotal(int usage) {
        this.billTotal = unitPrice * usage;
    }

    public String toString() {
        return "WaterBill{" +
                "city='" + city + '\'' +
                ", sector='" + sector + '\'' +
                ", unitPrice=" + unitPrice +
                ", billTotal=" + billTotal +
                "}\n";
    }
}

