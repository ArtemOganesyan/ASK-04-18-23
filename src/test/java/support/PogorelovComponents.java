package support;

public class PogorelovComponents {

//    Artem's component (modded)
    public static String componentFor(String name) {
        switch (name) {

//      Login Page Elements

            case "LoginEmailField":
                return "//input[@formcontrolname='email']";

            case "LoginPasswdField":
                return "//input[@formcontrolname='password']";

            case "SubmitButtn":
                return "//button[@type='submit']";

            case "ForgotPass":
                return "//a[@href='/#/forgot-password']";

            case "RegisterNow":
                return "//button/span[contains(text(),'Register Now')]";


//      Home Page Elements

//            Navigation Panel

            case "LogOut":
                return "//h5[contains(text(),'Log Out')]";

            case "Home":
                return "//a[@href='/#/home']";

            case "Submissions":
                return "//h5[text(),'Submissions']";

            case "Assignments":
                return "//h5[text()='Assignments']";

            case "Quizzes":
                return "//h5[text()='Quizzes']";

            case "UsersMgmt":
                return "//h5[text()=\"User's Management\"]";

            case "Settings":
                return "//h5[contains(text(),'Settings')]";

//                Notification Panels Links

            case "GoToSubmissions":
                return "//h5[contains(text(),'Go To Submissions')]";

            case "GoToAssignments":
                return "//h5[contains(text(),'Go To Assignments')]";

            case "GoToUsersMgmt":
                return "//h5[contains(text(),'Go To Users Management')]";

            case "QuizzesList":
                return "//div[@class='quizzes']";

        }

        return "";
    }

}
