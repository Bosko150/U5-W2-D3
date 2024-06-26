package francescocossu.u5w2d3.controllers;

import francescocossu.u5w2d3.entities.BlogPost;
import francescocossu.u5w2d3.entities.BlogPostPayload;
import francescocossu.u5w2d3.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogposts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;


    @GetMapping
    private List<BlogPost> getAllBlogPosts() {
        return blogPostService.getAllBlogPosts();
    }

    @GetMapping("/{id}")
    private BlogPost findBlogPostById(@PathVariable UUID id) {
        return blogPostService.findBlogPostById(id);
    }

    @PostMapping
    private BlogPostPayload saveBlogPost(@RequestBody BlogPostPayload blogPost) {
        return blogPostService.saveBlogPost(blogPost);
    }


    @PutMapping("/{id}")
    private BlogPost findBlogPostByIdAndUpdate(@PathVariable UUID id, @RequestBody BlogPost blogPostUpdated) {
        return blogPostService.findBlogPostByIdAndUpdate(id, blogPostUpdated);
    }

    @DeleteMapping("/{id}")
    private void deleteBlogPostById(@PathVariable UUID id) {
        blogPostService.deleteBlogPostById(id);
    }
}