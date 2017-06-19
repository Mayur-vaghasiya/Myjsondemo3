package com.example.myjsondemo;


public class product {


    private String Name, ImageName, ProductID, PackageID, SKU, LastModified, CategoryIDs;
    private Long Price;

    public product(){

    }
    public product( String Name, String productID, String packageID, String Image, String SKU,String lastModified, Long Price, String categoryIDs) {
        this.Name = Name;
        this.ImageName = Image;
        this.Price = Price;
        this.ProductID=productID;
        this.PackageID=packageID;
        this.SKU=SKU;
        this.LastModified=lastModified;
        this.CategoryIDs=categoryIDs;

    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setImageName(String Image) {
        this.ImageName = Image;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setPrice(Long price) {
        this.Price = price;
    }

    public Long getPrice() {
        return Price;
    }

    public void setProductID(String productID) {
        this.ProductID = productID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setPackageID(String packageID) {
        this.PackageID = packageID;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getSKU() {
        return SKU;
    }

    public void setLastModified(String lastModified) {
        this.LastModified = lastModified;
    }

    public String getLastModified() {
        return LastModified;
    }

    public void setCategoryIDs(String categoryIDs) {
        this.CategoryIDs = categoryIDs;
    }
    public String getCategoryIDs(){
        return  CategoryIDs;
    }
}
