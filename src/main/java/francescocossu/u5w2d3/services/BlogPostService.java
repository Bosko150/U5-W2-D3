package francescocossu.u5w2d3.services;

import francescocossu.u5w2d3.entities.BlogPost;
import francescocossu.u5w2d3.entities.BlogPostPayload;
import francescocossu.u5w2d3.exceptions.NotFoundException;
import francescocossu.u5w2d3.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogPostService {


    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private PostAuthorService postAuthorService;

    public BlogPostPayload saveBlogPost(BlogPostPayload blogPost) {

        BlogPost blogpost1 = new BlogPost(blogPost.getCategory(), blogPost.getTitle(), blogPost.getBody(), blogPost.getReadingTime(), postAuthorService.findAuthorById(blogPost.getAuthorId()));

        blogPostRepository.save(blogpost1);
        return blogPost;
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public BlogPost findBlogPostById(UUID id) {

        return blogPostRepository.findById(id).orElseThrow(() -> new NotFoundException(id));

    }

    public BlogPost findBlogPostByIdAndUpdate(UUID id, BlogPost updatedBlogPost) {

        BlogPost found = this.findBlogPostById(id);
        found.setCategory(updatedBlogPost.getCategory());
        found.setTitle(updatedBlogPost.getTitle());
        found.setBody(updatedBlogPost.getBody());
        found.setReadingTime(updatedBlogPost.getReadingTime());
        return this.blogPostRepository.save(found);
    }

    public void deleteBlogPostById(UUID id) {

        blogPostRepository.deleteById(id);
    }


}
