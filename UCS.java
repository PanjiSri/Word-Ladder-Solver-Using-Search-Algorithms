import java.util.*;

public class UCS {

    private String word_start;
    private String word_goal;


    public UCS(String word_start, String word_goal){
        this.word_start = word_start;
        this.word_goal = word_goal;
    }


    public void printWordStartGoal() {
        System.out.println("Word start: " + word_start);
        System.out.println("Word goal: " + word_goal);
    }



    public int countDifferentLetters(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // UCS ucs = new UCS();
        // ucs.printWordStartGoal();

        // String exampleWord = "EAT"; // Contoh kata
        // ArrayList<Pair<String, Integer>> result = ucs.generatePermutationsList(exampleWord);
        // // Menampilkan hasil
        // int i = 0;
        // for (Pair<String, Integer> entry : result) {
        //     System.out.printf("%d. %s -> %d\n", ++i, entry.getKey(), entry.getValue());
        // }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word start: ");
        String start = sc.nextLine().toUpperCase();
        System.out.print("Enter word goal: ");
        String goal = sc.nextLine().toUpperCase();

        UCS ucs = new UCS(start, goal);

        ucs.printWordStartGoal();
        sc.close();
    }


    public void insertInOrder(ArrayList<StringIntegerPair> list, StringIntegerPair newItem) {
        int index = 0;
        // Mencari indeks di mana elemen baru harus dimasukkan agar tetap terurut
        while (index < list.size() && list.get(index).getIntegerElement() < newItem.getIntegerElement()) {
            index++;
        }
        list.add(index, newItem);
    }



    public void algorithm() {

        //Uniform Cost Search
        String currentWord = word_start;

        //Simpul buat di ekspan
        ArrayList<StringIntegerPair> nodeToExpan = new ArrayList<>();

        //Simpul Simpul ekspansi
        ArrayList<StringIntegerPair> nodeExpantion = new ArrayList<>();

        nodeToExpan.add(new StringIntegerPair(currentWord, 0));
        
        Worddiff wd = new Worddiff();

        int cost = 0;

        while(!currentWord.equals(word_goal)) {

            ArrayList<String> temp = wd.findWordDiff(currentWord);

            for (int i = 0; i < temp.size(); i++) {
                insertInOrder(nodeExpantion, new StringIntegerPair(temp.get(i) + currentWord, cost + 1));
            }

            
            StringIntegerPair min = nodeExpantion.remove(0);

            currentWord = min.getStringElement();

            cost++;

        }
                    
    }

   
}
