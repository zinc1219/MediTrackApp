public class MediTrackBuggy {
    public static void main(String[] args) {
        System.out.println("Patient system ready");
        String status = "active";
        System.out.println("Status: " + status);
        int patients = 42;
    }


}

/*
Error 1

(a) Error type:
Syntax error (missing semicolon)

(b) Prediction:
The line

System.out.println("Patient system ready")

is missing a semicolon (;), so the program will not compile.

(c) Fix:

System.out.println("Patient system ready");
Error 2

(a) Error type:
Case sensitivity / variable name error

(b) Prediction:
The variable is declared as status but used as Status.
Java is case-sensitive, so this will cause a compilation error: cannot find symbol.

(c) Fix:

System.out.println("Status: " + status);
Error 3

(a) Error type:
Type mismatch error

(b) Prediction:
The variable patients is declared as int but assigned a String "42".
Java does not allow assigning a String to an integer variable.

(c) Fix:

int patients = 42;
*/
