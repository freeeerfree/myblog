package com.myblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myblog.service.SortService;


@RequestMapping(value="/sort")
@RestController
public class SortController {
	  @Autowired
	   private SortService sortService;
	   public void setSortService(SortService sortService) {
		    this.sortService=sortService;   
	   }
	   @RequestMapping(value="/{headSort}",method=RequestMethod.POST)
	   public List<String> getLeftSort(@PathVariable String headSort) {
		return sortService.getLeftSort(headSort);
                   
	   }
}
