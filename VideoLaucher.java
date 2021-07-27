import java.util.MissingFormatArgumentException;
import java.util.Scanner;

public class VideoLaucher {
    static String str;
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        VideoStore vs=new VideoStore();
       
        boolean bool=true;
        while (bool) {
            for (String s : new VideoStore().v_store) {
                System.out.println(s);
            }
            System.out.println("Enter ur choice ");
            int input=0;
            try
            {
             input = sc.nextInt();
            sc.nextLine();
            }
            catch (Exception e){
                e.printStackTrace();
            }
           if(input>0 &&input<7) {
               switch (input) {
                   case 1: {
                       System.out.println("enter the name of ur video ");
                       String name = sc.nextLine();
                       vs.addVideo(name);
                       break;
                   }
                   case 2: {
                       System.out.println("enter the name of the video you want to check out :");

                       try {
                           str = sc.nextLine();
                           if (!str.equals(vs.getName())) {
                               throw new MissingFormatArgumentException("");
                           }
                           vs.doCheckout(str);
                           System.out.println("video \"" + str + "\" checked out successfully");
                       } catch (MissingFormatArgumentException e) {
                           System.out.println("Oops...!!Enter correct name of the vedio");
                       }

                       break;
                   }
                   case 3: {
                       System.out.println("enter the name of the video you want to return :");
                       try {
                           str = sc.nextLine();
                           if (!str.equals(vs.getName())) {
                               throw new MissingFormatArgumentException("");
                           }
                           vs.doReturn(str);
                           System.out.println("video \"" + str + "\" returned successfully");
                       } catch (MissingFormatArgumentException e) {
                           System.out.println("Oops...!!Enter correct name of the vedio");
                       }

                       break;
                   }
                   case 4: {
                       System.out.println("enter the name of the video u want to rate: ");

                       try {
                           str = sc.nextLine();
                           if (!str.equals(vs.getName())) {
                               throw new MissingFormatArgumentException("");
                           }
                           System.out.println("enter the rating for this vedio");
                           int rat = sc.nextInt();
                           System.out.println("Rating \"" + rat + "\" has been mapped to the \"" + str + "\"");
                           vs.receiveRating(str, rat);
                       } catch (MissingFormatArgumentException e) {
                           System.out.println("Oops...!!Enter correct name of the vedio");
                       }
                       break;
                   }
                   case 5: {
                       vs.listinventory();
                       break;
                   }
                   case 6: {
                       System.out.println("Exciting...!!! thanks for using this appication");
                       bool = false;
                       break;
                   }
               }
           }else {
               System.out.println("Enter the correct number...!");
           }
        }


    }
}
class Video
{
    static String videoName;
    boolean checkout;
    int rating;
    String getName()
    {

        return videoName;
    }
    void docheckout()
    {
      checkout =true;
    }
    void doreturn()
    {
       checkout=false;
    }
    void receiverating(int rat)
    {
        rating=rat;
    }
    int getRating()
    {
        return rating;
    }
    boolean getcheckout()
    {
        return checkout;
    }

}

class VideoStore extends Video
{
    String v_store[]={"1.Add video:","2.check out video","3.Return video"
    ,"4.receive rating","5.List invenory","6.Exit"};
    Scanner sc=new Scanner(System.in);
    void addVideo(String name)
    {
        videoName=name;
        System.out.println(" video \""+name+"\" added successfully ");
    }
    void doCheckout(String name)
    {
      docheckout();
    }
    void doReturn(String name)
    {
     doreturn();

    }
    void receiveRating(String name, int rating){
           receiverating(rating);
    }
    void listinventory()
    {
        System.out.println("video name:"+getName()+", checkout status:"+getcheckout()+", rating: "+getRating());
    }
}