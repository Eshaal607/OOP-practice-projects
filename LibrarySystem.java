import java.util.ArrayList;

class Book{
    private String title;
    private String author;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public String toString(){
        return "\nTitle: "+ title +" by " + author;
    }
}

class Member{

    String name;
    int memberId;

    public Member(String name, int id ){
        this.name = name;
        this.memberId = id;
    }

    public String toString(){
        return "\nMember: " + name +"(ID: " + memberId + ")";
    }
}

class Library{

    String name;
    ArrayList<Member> members = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();

    public Library(String name){
        this.name = name;
    }

    public void addmember(Member member){
        members.add(member);
    }

    public void addbook(Book book){
        books.add(book);
    }

    public String toString(){
        return "Library: "+ name +"\nMembers: "+ members +"\nBooks: "+ books;
    }

}

public class LibrarySystem {
    public static void main(String[] args) {
        Library lib = new Library("City Library");

        lib.addbook(new Book("Fourth Wing","Rebecca Yarros"));
        lib.addbook(new Book("The Hunger Games","Suzanne Collins"));
        lib.addbook(new Book("Shadow and Bone","Leigh Bardugo"));

        lib.addmember(new Member("Eshaal",162));
        lib.addmember(new Member("Fatima",21));
        lib.addmember(new Member("Aisha",62));

        System.out.println(lib);
    }
}