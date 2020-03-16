# spring-boot-caffeine-cache-demo
Spring boot project to show how the caffeine cache can be configured and used.

## 1. Required Dependecies
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-cache</artifactId>
</dependency>
<dependency>
	<groupId>com.github.ben-manes.caffeine</groupId>
	<artifactId>caffeine</artifactId>
</dependency>
```

## 2. Caffeine Cache Specifications
```
demo.cache.caffeine-specs.book=expireAfterWrite=3600s,maximumSize=500
demo.cache.caffeine-specs.student=expireAfterWrite=600s,maximumSize=500
```

## 3. Usage of cache annotation
```
@Service
@CacheConfig(cacheNames = { "book" })
public class BookServiceImpl implements BookService {

	@Override
	@Cacheable
	public Book getBookByISBN(String ISBN) {
		return getBook(ISBN);
	}

	private Book getBook(String ISBN) {
		return new Book(ISBN, String.format("title%s", ISBN), String.format("author%s", ISBN));
	}

}
```
