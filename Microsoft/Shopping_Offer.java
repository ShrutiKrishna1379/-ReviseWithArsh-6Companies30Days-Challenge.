/*Input: price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
Output: 14
Explanation: There are two kinds of items, A and B. Their prices are $2 and $5 respectively. 
In special offer 1, you can pay $5 for 3A and 0B
In special offer 2, you can pay $10 for 1A and 2B. 
You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A. */


package Microsoft;

import java.util.ArrayList;
import java.util.List;

public class Shopping_Offer {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return solve(price,special,needs,0);
    }
    int solve(List<Integer> price, List<List<Integer>> special, List<Integer> needs,int s){
        int sum=0;
        for(int i=0;i<needs.size();i++) sum+=needs.get(i)*price.get(i);
        for(int i=s;i<special.size();i++){
            List<Integer> l1=special.get(i);
            List<Integer> l2=new ArrayList<>();
            for(int j=0;j<needs.size();j++){
                if(needs.get(j)<l1.get(j)){
                    l2=null;
                    break;
                }
                l2.add(needs.get(j)-l1.get(j));
            }
            if(l2!=null){
                sum=Math.min(sum,l1.get(l1.size()-1)+solve(price,special,l2,i));
            }
        }
        return sum;
        
    }
}

/*class Solution {
    int amount;
    public int shoppingOffers(List<Integer> price,List<List<Integer>> special,List<Integer> needs) {
        amount=directlyBuy(price,needs);
        help(price,special,needs,0,0);
        return amount;
    }
    int directlyBuy(List<Integer> price,List<Integer> needs){
        int total=0;
        int n=needs.size();
        for(int i=0;i<n;i++){
            total+=price.get(i)*needs.get(i);
        }
        return total;
    }
    boolean canUse(List<Integer> offer,List<Integer> needs){
        int n=needs.size();
        for(int i=0;i<n;i++){
            if(offer.get(i)>needs.get(i))return false;
        }
        return true;
    }
    void help(List<Integer> price,List<List<Integer>> special,List<Integer> needs,int used,int index){
        if(used>=amount)return;
        if(index==special.size()){
            used+=directlyBuy(price,needs);
            if(used<amount){
                amount=used;
            }
            return;
        }
        List<Integer> offer=special.get(index);
        if(canUse(offer,needs)){
            int n=needs.size();
            List<Integer> updatedNeeds=new ArrayList<>();
            for(int i=0;i<n;i++){
                updatedNeeds.add(needs.get(i)-offer.get(i));
            }
            help(price,special,updatedNeeds,used+offer.get(n),index);
        }
        help(price,special,needs,used,index+1);
    }
} */
