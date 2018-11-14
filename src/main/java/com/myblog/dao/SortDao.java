package com.myblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myblog.model.Sort;

public interface SortDao {

      public List<String>  getLeftSort(String headLeft);//得到一级分类中的二级分类
      public List<String>  getAllSort();//得到所有分类，在添加文章中，二级分类直接使用。
      public void addSort(Sort sort);
}
