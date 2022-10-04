import java.util.*;

/**
 * @author 86134
 */
public class Main {
    public static void main(String[] args) {
        Enpower test = new Enpower();
        test.init();
    }
}
class Man{
    String name;
    Set<String> action1;
    Set<String> action2;
    Set<String> action3;
    Man(String n, Set<String>ac1, Set<String>ac2, Set<String>ac3){
        name = n;
        action1 = ac1;
        action2 = ac2;
        action3 = ac3;
    }
}
class Enpower{
    Scanner input = new Scanner(System.in);
    Map<String, Man> men = new HashMap<>();
    Map<String ,Set<String>> relationship = new HashMap<>();
    public void init(){
        int n = input.nextInt();
        int m = input.nextInt();
        int q = input.nextInt();
        inputMan(n);
        inputRelationship(m);
        for(int i=0;i<q;i++){
            inputTest();
        }
        /*System.out.println("角色关系");
        for(String s : relationship.keySet()){
            System.out.println(s+" ");
            Set<String > p1 = relationship.get(s);
            for(String o : p1){
                System.out.println(o);
            }
            System.out.println();
        }*/
    }
    public void inputMan(int n){

        for(int j=0;j<n;j++){
            Set<String > action1 = new HashSet<>();
            Set<String > action2 = new HashSet<>();
            Set<String > action3 = new HashSet<>();
            String name = input.next();
            int a = input.nextInt();
            for (int i=0;i<a;i++){
                String ac1 = input.next();
                action1.add(ac1);
            }
            int b = input.nextInt();
            for (int i=0;i<b;i++){
                String ac2 = input.next();
                action2.add(ac2);
            }
            int c = input.nextInt();
            for (int i=0;i<c;i++){
                String ac3 = input.next();
                action3.add(ac3);
            }
            Man man1 = new Man(name ,action1, action2, action3);
            men.put(name, man1);
        }
    }
    public void inputRelationship(int m){
        for (int i=0;i<m;i++){
            Set<String> temp = new HashSet<>();
            String name = input.next();
            int num = input.nextInt();
            for(int j=0;j<num;j++){
                String type = input.next();
                String typeName = input.next();
                relationship.put(typeName,temp);
                for(String key : relationship.keySet()){
                    Set<String> value = relationship.get(key);
                    if(Objects.equals(key, typeName)){
                        value.add(name);
                    }
                }
            }
        }
    }
    public void inputTest(){
        Set<String> allNames = new HashSet<>();
        String testName = input.next();
        allNames.add(testName);
        int num = input.nextInt();
        for(int j=0;j<num;j++){
            String name = input.next();
            allNames.add(name);
        }
        if(judge(allNames)){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
        allNames.clear();
    }
    public boolean judge(Set<String> allNames){
        String ac1 = input.next();
        String ac2 = input.next();
        String ac3 = input.next();
        for(String s : allNames){
            if(!relationship.containsKey(s)) {
                continue;
            }else{
                Set<String> jud = relationship.get(s);
                for(String p : jud){
                    Man res = men.get(p);
                    //System.out.println("相关角色："+res.name);
                    if(res.action1.contains(ac1)||res.action1.contains("*")){
                        if(res.action2.contains(ac2)||res.action2.contains("*")){
                            if(res.action3.contains(ac3)||res.action3.isEmpty()){
                                return true;
                            }
                            //System.out.println("第1步");
                        }
                        //System.out.println("第2步");
                    }
                    //System.out.println("第3步");
                }
            }
        }
        return false;
    }
}
