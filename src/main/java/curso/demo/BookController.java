import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    /**
     * @return
     */
    @GetMapping
    public List<String> getBooks() {
        return Arrays.asList("Effective Java", "Clean Code");
    }
    
    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id) {
        return "Book " + id;
    }
}
