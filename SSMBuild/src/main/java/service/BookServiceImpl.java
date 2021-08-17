package service;

import dao.BooksMapper;
import pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{
    
    //service 调用dao层
    private dao.BooksMapper BooksMapper;

    // 设置一个set方法，用于注入mapper
    public void setBookMapper(BooksMapper BooksMapper) {
        this.BooksMapper = BooksMapper;
    }

    public int addBook(Books book) {
        return BooksMapper.addBook(book);
    }

    public int deleteBookById(int id) {
        return BooksMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return BooksMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return BooksMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return BooksMapper.queryAllBook();
    }
}
