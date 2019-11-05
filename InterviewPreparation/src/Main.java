import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.nio.charset.StandardCharsets;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      String[] names=line.split("@");
      if(names.length<2){
        System.out.println(" names false");
        continue;
      }
      char[] name=names[0].toCharArray();
      String[] domains = names[1].split("\\.");
      if(domains.length<2){
        System.out.println("domain false");
        continue;
      }
      char[] domain=domains[0].toCharArray();
      String tld=domains[1];
      System.out.println(tld);
      if(!(tld!="com" ||tld!="org"||tld!="net")){
        System.out.println("false");
        continue;
      }
      for(int i=0;i<name.length;i++){
        if(!((name[i]>='a'&&name[i]<='z') || (name[i]>='A'&&name[i]<='Z') || (name[i]>='0'&&name[i]<='9') || name[i]=='_' || name[i] == '.')){
        System.out.println("name false");
        continue;  
        }
      }
      for(int i=0;i<domain.length;i++){
        if(!((domain[i]>='a'&&domain[i]<='z') || domain[i]=='-')){
        System.out.println("domain false");
        continue;  
        }
      }
      System.out.println("true");
    }
  }
}