package org.sellers.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_EXAMPLE")
public class TExample {
    @Id
    @Column(name = "EXAMPLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short exampleId;

    @Column(name = "EXAMPLE_NAME")
    private String exampleName;

    @Column(name = "EXAMPLE_DESC")
    private String exampleDesc;

    @Column(name = "INSERT_TIME")
    private Date insertTime;

    @Column(name = "IMAGES")
    private String images;

    /**
     * @return EXAMPLE_ID
     */
    public Short getExampleId() {
        return exampleId;
    }

    /**
     * @param exampleId
     */
    public void setExampleId(Short exampleId) {
        this.exampleId = exampleId;
    }

    /**
     * @return EXAMPLE_NAME
     */
    public String getExampleName() {
        return exampleName;
    }

    /**
     * @param exampleName
     */
    public void setExampleName(String exampleName) {
        this.exampleName = exampleName == null ? null : exampleName.trim();
    }

    /**
     * @return EXAMPLE_DESC
     */
    public String getExampleDesc() {
        return exampleDesc;
    }

    /**
     * @param exampleDesc
     */
    public void setExampleDesc(String exampleDesc) {
        this.exampleDesc = exampleDesc == null ? null : exampleDesc.trim();
    }

    /**
     * @return INSERT_TIME
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return IMAGES
     */
    public String getImages() {
        return images;
    }

    /**
     * @param images
     */
    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }
}