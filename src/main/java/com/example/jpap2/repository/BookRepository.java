package com.example.jpap2.repository;
import com.example.jpap2.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorIgnoreCase(String author);
    List<Book> findByPriceBetween(Double minPrice, Double maxPrice);
}
