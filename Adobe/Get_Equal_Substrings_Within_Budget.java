// Get Equal Substrings Within Budget  

class  Get_Equal_Substrings_Within_Budget{
    public int equalSubstring(String s, String t, int maxCost) {
        int i=0,j=0,cost=0,max=0;
        while(j<s.length()){
            cost+=Math.abs(t.charAt(j)-s.charAt(j)); 
            if(cost<=maxCost){
                max=Math.max(max,j-i+1);
            }
            else{
                while(cost>maxCost){
                    cost-=Math.abs(t.charAt(i)-s.charAt(i));
                    i++;
                }            
            }
            j++;
        }
        return max;
    }
}
