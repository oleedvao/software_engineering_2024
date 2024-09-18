public class InformationChecker {

    public int controlAge(int age) {
        if (age < 0) {
            return 0;
        }
        else if (age > 120) {
            return 120;
        }
        return age;
    }

}
