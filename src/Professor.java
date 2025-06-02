public class Professor extends ObjectPlus{
    private String firstName;
    private String lastName;
    private String title;
    private Address address; // atrybut złożony

    public Professor(String firstName, String lastName, String title, Address address) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.address = address;
    }

    @Override // przesłonięcie
    public String toString() {
        return title + " " + firstName + " " + lastName + ", " + address;
    }
}
