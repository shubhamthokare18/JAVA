public class AssignmentWork {

    private Pen pen;

    // Constructor Injection (Best Practice)
    public AssignmentWork(Pen pen) {
        this.pen = pen;
    }

    public void writeAssignment(String text) {
        if (pen == null) {
            throw new IllegalStateException("Pen is not set");
        }
        pen.write(text);
    }
}