package com.myblog.dao;
import java.util.List;
import com.myblog.model.Article;
public interface ArticleDao {
    public List<Article> getAllArticleMessages(); //初次加载，获取所有文章。 后续会修改控制为一次加载的文章数。在滚轮或者点击按钮时，再次加载
    public List<Article> getSortArticleMessages(String sort);//得到当前分类所有文章
    public void writeArticle(Article article);//写入文章
   // public int findMaxID();//找到最大的ID，在更新最新文章的时候需要用到最大id+1.不合理，应该随机文章id.随机的文章id不能重复。 主键最好不要承载业务，在前人的经验中，主键承载业务，会使修改变得困难。
    public Article getArticleContent(int id);//通过文章的id,获取当前文章的内容
}