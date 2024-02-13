class ThroneInheritance {

    Map<String, List<String>> map = new HashMap<>();
    Set<String> deathSet = new HashSet<>();
    String kingName;

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        map.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        List<String> list = map.getOrDefault(parentName, new ArrayList<>());
        list.add(childName);
        map.put(parentName, list);
    }
    
    public void death(String name) {
        deathSet.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        Deque<String> next = new ArrayDeque<>();
        List<String> ansList = new ArrayList<>();
        if(kingName != null) {
            next.add(kingName);
        }

        while(!next.isEmpty()) {
            String name = next.poll();
            if(!deathSet.contains(name)) {
                ansList.add(name);
            }

            if(map.containsKey(name)) {
                List<String> children = map.getOrDefault(name, new ArrayList<>());
                for(int i=children.size() - 1; i >= 0; i--) {
                    next.push(children.get(i));
                }
            }
        }


        return ansList;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
