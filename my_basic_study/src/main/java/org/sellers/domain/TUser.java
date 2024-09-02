package org.sellers.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "T_USER")
public class TUser {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "REAL_NAME")
    private String realName;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private BigDecimal phoneNumber;

    @Column(name = "USER_TYPE")
    private String userType;

    @Column(name = "ADDRESS")
    private Object address;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "PRODUCT_ID")
    private Short productId;

    @Column(name = "USER_INFOR_ID")
    private Short userInforId;

    @Column(name = "PAYER_ID")
    private Short payerId;

    /**
     * @return USER_ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return REAL_NAME
     */
    public String getRealName() {
        return realName;
    }

    /**
     * @param realName
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * @return GENDER
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * @return USER_NAME
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return PHONE_NUMBER
     */
    public BigDecimal getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(BigDecimal phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return USER_TYPE
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * @return ADDRESS
     */
    public Object getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(Object address) {
        this.address = address;
    }

    /**
     * @return BIRTHDAY
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

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
     * @return USER_INFOR_ID
     */
    public Short getUserInforId() {
        return userInforId;
    }

    /**
     * @param userInforId
     */
    public void setUserInforId(Short userInforId) {
        this.userInforId = userInforId;
    }

    /**
     * @return PAYER_ID
     */
    public Short getPayerId() {
        return payerId;
    }

    /**
     * @param payerId
     */
    public void setPayerId(Short payerId) {
        this.payerId = payerId;
    }
}