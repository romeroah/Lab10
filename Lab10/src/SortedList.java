import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    public void add(String element) {
        if (list.isEmpty()) {
            list.add(element);
            return;
        }
        
        int pos = findInsertPosition(element);
        list.add(pos, element);
    }

    private int findInsertPosition(String target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = target.compareTo(list.get(mid));

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public SearchResult search(String target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = target.compareTo(list.get(mid));

            if (comparison == 0) {
                return new SearchResult(true, mid, list.get(mid));
            } else if (comparison < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new SearchResult(false, left, null);
    }

    public String toString() {
        return String.join(", ", list);
    }

    public static class SearchResult {
        public final boolean found;
        public final int position;
        public final String element;

        public SearchResult(boolean found, int position, String element) {
            this.found = found;
            this.position = position;
            this.element = element;
        }
    }
}
