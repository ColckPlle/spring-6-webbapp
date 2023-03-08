package guru.springframework.spring6webbapp.bootstrap;

import guru.springframework.spring6webbapp.domain.Author;
import guru.springframework.spring6webbapp.domain.Book;
import guru.springframework.spring6webbapp.domain.Publisher;
import guru.springframework.spring6webbapp.repositories.PublisherRepository;
import guru.springframework.spring6webbapp.repositories.AuthorRepository;
import guru.springframework.spring6webbapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book aaa = new Book();
        aaa.setTitle("Average Around Artists");
        aaa.setIsbn("123456");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book aaaSaved = bookRepository.save(aaa);
        Book dddSaved = bookRepository.save(ddd);

        ericSaved.getBooks().add(dddSaved);
        ericSaved.getBooks().add(aaaSaved);


        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("132 Main St");
        Publisher savedPublisher = publisherRepository.save(publisher);

        dddSaved.setPublisher(savedPublisher);
        aaaSaved.setPublisher(savedPublisher);
        bookRepository.save(dddSaved);
        bookRepository.save(aaaSaved);


        System.out.println("In BootStrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
