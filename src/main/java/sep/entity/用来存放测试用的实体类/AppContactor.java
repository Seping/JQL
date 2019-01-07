package sep.entity.用来存放测试用的实体类;

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
@Table(name = "app_contactor")
@Where(clause = "sys_i_status != 1")
public class AppContactor {

    private Integer iId;
    private String vcName;
    private Integer iSex;
    private String vcWorkUnit;
    private String vcPosition;
    private Integer iImportance;
    private String vcOfficeTel;
    private String vcMobile;
    private String vcHomeTel;
    private String vcFax;
    private String vcOtherTel;
    private String vcOtherTel2;
    private Integer iCommonlyUsed;
    private String vcMobilePwd;
    private Integer iMobileUser;
    private String vcPy;
    private String vcEmail;
    private String vcOfuser;
    private Timestamp dtDstime;
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
    private String vcPicture;
    private String sysVcRemark;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="i_id")
    public Integer getiId() { return iId; }

    public void setiId(Integer iId) { this.iId = iId; }

    @Basic
    @Column(name="vc_name")
    public String getVcName() { return vcName; }

    public void setVcName(String vcName) { this.vcName = vcName; }

    @Basic
    @Column(name="i_sex")
    public Integer getiSex() { return iSex; }

    public void setiSex(Integer iSex) { this.iSex = iSex; }

    @Basic
    @Column(name="vc_work_unit")
    public String getVcWorkUnit() { return vcWorkUnit; }

    public void setVcWorkUnit(String vcWorkUnit) { this.vcWorkUnit = vcWorkUnit; }

    @Basic
    @Column(name="vc_position")
    public String getVcPosition() { return vcPosition; }

    public void setVcPosition(String vcPosition) { this.vcPosition = vcPosition; }

    @Basic
    @Column(name="i_importance")
    public Integer getiImportance() { return iImportance; }

    public void setiImportance(Integer iImportance) { this.iImportance = iImportance; }

    @Basic
    @Column(name="vc_office_tel")
    public String getVcOfficeTel() { return vcOfficeTel; }

    public void setVcOfficeTel(String vcOfficeTel) { this.vcOfficeTel = vcOfficeTel; }

    @Basic
    @Column(name="vc_mobile")
    public String getVcMobile() { return vcMobile; }

    public void setVcMobile(String vcMobile) { this.vcMobile = vcMobile; }

    @Basic
    @Column(name="vc_home_tel")
    public String getVcHomeTel() { return vcHomeTel; }

    public void setVcHomeTel(String vcHomeTel) { this.vcHomeTel = vcHomeTel; }

    @Basic
    @Column(name="vc_fax")
    public String getVcFax() { return vcFax; }

    public void setVcFax(String vcFax) { this.vcFax = vcFax; }

    @Basic
    @Column(name="vc_other_tel")
    public String getVcOtherTel() { return vcOtherTel; }

    public void setVcOtherTel(String vcOtherTel) { this.vcOtherTel = vcOtherTel; }

    @Basic
    @Column(name="vc_other_tel2")
    public String getVcOtherTel2() { return vcOtherTel2; }

    public void setVcOtherTel2(String vcOtherTel2) { this.vcOtherTel2 = vcOtherTel2; }

    @Basic
    @Column(name="i_commonly_used")
    public Integer getiCommonlyUsed() { return iCommonlyUsed; }

    public void setiCommonlyUsed(Integer iCommonlyUsed) { this.iCommonlyUsed = iCommonlyUsed; }

    @Basic
    @Column(name="vc_mobile_pwd")
    public String getVcMobilePwd() { return vcMobilePwd; }

    public void setVcMobilePwd(String vcMobilePwd) { this.vcMobilePwd = vcMobilePwd; }

    @Basic
    @Column(name="i_mobile_user")
    public Integer getiMobileUser() { return iMobileUser; }

    public void setiMobileUser(Integer iMobileUser) { this.iMobileUser = iMobileUser; }

    @Basic
    @Column(name="vc_py")
    public String getVcPy() { return vcPy; }

    public void setVcPy(String vcPy) { this.vcPy = vcPy; }

    @Basic
    @Column(name="vc_email")
    public String getVcEmail() { return vcEmail; }

    public void setVcEmail(String vcEmail) { this.vcEmail = vcEmail; }

    @Basic
    @Column(name="vc_ofuser")
    public String getVcOfuser() { return vcOfuser; }

    public void setVcOfuser(String vcOfuser) { this.vcOfuser = vcOfuser; }

    @Basic
    @Column(name="dt_dstime")
    public Timestamp getDtDstime() { return dtDstime; }

    public void setDtDstime(Timestamp dtDstime) { this.dtDstime = dtDstime; }

    @Basic
    @Column(name="i_extend1")
    public Integer getiExtend1() { return iExtend1; }

    public void setiExtend1(Integer iExtend1) { this.iExtend1 = iExtend1; }

    @Basic
    @Column(name="i_extend2")
    public Integer getiExtend2() { return iExtend2; }

    public void setiExtend2(Integer iExtend2) { this.iExtend2 = iExtend2; }

    @Basic
    @Column(name="vc_extend1")
    public String getVcExtend1() { return vcExtend1; }

    public void setVcExtend1(String vcExtend1) { this.vcExtend1 = vcExtend1; }

    @Basic
    @Column(name="vc_extend2")
    public String getVcExtend2() { return vcExtend2; }

    public void setVcExtend2(String vcExtend2) { this.vcExtend2 = vcExtend2; }

    @Basic
    @Column(name="vc_extend3")
    public String getVcExtend3() { return vcExtend3; }

    public void setVcExtend3(String vcExtend3) { this.vcExtend3 = vcExtend3; }

    @Basic
    @CreateTimestamp
    @Column(name="sys_dt_create")
    public Timestamp getSysDtCreate() { return sysDtCreate; }

    public void setSysDtCreate(Timestamp sysDtCreate) { this.sysDtCreate = sysDtCreate; }

    @Basic
    @Column(name="sys_i_create_user")
    public Integer getSysICreateUser() { return sysICreateUser; }

    public void setSysICreateUser(Integer sysICreateUser) { this.sysICreateUser = sysICreateUser; }

    @Basic
    @UpdateTimestamp
    @Column(name="sys_dt_last_update")
    public Timestamp getSysDtLastUpdate() { return sysDtLastUpdate; }

    public void setSysDtLastUpdate(Timestamp sysDtLastUpdate) { this.sysDtLastUpdate = sysDtLastUpdate; }

    @Basic
    @Column(name="sys_i_last_update_user")
    public Integer getSysILastUpdateUser() { return sysILastUpdateUser; }

    public void setSysILastUpdateUser(Integer sysILastUpdateUser) { this.sysILastUpdateUser = sysILastUpdateUser; }

    @Basic
    @ColumnDefault(value = "0")
    @Generated(GenerationTime.INSERT)
    @Column(name="sys_i_status")
    public Integer getSysIStatus() { return sysIStatus; }

    public void setSysIStatus(Integer sysIStatus) { this.sysIStatus = sysIStatus; }

    @Basic
    @Column(name="vc_picture")
    public String getVcPicture() { return vcPicture; }

    public void setVcPicture(String vcPicture) { this.vcPicture = vcPicture; }

    @Basic
    @Column(name="sys_vc_remark")
    public String getSysVcRemark() { return sysVcRemark; }

    public void setSysVcRemark(String sysVcRemark) { this.sysVcRemark = sysVcRemark; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppContactor that = (AppContactor) o;

        if (iId != null ? !iId.equals(that.iId) : that.iId != null) return false;
        if (vcName != null ? !vcName.equals(that.vcName) : that.vcName != null) return false;
        if (iSex != null ? !iSex.equals(that.iSex) : that.iSex != null) return false;
        if (vcWorkUnit != null ? !vcWorkUnit.equals(that.vcWorkUnit) : that.vcWorkUnit != null) return false;
        if (vcPosition != null ? !vcPosition.equals(that.vcPosition) : that.vcPosition != null) return false;
        if (iImportance != null ? !iImportance.equals(that.iImportance) : that.iImportance != null) return false;
        if (vcOfficeTel != null ? !vcOfficeTel.equals(that.vcOfficeTel) : that.vcOfficeTel != null) return false;
        if (vcMobile != null ? !vcMobile.equals(that.vcMobile) : that.vcMobile != null) return false;
        if (vcHomeTel != null ? !vcHomeTel.equals(that.vcHomeTel) : that.vcHomeTel != null) return false;
        if (vcFax != null ? !vcFax.equals(that.vcFax) : that.vcFax != null) return false;
        if (vcOtherTel != null ? !vcOtherTel.equals(that.vcOtherTel) : that.vcOtherTel != null) return false;
        if (vcOtherTel2 != null ? !vcOtherTel2.equals(that.vcOtherTel2) : that.vcOtherTel2 != null) return false;
        if (iCommonlyUsed != null ? !iCommonlyUsed.equals(that.iCommonlyUsed) : that.iCommonlyUsed != null) return false;
        if (vcMobilePwd != null ? !vcMobilePwd.equals(that.vcMobilePwd) : that.vcMobilePwd != null) return false;
        if (iMobileUser != null ? !iMobileUser.equals(that.iMobileUser) : that.iMobileUser != null) return false;
        if (vcPy != null ? !vcPy.equals(that.vcPy) : that.vcPy != null) return false;
        if (vcEmail != null ? !vcEmail.equals(that.vcEmail) : that.vcEmail != null) return false;
        if (vcOfuser != null ? !vcOfuser.equals(that.vcOfuser) : that.vcOfuser != null) return false;
        if (dtDstime != null ? !dtDstime.equals(that.dtDstime) : that.dtDstime != null) return false;
        if (iExtend1 != null ? !iExtend1.equals(that.iExtend1) : that.iExtend1 != null) return false;
        if (iExtend2 != null ? !iExtend2.equals(that.iExtend2) : that.iExtend2 != null) return false;
        if (vcExtend1 != null ? !vcExtend1.equals(that.vcExtend1) : that.vcExtend1 != null) return false;
        if (vcExtend2 != null ? !vcExtend2.equals(that.vcExtend2) : that.vcExtend2 != null) return false;
        if (vcExtend3 != null ? !vcExtend3.equals(that.vcExtend3) : that.vcExtend3 != null) return false;
        if (sysDtCreate != null ? !sysDtCreate.equals(that.sysDtCreate) : that.sysDtCreate != null) return false;
        if (sysICreateUser != null ? !sysICreateUser.equals(that.sysICreateUser) : that.sysICreateUser != null) return false;
        if (sysDtLastUpdate != null ? !sysDtLastUpdate.equals(that.sysDtLastUpdate) : that.sysDtLastUpdate != null) return false;
        if (sysILastUpdateUser != null ? !sysILastUpdateUser.equals(that.sysILastUpdateUser) : that.sysILastUpdateUser != null) return false;
        if (sysIStatus != null ? !sysIStatus.equals(that.sysIStatus) : that.sysIStatus != null) return false;
        if (vcPicture != null ? !vcPicture.equals(that.vcPicture) : that.vcPicture != null) return false;
        if (sysVcRemark != null ? !sysVcRemark.equals(that.sysVcRemark) : that.sysVcRemark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iId != null ? iId.hashCode() : 0;
        result = 31 * result + (vcName != null ? vcName.hashCode() : 0);
        result = 31 * result + (iSex != null ? iSex.hashCode() : 0);
        result = 31 * result + (vcWorkUnit != null ? vcWorkUnit.hashCode() : 0);
        result = 31 * result + (vcPosition != null ? vcPosition.hashCode() : 0);
        result = 31 * result + (iImportance != null ? iImportance.hashCode() : 0);
        result = 31 * result + (vcOfficeTel != null ? vcOfficeTel.hashCode() : 0);
        result = 31 * result + (vcMobile != null ? vcMobile.hashCode() : 0);
        result = 31 * result + (vcHomeTel != null ? vcHomeTel.hashCode() : 0);
        result = 31 * result + (vcFax != null ? vcFax.hashCode() : 0);
        result = 31 * result + (vcOtherTel != null ? vcOtherTel.hashCode() : 0);
        result = 31 * result + (vcOtherTel2 != null ? vcOtherTel2.hashCode() : 0);
        result = 31 * result + (iCommonlyUsed != null ? iCommonlyUsed.hashCode() : 0);
        result = 31 * result + (vcMobilePwd != null ? vcMobilePwd.hashCode() : 0);
        result = 31 * result + (iMobileUser != null ? iMobileUser.hashCode() : 0);
        result = 31 * result + (vcPy != null ? vcPy.hashCode() : 0);
        result = 31 * result + (vcEmail != null ? vcEmail.hashCode() : 0);
        result = 31 * result + (vcOfuser != null ? vcOfuser.hashCode() : 0);
        result = 31 * result + (dtDstime != null ? dtDstime.hashCode() : 0);
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
        result = 31 * result + (vcPicture != null ? vcPicture.hashCode() : 0);
        result = 31 * result + (sysVcRemark != null ? sysVcRemark.hashCode() : 0);
        return result;
    }
}