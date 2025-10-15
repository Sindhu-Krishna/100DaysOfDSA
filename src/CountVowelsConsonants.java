public class CountVowelsConsonants {
    public static void main(String[] args) {
        String str = "hello world";
        int vowels = 0, consonants = 0;

        str = str.toLowerCase();
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if ("aeiou".indexOf(c) != -1)
                    vowels++;
                else
                    consonants++;
            }
        }

        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }
}
