package support;

public class Components {
    public static String componentFor(String name) {
        switch (name) {
            case "LoginTextField":
                return "//input[@formcontrolname='email']";
            case "PasswordTextField":
                return "//input[@formcontrolname='password']";
            case "SubmitButton":
                return "//button[@type='submit']";
            case "Settings":
                return "//h5[contains(text(),'Settings')]";
            case "ChangeYourName":
                return "//span[contains(text(),'Change Your Name')]";
            case "NewName":
                return "//input[@placeholder='New name']";
            case "Change":
                return "//button[@aria-label='Close dialog']/..//span[contains(text(),'Change')]";
            case "DisplayedName":
                return "//h3[contains(text(),'Ernest Gattas')]";
            case "UserName":
                return "//div[@class='info']";
        }
        return "";
    }
}