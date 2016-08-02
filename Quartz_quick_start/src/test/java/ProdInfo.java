/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */

/**
 * Created by baidu on 16/8/2.
 */
public class ProdInfo {
    private String productName;
    private String productCode;

    public ProdInfo() {
    }

    public ProdInfo(String productName, String productCode) {
        this.productName = productName;
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return "ProdInfo{" +
                "productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                '}';
    }
}
