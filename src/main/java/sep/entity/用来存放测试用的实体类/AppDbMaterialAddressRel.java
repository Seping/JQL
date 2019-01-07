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
@Table(name = "app_db_material_address_rel")
@Where(clause = "sys_i_status != 1")
public class AppDbMaterialAddressRel {
    private Integer iId;
    private Integer iMaterialAddressId;
    private Integer iContactorId;
    private Integer iContactorType;
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
    @Column(name = "i_material_address_id")
    public Integer getiMaterialAddressId() {
        return iMaterialAddressId;
    }

    public void setiMaterialAddressId(Integer iMaterialAddressId) {
        this.iMaterialAddressId = iMaterialAddressId;
    }

    @Basic
    @Column(name = "i_contactor_id")
    public Integer getiContactorId() {
        return iContactorId;
    }

    public void setiContactorId(Integer iContactorId) {
        this.iContactorId = iContactorId;
    }

    @Basic
    @Column(name = "i_contactor_type")
    public Integer getiContactorType() {
        return iContactorType;
    }

    public void setiContactorType(Integer iContactorType) {
        this.iContactorType = iContactorType;
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
    @Generated(GenerationTime.INSERT)
    @ColumnDefault("0")
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

        AppDbMaterialAddressRel that = (AppDbMaterialAddressRel) o;

        if (iId != null ? !iId.equals(that.iId) : that.iId != null) return false;
        if (iMaterialAddressId != null ? !iMaterialAddressId.equals(that.iMaterialAddressId) : that.iMaterialAddressId != null)
            return false;
        if (iContactorId != null ? !iContactorId.equals(that.iContactorId) : that.iContactorId != null) return false;
        if (iContactorType != null ? !iContactorType.equals(that.iContactorType) : that.iContactorType != null)
            return false;
        if (iExtend1 != null ? !iExtend1.equals(that.iExtend1) : that.iExtend1 != null) return false;
        if (iExtend2 != null ? !iExtend2.equals(that.iExtend2) : that.iExtend2 != null) return false;
        if (vcExtend1 != null ? !vcExtend1.equals(that.vcExtend1) : that.vcExtend1 != null) return false;
        if (vcExtend2 != null ? !vcExtend2.equals(that.vcExtend2) : that.vcExtend2 != null) return false;
        if (vcExtend3 != null ? !vcExtend3.equals(that.vcExtend3) : that.vcExtend3 != null) return false;
        if (sysDtCreate != null ? !sysDtCreate.equals(that.sysDtCreate) : that.sysDtCreate != null) return false;
        if (sysICreateUser != null ? !sysICreateUser.equals(that.sysICreateUser) : that.sysICreateUser != null)
            return false;
        if (sysDtLastUpdate != null ? !sysDtLastUpdate.equals(that.sysDtLastUpdate) : that.sysDtLastUpdate != null)
            return false;
        if (sysILastUpdateUser != null ? !sysILastUpdateUser.equals(that.sysILastUpdateUser) : that.sysILastUpdateUser != null)
            return false;
        if (sysIStatus != null ? !sysIStatus.equals(that.sysIStatus) : that.sysIStatus != null) return false;
        if (sysVcRemark != null ? !sysVcRemark.equals(that.sysVcRemark) : that.sysVcRemark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iId != null ? iId.hashCode() : 0;
        result = 31 * result + (iMaterialAddressId != null ? iMaterialAddressId.hashCode() : 0);
        result = 31 * result + (iContactorId != null ? iContactorId.hashCode() : 0);
        result = 31 * result + (iContactorType != null ? iContactorType.hashCode() : 0);
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
