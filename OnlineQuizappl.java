import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineQuizappl {  // Changed class name here
    private List<Question> questions;
    private Scanner scanner;

    public OnlineQuizappl() {  // Updated constructor name
        questions = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuiz() {
        System.out.println("Welcome to the  Quiz Application!");
        int score = 0;
        for (Question question : questions) {
            System.out.println(question.getQuestion());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.print("Your answer: ");
            int answerIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // consume newline
            if (question.isCorrect(answerIndex)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + question.getCorrectAnswer());
            }
        }
        System.out.println("Your final score is " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        OnlineQuizappl quiz = new OnlineQuizappl();  // Updated object instantiation
        quiz.addQuestion(new Question("Who is known as the 'King of cricket'?", "Virat", List.of("smith", "root", "williamson", "Virat")));
        quiz.addQuestion(new Question("What is the chemical symbol for methane?", "CH2", List.of("O2", "H2", "C2H", "CH2")));
        quiz.addQuestion(new Question("Who invented the tubelight?", "Thomas Edison", List.of("Thomas Edison", "Alexander Graham Bell", "Nikola Tesla", "Guglielmo Marconi")));
        quiz.addQuestion(new Question("Which planet is closest to the Sun?", "Mercury", List.of("Venus", "Earth", "Mercury", "Mars")));
        quiz.addQuestion(new Question("What is the capital of India?", "Delhi", List.of("Mumbai", "Melbourne", "Delhi", "Brisbane")));
        quiz.addQuestion(new Question("What is the largest mammal in the world?", "Blue Whale", List.of("Elephant", "Blue Whale", "Great White Shark", "Giraffe")));
        quiz.addQuestion(new Question("Who discovered penicillin?", "Alexander Fleming", List.of("Marie Curie", "Alexander Fleming", "Isaac Newton", "Louis Pasteur")));
        quiz.addQuestion(new Question("Which country is home to the kangaroo?", "Australia", List.of("India", "Australia", "South Africa", "Brazil")));
        quiz.addQuestion(new Question("What is the square root of 81?", "9", List.of("9", "12", "14", "16")));
        quiz.addQuestion(new Question("Who wrote 'ramayan'?", "Valmiki", List.of("Kabir das", "premchand", "Valmiki", "George Eliot")));
        quiz.addQuestion(new Question("Which is the smallest ocean in the world?", "Arctic Ocean", List.of("Indian Ocean", "Pacific Ocean", "Atlantic Ocean", "Arctic Ocean")));
        quiz.addQuestion(new Question("What is the boiling point of water in Celsius?", "100°C", List.of("50°C", "90°C", "100°C", "120°C")));
        quiz.addQuestion(new Question("Which language has the most native speakers?", "Mandarin Chinese", List.of("Spanish", "English", "Mandarin Chinese", "Hindi")));
        quiz.addQuestion(new Question("Who painted the Monalisa ?", "Leonardo da Vinci", List.of("Leonardo da Vinci", "Raphael", "Michelangelo", "Donatello")));
        quiz.addQuestion(new Question("Which continent has the most population?", "Asia", List.of("Asia", "Europe", "Africa", "South America")));
        quiz.addQuestion(new Question("What is the main component of the sun?", "Hydrogen", List.of("Oxygen", "Helium", "Hydrogen", "Carbon")));
        quiz.addQuestion(new Question("What is the largest river in the world?", "Nile", List.of("Nile", "godavari", "ganga", "indus")));
    quiz.addQuestion(new Question("who is the god of cricket?","Sachin",List.of("dhoni","Sachin","Kallis","Warne")));

        quiz.startQuiz();
    }
}

class Question {
    private String question;
    private String correctAnswer;
    private List<String> options;

    public Question(String question, String correctAnswer, List<String> options) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrect(int index) {
        return options.get(index).equalsIgnoreCase(correctAnswer);
    }
}