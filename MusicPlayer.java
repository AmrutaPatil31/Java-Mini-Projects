import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicPlayer {
    public static void main(String[] args) {
        //first download audio from audio library youtube studio
        //then covert the audio file wav by visiting website Mp3 wav converter(https://cloudconvert.com/mp3-to-wav)
        //try with resources automatically close the scanner,
        String filePath="Dopamina - Inaban (1).wav";
        File file=new File(filePath);

        try(Scanner sc=new Scanner(System.in);
                    AudioInputStream audioStream=AudioSystem.getAudioInputStream(file)){

                    Clip clip=AudioSystem.getClip();
                    clip.open(audioStream);
                    String response="";
                    while(!response.equals("Q")){
                        System.out.println("P-play");
                        System.out.println("S-stop");
                        System.out.println("R-reset");
                        System.out.println("Q-quit");

                        System.out.println("Enter the input:");
                        response=sc.nextLine().toUpperCase();

                        switch(response){
                            case "P"-> clip.start();
                            case "S"-> clip.stop();
                            case "R"-> clip.setMicrosecondPosition(0);
                            case "Q"-> clip.close();
                            default->System.out.println("Invalid choice");
                        }
                    }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
       catch (UnsupportedAudioFileException e) {
            System.out.println("Audio unsupported");
        }
        catch (LineUnavailableException e) {
            System.out.println("Line unavailable");
        }
        catch (IOException e) {
            System.out.println("Something went wrong");
        }
        finally{
            System.out.println("Bye");
        }
        

        
    }
}
