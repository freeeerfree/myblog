package com.myblog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sort")
public class Sort {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
    @Column(name="headSort")
    String headSort;
    @Column(name="leftSort")
    String leftSort;
    public Sort() {
    	
    }
    public Sort(int id,String headSort,String leftSort) {
         this.id=id;
         this.headSort=headSort;
         this.leftSort=leftSort;
        
    }
    public void  setId(int id){
    	this.id=id;
    }
    public int getId() {
    	return id;
    }
    public String  getLeftSort() {
         return leftSort;
    }
    public void setLeftSort(String leftSort) {
    	this.leftSort=leftSort;
    }
    public String getHeadSort() {
    	return headSort;
    }
    public void setHeadSort(String headSort) {
    	this.headSort=headSort;
    }

}
