package org.sellers.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_PRODUCT")
public class TProduct {
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_TYPE")
    private String productType;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "VALIDITY_TIME")
    private Date validityTime;

    /**
     * @return PRODUCT_ID
     */
    public Short getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(Short productId) {
        this.productId = productId;
    }

    /**
     * @return PRODUCT_NAME
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * @return PRODUCT_TYPE
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType
     */
    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    /**
     * @return PRICE
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    /**
     * @return VALIDITY_TIME
     */
    public Date getValidityTime() {
        return validityTime;
    }

    /**
     * @param validityTime
     */
    public void setValidityTime(Date validityTime) {
        this.validityTime = validityTime;
    }
}