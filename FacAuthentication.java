import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class FacAuthentication 
{   

      void createAc(String userName,String Password) throws IOException
      { 
        
            boolean flag=true;
        
            FileReader fr = new FileReader("F:\\UniversityMgmt\\FacCredentials.txt");
            BufferedReader br = new BufferedReader(fr);

            String data;
        while((data=br.readLine())!=null)
        {
            String[] parts=data.split(":");
            if(parts.length>0 && parts[0].equals(userName))
            {   
                flag=false;
                break;
            }

        }

        if(flag)

        {
            FileWriter fw = new FileWriter("F:\\UniversityMgmt\\FacCredentials.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(userName+":"+Password);
            bw.newLine();
            bw.close();

            System.out.println("user Added SuccessFully");

            fw.close();
        }
        else    
        {
            System.out.println("User Already Exist !");
        }

      }

        public String  login(String uname,String upass) throws IOException
      {

        FileReader fr = new FileReader("F:\\UniversityMgmt\\FacCredentials.txt");
        BufferedReader br = new BufferedReader(fr);

        String data;
        while((data=br.readLine())!=null)
        {
            String[] parts=data.split(":");
            if(parts.length>0 && parts[0].equals(uname) && parts[1].equals(upass))
            {   
                return "fac";
            }
        }
        return "false";
      }
}

