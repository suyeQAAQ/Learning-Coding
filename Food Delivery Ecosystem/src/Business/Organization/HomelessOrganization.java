/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.HomelessRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author 帅的一匹
 */
public class HomelessOrganization extends Organization {

    public HomelessOrganization() {
        super(Organization.Type.Homeless.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new HomelessRole());
        return roles;
    }
}
