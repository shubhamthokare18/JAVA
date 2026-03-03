public class PenAdapter implements Pen {

    private PilotPen pilotPen;

    public PenAdapter(PilotPen pilotPen) {
        this.pilotPen = pilotPen;
    }

    @Override
    public void write(String text) {
        pilotPen.mark(text);   // converting write() → mark()
    }
}