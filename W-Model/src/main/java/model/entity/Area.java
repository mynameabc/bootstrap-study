package model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sys_area")
public class Area implements java.io.Serializable {

    @Id
    @Column(name = "areaID")
    private String areaID;

    @Column(name = "parentID")
    private String parentID;

    @Column(name = "name")
    private String name;

    @Column(name = "sort")
    private BigDecimal sort;

    @Column(name = "code")
    private String code;

    @Column(name = "grade")
    private String grade;

    @Column(name = "delFlag")
    private Boolean delFlag;

    public String getAreaID() {
        return areaID;
    }

    public void setAreaID(String areaID) {
        this.areaID = areaID;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSort() {
        return sort;
    }

    public void setSort(BigDecimal sort) {
        this.sort = sort;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}
