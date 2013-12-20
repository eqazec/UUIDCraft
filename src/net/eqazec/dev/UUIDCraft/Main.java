package net.eqazec.dev.UUIDCraft;

import com.mojang.api.profiles.HttpProfileRepository;
import com.mojang.api.profiles.Profile;
import com.mojang.api.profiles.ProfileCriteria;

import java.io.*;

public class Main
{
  public static void main(String[] args)
  {
	  try
	  {
		  File input = new File("usernames.txt");
		  File output = new File("uuids.txt");
		  
		  FileReader fr = new FileReader(input);
		  BufferedReader br = new BufferedReader(fr);
		  
		  PrintWriter pw = new PrintWriter(output);

		  String username;
		  while((username = br.readLine()) != null)
		  {
			  username = br.readLine();
			  String uuid = getUUID(username);
			  pw.println(uuid);
		  }
		  pw.flush();
		  pw.close();
		  br.close();
		  fr.close();
	  }
	  catch (FileNotFoundException e)
	  {
		  System.err.println("File 'usernames.txt' not found. Please check the location and format of the file.");
	  }
	  catch (IOException e)
	  {
		  System.err.println("Java IOException @ Class: Main");
	  }
  }
  
  private static final HttpProfileRepository profileRepository = new HttpProfileRepository();
  
  public static String getUUID(String name)
  {
    Profile[] profiles = profileRepository.findProfilesByCriteria(new ProfileCriteria[] { new ProfileCriteria(name, "minecraft") });
    if (profiles.length == 1) {
      return profiles[0].getId();
    }
    return "Couldn't get the UUID! :(";
  }
}
