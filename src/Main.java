import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;


// Define a class to represent a political question with its options.
class Question {
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    // Constructor to initialize the question and options.
    public Question(String question, String optionA, String optionB, String optionC, String optionD) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
    }

    // Getter methods to retrieve the question and options.
    public String getQuestion() {
        return question;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }
}


public class Main {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();

        // Add your questions and options here
        questions.add(new Question("What is your stance on government surveillance and privacy?",
                "A. Support government surveillance measures for national security.",
                "B. Advocate for stronger privacy protections and restrictions on surveillance.",
                "C. Oppose all forms of government surveillance.",
                "D. Believe privacy should be determined by private sector innovations, not government regulation."));

        questions.add(new Question("How should the government address criminal justice reform?",
                "A. Support tougher sentencing and law enforcement measures.",
                "B. Advocate for police reform and criminal justice system reform.",
                "C. Focus on restorative justice and community-based solutions.",
                "D. Reduce the government's role in the criminal justice system and emphasize individual responsibility."));

        questions.add(new Question("What is your stance on gun control?",
                "A. Support the Second Amendment and oppose stricter gun control measures.",
                "B. Advocate for stricter gun control laws and background checks.",
                "C. Promote the reduction of firearms in society.",
                "D. Believe gun control should be determined at the state and local levels."));

        questions.add(new Question("What is your position on social issues like abortion and LGBTQ+ rights?",
                "A. Support pro-life and traditional family values.",
                "B. Advocate for pro-choice and LGBTQ+ rights.",
                "C. Promote gender-neutral and inclusive policies.",
                "D. Believe these issues should be left to individual choice and private institutions."));

        questions.add(new Question("How should the government approach drug policy?",
                "A. Enforce strict drug laws and penalties.",
                "B. Decriminalize or legalize certain drugs.",
                "C. Promote drug education and harm reduction strategies.",
                "D. Let the market and individuals decide drug policies."));

        questions.add(new Question("What should the government do about taxation?",
                "A. Reduce taxes, the government already takes too much money away from hard-working individuals.",
                "B. Increase taxes for the wealthy.",
                "C. Taxation should be based on carbon footprint.",
                "D. Stay out of it, the government has caused enough damage already."));

        questions.add(new Question("How should the government approach environmental policy?",
                "A. Deregulate industries to encourage economic growth.",
                "B. Implement stricter regulations to protect the environment.",
                "C. Prioritize green and sustainable policies at all costs.",
                "D. Let the free market decide without government interference."));

        questions.add(new Question("What is your stance on healthcare reform?",
                "A. Reduce government involvement and promote private healthcare solutions.",
                "B. Implement a universal healthcare system to ensure coverage for all citizens.",
                "C. Advocate for holistic and alternative healthcare practices.",
                "D. Let individuals make their own healthcare choices without government mandates."));

        questions.add(new Question("How should the government handle immigration?",
                "A. Strengthen border security and enforce immigration laws.",
                "B. Offer a pathway to citizenship for undocumented immigrants.",
                "C. Promote open borders and freedom of movement.",
                "D. Leave immigration decisions to local communities and private enterprise."));

        questions.add(new Question("What's your perspective on government involvement in the economy?",
                "A. Reduce government regulation and promote free-market capitalism.",
                "B. Increase government intervention to address income inequality.",
                "C. Transition to a green and sustainable economy.",
                "D. Minimize government interference and allow market forces to prevail."));

        questions.add(new Question("What's your stance on education policy?",
                "A. Promote school choice and charter schools for increased competition.",
                "B. Invest in public education and support universal pre-K and college tuition programs.",
                "C. Focus on environmental and sustainability education in schools.",
                "D. Advocate for the privatization of education and limited government involvement."));

        questions.add(new Question("What is your view on international trade?",
                "A. Support free trade agreements and open markets.",
                "B. Favor trade policies that protect domestic industries and jobs.",
                "C. Promote fair trade and sustainability in global commerce.",
                "D. Oppose international trade agreements and prioritize self-sufficiency."));

        questions.add(new Question("What is your stance on social welfare programs?",
                "A. Reduce government spending on social welfare programs.",
                "B. Expand social safety nets and increase support for those in need.",
                "C. Redirect welfare funding towards environmentally sustainable initiatives.",
                "D. Let private charities and organizations address social welfare needs."));

        questions.add(new Question("How should the government address income inequality?",
                "A. Reduce taxes and regulations to stimulate economic growth and job creation.",
                "B. Implement progressive taxation and wealth redistribution policies.",
                "C. Support a basic income guarantee to address poverty.",
                "D. Let the free market address income inequality without government intervention."));

        questions.add(new Question("What's your view on foreign policy and military intervention?",
                "A. Maintain a strong military presence and engage in international conflicts when necessary.",
                "B. Promote diplomacy and reduce military involvement in foreign affairs.",
                "C. Emphasize peaceful, non-interventionist foreign relations.",
                "D. Withdraw from most international commitments and alliances."));

        questions.add(new Question("Which political party do you affiliate with?",
                "A. Republican",
                "B. Democrat",
                "C. Green Party",
                "D. Libertarian"));

        // Initialize a scanner to read user input.
        Scanner scanner = new Scanner(System.in);

        // Initialize scores for different political parties.
        int republicanScore = 0;
        int democratScore = 0;
        int greenPartyScore = 0;
        int libertarianScore = 0;

        int questionNumber = 1;

        // Iterate through each question in the list.
        for (Question question : questions) {
            System.out.println("Question " + questionNumber + ": " + question.getQuestion());
            System.out.println(question.getOptionA());
            System.out.println(question.getOptionB());
            System.out.println(question.getOptionC());
            System.out.println(question.getOptionD());

            String userAnswer = "";
            boolean validAnswer = false;

            // Prompt the user to enter their answer and validate it.
            while (!validAnswer) {
                System.out.print("Enter your answer (A/B/C/D): ");
                userAnswer = scanner.nextLine().toUpperCase();

                if (userAnswer.equals("A") || userAnswer.equals("B") || userAnswer.equals("C") || userAnswer.equals("D")) {
                    validAnswer = true;
                } else {
                    System.out.println("Invalid answer. Please enter A, B, C, or D.");
                }
            }

            //first 5 questions have a basic weighing
            int score = 1;
            //questions 5-10 are somewhat more important and have higher weight
            if (questionNumber > 5) {
                score = 2;
            }
            //questions 10-15 are the most important and are weighed the highest
            if (questionNumber > 10) {
                score = 3;
            }

            // Write user's answers to party-specific files and increase score based on answer
            try {
                FileWriter writer = null;
                switch (userAnswer) {
                    case "A":
                        writer = new FileWriter("RepublicanAnswers.txt", true);
                        republicanScore += score;
                        writer.write("Question " + questionNumber + ": " + question.getQuestion() + "\n");
                        writer.write("Your Answer: " + question.getOptionA() + "\n");

                        //these specific questions could be applied to libertarian partially so they get +1 points
                        if(questionNumber>5&&questionNumber<16){
                            libertarianScore++;
                        }
                        break;
                    case "B":
                        writer = new FileWriter("DemocratAnswers.txt", true);
                        democratScore += score;
                        writer.write("Question " + questionNumber + ": " + question.getQuestion() + "\n");
                        writer.write("Your Answer: " + question.getOptionB() + "\n");

                        //these specific questions can apply to greenparty partially so they get +1 points
                        if(questionNumber<16){
                            greenPartyScore++;
                        }
                        break;
                    case "C":
                        writer = new FileWriter("GreenPartyAnswers.txt", true);
                        greenPartyScore += score;
                        writer.write("Question " + questionNumber + ": " + question.getQuestion() + "\n");
                        writer.write("Your Answer: " + question.getOptionC() + "\n");

                        //these specific questions could be applied to libertarian partially so they get +1 points
                        if(questionNumber<=5 || questionNumber>12){
                            libertarianScore++;
                        }
                        break;
                    case "D":
                        writer = new FileWriter("LibertarianAnswers.txt", true);
                        libertarianScore += score;
                        writer.write("Question " + questionNumber + ": " + question.getQuestion() + "\n");
                        writer.write("Your Answer: " + question.getOptionD() + "\n");
                        break;
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Total Score available is 30, if user inputs over 15 points for any one party, he is predicted to be voting for that party
            int[] scores = {republicanScore, democratScore, greenPartyScore, libertarianScore};
            String[] parties = {"Republican", "Democrat", "Green Party", "Libertarian"};

            for (int i = 0; i < scores.length; i++) {
                if (scores[i] > 15) {
                    System.out.println("You will likely vote " + parties[i]);
                    System.exit(0);
                }
            }


            questionNumber++;
        }
    }
}
