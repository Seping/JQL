package 用来存放测试用的实体类;

import sep.annotation.Column;
import sep.annotation.Id;
import sep.annotation.Table;
import sep.entity.struct.field.special.CreateTimestamp;
import sep.entity.struct.field.special.CreateUser;
import sep.entity.struct.field.special.UpdateTimestamp;
import sep.entity.struct.field.special.UpdateUser;

import java.sql.Timestamp;


@Table(name = "app_db_material_address")
public class AppDbMaterialAddress {
    private Integer iId;
    private String vcName;
    private Integer iAreaId;
    private String vcDept;
    private Double dLongitude;
    private Double dLatitude;
    private String vcAddress;
    private String vcTraffic;
    private String vcDutyTel;
    private String vcFax;
    private String vcDeptAddress;
    private String vcGroup;
    private Timestamp dtUpdateTime;
    private String vcRemark;
    private Timestamp dtUseTime;
    private String vcBasicSituation;
    private Double dArea;
    private Integer iDeptId;
    private Integer iOperateId;
    private Integer iStatus;
    private Integer iExtend1;
    private Integer iExtend2;
    private String vcExtend1;
    private String vcExtend2;
    private String vcExtend3;
    private Integer sysIStatus;
    private Timestamp sysDtCreate;
    private Integer sysICreateUser;
    private Timestamp sysDtLastUpdate;
    private Integer sysILastUpdateUser;
    private String sysVcRemark;

    @Id(columnName = "i_id")
    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    
    @Column(columnName = "vc_name")
    public String getVcName() {
        return vcName;
    }

    public void setVcName(String vcName) {
        this.vcName = vcName;
    }

    
    @Column(columnName = "i_area_id")
    public Integer getiAreaId() {
        return iAreaId;
    }

    public void setiAreaId(Integer iAreaId) {
        this.iAreaId = iAreaId;
    }

    
    @Column(columnName = "vc_dept")
    public String getVcDept() {
        return vcDept;
    }

    public void setVcDept(String vcDept) {
        this.vcDept = vcDept;
    }

    
    @Column(columnName = "d_longitude")
    public Double getdLongitude() {
        return dLongitude;
    }

    public void setdLongitude(Double dLongitude) {
        this.dLongitude = dLongitude;
    }

    
    @Column(columnName = "d_latitude")
    public Double getdLatitude() {
        return dLatitude;
    }

    public void setdLatitude(Double dLatitude) {
        this.dLatitude = dLatitude;
    }

    
    @Column(columnName = "vc_address")
    public String getVcAddress() {
        return vcAddress;
    }

    public void setVcAddress(String vcAddress) {
        this.vcAddress = vcAddress;
    }

    
    @Column(columnName = "vc_traffic")
    public String getVcTraffic() {
        return vcTraffic;
    }

    public void setVcTraffic(String vcTraffic) {
        this.vcTraffic = vcTraffic;
    }

    
    @Column(columnName = "vc_duty_tel")
    public String getVcDutyTel() {
        return vcDutyTel;
    }

    public void setVcDutyTel(String vcDutyTel) {
        this.vcDutyTel = vcDutyTel;
    }

    
    @Column(columnName = "vc_fax")
    public String getVcFax() {
        return vcFax;
    }

    public void setVcFax(String vcFax) {
        this.vcFax = vcFax;
    }

    
    @Column(columnName = "vc_dept_address")
    public String getVcDeptAddress() {
        return vcDeptAddress;
    }

    public void setVcDeptAddress(String vcDeptAddress) {
        this.vcDeptAddress = vcDeptAddress;
    }

    
    @Column(columnName = "vc_group")
    public String getVcGroup() {
        return vcGroup;
    }

    public void setVcGroup(String vcGroup) {
        this.vcGroup = vcGroup;
    }

    
    @Column(columnName = "dt_update_time")
    public Timestamp getDtUpdateTime() {
        return dtUpdateTime;
    }

    public void setDtUpdateTime(Timestamp dtUpdateTime) {
        this.dtUpdateTime = dtUpdateTime;
    }

    
    @Column(columnName = "vc_remark")
    public String getVcRemark() {
        return vcRemark;
    }

    public void setVcRemark(String vcRemark) {
        this.vcRemark = vcRemark;
    }

    
    @Column(columnName = "dt_use_time")
    public Timestamp getDtUseTime() {
        return dtUseTime;
    }

    public void setDtUseTime(Timestamp dtUseTime) {
        this.dtUseTime = dtUseTime;
    }

    
    @Column(columnName = "vc_basic_situation")
    public String getVcBasicSituation() {
        return vcBasicSituation;
    }

    public void setVcBasicSituation(String vcBasicSituation) {
        this.vcBasicSituation = vcBasicSituation;
    }

    
    @Column(columnName = "d_area")
    public Double getdArea() {
        return dArea;
    }

    public void setdArea(Double dArea) {
        this.dArea = dArea;
    }

    
    @Column(columnName = "i_dept_id")
    public Integer getiDeptId() {
        return iDeptId;
    }

    public void setiDeptId(Integer iDeptId) {
        this.iDeptId = iDeptId;
    }

    
    @Column(columnName = "i_operate_id")
    public Integer getiOperateId() {
        return iOperateId;
    }

    public void setiOperateId(Integer iOperateId) {
        this.iOperateId = iOperateId;
    }

    
    @Column(columnName = "i_status")
    public Integer getiStatus() {
        return iStatus;
    }

    public void setiStatus(Integer iStatus) {
        this.iStatus = iStatus;
    }

    
    @Column(columnName = "i_extend1")
    public Integer getiExtend1() {
        return iExtend1;
    }

    public void setiExtend1(Integer iExtend1) {
        this.iExtend1 = iExtend1;
    }

    
    @Column(columnName = "i_extend2")
    public Integer getiExtend2() {
        return iExtend2;
    }

    public void setiExtend2(Integer iExtend2) {
        this.iExtend2 = iExtend2;
    }

    
    @Column(columnName = "vc_extend1")
    public String getVcExtend1() {
        return vcExtend1;
    }

    public void setVcExtend1(String vcExtend1) {
        this.vcExtend1 = vcExtend1;
    }

    
    @Column(columnName = "vc_extend2")
    public String getVcExtend2() {
        return vcExtend2;
    }

    public void setVcExtend2(String vcExtend2) {
        this.vcExtend2 = vcExtend2;
    }

    
    @Column(columnName = "vc_extend3")
    public String getVcExtend3() {
        return vcExtend3;
    }

    public void setVcExtend3(String vcExtend3) {
        this.vcExtend3 = vcExtend3;
    }


    @Column(columnName = "sys_dt_create",
            field = CreateTimestamp.class)
    public Timestamp getSysDtCreate() {
        return sysDtCreate;
    }

    public void setSysDtCreate(Timestamp sysDtCreate) {
        this.sysDtCreate = sysDtCreate;
    }

    @Column(columnName = "sys_i_create_user",
            field = CreateUser.class)
    public Integer getSysICreateUser() {
        return sysICreateUser;
    }

    public void setSysICreateUser(Integer sysICreateUser) {
        this.sysICreateUser = sysICreateUser;
    }

    @Column(columnName = "sys_dt_last_update",
            field = UpdateTimestamp.class)
    public Timestamp getSysDtLastUpdate() {
        return sysDtLastUpdate;
    }

    public void setSysDtLastUpdate(Timestamp sysDtLastUpdate) {
        this.sysDtLastUpdate = sysDtLastUpdate;
    }

    @Column(columnName = "sys_i_last_update_user",
            field = UpdateUser.class)
    public Integer getSysILastUpdateUser() {
        return sysILastUpdateUser;
    }

    public void setSysILastUpdateUser(Integer sysILastUpdateUser) {
        this.sysILastUpdateUser = sysILastUpdateUser;
    }

    @Column(columnName = "sys_i_status",
            insertValue = "0",
            queryValue = "0",
            tombstoneValue = "1")
    public Integer getSysIStatus() {
        return sysIStatus;
    }

    public void setSysIStatus(Integer sysIStatus) {
        this.sysIStatus = sysIStatus;
    }

    @Column(columnName = "sys_vc_remark")
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

        AppDbMaterialAddress that = (AppDbMaterialAddress) o;

        if (iId != null ? !iId.equals(that.iId) : that.iId != null) return false;
        if (vcName != null ? !vcName.equals(that.vcName) : that.vcName != null) return false;
        if (iAreaId != null ? !iAreaId.equals(that.iAreaId) : that.iAreaId != null) return false;
        if (vcDept != null ? !vcDept.equals(that.vcDept) : that.vcDept != null) return false;
        if (dLongitude != null ? !dLongitude.equals(that.dLongitude) : that.dLongitude != null) return false;
        if (dLatitude != null ? !dLatitude.equals(that.dLatitude) : that.dLatitude != null) return false;
        if (vcAddress != null ? !vcAddress.equals(that.vcAddress) : that.vcAddress != null) return false;
        if (vcTraffic != null ? !vcTraffic.equals(that.vcTraffic) : that.vcTraffic != null) return false;
        if (vcDutyTel != null ? !vcDutyTel.equals(that.vcDutyTel) : that.vcDutyTel != null) return false;
        if (vcFax != null ? !vcFax.equals(that.vcFax) : that.vcFax != null) return false;
        if (vcDeptAddress != null ? !vcDeptAddress.equals(that.vcDeptAddress) : that.vcDeptAddress != null)
            return false;
        if (vcGroup != null ? !vcGroup.equals(that.vcGroup) : that.vcGroup != null) return false;
        if (dtUpdateTime != null ? !dtUpdateTime.equals(that.dtUpdateTime) : that.dtUpdateTime != null) return false;
        if (vcRemark != null ? !vcRemark.equals(that.vcRemark) : that.vcRemark != null) return false;
        if (dtUseTime != null ? !dtUseTime.equals(that.dtUseTime) : that.dtUseTime != null) return false;
        if (vcBasicSituation != null ? !vcBasicSituation.equals(that.vcBasicSituation) : that.vcBasicSituation != null)
            return false;
        if (dArea != null ? !dArea.equals(that.dArea) : that.dArea != null) return false;
        if (iDeptId != null ? !iDeptId.equals(that.iDeptId) : that.iDeptId != null) return false;
        if (iOperateId != null ? !iOperateId.equals(that.iOperateId) : that.iOperateId != null) return false;
        if (iStatus != null ? !iStatus.equals(that.iStatus) : that.iStatus != null) return false;
        if (iExtend1 != null ? !iExtend1.equals(that.iExtend1) : that.iExtend1 != null) return false;
        if (iExtend2 != null ? !iExtend2.equals(that.iExtend2) : that.iExtend2 != null) return false;
        if (vcExtend1 != null ? !vcExtend1.equals(that.vcExtend1) : that.vcExtend1 != null) return false;
        if (vcExtend2 != null ? !vcExtend2.equals(that.vcExtend2) : that.vcExtend2 != null) return false;
        if (vcExtend3 != null ? !vcExtend3.equals(that.vcExtend3) : that.vcExtend3 != null) return false;
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
        result = 31 * result + (iAreaId != null ? iAreaId.hashCode() : 0);
        result = 31 * result + (vcDept != null ? vcDept.hashCode() : 0);
        result = 31 * result + (dLongitude != null ? dLongitude.hashCode() : 0);
        result = 31 * result + (dLatitude != null ? dLatitude.hashCode() : 0);
        result = 31 * result + (vcAddress != null ? vcAddress.hashCode() : 0);
        result = 31 * result + (vcTraffic != null ? vcTraffic.hashCode() : 0);
        result = 31 * result + (vcDutyTel != null ? vcDutyTel.hashCode() : 0);
        result = 31 * result + (vcFax != null ? vcFax.hashCode() : 0);
        result = 31 * result + (vcDeptAddress != null ? vcDeptAddress.hashCode() : 0);
        result = 31 * result + (vcGroup != null ? vcGroup.hashCode() : 0);
        result = 31 * result + (dtUpdateTime != null ? dtUpdateTime.hashCode() : 0);
        result = 31 * result + (vcRemark != null ? vcRemark.hashCode() : 0);
        result = 31 * result + (dtUseTime != null ? dtUseTime.hashCode() : 0);
        result = 31 * result + (vcBasicSituation != null ? vcBasicSituation.hashCode() : 0);
        result = 31 * result + (dArea != null ? dArea.hashCode() : 0);
        result = 31 * result + (iDeptId != null ? iDeptId.hashCode() : 0);
        result = 31 * result + (iOperateId != null ? iOperateId.hashCode() : 0);
        result = 31 * result + (iStatus != null ? iStatus.hashCode() : 0);
        result = 31 * result + (iExtend1 != null ? iExtend1.hashCode() : 0);
        result = 31 * result + (iExtend2 != null ? iExtend2.hashCode() : 0);
        result = 31 * result + (vcExtend1 != null ? vcExtend1.hashCode() : 0);
        result = 31 * result + (vcExtend2 != null ? vcExtend2.hashCode() : 0);
        result = 31 * result + (vcExtend3 != null ? vcExtend3.hashCode() : 0);
        result = 31 * result + (sysIStatus != null ? sysIStatus.hashCode() : 0);
        result = 31 * result + (sysDtCreate != null ? sysDtCreate.hashCode() : 0);
        result = 31 * result + (sysICreateUser != null ? sysICreateUser.hashCode() : 0);
        result = 31 * result + (sysDtLastUpdate != null ? sysDtLastUpdate.hashCode() : 0);
        result = 31 * result + (sysILastUpdateUser != null ? sysILastUpdateUser.hashCode() : 0);
        result = 31 * result + (sysVcRemark != null ? sysVcRemark.hashCode() : 0);
        return result;
    }
}
