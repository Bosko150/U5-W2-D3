package francescocossu.u5w2d3.services;

import francescocossu.u5w2d3.entities.PostAuthor;
import francescocossu.u5w2d3.exceptions.NotFoundException;
import francescocossu.u5w2d3.repositories.PostAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostAuthorService {

    @Autowired
    private PostAuthorRepository postAuthorRepository;

    public PostAuthor saveAuthor(PostAuthor author) {
        return postAuthorRepository.save(author);
    }

    public Page<PostAuthor> getAllAuthors(int pageNumber, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return postAuthorRepository.findAll(pageable);
    }

    public PostAuthor findAuthorById(UUID id) {

        return postAuthorRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public PostAuthor findAuthorByIdAndUpdate(UUID id, PostAuthor updatedAuthor) {

        PostAuthor found = this.findAuthorById(UUID.fromString(String.valueOf(id)));
        found.setName(updatedAuthor.getName());
        found.setSurname(updatedAuthor.getSurname());
        return this.postAuthorRepository.save(found);
    }

    public void deleteAuthorById(UUID id) {

        postAuthorRepository.deleteById(id);
    }
}
