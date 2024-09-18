public class DangerZone {

    public void killSwitch(boolean killTheProgram) {
        if (killTheProgram) {
            throw new RuntimeException();
        }
    }
}
