class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character,List<Character>> adjList = new HashMap();
        HashMap<Character,Integer> indegree = new HashMap();
        //Create data strucutres for unique characters
        for(String word : words){
            for(char c : word.toCharArray()){
                indegree.put(c,0);
                adjList.put(c,new ArrayList());
            }
        }
        
        for(int i=0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
             // Check that word2 is not a prefix of word1.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            // Find the first non match and insert the corresponding relation.
            for(int j=0;j<Math.min(word1.length(),word2.length());j++){
                if(word1.charAt(j)!=word2.charAt(j)){
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    indegree.put(word2.charAt(j),indegree.get(word2.charAt(j))+1);
                    break;
                }
            }
        }
        //BFS
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList();
        for(Character c: indegree.keySet()){
            if(indegree.get(c).equals(0)){
                queue.add(c);
            }
        }
        while(!queue.isEmpty()){
            Character c = queue.remove();
            sb.append(c);
            for(Character next : adjList.get(c)){
                indegree.put(next,indegree.get(next)-1);
                if(indegree.get(next).equals(0)){
                    queue.add(next);
                }
            }
        }
        if(sb.length()<indegree.size()){
            return "";
        }
        return sb.toString();
    }
}

// w r t