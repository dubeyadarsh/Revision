//https://leetcode.com/problems/robot-collisions/



import java.util.*;
class Solution {
    // jO banda left me aarha woh  jitne bhi uske left me right wale bande hai unse fight karega ,
    // agar woh sabko hara diya toh answer me include , aur agar kisi se haar gaya toh koi baat nahu
    
    // upar wale logic ko implement karne k liye
    // 1)Sort each array according to position array.
    // 2) jitne bhi R wale bande hai unko stack me daalo and move on.
    // 3) Jitne bhi l wale bande hai woh stack me jitne bhi bande pade hai unse fight karega
    //      agar sabko hara deta hai toh answer me include hoga
    // 4) yaa phir agar stack wala banda kisi L ko maarta hai toh uska health 1 se kam kar diya jayega.
    
    class pair{
        int pos;
        int health;
        char d;
        public pair(int pos,int health,char d){
            this.pos=pos;
            this.health=health;
            this.d=d;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
       
        int len=positions.length;
        int newarray[]=Arrays.copyOf(positions,len);
       pair[] robot=new pair[len];
        for(int i=0;i<len;i++){
            robot[i]=new pair(positions[i],healths[i],directions.charAt(i));
        }
        Arrays.sort(robot,new Comparator<pair>(){
            @Override
           public int compare(pair p1,pair p2){
               return p1.pos-p2.pos;
           } 
        });
        Map<Integer,Integer> listpair=new HashMap<>();
        Stack<pair> stack=new Stack<>();
         for(int i=0;i<len;i++){
             pair ll=robot[i];
             if(ll.d=='L'){
                 boolean is=false;
                 while(!stack.isEmpty()){
                     pair qq=stack.pop();
                     if(qq.health<ll.health){
                         ll.health=ll.health-1;
                     }else if (qq.health>ll.health){
                      qq.health=qq.health-1;
                         stack.push(qq);
                         break;
                     }else{
                         is=true;
                         break;
                     }
                 }
                  if(stack.isEmpty() && !is)   listpair.put(ll.pos,ll.health);

             }else{
                 stack.push(ll);
             }

        }
        
      
         while(!stack.isEmpty()){
             pair m=stack.pop();
             listpair.put(m.pos,m.health);
        }
        List<Integer> listAns=new ArrayList<>();
        for(int i=0;i<len;i++){
            if(listpair.containsKey(newarray[i])){
                listAns.add(listpair.get(newarray[i]));
            }
        }
        return listAns;
    }
}
