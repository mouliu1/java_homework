import java.util.*;

/**
 * @author 86134
 */

public class Main {
    public static final int max = 500;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap users = new HashMap<String,HashSet>();
        int n = input.nextInt();
        int m = input.nextInt();
        int q = input.nextInt();
        Actor[] test = new Actor[n];
        //----------角色数量部分----------
        for (int i=0;i<n;i++){
            test[i] = new Actor();
            String name = input.next();
            test[i].init(name);
            //-------操作-------
            int nvNum = input.nextInt();
            for (int j=0;j<nvNum;j++){
                String option = input.next();
                test[i].nv.add(option);
            }
            //-------资源种类-------
            int noNum = input.nextInt();
            for (int j=0;j<noNum;j++){
                String option = input.next();
                test[i].no.add(option);
            }
            //-------资源名称-------
            int nnNum = input.nextInt();
            for (int j=0;j<nnNum;j++){
                String option = input.next();
                test[i].nn.add(option);
            }
            /*for (String s : test[i].nv) {
                System.out.print(s + " ");
            }
            System.out.println();
            for (String s : test[i].no) {
                System.out.print(s + " ");
            }
            System.out.println();
            for (String s : test[i].nn) {
                System.out.print(s + " ");
            }
            System.out.println(test[i].name);*/
        }
        //----------角色关联数量部分----------
        int sum = 0;
        RelationshipGroup[] groups = new RelationshipGroup[max];
        RelationshipPerson[] rePeople = new RelationshipPerson[max];
        int count = 0;
        for(int pp=0;pp<m;pp++){
            String name = input.next();
            int numRelationship = input.nextInt();
            for(int i=0;i<numRelationship;i++){
                String type1 = "g";
                String type = input.next();
                String person = input.next();
                if(Objects.equals(type, type1)){
                    groups[i] = new RelationshipGroup(person);
                    groups[i].member.add(name);
                    sum++;
                }else{
                    rePeople[count] = new RelationshipPerson(person);
                    rePeople[count].member.add(name);
                    count++;
                }
            }
            /*System.out.println(sum);
            for(int i=0;i<sum;i++){
                for(String s : groups[i].member){
                    System.out.println(s+" ");
                }
            }
            System.out.println("个人：");
            for(String key : relationshipPerson.keySet()){
                String value = relationshipPerson.get(key);
                System.out.println(key+" "+value);
            }*/
        }
        //----------待检查的操作部分----------
        String checkName = input.next();
        int ng = input.nextInt();
        String []relatedGroups = new String[ng];
        for(int i=0;i<ng;i++){
            relatedGroups[i] = input.next();
        }
        String action1 = input.next();
        String action2 = input.next();
        String action3 = input.next();
        boolean res = false;
        for(int i=0;i<count;i++){
            if(Objects.equals(rePeople[i].name, checkName)){
                for(int i1=0;i1<rePeople[i].member.size();i++){

                }
                res=true;
            }
        }
        if(res){
            System.out.println("1");
        }else{
            for(int j=0;j<ng;j++){
                for(int i=0;i<sum;i++){
                    if(Objects.equals(groups[i].groupName, relatedGroups[j])){
                        for(int r=0;r<groups[i].member.size();r++){
                            res = judge(groups[i].member.get(i), action1, action2, action3, n);
                        }
                    }
                }
            }
            if(res){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }

    public static boolean judge(String name, String action1, String action2, String action3, int num){
        for(int i=0;i<num;i++){

        }
        return true;
    }
}

class Actor{
    String name;
    HashSet<String> nv = new HashSet<String>();
    HashSet<String> no = new HashSet<String>();
    HashSet<String> nn = new HashSet<String>();
    public void init(String n){
        name =n;
    }
}
class RelationshipGroup {
    String groupName;
    ArrayList<String> member = new ArrayList<>();
    RelationshipGroup(String n){
        groupName = n;
    }
}
class RelationshipPerson{
    String name;
    ArrayList<String> member = new ArrayList<>();
    RelationshipPerson(String n){
        name = n;
    }
}
