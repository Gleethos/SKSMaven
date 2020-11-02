import main.BlogPostRepository
import main.entities.Author
import main.entities.BlogPost
import main.entities.Landmark
import main.entities.Type
import spock.lang.Shared
import spock.lang.Specification

import javax.persistence.EntityManager
import javax.persistence.Persistence


class MyTest extends  Specification
{
    @Shared
    EntityManager entityManager
    @Shared
    Author mockAuthor
    @Shared
    Landmark mockLandmark

    def setup()
    {
        def emf = Persistence.createEntityManagerFactory("BlogPostPU")
        entityManager = emf.createEntityManager()
        mockAuthor = new Author(1, "Max", "Mustermann", "m.m@mmm.at")
        mockLandmark = new Landmark("Mountain", 1.0, 1.0, Type.Landscape)
    }

    def cleanup()
    {
        entityManager.close()
    }

    def 'Test BlogPost saving and loading.'(
        String title, int found
    ) {
        given : 'A transaction is being initialized.'
            entityManager.getTransaction().begin()
        and : 'A utility class for saving and loading entries is bing instantiated.'
            def blogPostRepository = new BlogPostRepository(entityManager)
        and : 'We create a new BlogPost instance.'
            def post = new BlogPost(title, "", "", mockAuthor, mockLandmark)

        when : 'The new BlogPost instance is being persisted...'
            blogPostRepository.save(post)

        then : 'The total size of all persisted entities is as expected.'
            blogPostRepository.findAll().size() == found

        when : 'All entities are being fetched into a list...'
            def all = blogPostRepository.findAll()

        then : 'This list contains the BlogPost we created previously.'
            all.any { (it == post) }

        where : 'The following post title and number of found posts is being used.'
            title               || found
            "Die Alpenpiste"    || 0
            "Das Parlament"     || 1
            "Stephansdom"       || 2
    }


}