package practice.problem;

import java.util.*;

public class TravelBuddy {
    public class Solution {

        class Buddy implements Comparable<Buddy> {

            String name;
            int similarity;
            Set<String> wishList;

            public Buddy(String name, int similarity, Set<String> wishList) {
                this.name = name;
                this.similarity = similarity;
                this.wishList = wishList;
            }

            @Override
            public int compareTo(Buddy that) {
                return this.similarity - that.similarity;
            }
        }

        private List<Buddy> buddies;
        private Set<String> myWishList;

        public Solution(Set<String> myWishList, Map<String, Set<String>> friendWishLists) {
            this.buddies = new ArrayList<>();
            this.myWishList = myWishList;
            for (String name : friendWishLists.keySet()) {
                Set<String> wishList = friendWishLists.get(name);
                Set<String> intersection = new HashSet<>(wishList);
                intersection.retainAll(myWishList);
                int similarity = intersection.size();
                if (similarity >= wishList.size() / 2) {
                    buddies.add(new Buddy(name, similarity, wishList));
                }
            }
        }

        public List<String> recommend(int k) {
            List<String> res = new ArrayList<>();
            Collections.sort(buddies);
            int i = 0;
            while (k > 0 && i < buddies.size()) {
                Set<String> diff = new HashSet<>(buddies.get(i).wishList);
                diff.removeAll(myWishList);
                if (diff.size() <= k) {
                    res.addAll(diff);
                    k -= diff.size();
                    i++;
                } else {
                    Iterator<String> it = diff.iterator();
                    while (k > 0) {
                        res.add(it.next());
                        k--;
                    }
                }
            }
            return res;
        }
    }
}
