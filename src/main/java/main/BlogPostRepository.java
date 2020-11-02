package main;

import lombok.AllArgsConstructor;
import main.entities.BlogPost;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import java.util.List;

public class BlogPostRepository {
    private EntityManager em;

    public BlogPostRepository(EntityManager em) {
        this.em = em;
    }

    public List<BlogPost> findAll(){
        return em.createNamedQuery("BlogPost.selectAll", BlogPost.class)
                .getResultList();
    }

    public BlogPost save(BlogPost post){
        return em.merge(post);
    }
}
