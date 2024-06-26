package francescocossu.u5w2d3.repositories;

import francescocossu.u5w2d3.entities.PostAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface PostAuthorRepository extends JpaRepository<PostAuthor, UUID> {
}
