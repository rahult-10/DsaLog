//LC -> 721. Accounts Merge
// gfg

class Solution {
    int[] parent;
    int[] rank;

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv)
            return;
        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailId = new HashMap<>();
        Map<String, String> emailName = new HashMap<>();
        int id = 0;
        for (List<String> acc : accounts) {
            String name = acc.get(0);

            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);

                if (!emailId.containsKey(email)) {
                    emailId.put(email, id++);
                }

                emailName.put(email, name);
            }
        }

        parent = new int[id];
        rank = new int[id];
        for (int i = 0; i < id; i++) {
            parent[i] = i;
        }

        for (List<String> acc : accounts) {
            int first = emailId.get(acc.get(1));

            for (int i = 2; i < acc.size(); i++) {
                int current = emailId.get(acc.get(i));
                union(first, current);
            }
        }

        Map<Integer, List<String>> groups = new HashMap<>();
        for (String email : emailId.keySet()) {
            int root = find(emailId.get(email));

            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> emails : groups.values()) {

            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(emailName.get(emails.get(0)));
            merged.addAll(emails);
            result.add(merged);
        }
        return result;
    }
}