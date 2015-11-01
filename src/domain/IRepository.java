package domain;

import domain.entities.*;
import java.util.List;

public interface IRepository {
    // Users
    List<User> getUsers();
    void addUser(String uniqName, String password);
    void addUser(User newUser);
    void removeUser(String uniqName);

    // Publications
    List<Article> getArticles();
    void addArticle(Article newArticle);
    void updateArticle(Article article);
    void removeArticle(int articleId);

    List<Book> getBooks();
    void addBook(Book newBook);
    void updateBook(Book book);
    void removeBook(int bookId);

    List<Inproceeding> getInproceedings();
    void addInproceeding(Inproceeding newInproceeding);
    void updateInproceeding(Inproceeding inproceeding);
    void removeInproceeding(int inproceedingId);

    List<Proceeding> getProceedings();
    void addProceeding(Proceeding newProceeding);
    void updateProceeding(Proceeding proceeding);
    void removeProceeding(int proceedingId);

    List<Incollection> getIncollections();
    void addIncollection(Incollection newIncollection);
    void updateIncollection(Incollection incollection);
    void removeIncollection(int incollectionId);

    List<PhdThesis> getPhdTheses();
    void addPhdThesis(PhdThesis newPhdThesis);
    void updatePhdThesis(PhdThesis phdThesis);
    void removePhdThesis(int phdThesisId);

    List<MastersThesis> getMastersTheses();
    void addMastersThesis(MastersThesis newMastersThesis);
    void updateMastersThesis(MastersThesis mastersThesis);
    void removeMastersThesis(int mastersThesisId);

    // Site
    List<Site> getSites();
    void addSite(Site newSite);
    void updateSite(Site site);
    void removeSite(int siteId);
    
    // Cite
    List<Cite> getCites();
    void addCite(Cite newCite);
    void updateCite(Cite cite);
    void removeCite(int citeId);

    // Journal
    List<Journal> getJournals();
    void addJournal(Journal newJournal);
    void updateJournal(Journal journal);
    void removeJournal(int journalId);
    
    // Publisher
    List<Publisher> getPublishers();
    void addPublisher(Publisher newPublisher);
    void updatePublisher(Publisher publisher);
    void removePublisher(int publisherId);
}