
package Classes;


public class Admin  {


    private Integer adminId;

    private String adminName;

    private String adminUserName;

    private String adminPassword;

    private String adminEmail;

    public Admin() {
    }

    public Admin(Integer adminId) {
        this.adminId = adminId;
    }

    public Admin(Integer adminId, String adminName, String adminUserName, String adminPassword, String adminEmail) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminUserName = adminUserName;
        this.adminPassword = adminPassword;
        this.adminEmail = adminEmail;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }


    
}
