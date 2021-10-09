package dsa.section13;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vowel {

   /*
   // TODO regex
func (v *Vowel) CalculateNumberOfVowelsRegex() int {
	rx, _ := regexp.Compile("a|e|i|o|u|A|E|I|O|U")
	//rx, _ := regexp.Compile("$v")

	allString := rx.FindAllString(v.Input, -1)
	return len(allString)
}


String input = "Gonzalez";
Pattern p = Pattern.compile("[aeiouy]", Pattern.CASE_INSENSITIVE);
Matcher m = p.matcher(input);
if (m.find()) {
    System.out.println(String.format("First vowel: %s", m.group()));
}
else {
    System.out.println("No vowels in input.");
}
    */
    public int CalculateNumberOfVowelsRegex(String input) {
        Pattern p = Pattern.compile("(?i)[aeiou]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);

        int count=0;
        while (m.find()){
            count = count + m.group(0).length();
        }
        return count;
    }

}
