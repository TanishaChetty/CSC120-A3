import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class Conversation implements Chatbot {

  // Attributes 
  // String[] responses = {"Awesome.", "Epic!", "I'm so sorry", "Fuckkk man", "Cool", 
  // "Goated","You're being really weird right now", "Oh my god you can't say that"};

  /**
   * Constructor 
   */
  Conversation() {
    
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    Scanner input = new Scanner (System.in);
    String response;
    Random random_int = new Random();
    ArrayList <String> transcript = new ArrayList<>();

    // starts the conversation
    System.out.println("How many rounds of conversation?");
    int rounds = input.nextInt();
    input.nextLine(); 
    if (rounds > 0 ){
      System.out.println("Welcome! What's up?");
      transcript.add("Welcome! What's up?"); //adds to transcript
    }
    

    // chatbot responds
    for(int i = 0; i < rounds; i++){
      response = input.nextLine();
      transcript.add(response);
      // String chatResponse = mirrorResponse(response);

      // if (chatResponse.equals(response)){
      //   System.out.println(responses[random_int.nextInt(0, (responses.length)-1)]);
      // }
      // else {
      //   System.out.println(chatResponse);
      // }
      System.out.println(mirrorResponse(response));
      transcript.add(mirrorResponse(response));
    
    }
    System.out.println("See ya!"); // closing message
    transcript.add("See ya!");

    // prints out transcript
    System.out.println("\nTRANSCRIPT:");
    for (String message: transcript){
      System.out.println(message);
    }

  }
public static String mirrorResponse(String input) {
  // creating array for mirrored words
  String[][] mirror_pairs = {
    {"I", "you"}, {"me", "you"}, {"am", "are"}, {"you", "I"}, {"my", "you"}, {"your", "my"},{"are", "am"},
  }; 
  String[] split_words = input.split(" ");
  boolean check_mirror = false;

  for (int i  = 0; i < split_words.length; i++){
    for (String[] j : mirror_pairs){
      if (split_words[i] .equalsIgnoreCase(j[0])){
        split_words[i] = j[1];
        check_mirror = true;
        break;
      }
    }
  }

  String[] responses = {"Awesome.", "Epic!", "I'm so sorry", "Fuckkk man", "Cool", 
  "Goated","You're being really weird right now", "Oh my god you can't say that"};

  Random random_int = new Random();

  //make the sentence again
  if (check_mirror){
    String sentence = "";
    for (int i = 0; i < split_words.length; i++){
      sentence += split_words[i] + " ";
    }
    sentence = sentence.trim();
  
    if (!sentence.isEmpty()){
      sentence = sentence.substring(0, 1).toUpperCase() +sentence.substring(1);
    } 
      return sentence;
    }
    else {
      return responses[random_int.nextInt(0, (responses.length)-1)];
    }
  }


  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    // System.out.println("\nTRANSCRIPT:");
    // for (String message: transcript){
    //   System.out.println(message);
    // }


  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    String returnString = ""; 
    return returnString; 
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
