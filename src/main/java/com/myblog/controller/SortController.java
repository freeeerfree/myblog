package com.myblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myblog.service.SortService;


@RequestMapping(value="/blog")
@RestController
public class SortController {
	  @Autowired
	   private SortService sortService;
	   public void setSortService(SortService sortService) {
		    this.sortService=sortService;   
	   }
	   @RequestMapping(value="/{headSort}",method=RequestMethod.POST)
	   public List<String> getLeftSort(@PathVariable String headSort) {
		  System.out.println("我在运行");
		  System.out.println(sortService.getLeftSort(headSort).get(0));
		return sortService.getLeftSort(headSort);
                   
	   }
}
