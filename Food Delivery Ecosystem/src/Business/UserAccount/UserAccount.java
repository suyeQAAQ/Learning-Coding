/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.Workqueue.Workqueue;

/**
 *
 * @author 帅的一匹
 */
public class UserAccount {
     private String username;
    private String password;
    private Employee employee;
    private Role role;
    private Workqueue workQueue;
    public UserAccount() {
        workQueue = new Workqueue();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Workqueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(Workqueue workQueue) {
        this.workQueue = workQueue;
    }
     @Override
    public String toString() {
        return username;
    }
}
