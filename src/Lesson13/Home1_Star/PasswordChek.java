package Lesson13.Home1_Star;

class PasswordChek {
    static boolean engine(String login,String password,String confirmPassword) throws
            WrongLoginException, WrongPasswordException {
        if (!login.matches("\\S+")|login.length()>20){
            throw new WrongLoginException("WrongLoginException");
        }

        if (!password.matches("\\S+")|password.length()>20|!(confirmPassword.equals(password))
                |!(password.matches(".*\\d.*")))
        {
            throw new WrongPasswordException("WrongPasswordException");
    }
        return true;
}
}

