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
@Table(name = "app_user")
@Where(clause = "sys_i_status != 1")
public class AppUser {

    private Integer iId;
    private Integer iOperatorId;
    private Timestamp sysDtCreate;
    private Timestamp sysDtLastUpdate;
    private Integer sysICreateUser;
    private Integer sysILastUpdateUser;
    private Integer sysIStatus;
    private String sysVcRemark;
    private String vcPassword;
    private String vcUsername;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="i_id")
    public Integer getiId() { return iId; }

    public void setiId(Integer iId) { this.iId = iId; }

    @Basic
    @Column(name="i_operator_id")
    public Integer getiOperatorId() { return iOperatorId; }

    public void setiOperatorId(Integer iOperatorId) { this.iOperatorId = iOperatorId; }

    @Basic
    @CreateTimestamp
    @Column(name="sys_dt_create")
    public Timestamp getSysDtCreate() { return sysDtCreate; }

    public void setSysDtCreate(Timestamp sysDtCreate) { this.sysDtCreate = sysDtCreate; }

    @Basic
    @UpdateTimestamp
    @Column(name="sys_dt_last_update")
    public Timestamp getSysDtLastUpdate() { return sysDtLastUpdate; }

    public void setSysDtLastUpdate(Timestamp sysDtLastUpdate) { this.sysDtLastUpdate = sysDtLastUpdate; }

    @Basic
    @Column(name="sys_i_create_user")
    public Integer getSysICreateUser() { return sysICreateUser; }

    public void setSysICreateUser(Integer sysICreateUser) { this.sysICreateUser = sysICreateUser; }

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
    @Column(name="sys_vc_remark")
    public String getSysVcRemark() { return sysVcRemark; }

    public void setSysVcRemark(String sysVcRemark) { this.sysVcRemark = sysVcRemark; }

    @Basic
    @Column(name="vc_password")
    public String getVcPassword() { return vcPassword; }

    public void setVcPassword(String vcPassword) { this.vcPassword = vcPassword; }

    @Basic
    @Column(name="vc_username")
    public String getVcUsername() { return vcUsername; }

    public void setVcUsername(String vcUsername) { this.vcUsername = vcUsername; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppUser that = (AppUser) o;

        if (iId != null ? !iId.equals(that.iId) : that.iId != null) return false;
        if (iOperatorId != null ? !iOperatorId.equals(that.iOperatorId) : that.iOperatorId != null) return false;
        if (sysDtCreate != null ? !sysDtCreate.equals(that.sysDtCreate) : that.sysDtCreate != null) return false;
        if (sysDtLastUpdate != null ? !sysDtLastUpdate.equals(that.sysDtLastUpdate) : that.sysDtLastUpdate != null) return false;
        if (sysICreateUser != null ? !sysICreateUser.equals(that.sysICreateUser) : that.sysICreateUser != null) return false;
        if (sysILastUpdateUser != null ? !sysILastUpdateUser.equals(that.sysILastUpdateUser) : that.sysILastUpdateUser != null) return false;
        if (sysIStatus != null ? !sysIStatus.equals(that.sysIStatus) : that.sysIStatus != null) return false;
        if (sysVcRemark != null ? !sysVcRemark.equals(that.sysVcRemark) : that.sysVcRemark != null) return false;
        if (vcPassword != null ? !vcPassword.equals(that.vcPassword) : that.vcPassword != null) return false;
        if (vcUsername != null ? !vcUsername.equals(that.vcUsername) : that.vcUsername != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iId != null ? iId.hashCode() : 0;
        result = 31 * result + (iOperatorId != null ? iOperatorId.hashCode() : 0);
        result = 31 * result + (sysDtCreate != null ? sysDtCreate.hashCode() : 0);
        result = 31 * result + (sysDtLastUpdate != null ? sysDtLastUpdate.hashCode() : 0);
        result = 31 * result + (sysICreateUser != null ? sysICreateUser.hashCode() : 0);
        result = 31 * result + (sysILastUpdateUser != null ? sysILastUpdateUser.hashCode() : 0);
        result = 31 * result + (sysIStatus != null ? sysIStatus.hashCode() : 0);
        result = 31 * result + (sysVcRemark != null ? sysVcRemark.hashCode() : 0);
        result = 31 * result + (vcPassword != null ? vcPassword.hashCode() : 0);
        result = 31 * result + (vcUsername != null ? vcUsername.hashCode() : 0);
        return result;
    }
}