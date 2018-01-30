/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dao;

import java.util.List;
 
import com.websystique.springmvc.model.MemberSales;


public interface MemberSalesDao {
    
    List <MemberSales> showOneMemberSales(int user_id);
    
    List <MemberSales> showAllPendingMemberSales();
    
    void approveMemberSales(MemberSales membersales);
    
    void addMemberSales(MemberSales membersales);
    
    void deleteMemberSales(MemberSales membersales);
    
   
    
    
    
}
