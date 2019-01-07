package 用来存放测试用的实体类;


import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Where;
import sep.annotation.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Timestamp;

@Entity
@Table(name = "app_area")
@Where(clause = "sys_i_status != 1")
public class AppArea {
    private Integer iId;
    private String vcName;
    private String vcCode;
    private Integer iOrder;
    private Integer iPid;
    private Double dLongitude;
    private Double dLatitude;
    private String vcRemark;
    private Integer iExtend1;
    private Integer iExtend2;
    private String vcExtend1;
    private String vcExtend2;
    private String vcExtend3;
    private Timestamp sysDtCreate;
    private Integer sysICreateUser;
    private Timestamp sysDtLastUpdate;
    private Integer sysILastUpdateUser;
    private Integer sysIStatus;
    private String sysVcRemark;

    @Id
    @Column(name = "i_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    @Basic
    @Column(name = "vc_name")
    public String getVcName() {
        return vcName;
    }

    public void setVcName(String vcName) {
        this.vcName = vcName;
    }

    @Basic
    @Column(name = "vc_code")
    public String getVcCode() {
        return vcCode;
    }

    public void setVcCode(String vcCode) {
        this.vcCode = vcCode;
    }

    @Basic
    @Column(name = "i_order")
    public Integer getiOrder() {
        return iOrder;
    }

    public void setiOrder(Integer iOrder) {
        this.iOrder = iOrder;
    }

    @Basic
    @Column(name = "i_pid")
    public Integer getiPid() {
        return iPid;
    }

    public void setiPid(Integer iPid) {
        this.iPid = iPid;
    }

    @Basic
    @Column(name = "d_longitude")
    public Double getdLongitude() {
        return dLongitude;
    }

    public void setdLongitude(Double dLongitude) {
        this.dLongitude = dLongitude;
    }

    @Basic
    @Column(name = "d_latitude")
    public Double getdLatitude() {
        return dLatitude;
    }

    public void setdLatitude(Double dLatitude) {
        this.dLatitude = dLatitude;
    }

    @Basic
    @Column(name = "vc_remark")
    public String getVcRemark() {
        return vcRemark;
    }

    public void setVcRemark(String vcRemark) {
        this.vcRemark = vcRemark;
    }

    @Basic
    @Column(name = "i_extend1")
    public Integer getiExtend1() {
        return iExtend1;
    }

    public void setiExtend1(Integer iExtend1) {
        this.iExtend1 = iExtend1;
    }

    @Basic
    @Column(name = "i_extend2")
    public Integer getiExtend2() {
        return iExtend2;
    }

    public void setiExtend2(Integer iExtend2) {
        this.iExtend2 = iExtend2;
    }

    @Basic
    @Column(name = "vc_extend1")
    public String getVcExtend1() {
        return vcExtend1;
    }

    public void setVcExtend1(String vcExtend1) {
        this.vcExtend1 = vcExtend1;
    }

    @Basic
    @Column(name = "vc_extend2")
    public String getVcExtend2() {
        return vcExtend2;
    }

    public void setVcExtend2(String vcExtend2) {
        this.vcExtend2 = vcExtend2;
    }

    @Basic
    @Column(name = "vc_extend3")
    public String getVcExtend3() {
        return vcExtend3;
    }

    public void setVcExtend3(String vcExtend3) {
        this.vcExtend3 = vcExtend3;
    }

    @Basic
    @Column(name = "sys_dt_create")
    @CreateTimestamp
    public Timestamp getSysDtCreate() {
        return sysDtCreate;
    }

    public void setSysDtCreate(Timestamp sysDtCreate) {
        this.sysDtCreate = sysDtCreate;
    }

    @Basic
    @Column(name = "sys_i_create_user")
    public Integer getSysICreateUser() {
        return sysICreateUser;
    }

    public void setSysICreateUser(Integer sysICreateUser) {
        this.sysICreateUser = sysICreateUser;
    }

    @Basic
    @Column(name = "sys_dt_last_update")
    @UpdateTimestamp
    public Timestamp getSysDtLastUpdate() {
        return sysDtLastUpdate;
    }

    public void setSysDtLastUpdate(Timestamp sysDtLastUpdate) {
        this.sysDtLastUpdate = sysDtLastUpdate;
    }

    @Basic
    @Column(name = "sys_i_last_update_user")
    public Integer getSysILastUpdateUser() {
        return sysILastUpdateUser;
    }

    public void setSysILastUpdateUser(Integer sysILastUpdateUser) {
        this.sysILastUpdateUser = sysILastUpdateUser;
    }

    @Basic
    @Column(name = "sys_i_status")
    @ColumnDefault(value = "0")
    @Generated(GenerationTime.INSERT)
    public Integer getSysIStatus() {
        return sysIStatus;
    }

    public void setSysIStatus(Integer sysIStatus) {
        this.sysIStatus = sysIStatus;
    }

    @Basic
    @Column(name = "sys_vc_remark")
    public String getSysVcRemark() {
        return sysVcRemark;
    }

    public void setSysVcRemark(String sysVcRemark) {
        this.sysVcRemark = sysVcRemark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppArea appArea = (AppArea) o;

        if (iId != null ? !iId.equals(appArea.iId) : appArea.iId != null) return false;
        if (vcName != null ? !vcName.equals(appArea.vcName) : appArea.vcName != null) return false;
        if (vcCode != null ? !vcCode.equals(appArea.vcCode) : appArea.vcCode != null) return false;
        if (iOrder != null ? !iOrder.equals(appArea.iOrder) : appArea.iOrder != null) return false;
        if (iPid != null ? !iPid.equals(appArea.iPid) : appArea.iPid != null) return false;
        if (dLongitude != null ? !dLongitude.equals(appArea.dLongitude) : appArea.dLongitude != null) return false;
        if (dLatitude != null ? !dLatitude.equals(appArea.dLatitude) : appArea.dLatitude != null) return false;
        if (vcRemark != null ? !vcRemark.equals(appArea.vcRemark) : appArea.vcRemark != null) return false;
        if (iExtend1 != null ? !iExtend1.equals(appArea.iExtend1) : appArea.iExtend1 != null) return false;
        if (iExtend2 != null ? !iExtend2.equals(appArea.iExtend2) : appArea.iExtend2 != null) return false;
        if (vcExtend1 != null ? !vcExtend1.equals(appArea.vcExtend1) : appArea.vcExtend1 != null) return false;
        if (vcExtend2 != null ? !vcExtend2.equals(appArea.vcExtend2) : appArea.vcExtend2 != null) return false;
        if (vcExtend3 != null ? !vcExtend3.equals(appArea.vcExtend3) : appArea.vcExtend3 != null) return false;
        if (sysDtCreate != null ? !sysDtCreate.equals(appArea.sysDtCreate) : appArea.sysDtCreate != null) return false;
        if (sysICreateUser != null ? !sysICreateUser.equals(appArea.sysICreateUser) : appArea.sysICreateUser != null)
            return false;
        if (sysDtLastUpdate != null ? !sysDtLastUpdate.equals(appArea.sysDtLastUpdate) : appArea.sysDtLastUpdate != null)
            return false;
        if (sysILastUpdateUser != null ? !sysILastUpdateUser.equals(appArea.sysILastUpdateUser) : appArea.sysILastUpdateUser != null)
            return false;
        if (sysIStatus != null ? !sysIStatus.equals(appArea.sysIStatus) : appArea.sysIStatus != null) return false;
        if (sysVcRemark != null ? !sysVcRemark.equals(appArea.sysVcRemark) : appArea.sysVcRemark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iId != null ? iId.hashCode() : 0;
        result = 31 * result + (vcName != null ? vcName.hashCode() : 0);
        result = 31 * result + (vcCode != null ? vcCode.hashCode() : 0);
        result = 31 * result + (iOrder != null ? iOrder.hashCode() : 0);
        result = 31 * result + (iPid != null ? iPid.hashCode() : 0);
        result = 31 * result + (dLongitude != null ? dLongitude.hashCode() : 0);
        result = 31 * result + (dLatitude != null ? dLatitude.hashCode() : 0);
        result = 31 * result + (vcRemark != null ? vcRemark.hashCode() : 0);
        result = 31 * result + (iExtend1 != null ? iExtend1.hashCode() : 0);
        result = 31 * result + (iExtend2 != null ? iExtend2.hashCode() : 0);
        result = 31 * result + (vcExtend1 != null ? vcExtend1.hashCode() : 0);
        result = 31 * result + (vcExtend2 != null ? vcExtend2.hashCode() : 0);
        result = 31 * result + (vcExtend3 != null ? vcExtend3.hashCode() : 0);
        result = 31 * result + (sysDtCreate != null ? sysDtCreate.hashCode() : 0);
        result = 31 * result + (sysICreateUser != null ? sysICreateUser.hashCode() : 0);
        result = 31 * result + (sysDtLastUpdate != null ? sysDtLastUpdate.hashCode() : 0);
        result = 31 * result + (sysILastUpdateUser != null ? sysILastUpdateUser.hashCode() : 0);
        result = 31 * result + (sysIStatus != null ? sysIStatus.hashCode() : 0);
        result = 31 * result + (sysVcRemark != null ? sysVcRemark.hashCode() : 0);
        return result;
    }
}
