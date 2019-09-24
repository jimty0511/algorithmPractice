package practice.problem;

import java.util.HashSet;
import java.util.Set;

// 929. Unique Email Addresses
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0)
            return 0;
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] arr = email.split("@");
            String local = arr[0].contains("+") ?
                    arr[0].substring(0, arr[0].indexOf("+")).replace(".", "") :
                    arr[0].replace(".", "");
            set.add(local + "@" + arr[1]);
        }
        return set.size();
    }

    public int numUniqueEmailsTwo(String[] emails) {
        if (emails == null || emails.length == 0)
            return 0;
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            boolean beforePlus = true;
            int index = 0;
            for (int i = 0; i < email.length(); i++) {
                if (beforePlus && email.charAt(i) != '@') {
                    if (email.charAt(i) == '.') {
                        continue;
                    } else if (email.charAt(i) == '+') {
                        beforePlus = false;
                    } else {
                        sb.append(email.charAt(i));
                    }
                } else if (email.charAt(i) == '@') {
                    index = i;
                    break;
                }
            }
            sb.append(email.substring(index));
            set.add(sb.toString());
        }
        return set.size();
    }
}
