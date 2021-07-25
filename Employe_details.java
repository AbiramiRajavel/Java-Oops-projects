import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import java.util.Date;
import java.util.Scanner;

public class Employe_details {
    public static void main(String[] args) throws ParseException {

       Scanner s=new Scanner(System.in);
      String name;
       int id;
         String date;
        char des;
        String depat;
         int basic;
          int hra;
         int it;

       System.out.println("how many employess");
       int no=s.nextInt();
        emp em[]=new emp[no];
       for (int i=0;i<no;i++){
           name=s.next();id= s.nextInt();
           date=s.next();
           Date dt=new SimpleDateFormat("dd/mm/yyyy").parse(date);
           des=s.next().charAt(0);
           depat=s.next();
           basic=s.nextInt();
           hra=s.nextInt();
           it=s.nextInt();
           em[i]=new emp(name,id,date,des,depat,basic,hra,it);

       }

        for (emp st:em){
            System.out.println(st);
        }
        System.out.println("enter employee Id");
        int roolno=s.nextInt();
        int c=0;
        for(int i=0;i<em.length;i++){
          if(em[i].getId()==roolno){
              System.out.println("emp no: "+em[i].getId()+"  name: "+em[i].getName()+"  department: "
                      +emp.da(em[i].getDes())[0]+"  salary: "+emp.salcal(em[i].getBasic(),
                      em[i].getHra(),emp.da(em[i].getDes())[1],em[i].getIt()));
              c++;
          }
        }
    if(c==0){
        System.out.println("There is no employe id with: "+roolno);
    }

    }
}
class emp{
    private String name;
    private  int id;
    private String dt;
    private char des;
    private String depat;
    private int basic;
    private  int hra;
    private int it;

    public emp(String name, int id, String dt, char des, String depat, int basic, int hra, int it) {
        this.name = name;
        this.id = id;
        this.dt = dt;
        this.des = des;
        this.depat = depat;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
    }


   static String[] da(char c){
        String str[]=new String[2];
        switch (c){
            case 'e':{
                str[0]="engineer";str[1]="20000";
                return str;
            }


            case 'c':{
                str[0]="concultant";str[1]="32000";
                return str;
            }


            case 'k':
            {
                str[0]="clerk";str[1]="12000";
                return str;
            }

            case 'r':
            {
                str[0]="Receptionist";str[1]="15000";
                return str;
            }

            case 'm':
            {
                str[0]="manager";str[1]="40000";
                return str;
            }
        }
        return str;
    }

    @Override
    public String toString() {
        return "emp{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", dt='" + dt + '\'' +
                ", des=" + des +
                ", depat='" + depat + '\'' +
                ", basic=" + basic +
                ", hra=" + hra +
                ", it=" + it +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public char getDes() {
        return des;
    }

    public void setDes(char des) {
        this.des = des;
    }

    public String getDepat() {
        return depat;
    }

    public void setDepat(String depat) {
        this.depat = depat;
    }

    public int getBasic() {
        return basic;
    }

    public void setBasic(int basic) {
        this.basic = basic;
    }

    public int getHra() {
        return hra;
    }

    public void setHra(int hra) {
        this.hra = hra;
    }

    public int getIt() {
        return it;
    }

    public void setIt(int it) {
        this.it = it;
    }
    static int salcal(int basic,int hra,String da,int it){
        int dada=Integer.parseInt(da);
        int salary=basic+hra+dada-it;
        return salary;
    }
}