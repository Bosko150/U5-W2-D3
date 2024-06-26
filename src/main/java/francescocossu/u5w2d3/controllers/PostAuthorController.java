package francescocossu.u5w2d3.controllers;

import francescocossu.u5w2d3.entities.PostAuthor;
import francescocossu.u5w2d3.services.PostAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class PostAuthorController {

    @Autowired
    private PostAuthorService authorService;

    @GetMapping
    private Page<PostAuthor> getAllAuthors(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "name") String sortBy) {
        return authorService.getAllAuthors(page, size, sortBy);
    }

    @GetMapping("/{id}")
    private PostAuthor findAuthorById(@PathVariable UUID id) {
        return authorService.findAuthorById(id);
    }

    @PostMapping
    private PostAuthor saveAuthor(@RequestBody PostAuthor author) {
        return authorService.saveAuthor(author);
    }


    @PutMapping("/{id}")
    private PostAuthor findAuthorByIdAndUpdate(@PathVariable UUID id, @RequestBody PostAuthor updatedAuthor) {
        return authorService.findAuthorByIdAndUpdate(id, updatedAuthor);
    }

    @DeleteMapping("/{id}")
    private void deleteAuthorById(@PathVariable UUID id) {
        authorService.deleteAuthorById(id);
    }
}
