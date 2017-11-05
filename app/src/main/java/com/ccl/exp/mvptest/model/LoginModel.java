package com.ccl.exp.mvptest.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccl on 2016/10/21.
 */
public class LoginModel {

    /**
     * createTime : 2016-12-28 13:21:13
     * updateTime : 2016-12-28 13:21:13
     * isValid : 1
     * remarks : llf
     * studentID : 8638
     * provinceID : 110000
     * cityID : 110100
     * countyID : 110108
     * townshipID : null
     * schoolID : 1
     * gradeID : 1
     * eclassID : 1
     * paymentModeID : 25
     * equipmentModelID : 1
     * studentNumber :
     * studentName : 自选
     * headerPic : null
     * birthday : 2016-12-02 00:00:00
     * gender : 1
     * phoneNumber :
     * mail :
     * studentType : 1
     * deviceNumber : null
     * deviceName : null
     * appVersion : null
     * thirdGFee : 0
     * padFee : 0
     * accountAmount : 0
     * goldNum : 0
     * isDeduction : 0
     * isThirdGPay : 0
     * isPadPay : 0
     * isOnline : 0
     * isLogined : 0
     * lastLoginTime : null
     * invalidTime : 2017-12-29 00:00:00
     * topLevel : null
     * isReview : 0
     * unreadMessageNum : 0
     * labelIDs :
     * firstLoginTime : null
     * tryKind : 0
     * isDeleteBook : 0
     * releaseChannel : tpschool00
     * systemLoginName : 1655546
     * studentLoginName : null
     * isExperimental:1
     * memberType : 2
     * memberPriceList : [{"createTime":null,"updateTime":null,"isValid":1,"remarks":"","memberPriceID":4,"memberType":2,"year":1,"thirdGPrice":350,"padPrice":1980,"padOriginalPrice":2380},{"createTime":null,"updateTime":null,"isValid":1,"remarks":"","memberPriceID":5,"memberType":2,"year":2,"thirdGPrice":700,"padPrice":3060,"padOriginalPrice":3760},{"createTime":null,"updateTime":null,"isValid":1,"remarks":"","memberPriceID":6,"memberType":2,"year":3,"thirdGPrice":1050,"padPrice":3960,"padOriginalPrice":4940}]
     */

    private String createTime;
    private String updateTime;
    private int isValid;
    private String remarks;
    private int studentID;
    private int provinceID;
    private int cityID;
    private int countyID;
    private String townshipID;
    private int schoolID;
    private int gradeID;
    private int eclassID;
    private int paymentModeID;
    private int equipmentModelID;
    private String studentNumber;
    private String studentName;
    private String headerPic;
    private String birthday;
    private String gender;
    private String phoneNumber;
    private String mail;
    private int studentType;
    private String deviceNumber;
    private String deviceName;
    private String appVersion;
    private String thirdGFee;
    private String padFee;
    private int goldNum;
    private int isDeduction;
    private int isThirdGPay;
    private int isPadPay;
    private int isOnline;
    private int isLogined;
    private String lastLoginTime;
    private String invalidTime;
    private String topLevel;
    private int isReview;
    private int unreadMessageNum;
    private String labelIDs;
    private String firstLoginTime;
    private int tryKind;
    private int isDeleteBook;
    private String releaseChannel;
    private String systemLoginName;
    private String studentLoginName;
    private int memberType;
    private String internetProtocol;
    private String companyProtocol;
    private String payProtocol;
    private String cardIntroduction;
    private long sendPaymentID;
    private int paymentType;
    private long sendPriceID;
    private int isExperimental;
    private int showPersonalAccount;
    private int isSend;
    private String padIntroduction;
    private String activityUrl;
    private int studySection;
    private int isUploadMp3;
    private String commentUrl;
    private String reportUrl;

    @Override
    public String toString() {
        return "LoginModel{" +
                "createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", isValid=" + isValid +
                ", remarks='" + remarks + '\'' +
                ", studentID=" + studentID +
                ", provinceID=" + provinceID +
                ", cityID=" + cityID +
                ", countyID=" + countyID +
                ", townshipID='" + townshipID + '\'' +
                ", schoolID=" + schoolID +
                ", gradeID=" + gradeID +
                ", eclassID=" + eclassID +
                ", paymentModeID=" + paymentModeID +
                ", equipmentModelID=" + equipmentModelID +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentName='" + studentName + '\'' +
                ", headerPic='" + headerPic + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", mail='" + mail + '\'' +
                ", studentType=" + studentType +
                ", deviceNumber='" + deviceNumber + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", thirdGFee='" + thirdGFee + '\'' +
                ", padFee='" + padFee + '\'' +
                ", goldNum=" + goldNum +
                ", isDeduction=" + isDeduction +
                ", isThirdGPay=" + isThirdGPay +
                ", isPadPay=" + isPadPay +
                ", isOnline=" + isOnline +
                ", isLogined=" + isLogined +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", invalidTime='" + invalidTime + '\'' +
                ", topLevel='" + topLevel + '\'' +
                ", isReview=" + isReview +
                ", unreadMessageNum=" + unreadMessageNum +
                ", labelIDs='" + labelIDs + '\'' +
                ", firstLoginTime='" + firstLoginTime + '\'' +
                ", tryKind=" + tryKind +
                ", isDeleteBook=" + isDeleteBook +
                ", releaseChannel='" + releaseChannel + '\'' +
                ", systemLoginName='" + systemLoginName + '\'' +
                ", studentLoginName='" + studentLoginName + '\'' +
                ", memberType=" + memberType +
                ", internetProtocol='" + internetProtocol + '\'' +
                ", companyProtocol='" + companyProtocol + '\'' +
                ", payProtocol='" + payProtocol + '\'' +
                ", cardIntroduction='" + cardIntroduction + '\'' +
                ", sendPaymentID=" + sendPaymentID +
                ", paymentType=" + paymentType +
                ", sendPriceID=" + sendPriceID +
                ", isExperimental=" + isExperimental +
                ", showPersonalAccount=" + showPersonalAccount +
                ", isSend=" + isSend +
                ", padIntroduction='" + padIntroduction + '\'' +
                ", activityUrl='" + activityUrl + '\'' +
                ", studySection=" + studySection +
                ", isUploadMp3=" + isUploadMp3 +
                ", commentUrl='" + commentUrl + '\'' +
                ", reportUrl='" + reportUrl + '\'' +
                ", memberPriceList=" + memberPriceList +
                '}';
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    public String getCommentUrl() {
        return commentUrl;
    }

    public void setCommentUrl(String commentUrl) {
        this.commentUrl = commentUrl;
    }

    /**
     * createTime : null
     * updateTime : null
     * isValid : 1
     * remarks :
     * memberPriceID : 4
     * memberType : 2
     * year : 1
     * thirdGPrice : 350
     * padPrice : 1980
     * padOriginalPrice : 2380
     */

    private List<MemberPriceListBean> memberPriceList;

    public static List<LoginModel> arrayLoginModelFromData(String str) {

        Type listType = new TypeToken<ArrayList<LoginModel>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public int getIsUploadMp3() {
        return isUploadMp3;
    }

    public void setIsUploadMp3(int isUploadMp3) {
        this.isUploadMp3 = isUploadMp3;
    }

    public int getStudySection() {
        return studySection;
    }

    public void setStudySection(int studySection) {
        this.studySection = studySection;
    }

    public String getActivityUrl() {
        return activityUrl;
    }

    public void setActivityUrl(String activityUrl) {
        this.activityUrl = activityUrl;
    }

    public String getPadIntroduction() {
        return padIntroduction;
    }

    public void setPadIntroduction(String padIntroduction) {
        this.padIntroduction = padIntroduction;
    }

    public long getSendPriceID() {
        return sendPriceID;
    }

    public void setSendPriceID(long sendPriceID) {
        this.sendPriceID = sendPriceID;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public long getSendPaymentID() {
        return sendPaymentID;
    }

    public void setSendPaymentID(long sendPaymentID) {
        this.sendPaymentID = sendPaymentID;
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

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(int provinceID) {
        this.provinceID = provinceID;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public int getCountyID() {
        return countyID;
    }

    public void setCountyID(int countyID) {
        this.countyID = countyID;
    }

    public String getTownshipID() {
        return townshipID;
    }

    public void setTownshipID(String townshipID) {
        this.townshipID = townshipID;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    public int getGradeID() {
        return gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }

    public int getEclassID() {
        return eclassID;
    }

    public void setEclassID(int eclassID) {
        this.eclassID = eclassID;
    }

    public int getPaymentModeID() {
        return paymentModeID;
    }

    public void setPaymentModeID(int paymentModeID) {
        this.paymentModeID = paymentModeID;
    }

    public int getEquipmentModelID() {
        return equipmentModelID;
    }

    public void setEquipmentModelID(int equipmentModelID) {
        this.equipmentModelID = equipmentModelID;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getHeaderPic() {
        return headerPic;
    }

    public void setHeaderPic(String headerPic) {
        this.headerPic = headerPic;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getStudentType() {
        return studentType;
    }

    public void setStudentType(int studentType) {
        this.studentType = studentType;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getThirdGFee() {
        return thirdGFee;
    }

    public void setThirdGFee(String thirdGFee) {
        this.thirdGFee = thirdGFee;
    }

    public String getPadFee() {
        return padFee;
    }

    public void setPadFee(String padFee) {
        this.padFee = padFee;
    }

    public int getGoldNum() {
        return goldNum;
    }

    public void setGoldNum(int goldNum) {
        this.goldNum = goldNum;
    }

    public int getIsDeduction() {
        return isDeduction;
    }

    public void setIsDeduction(int isDeduction) {
        this.isDeduction = isDeduction;
    }

    public int getIsThirdGPay() {
        return isThirdGPay;
    }

    public void setIsThirdGPay(int isThirdGPay) {
        this.isThirdGPay = isThirdGPay;
    }

    public int getIsPadPay() {
        return isPadPay;
    }

    public void setIsPadPay(int isPadPay) {
        this.isPadPay = isPadPay;
    }

    public int getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(int isOnline) {
        this.isOnline = isOnline;
    }

    public int getIsLogined() {
        return isLogined;
    }

    public void setIsLogined(int isLogined) {
        this.isLogined = isLogined;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(String invalidTime) {
        this.invalidTime = invalidTime;
    }

    public String getTopLevel() {
        return topLevel;
    }

    public void setTopLevel(String topLevel) {
        this.topLevel = topLevel;
    }

    public int getIsReview() {
        return isReview;
    }

    public void setIsReview(int isReview) {
        this.isReview = isReview;
    }

    public int getUnreadMessageNum() {
        return unreadMessageNum;
    }

    public void setUnreadMessageNum(int unreadMessageNum) {
        this.unreadMessageNum = unreadMessageNum;
    }

    public String getLabelIDs() {
        return labelIDs;
    }

    public void setLabelIDs(String labelIDs) {
        this.labelIDs = labelIDs;
    }

    public String getFirstLoginTime() {
        return firstLoginTime;
    }

    public void setFirstLoginTime(String firstLoginTime) {
        this.firstLoginTime = firstLoginTime;
    }

    public int getTryKind() {
        return tryKind;
    }

    public void setTryKind(int tryKind) {
        this.tryKind = tryKind;
    }

    public int getIsDeleteBook() {
        return isDeleteBook;
    }

    public void setIsDeleteBook(int isDeleteBook) {
        this.isDeleteBook = isDeleteBook;
    }

    public String getReleaseChannel() {
        return releaseChannel;
    }

    public void setReleaseChannel(String releaseChannel) {
        this.releaseChannel = releaseChannel;
    }

    public String getSystemLoginName() {
        return systemLoginName;
    }

    public void setSystemLoginName(String systemLoginName) {
        this.systemLoginName = systemLoginName;
    }

    public String getStudentLoginName() {
        return studentLoginName;
    }

    public void setStudentLoginName(String studentLoginName) {
        this.studentLoginName = studentLoginName;
    }

    public int getMemberType() {
        return memberType;
    }

    public void setMemberType(int memberType) {
        this.memberType = memberType;
    }

    public List<MemberPriceListBean> getMemberPriceList() {
        return memberPriceList;
    }

    public void setMemberPriceList(List<MemberPriceListBean> memberPriceList) {
        this.memberPriceList = memberPriceList;
    }

    public String getInternetProtocol() {
        return internetProtocol;
    }

    public void setInternetProtocol(String internetProtocol) {
        this.internetProtocol = internetProtocol;
    }

    public String getCompanyProtocol() {
        return companyProtocol;
    }

    public void setCompanyProtocol(String companyProtocol) {
        this.companyProtocol = companyProtocol;
    }

    public String getPayProtocol() {
        return payProtocol;
    }

    public void setPayProtocol(String payProtocol) {
        this.payProtocol = payProtocol;
    }

    public String getCardIntroduction() {
        return cardIntroduction;
    }

    public void setCardIntroduction(String cardIntroduction) {
        this.cardIntroduction = cardIntroduction;
    }

    public int getIsExperimental() {
        return isExperimental;
    }

    public void setIsExperimental(int isExperimental) {
        this.isExperimental = isExperimental;
    }

    public int getShowPersonalAccount() {
        return showPersonalAccount;
    }

    public void setShowPersonalAccount(int showPersonalAccount) {
        this.showPersonalAccount = showPersonalAccount;
    }

    public int getIsSend() {
        return isSend;
    }

    public void setIsSend(int isSend) {
        this.isSend = isSend;
    }

    public static class MemberPriceListBean implements Serializable {
        private String createTime;
        private String updateTime;
        private int isValid;
        private String remarks;
        private int memberPriceID;
        private int memberType;
        private int year;
        private int thirdGPrice;
        private int padPrice;
        private int padOriginalPrice;

        public static List<MemberPriceListBean> arrayMemberPriceListBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<MemberPriceListBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
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

        public int getIsValid() {
            return isValid;
        }

        public void setIsValid(int isValid) {
            this.isValid = isValid;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public int getMemberPriceID() {
            return memberPriceID;
        }

        public void setMemberPriceID(int memberPriceID) {
            this.memberPriceID = memberPriceID;
        }

        public int getMemberType() {
            return memberType;
        }

        public void setMemberType(int memberType) {
            this.memberType = memberType;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getThirdGPrice() {
            return thirdGPrice;
        }

        public void setThirdGPrice(int thirdGPrice) {
            this.thirdGPrice = thirdGPrice;
        }

        public int getPadPrice() {
            return padPrice;
        }

        public void setPadPrice(int padPrice) {
            this.padPrice = padPrice;
        }

        public int getPadOriginalPrice() {
            return padOriginalPrice;
        }

        public void setPadOriginalPrice(int padOriginalPrice) {
            this.padOriginalPrice = padOriginalPrice;
        }
    }
}
