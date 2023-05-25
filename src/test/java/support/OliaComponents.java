package support;

public class OliaComponents {
    public static String componentFor(String name) {
        switch (name) {
            case "LoginTextField":
                return "//input[@formcontrolname='email']";
            case "PasswordTextField":
                return "//input[@formcontrolname='password']";
            case "SubmissionsStatus1":
                return "(//*[contains(text(),'Test Quiz for Submissions Status')])[1]";
        }
        return "";
    }
}


