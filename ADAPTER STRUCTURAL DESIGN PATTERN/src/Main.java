public class Main {

    public static void main(String[] args) {

        PilotPen pilotPen = new PilotPen();
        Pen pen = new PenAdapter(pilotPen);   // Adapter used

        AssignmentWork assignmentWork = new AssignmentWork(pen);
        assignmentWork.writeAssignment("I am a bit tired to write an assignment.");
    }
}