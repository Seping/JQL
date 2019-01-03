package sep.entity.用来存放测试用的实体类;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "app_db_material")
@Where(clause = "sys_i_status != 1")
public class AppDbMaterial {
    private Integer iId;
    private String vcName;
    private Integer iMaterialClassId;
    private Integer iMaterialAddressId;
    private String vcSpecification;
    private Integer iNumber;
    private String vcUnit;
    private Date dtQuaguaPeriod;
    private Date dtRenewTime;
    private Integer iState;
    private Integer iConsumables;
    private Integer iMaintenanceState;
    private Integer iCaseClass;
    private Integer iSecrecyDegree;
    private Integer iLevel;
    private String vcManufacturer;
    private String vcAddress;
    private String vcCallmode;
    private String vcRemark;
    private String vcCapabilityParam;
    private Timestamp dtUpdateTime;
    private Integer sysIStatus;
    private Timestamp sysDtCreate;
    private Integer sysICreateUser;
    private Timestamp sysDtLastUpdate;
    private Integer sysILastUpdateUser;
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
    @Column(name = "i_material_class_id")
    public Integer getiMaterialClassId() {
        return iMaterialClassId;
    }

    public void setiMaterialClassId(Integer iMaterialClassId) {
        this.iMaterialClassId = iMaterialClassId;
    }

    @Basic
    @Column(name = "i_material_address_id")
    public Integer getiMaterialAddressId() {
        return iMaterialAddressId;
    }

    public void setiMaterialAddressId(Integer iMaterialAddressId) {
        this.iMaterialAddressId = iMaterialAddressId;
    }

    @Basic
    @Column(name = "vc_specification")
    public String getVcSpecification() {
        return vcSpecification;
    }

    public void setVcSpecification(String vcSpecification) {
        this.vcSpecification = vcSpecification;
    }

    @Basic
    @Column(name = "i_number")
    public Integer getiNumber() {
        return iNumber;
    }

    public void setiNumber(Integer iNumber) {
        this.iNumber = iNumber;
    }

    @Basic
    @Column(name = "vc_unit")
    public String getVcUnit() {
        return vcUnit;
    }

    public void setVcUnit(String vcUnit) {
        this.vcUnit = vcUnit;
    }

    @Basic
    @Column(name = "dt_quagua_period")
    public Date getDtQuaguaPeriod() {
        return dtQuaguaPeriod;
    }

    public void setDtQuaguaPeriod(Date dtQuaguaPeriod) {
        this.dtQuaguaPeriod = dtQuaguaPeriod;
    }

    @Basic
    @Column(name = "dt_renew_time")
    public Date getDtRenewTime() {
        return dtRenewTime;
    }

    public void setDtRenewTime(Date dtRenewTime) {
        this.dtRenewTime = dtRenewTime;
    }

    @Basic
    @Column(name = "i_state")
    public Integer getiState() {
        return iState;
    }

    public void setiState(Integer iState) {
        this.iState = iState;
    }

    @Basic
    @Column(name = "i_consumables")
    public Integer getiConsumables() {
        return iConsumables;
    }

    public void setiConsumables(Integer iConsumables) {
        this.iConsumables = iConsumables;
    }

    @Basic
    @Column(name = "i_maintenance_state")
    public Integer getiMaintenanceState() {
        return iMaintenanceState;
    }

    public void setiMaintenanceState(Integer iMaintenanceState) {
        this.iMaintenanceState = iMaintenanceState;
    }

    @Basic
    @Column(name = "i_case_class")
    public Integer getiCaseClass() {
        return iCaseClass;
    }

    public void setiCaseClass(Integer iCaseClass) {
        this.iCaseClass = iCaseClass;
    }

    @Basic
    @Column(name = "i_secrecy_degree")
    public Integer getiSecrecyDegree() {
        return iSecrecyDegree;
    }

    public void setiSecrecyDegree(Integer iSecrecyDegree) {
        this.iSecrecyDegree = iSecrecyDegree;
    }

    @Basic
    @Column(name = "i_level")
    public Integer getiLevel() {
        return iLevel;
    }

    public void setiLevel(Integer iLevel) {
        this.iLevel = iLevel;
    }

    @Basic
    @Column(name = "vc_manufacturer")
    public String getVcManufacturer() {
        return vcManufacturer;
    }

    public void setVcManufacturer(String vcManufacturer) {
        this.vcManufacturer = vcManufacturer;
    }

    @Basic
    @Column(name = "vc_address")
    public String getVcAddress() {
        return vcAddress;
    }

    public void setVcAddress(String vcAddress) {
        this.vcAddress = vcAddress;
    }

    @Basic
    @Column(name = "vc_callmode")
    public String getVcCallmode() {
        return vcCallmode;
    }

    public void setVcCallmode(String vcCallmode) {
        this.vcCallmode = vcCallmode;
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
    @Column(name = "vc_capability_param")
    public String getVcCapabilityParam() {
        return vcCapabilityParam;
    }

    public void setVcCapabilityParam(String vcCapabilityParam) {
        this.vcCapabilityParam = vcCapabilityParam;
    }

    @Basic
    @Column(name = "dt_update_time")
    public Timestamp getDtUpdateTime() {
        return dtUpdateTime;
    }

    public void setDtUpdateTime(Timestamp dtUpdateTime) {
        this.dtUpdateTime = dtUpdateTime;
    }

    @Basic
    @Column(name = "sys_i_status", updatable = false)
    @ColumnDefault("0")
    @Generated(GenerationTime.INSERT)
    public Integer getSysIStatus() {
        return sysIStatus;
    }

    public void setSysIStatus(Integer sysIStatus) {
        this.sysIStatus = sysIStatus;
    }

    @Basic
    @Column(name = "sys_dt_create", updatable = false)
    @CreationTimestamp
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

        AppDbMaterial that = (AppDbMaterial) o;

        if (iId != null ? !iId.equals(that.iId) : that.iId != null) return false;
        if (vcName != null ? !vcName.equals(that.vcName) : that.vcName != null) return false;
        if (iMaterialClassId != null ? !iMaterialClassId.equals(that.iMaterialClassId) : that.iMaterialClassId != null)
            return false;
        if (iMaterialAddressId != null ? !iMaterialAddressId.equals(that.iMaterialAddressId) : that.iMaterialAddressId != null)
            return false;
        if (vcSpecification != null ? !vcSpecification.equals(that.vcSpecification) : that.vcSpecification != null)
            return false;
        if (iNumber != null ? !iNumber.equals(that.iNumber) : that.iNumber != null) return false;
        if (vcUnit != null ? !vcUnit.equals(that.vcUnit) : that.vcUnit != null) return false;
        if (dtQuaguaPeriod != null ? !dtQuaguaPeriod.equals(that.dtQuaguaPeriod) : that.dtQuaguaPeriod != null)
            return false;
        if (dtRenewTime != null ? !dtRenewTime.equals(that.dtRenewTime) : that.dtRenewTime != null) return false;
        if (iState != null ? !iState.equals(that.iState) : that.iState != null) return false;
        if (iConsumables != null ? !iConsumables.equals(that.iConsumables) : that.iConsumables != null) return false;
        if (iMaintenanceState != null ? !iMaintenanceState.equals(that.iMaintenanceState) : that.iMaintenanceState != null)
            return false;
        if (iCaseClass != null ? !iCaseClass.equals(that.iCaseClass) : that.iCaseClass != null) return false;
        if (iSecrecyDegree != null ? !iSecrecyDegree.equals(that.iSecrecyDegree) : that.iSecrecyDegree != null)
            return false;
        if (iLevel != null ? !iLevel.equals(that.iLevel) : that.iLevel != null) return false;
        if (vcManufacturer != null ? !vcManufacturer.equals(that.vcManufacturer) : that.vcManufacturer != null)
            return false;
        if (vcAddress != null ? !vcAddress.equals(that.vcAddress) : that.vcAddress != null) return false;
        if (vcCallmode != null ? !vcCallmode.equals(that.vcCallmode) : that.vcCallmode != null) return false;
        if (vcRemark != null ? !vcRemark.equals(that.vcRemark) : that.vcRemark != null) return false;
        if (vcCapabilityParam != null ? !vcCapabilityParam.equals(that.vcCapabilityParam) : that.vcCapabilityParam != null)
            return false;
        if (dtUpdateTime != null ? !dtUpdateTime.equals(that.dtUpdateTime) : that.dtUpdateTime != null) return false;
        if (sysIStatus != null ? !sysIStatus.equals(that.sysIStatus) : that.sysIStatus != null) return false;
        if (sysDtCreate != null ? !sysDtCreate.equals(that.sysDtCreate) : that.sysDtCreate != null) return false;
        if (sysICreateUser != null ? !sysICreateUser.equals(that.sysICreateUser) : that.sysICreateUser != null)
            return false;
        if (sysDtLastUpdate != null ? !sysDtLastUpdate.equals(that.sysDtLastUpdate) : that.sysDtLastUpdate != null)
            return false;
        if (sysILastUpdateUser != null ? !sysILastUpdateUser.equals(that.sysILastUpdateUser) : that.sysILastUpdateUser != null)
            return false;
        if (sysVcRemark != null ? !sysVcRemark.equals(that.sysVcRemark) : that.sysVcRemark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iId != null ? iId.hashCode() : 0;
        result = 31 * result + (vcName != null ? vcName.hashCode() : 0);
        result = 31 * result + (iMaterialClassId != null ? iMaterialClassId.hashCode() : 0);
        result = 31 * result + (iMaterialAddressId != null ? iMaterialAddressId.hashCode() : 0);
        result = 31 * result + (vcSpecification != null ? vcSpecification.hashCode() : 0);
        result = 31 * result + (iNumber != null ? iNumber.hashCode() : 0);
        result = 31 * result + (vcUnit != null ? vcUnit.hashCode() : 0);
        result = 31 * result + (dtQuaguaPeriod != null ? dtQuaguaPeriod.hashCode() : 0);
        result = 31 * result + (dtRenewTime != null ? dtRenewTime.hashCode() : 0);
        result = 31 * result + (iState != null ? iState.hashCode() : 0);
        result = 31 * result + (iConsumables != null ? iConsumables.hashCode() : 0);
        result = 31 * result + (iMaintenanceState != null ? iMaintenanceState.hashCode() : 0);
        result = 31 * result + (iCaseClass != null ? iCaseClass.hashCode() : 0);
        result = 31 * result + (iSecrecyDegree != null ? iSecrecyDegree.hashCode() : 0);
        result = 31 * result + (iLevel != null ? iLevel.hashCode() : 0);
        result = 31 * result + (vcManufacturer != null ? vcManufacturer.hashCode() : 0);
        result = 31 * result + (vcAddress != null ? vcAddress.hashCode() : 0);
        result = 31 * result + (vcCallmode != null ? vcCallmode.hashCode() : 0);
        result = 31 * result + (vcRemark != null ? vcRemark.hashCode() : 0);
        result = 31 * result + (vcCapabilityParam != null ? vcCapabilityParam.hashCode() : 0);
        result = 31 * result + (dtUpdateTime != null ? dtUpdateTime.hashCode() : 0);
        result = 31 * result + (sysIStatus != null ? sysIStatus.hashCode() : 0);
        result = 31 * result + (sysDtCreate != null ? sysDtCreate.hashCode() : 0);
        result = 31 * result + (sysICreateUser != null ? sysICreateUser.hashCode() : 0);
        result = 31 * result + (sysDtLastUpdate != null ? sysDtLastUpdate.hashCode() : 0);
        result = 31 * result + (sysILastUpdateUser != null ? sysILastUpdateUser.hashCode() : 0);
        result = 31 * result + (sysVcRemark != null ? sysVcRemark.hashCode() : 0);
        return result;
    }
}
