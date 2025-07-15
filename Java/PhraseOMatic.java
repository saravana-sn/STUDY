
import java.util.Random;

class PhraseOMatic{
    public static void main (String[] args){
        String[] wordListOne = {"agnostic", "opinionated", 
                                "voice activated", "haptically driven", "extensible", 
                                "reactive", "agent based", "functional", "AI enabled", 
                                "strongly typed"};
        String[] wordListTwo = {"loosely coupled", "six sigma", 
                                "asynchronous", "event driven", "pub-sub", "IoT", "cloud native", 
                                "service oriented", "containerized", "serverless", 
                                "microservices", "distributed ledger"};
        String[] wordListThree = {"framework", "library", "DSL", "REST API", "repository", "pipeline", 
                                  "service mesh", "architecture", "perspective", "design", 
                                  "orientation"};

        Random randomGenerator = new Random();
        int randomIndex1 = randomGenerator.nextInt(wordListOne.length);
        int randomIndex2 = randomGenerator.nextInt(wordListTwo.length);
        int randomIndex3 = randomGenerator.nextInt(wordListThree.length);
        
        System.out.println(wordListOne[randomIndex1] +" "+ wordListTwo[randomIndex2] +" "+ wordListThree[randomIndex3]);
    }
}