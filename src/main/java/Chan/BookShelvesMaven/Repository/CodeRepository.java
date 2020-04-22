package Chan.BookShelvesMaven.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Chan.BookShelvesMaven.DAO.CodeData;

@Repository
public interface CodeRepository extends JpaRepository<CodeData, String>  {

}
