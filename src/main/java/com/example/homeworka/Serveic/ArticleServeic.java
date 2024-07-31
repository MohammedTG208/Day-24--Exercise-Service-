package com.example.homeworka.Serveic;

import com.example.homeworka.model.Article;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ArticleServeic {
//    Get all NewsArticles.//done
//2. Add a NewsArticle.//done
//3. Update a NewsArticle//done
//4. Delete a NewsArticle.//done
//5. Publish NewsArticles.//done
//6. Get all Published NewsArticles.//done
// 7. Get NewsArticles by Category.
    ArrayList<Article> articles = new ArrayList<Article>();

    public ArrayList<Article> getArticles() {
        return articles;
    }
    public void addArticles(Article articles) {
        this.articles.add(articles);
    }

    public boolean updateArticle(Article article,int id) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == id) {
                articles.set(i, article);
                return true;
            }
        }
        return false;
    }
    public boolean deleteArticle(int id) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == id) {
                articles.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean publishArticle(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                article.setPublished(true);
                return true;
            }
        }
        return false;
    }
    public ArrayList PublishedNewsArticles() {
        ArrayList<Article> newsArticles = new ArrayList<>();
            for (Article article : articles) {
                if (article.isPublished()) {
                    newsArticles.add(article);
                }
            }
            return newsArticles.isEmpty() ?null:newsArticles;
    }

    public ArrayList articlesByCategory(String category) {
        ArrayList<Article> newsArticles = new ArrayList<>();
        for (Article article : articles) {
            if (article.getCategory().equals(category)) {
                newsArticles.add(article);
            }
        }
        return newsArticles.isEmpty() ?null:newsArticles;
    }

}
