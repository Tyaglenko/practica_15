import java.util.Scanner;

public class Main {
    private static final String ADMIN_PASSWORD = "1111";
    private static final String[] QUESTIONS = {
            "Виберіть правильну форму дієслова 'бачити' у минулому часі:",
            "Виберіть правильну форму дієслова 'прийти' у третій особі однини:",
            "Виберіть правильну форму дієслова 'читати' у теперішньому часі:",
            "Виберіть правильну форму дієслова 'писати' у майбутньому часі:",
            "Виберіть правильну форму дієслова 'робити' у заперечному реченні:"
    };
    private static final String[][] OPTIONS = {
            {"a) бачив", "b) бачили", "c) бачився", "d) бачилися"},
            {"a) прийшла", "b) прийшов", "c) прийшли", "d) прийдуть"},
            {"a) читаю", "b) читаєш", "c) читають", "d) читаються"},
            {"a) напишу", "b) напишете", "c) напише", "d) напишуть"},
            {"a) робила", "b) робив", "c) не робив", "d) не робили"}
    };
    private static final String[] ANSWERS = {"a", "b", "c", "d", "c"};

    public static void main(String[] args) {
        System.out.println(" Tyaglenko Yakiv Olexsandrovich");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Вас вітає програма тестування на тему 'Неправильні дієслова'!");

        boolean isAdmin = false;
        System.out.print("Введіть пароль для перегляду правильних відповідей (або натисніть Enter, якщо не адміністратор): ");
        String password = scanner.nextLine();
        if (password.equals(ADMIN_PASSWORD)) {
            isAdmin = true;
            System.out.println("Ви увійшли як адміністратор. Можете переглядати правильні відповіді.");
        }

        int totalQuestions = QUESTIONS.length;
        int correctAnswers = 0;
        int currentQuestion = 0;

        while (currentQuestion < totalQuestions) {
            System.out.println();
            System.out.println(QUESTIONS[currentQuestion]);
            for (String option : OPTIONS[currentQuestion]) {
                System.out.println(option);
            }
            System.out.print("Введіть варіант відповіді (a, b, c, d) або q для виходу: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("q")) {
                break;
            }

            if (input.equals("a") || input.equals("b") || input.equals("c") || input.equals("d")) {
                if (input.equals(ANSWERS[currentQuestion])) {
                    correctAnswers++;
                }
                currentQuestion++;
            } else {
                System.out.println("Ви ввели неправильний варіант. Спробуйте ще раз.");
            }
        }

        System.out.println();
        System.out.println("Тестування завершено.");
        System.out.println("Ви відповіли правильно на " + correctAnswers + " питань з " + totalQuestions + ".");
        double percentage = (double) correctAnswers / totalQuestions * 100;
        System.out.println("Ваш результат: " + percentage + "%.");

        if (isAdmin) {
            System.out.println();
            System.out.println("Правильні відповіді:");
            for (int i = 0; i < totalQuestions; i++) {
                System.out.println((i + 1) + ") " + ANSWERS[i]);
            }
        }
    }
}